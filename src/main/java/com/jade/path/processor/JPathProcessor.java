package com.jade.path.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.jade.path.antlr.JPathProcessorBaseVisitor;
import com.jade.path.antlr.JPathProcessorLexer;
import com.jade.path.antlr.JPathProcessorParser;
import com.jade.path.antlr.JPathProcessorParser.ConditionExprContext;
import com.jade.path.antlr.JPathProcessorParser.ConditionSelectContext;
import com.jade.path.antlr.JPathProcessorParser.ExistCheckContext;
import com.jade.path.antlr.JPathProcessorParser.FetchNameContext;
import com.jade.path.antlr.JPathProcessorParser.FunValueContext;
import com.jade.path.antlr.JPathProcessorParser.FunctionCheckContext;
import com.jade.path.antlr.JPathProcessorParser.FunctionFetchContext;
import com.jade.path.antlr.JPathProcessorParser.FunctionNodeNameContext;
import com.jade.path.antlr.JPathProcessorParser.FunctionParamContext;
import com.jade.path.antlr.JPathProcessorParser.RangeExprContext;
import com.jade.path.antlr.JPathProcessorParser.SearchPathContext;
import com.jade.path.antlr.JPathProcessorParser.SpecialPathContext;
import com.jade.path.antlr.JPathProcessorParser.SubSearchPathContext;
import com.jade.path.exception.DoFailOnErrorHandler;
import com.jade.path.fn.FunctionPool;

public class JPathProcessor extends JPathProcessorBaseVisitor<JsonElement> {

	private final Map<String, Object> store = new HashMap<>();

	private final JPathValue root;

	private JPathProcessor(JsonObject root, Map<String, Object> values) {
		this.root = new JPathValue("", root);
		if (values != null && !values.isEmpty()) {
			this.store.putAll(values);
		}
	}

	public static final JsonElement find(String path, JsonObject content, Map<String, Object> values) {
		JsonElement findObj = inFind(path, content, values);

		if (findObj == null) {
			return null;
		}

		if (findObj instanceof JPathValue) {
			return ((JPathValue) findObj).getContent();
		}
		return findObj;
	}

	public static final JsonElement find(String path, JsonObject content) {
		JsonElement findObj = find(path, content, null);

		if (findObj == null) {
			return null;
		}

		if (findObj instanceof JPathValue) {
			return ((JPathValue) findObj).getContent();
		}
		return findObj;
	}

	protected static final JsonElement inFind(String path, JsonObject content, Map<String, Object> values) {
		CharStream input = CharStreams.fromString(path);
		JPathProcessorLexer lexer = new JPathProcessorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JPathProcessorParser parser = new JPathProcessorParser(tokens);
		parser.removeErrorListeners();
		parser.setErrorHandler(new DoFailOnErrorHandler());
		ParseTree tree = parser.locationPath();
		JPathProcessor processor = new JPathProcessor(content, values);
		return processor.visit(tree);
	}

	protected static final JsonElement inFind(String path, JsonObject content) {
		return inFind(path, content, null);
	}

	@Override
	public JsonElement visitLocationPath(JPathProcessorParser.LocationPathContext ctx) {
		JPathValue input = this.root;

		int size = ctx.specialPath().size();

		for (int i = 0; i < size; i++) {
			input = this.visitSpecialPath(ctx.specialPath(i), input);
			String path = ctx.specialPath(i).getText();
			if (input == null) {
				return null;
			}

			if ("*".equals(path) && i < size - 1) {
				String[] paths = new String[size - i - 1];
				int index = 0;
				for (int j = i + 1; j < size; j++) {
					paths[index++] = ctx.specialPath(j).getText();
				}
				String startPath = String.join("/", paths);
				JsonArray chs = new JsonArray();

				JsonElement v = input.getContent();
				if (v.isJsonObject()) {
					return all(v, startPath, chs);
				} else if (v.isJsonArray()) {
					for (JsonElement r : v.getAsJsonArray()) {
						if (!r.isJsonObject()) {
							continue;
						}
						all(r, startPath, chs);
					}
					return chs;
				}
			}
		}

		return input;
	}

