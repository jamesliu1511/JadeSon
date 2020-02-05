package com.jade.path.processor;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jade.path.antlr.JPathActionBaseVisitor;
import com.jade.path.antlr.JPathActionLexer;
import com.jade.path.antlr.JPathActionParser;
import com.jade.path.antlr.JPathActionParser.FunctionProcessorContext;
import com.jade.path.antlr.JPathActionParser.LocationPathContext;
import com.jade.path.antlr.JPathActionParser.ProcessorContext;
import com.jade.path.antlr.JPathActionParser.ProcessorParamContext;
import com.jade.path.exception.DoFailOnErrorHandler;
import com.jade.path.fn.FunctionPool;

public class JPathAction extends JPathActionBaseVisitor<JsonObject> {

	private final Map<String, Object> store = new HashMap<>();

	private final JsonObject target;

	private JPathAction(JsonObject target, Map<String, Object> values) {
		this.target = target;
		if (values != null && !values.isEmpty()) {
			this.store.putAll(values);
		}
	}

	public static final JsonObject process(JsonObject target, String targetPath, Map<String, Object> values) {
		CharStream input = CharStreams.fromString(targetPath);
		JPathActionLexer lexer = new JPathActionLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JPathActionParser parser = new JPathActionParser(tokens);
		parser.removeErrorListeners();
		parser.setErrorHandler(new DoFailOnErrorHandler());
		ParseTree tree = parser.locationPath();
		JPathAction processor = new JPathAction(target, values);
		return processor.visit(tree);
	}

	public static final JsonObject remove(JsonObject target, String targetPath) {
		JsonElement findObj = JPathProcessor.inFind(targetPath, target);
		if (findObj == null) {
			return target;
		}
		if (findObj instanceof JPathValue) {
			JPathValue el = (JPathValue) findObj;
			if (el.getParent() != null) {
				JsonElement parent = el.getParent().getContent();
				if (parent.isJsonObject()) {
					parent.getAsJsonObject().remove(el.getName());
				}
				if (parent.isJsonArray()) {
					parent.getAsJsonArray().remove(el.getContent());
				}
			}
		}
		return target;
	}

	public static final JsonObject process(JsonObject target, String targetPath) {
		return process(target, targetPath, null);
	}

	@Override
	public JsonObject visitLocationPath(LocationPathContext ctx) {
		int size = ctx.specialPath().size();
		if (size == 1) {
			String step = ctx.specialPath(0).getText();
			if ("*".equals(step)) {
				visitFunctionProcessor(ctx.functionProcessor(), this.target);
				return this.target;
			}
		}
		String[] paths = new String[size];
		for (int i = 0; i < size; i++) {
			paths[i] = ctx.specialPath(i).getText();
		}

		String path = String.join("/", paths);

		JsonElement el = JPathProcessor.find(path, this.target);

		visitFunctionProcessor(ctx.functionProcessor(), el);

		return this.target;
	}

	private Object processorParam(ProcessorParamContext ctx) {
		if (ctx.NCName() != null) {
			return ctx.NCName().getText();
		} else if (ctx.Literal() != null) {
			return JPathUtil.parseLiteral(ctx.Literal().getText());
		} else if (ctx.INT() != null) {
			return Integer.parseInt(ctx.INT().getText());
		} else if (ctx.specialName() != null) {
			return JPathUtil.parseLiteral(ctx.specialName().Literal().getText());
		}
		String name = ctx.variableReference().NCName().getText();
		return this.store.get(name);
	}

	private String processor(ProcessorContext ctx) {
		return ctx.NCName().getText();
	}

	private void visitFunctionProcessor(FunctionProcessorContext ctx, JsonElement content) {
		String funName = this.processor(ctx.processor());
		int size = ctx.processorParam().size();

		Object[] params = new Object[size];

		for (int i = 0; i < size; i++) {
			params[i] = this.processorParam(ctx.processorParam(i));
		}

		FunctionPool.execute(funName, content, params);
	}
}