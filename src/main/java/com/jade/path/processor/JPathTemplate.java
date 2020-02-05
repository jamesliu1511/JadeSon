package com.jade.path.processor;

import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jade.path.antlr.JTemplateBaseVisitor;
import com.jade.path.antlr.JTemplateLexer;
import com.jade.path.antlr.JTemplateParser;
import com.jade.path.exception.DoFailOnErrorHandler;

public class JPathTemplate extends JTemplateBaseVisitor<JsonObject> {

	private final JsonElement source;
	private final JsonObject target;

	private JPathTemplate(JsonElement source, JsonObject target) {
		this.source = source;
		this.target = target;
	}

	public static final JsonObject add(JsonObject target, String targetPath, JsonElement source, String sourcePath, Map<String, Object> values) {
		CharStream input = CharStreams.fromString(targetPath);
		JTemplateLexer lexer = new JTemplateLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JTemplateParser parser = new JTemplateParser(tokens);
		parser.removeErrorListeners();
		parser.setErrorHandler(new DoFailOnErrorHandler());
		ParseTree tree = parser.locationPath();

		JPathTemplate processor;
		if (StringUtils.isBlank(sourcePath) || "*".equals(sourcePath)) {
			processor = new JPathTemplate(source.deepCopy(), target);
		} else {
			JsonElement content = JPathProcessor.find(sourcePath, source.deepCopy().getAsJsonObject(), values);
			processor = new JPathTemplate(content, target);
		}
		return processor.visit(tree);
	}

	public static final JsonObject add(JsonObject target, String targetPath, JsonElement source, String sourcePath) {
		return add(target, targetPath, source, sourcePath, null);
	}

	public static final JsonObject add(String targetPath, JsonElement source, String sourcePath) {
		return add(new JsonObject(), targetPath, source, sourcePath, null);
	}

	public static final JsonObject add(JsonObject target, String targetPath, JsonElement source ) {
		return add(target, targetPath, source, null, null);
	}

	public static final JsonObject add(String targetPath, JsonElement source ) {
		return add(new JsonObject(), targetPath, source, null, null);
	}

	public static final JsonObject add(String targetPath, JsonElement source, String sourcePath, Map<String, Object> values) {
		return add(new JsonObject(), targetPath, source, sourcePath, values);
	}

	@Override
	public JsonObject visitLocationPath(JTemplateParser.LocationPathContext ctx) {

		int size = ctx.step().size();

		JsonObject input = this.target;
		for (int i = 0; i < size - 1; i++) {
			input = this.visitStep(ctx.step(i), input);
		}

		JTemplateParser.StepContext context = ctx.step(size - 1);
		String name;

		if (context.NCName() != null) {
			name = context.NCName().getText();
		} else {
			name = JPathUtil.parseLiteral(context.Literal().getText());
		}

		input.add(name, this.source);

		return this.target;
	}

	private JsonObject visitStep(JTemplateParser.StepContext ctx, JsonObject target) {
		String step;
		if (ctx.NCName() != null) {
			step = ctx.NCName().getText();
		} else {
			step = JPathUtil.parseLiteral(ctx.Literal().getText());
		}

		if (target.has(step)) {
			JsonElement el = target.get(step);
			if (!el.isJsonObject()) {
				JsonObject newEl = new JsonObject();
				target.add(step, newEl);
				return newEl;
			} else {
				return el.getAsJsonObject();
			}
		}

		JsonObject el = new JsonObject();
		target.add(step, el);

		return el;
	}
}