	private JsonElement all(JsonElement v, String startPath, JsonArray chs) {
		JsonObject current = v.getAsJsonObject();

		for (Entry<String, JsonElement> child : current.entrySet()) {
			String vPath = String.join("/", child.getKey(), startPath);
			JsonElement f = inFind(vPath, current, store);
			if (f != null) {
				chs.add(f);
			}
		}
		if (chs.size() > 1) {
			return chs;
		} else if (chs.size() == 1) {
			return chs.get(0);
		} else {
			return null;
		}
	}

	private JPathValue visitSpecialPath(SpecialPathContext ctx, JPathValue content) {
		if (ctx.step() != null) {
			return this.visitStep(ctx.step(), content);
		}
		return this.visitSearchPath(ctx.searchPath(), content);
	}

	private JPathValue visitSearchPath(SearchPathContext ctx, JPathValue content) {
		JPathValue ret = visitStep(ctx.step(), content);

		if (ret == null || ret.getContent() == null) {
			return null;
		}

		return this.visitPredicate(ctx.predicate(), ret);
	}

	private JPathValue visitStep(JPathProcessorParser.StepContext ctx, JPathValue content) {
		String step = null;
		if (content == null) {
			return null;
		}

		if ("*".equals(ctx.getText())) {
			return content;
		}

		if (ctx.NCName() != null) {
			step = ctx.NCName().getText();
		} else if (ctx.Literal() != null) {
			step = JPathUtil.parseLiteral(ctx.Literal().getText());
		} else if (ctx.all() != null) {
			return content;
		}

		if (content.getContent() == null) {
			return null;
		}

		if (content.getContent().isJsonObject()) {
			return content.getChild(step);
		} else if (content.getContent().isJsonArray()) {
			JsonArray array = content.getContent().getAsJsonArray();
			JsonArray ret = new JsonArray();
			for (JsonElement el : array) {
				if (el.isJsonObject()) {
					JsonObject obj = el.getAsJsonObject();
					if (obj.has(step)) {
						ret.add(obj.get(step));
					}
				}
			}
			if (ret.size() > 0) {
				return new JPathValue(ret, content);
			} else {
				return null;
			}
		}
		return null;
	}

	private JPathValue visitPredicate(JPathProcessorParser.PredicateContext ctx, JPathValue content) {
		JsonElement el = null;
		if (ctx.chooseSelect() != null) {
			JsonElement choose = content.getContent();
			if (choose == null || choose.isJsonPrimitive() || choose.isJsonNull()) {
				return null;
			}
			el = visitChooseSelect(ctx.chooseSelect(), choose);
		} else if (ctx.arrayExpr() != null) {
			el = visitArrayExpr(ctx.arrayExpr(), content);
		} else if (ctx.conditionSelect() != null) {
			el = visitConditionSelect(ctx.conditionSelect());
		}
		return new JPathValue(el, content);
	}

	private JsonElement visitArrayExpr(JPathProcessorParser.ArrayExprContext ctx, JPathValue content) {
		if (content == null) {
			return null;
		}

		if (ctx.numSelect() != null) {
			JsonElement el = content.getContent();
			if (!el.isJsonArray()) {
				return null;
			}
			return visitNumSelect(ctx.numSelect(), el.getAsJsonArray());
		} else if (ctx.rangeSelect() != null) {
			JsonElement el = content.getContent();
			if (!el.isJsonArray()) {
				return null;
			}
			return visitRangeSelect(ctx.rangeSelect(), el.getAsJsonArray());
		} else if (ctx.conditionSelect() != null) {
			return visitConditionSelect(ctx.conditionSelect(), content);
		} else if (ctx.all() != null) {
			return content.getContent();
		} else if (ctx.functionFetch() != null) {
			JsonElement el = content.getContent();
			return this.visitFunctionFetch(ctx.functionFetch(), el);
		}

		JsonElement el = content.getContent();
		if (!el.isJsonObject()) {
			return null;
		}
		return this.visitExistCheck(ctx.existCheck(), el.getAsJsonObject());
	}

	private JsonElement visitFunctionFetch(FunctionFetchContext ctx, JsonElement content) {

		if (content == null || content.isJsonNull() || content.isJsonPrimitive()) {
			return null;
		}

		FetchNameContext name = ctx.fetchName();
		String funName = name.NCName().getText();
		int size = ctx.functionNodeName().size();
		Map<String, JsonElement> els = new HashMap<>();

		if (content.isJsonObject()) {
			for (int i = 0; i < size; i++) {
				String path = ctx.functionNodeName(i).subSearchPath().getText();

				els.put(String.format("%s-{%d}", path, i), find(path, content.getAsJsonObject()));
			}
			return FunctionPool.process(funName, content, els);
		}

		JsonArray array = content.getAsJsonArray();

		for (int j = 0; j < array.size(); j++) {
			JsonElement el = array.get(j);
			if (el.isJsonObject()) {
				for (int i = 0; i < size; i++) {
					String path = ctx.functionNodeName(i).subSearchPath().getText();
					els.put(String.format("%s-{%d,%d}", path, i, j), find(path, el.getAsJsonObject()));
				}
			} else if (el.isJsonArray()) {
				JsonArray ar = el.getAsJsonArray();
				for (int n = 0; n < ar.size(); n++) {
					JsonElement x = ar.get(n);
					for (int i = 0; i < size; i++) {
						String path = ctx.functionNodeName(i).subSearchPath().getText();
						JsonElement s = find(path, x.getAsJsonObject());
						els.put(String.format("%s-{%d,%d,%d}", path, i, n, j), s);
					}
				}
			}
		}
		return FunctionPool.process(funName, content, els);
	}

	private JsonElement visitNumSelect(JPathProcessorParser.NumSelectContext ctx, JsonArray el) {

		if (el == null) {
			return null;
		}

		JsonArray result = new JsonArray();
		int size = ctx.INT().size();
		if (size == 1) {
			String v = ctx.INT(0).getText();
			int index = Integer.parseInt(v);
			return el.get(index);
		}
		int num = el.size();
		for (int i = 0; i < size; i++) {
			String v = ctx.INT(i).getText();
			int index = Integer.parseInt(v);
			index = index < 0 ? num + index : index;
			if (index < num) {
				result.add(el.get(index));
			}
		}
		return result;
	}

	private JsonArray visitRangeSelect(JPathProcessorParser.RangeSelectContext ctx, JsonArray el) {
		JsonArray result = new JsonArray();
		List<RangeExprContext> rangs = ctx.rangeExpr();
		for (RangeExprContext r : rangs) {
			result.addAll(visitRangeExpr(r, el));
		}
		return result;
	}

	private JsonArray visitRangeExpr(JPathProcessorParser.RangeExprContext ctx, JsonArray el) {
		if (el == null || el.isJsonNull()) {
			return null;
		}
		JsonArray result = new JsonArray();

		int size = el.size();
		int start = Integer.parseInt(ctx.INT(0).getText());
		int stop = Integer.parseInt(ctx.INT(1).getText());

		start = start < 0 ? size + start : start;
		start = start >= size ? size - 1 : start;
		stop = stop < 0 ? size + stop : stop;
		stop = stop >= size ? size - 1 : stop;

		start = start < 0 ? 0 : start;
		stop = stop < 0 ? 0 : stop;

		for (int i = start; i <= stop; i++) {
			result.add(el.get(i));
		}

		return result;
	}

	private JsonElement visitChooseSelect(JPathProcessorParser.ChooseSelectContext ctx, JsonElement el) {
		if (el == null) {
			return null;
		}
		if (el.isJsonObject()) {
			JsonObject result = new JsonObject();
			int size = ctx.NCName().size();
			for (int i = 0; i < size; i++) {
				String v = ctx.NCName(i).getText();
				JsonElement sel = find(v, el.getAsJsonObject());
				if (null != sel) {
					result.add(v, sel);
				}
			}
			return result;
		} else if (el.isJsonArray()) {
			JsonArray array = el.getAsJsonArray();
			JsonArray ret = new JsonArray();
			int size = ctx.NCName().size();
			for (JsonElement e : array) {
				if (!e.isJsonObject()) {
					continue;
				}
				JsonObject result = new JsonObject();
				for (int i = 0; i < size; i++) {
					String v = ctx.NCName(i).getText();
					JsonElement sel = find(v, e.getAsJsonObject());
					if (null != sel) {
						result.add(v, sel);
					}
				}
				ret.add(result);
			}
			return ret;
		}

		return null;
	}

	private JsonElement visitConditionSelect(ConditionSelectContext ctx, JPathValue content) {
		if (ctx.conditionExpr() == null || content == null || content.getContent() == null) {
			return null;
		}
		JsonElement el = content.getContent();
		if (el.isJsonArray()) {
			return this.processArray(ctx, el.getAsJsonArray());
		} else if (el.isJsonObject()) {
			return this.processJsonObject(ctx, el);
		} else if (el.isJsonPrimitive()) {
			if (this.processPrimitive(ctx, el)) {
				return content.getParent().getContent();
			} else {
				return null;
			}
		}
		return this.visit(ctx);
	}

	private boolean processPrimitive(ConditionSelectContext ctx, JsonElement content) {
		int size = ctx.conditionExpr().size();
		boolean ok = visitConditionExpr(ctx.conditionExpr(0), content);
		for (int i = 1; i < size; i++) {
			boolean result = visitConditionExpr(ctx.conditionExpr(i), content);
			int index = 2 * i - 1;
			String op = ctx.getChild(index).getText();
			if (op.equals("&&")) {
				ok = ok && result;
			} else {
				ok = ok || result;
			}
		}
		return ok;
	}

	private JsonElement processJsonObject(ConditionSelectContext ctx, JsonElement content) {
		int size = ctx.conditionExpr().size();
		boolean ok = visitConditionExpr(ctx.conditionExpr(0), content);
		for (int i = 1; i < size; i++) {
			boolean result = visitConditionExpr(ctx.conditionExpr(i), content);
			int index = 2 * i - 1;
			String op = ctx.getChild(index).getText();
			if (op.equals("&&")) {
				ok = ok && result;
			} else {
				ok = ok || result;
			}
		}
		if (ok) {
			return content;
		}

		return null;
	}

	private final boolean arrayCondition(ConditionSelectContext ctx, int size, JsonElement el) {
		boolean ok = visitConditionExpr(ctx.conditionExpr(0), el);
		for (int i = 1; i < size; i++) {
			boolean result = visitConditionExpr(ctx.conditionExpr(i), el);
			int index = 2 * i - 1;
			String op = ctx.getChild(index).getText();
			if (op.equals("&&")) {
				ok = ok && result;
			} else {
				ok = ok || result;
			}
		}
		return ok;
	}

	private JsonElement processArray(ConditionSelectContext ctx, JsonArray array) {
		int size = ctx.conditionExpr().size();
		JsonArray ret = new JsonArray();

		boolean primitiveOnly = true;
		for (JsonElement el : array) {
			if (!el.isJsonPrimitive()) {
				primitiveOnly = false;
			}
		}

		if (primitiveOnly) {
			if (arrayCondition(ctx, size, array)) {
				return array;
			}
			return null;
		} else {
			for (JsonElement el : array) {
				if (el.isJsonArray()) {
					for (JsonElement child : el.getAsJsonArray()) {
						if (arrayCondition(ctx, size, child)) {
							ret.add(child);
						}
					}
				} else {
					if (arrayCondition(ctx, size, el)) {
						ret.add(el);
					}
				}
			}
		}

		return ret;
	}

	private static boolean compare(String op, double left, double right) {

		if (">=".equals(op)) {
			return left >= right;
		} else if ("<=".equals(op)) {
			return left <= right;
		} else if (">".equals(op)) {
			return left > right;
		} else if ("<".equals(op)) {
			return left < right;
		} else if ("==".equals(op)) {
			return left == right;
		}
		return false;
	}

	private static boolean compare(String op, long left, long right) {

		if (">=".equals(op)) {
			return left >= right;
		} else if ("<=".equals(op)) {
			return left <= right;
		} else if (">".equals(op)) {
			return left > right;
		} else if ("<".equals(op)) {
			return left < right;
		} else if ("==".equals(op)) {
			return left == right;
		}
		return false;
	}

	@Override
	public JsonPrimitive visitNumValue(JPathProcessorParser.NumValueContext ctx) {
		String val = ctx.getText();
		if (ctx.INT() != null) {
			return new JsonPrimitive(Integer.parseInt(val));
		}
		return new JsonPrimitive(Double.parseDouble(val));
	}

	private JsonElement visitExistCheck(ExistCheckContext ctx, JsonObject content) {
		if (content.has(ctx.NCName().getText())) {
			return content;
		}
		return null;
	}

	private boolean visitConditionExpr(ConditionExprContext ctx, JsonElement source) {

		if (ctx.functionCheck() != null) {
			return visitFunctionCheck(ctx.functionCheck(), source);
		}

		if (ctx.subSearchPath() != null) {
			JsonElement el = visitSubSearchPath(ctx.subSearchPath(), source);
			if (el == null) {
				return false;
			}
			JPathProcessorParser.NumValueContext context = ctx.numValue();
			String val = context.getText();
			if (context.INT() != null) {
				long v = el.getAsLong();
				return compare(ctx.op.getText(), v, Long.parseLong(val));
			}
			double x = el.getAsDouble();
			return compare(ctx.op.getText(), x, Double.parseDouble(val));
		} else if (ctx.funValue() != null) {
			Object ret = this.funValue(ctx.funValue(), source);
			if (ret == null) {
				return false;
			}
			JPathProcessorParser.NumValueContext context = ctx.numValue();
			String val = context.getText();
			if (context.INT() != null) {
				long v = (long) ret;
				return compare(ctx.op.getText(), v, Long.parseLong(val));
			}
			double x = (double) ret;
			return compare(ctx.op.getText(), x, Double.parseDouble(val));
		}

		return false;
	}

	private Object funValue(FunValueContext ctx, JsonElement el) {
		String funName = ctx.funValueName().NCName().getText();

		JsonElement e = el;
		if (ctx.functionNodeName() != null) {
			String nodeName = ctx.functionNodeName().subSearchPath().getText();
			e = find(nodeName, el.getAsJsonObject());
		}
		return FunctionPool.process(funName, e);
	}

	private JsonElement visitSubSearchPath(SubSearchPathContext ctx, JsonElement el) {

		if (el == null || !el.isJsonObject()) {
			return null;
		}

		return find(ctx.getText(), el.getAsJsonObject());
	}

	private Object param(FunctionParamContext context) {
		if (context.Literal() != null) {
			return JPathUtil.parseLiteral(context.getText());
		} else if (context.variableReference() != null) {
			String name = context.variableReference().NCName().getText();
			return this.store.get(name);
		} else {
			return context.Number().getText();
		}
	}

	private boolean visitFunctionCheck(FunctionCheckContext ctx, JsonElement el) {
		if (el == null) {
			return false;
		}
		String funName = ctx.functionName().NCName().getText();
		FunctionNodeNameContext v = ctx.functionNodeName();
		int size = ctx.functionParam().size();

		Object[] params = new Object[size];
		if (v == null) {
			if (size < 1) {
				return FunctionPool.invoke(funName, el);
			} else {
				for (int i = 0; i < size; i++) {
					FunctionParamContext context = ctx.functionParam(i);
					params[i] = param(context);
				}
				return FunctionPool.invoke(funName, el, params);
			}
		} else {
			if (el.isJsonObject()) {
				String nodeName = v.subSearchPath().getText();
				JsonElement ret = find(nodeName, el.getAsJsonObject());

				if (size < 1) {
					return FunctionPool.invoke(funName, ret);
				} else {
					for (int i = 0; i < size; i++) {
						FunctionParamContext context = ctx.functionParam(i);
						params[i] = param(context);
					}
					return FunctionPool.invoke(funName, ret, params);
				}
			}
			return false;
		}
	}
}