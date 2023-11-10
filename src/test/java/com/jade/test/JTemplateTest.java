package com.jade.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jade.path.JadeDoc;
import com.jade.path.JadeDoc.CompiledPattern;
import com.jade.path.exception.ItemNotFoundException;
import com.jade.path.fn.FunctionPool;
import com.jade.path.processor.JPathTemplate;

public class JTemplateTest {
	@Test
	public void test1() {
		JadeDoc doc = JadeDoc.build().create();

		doc.add("a/b/c/e/num", 2);
		doc.add("a/b/c/e/a", 4);

		doc.add("a/b/d/c", 2);
		doc.add("a/b/d/a", 4);

		JsonElement el = doc.fetch("a/b/c{e,d}");

		System.out.println(el);

		JsonObject x = JPathTemplate.add("ab/ac/x", el);

		System.out.println(x);
	}

	@Test
	public void test2a() {
		JadeDoc doc = JadeDoc.build().create();

		JsonArray c = new JsonArray();
		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		c.add(d2);

		doc.add("a/b/c", c);

		System.out.println(c);
		JsonElement el = doc.fetch("a/b/c[0,1, -1]");
		System.out.println(el);
		JsonObject x = JPathTemplate.add("ab/ac/x", el);

		System.out.println(x);
	}

	@Test
	public void test2b() {
		JadeDoc doc = JadeDoc.build().create();

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		doc.add("a/b/c", e, d, d2);

		JsonElement el = doc.fetch("a/b/c[0,1, -1]");
		System.out.println(el);
		JsonObject x = JPathTemplate.add("ab/ac/x", el);

		System.out.println(x);
	}

	@Test
	public void test2() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		c.add(d2);

		System.out.println(elements);

		JadeDoc doc = JadeDoc.build().create(elements);

		JsonElement el = doc.fetch("a/b/c[0,1,3, -1]");
		System.out.println(el);
	}

	@Test
	public void test3a() {
		JadeDoc doc = JadeDoc.build().create();

		JsonArray c = new JsonArray();

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		c.add(d2);

		doc.add("a/b/c", c);

		JsonElement el = doc.fetch("a/b/c[<0,3>,<1,2>]");

		el = JPathTemplate.add("ab/ac/v", doc.content(), "a/b/c");

		System.out.println(el);
	}

	@Test
	public void test4() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);
		b.addProperty("disabled", true);
		b.addProperty("title", "thinking in java");

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		c.add(d2);

		System.out.println(elements);

		Map<String, Object> values = new HashMap<>();
		values.put("title", "java");

		JsonObject ret = JPathTemplate.add("ab/ac/x", elements, "a/b/title[fn:contain($title)]/c[*]/test", values);

		ret = JPathTemplate.add(ret, "ab/ac/t", elements, "a/b/title[fn:contain($title)]/c[0]/test", values);
		System.out.println(ret);
	}

	@Test
	public void test5() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);
		b.addProperty("disabled", true);
		b.addProperty("title", "thinking in java");

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", 2);
		d2.addProperty("a", 3);

		JsonObject x = b.deepCopy();
		x.addProperty("title", "thinking in c#");
		a.add("x", x);

		c.add(d2);

		System.out.println(elements);

		Map<String, Object> values = new HashMap<>();
		values.put("title", "java,c#");

		BiPredicate<JsonElement, Object[]> fun = (el, content) -> {
			String title = (String) content[0];
			String[] rs = title.split(",");
			for (String r : rs) {
				if (el.getAsString().contains(r)) {
					return true;
				}
			}
			return false;
		};

		FunctionPool.registerFn("mycontain", fun);

		JsonObject ret = JPathTemplate.add("ab/ac/x1", elements, "a/b/title[fn:mycontain($title)]", values);
		System.out.println(ret);
		ret = JPathTemplate.add("ab/ac/x2", elements, "a/x/title[fn:mycontain($title)]", values);
		System.out.println(ret);

		ret = JPathTemplate.add("ab/ac/v", elements, "a/*/title[fn:mycontain($title)]", values);
		System.out.println(ret);
	}

	@Test
	public void testXX() {
		String data = "{\n" + "    \"main\": 6,\n" + "    \"sub\": {\n" + "        \"time\": 2,\n"
				+ "        \"overdue\": {\n" + "            \"percentage\": false,\n" + "            \"overdue\": 0\n"
				+ "        }\n" + "    }\n" + "}";

		Object x = JadeDoc.from(data, Object.class);
		System.out.println(JadeDoc.toJson(x));
	}

	@Test
	public void testX33() {
		String data = "{\"xid\":\"D001L01\",\"module\":\"headquarter\",\"pType\":\"building\",\"page\":\"structure\",\"httpMethod\":\"GET\",\"requestPath\":\"/api/headquarter/structure/building/D001L01\",\"template\":\"{\\\"patterns\\\":[{\\\"source\\\":\\\"mybatis/FloorMapper/select\\\",\\\"target\\\":\\\"data\\\"},{\\\"source\\\":\\\"status\\\"}]}\",\"pagewithconfig\":\"false\",\"type\":\"Floor\",\"config\":\"mybatis[FloorMapper.select]\"}";
		var all = JadeDoc.build().create(data);
		var template = JadeDoc.JsonTemplate.parse("");
		var templatePatterns = template.getCompilePattern();
		var newTemplate = template.generate(all, templatePatterns);
		var dynamicTemplate = new CompiledPattern(
				"{\"simplePattern\":[\"*\"], \"actions\":[\"*[fm:rename(@xid, '@{pType}Id')]\"]}");
		if (dynamicTemplate != null) {
			String content = dynamicTemplate.compileX(all);
			// var xx = JPathAction.process(all.content(), "*[fm:rename(@xid,
			// 'buildingId')]");
			// System.out.println(JadeDoc.toJson(xx));
			newTemplate.add(content);
		}
		var formatterDocBuilder = JadeDoc.template(newTemplate);
		var x = formatterDocBuilder.create(all);
		System.out.println(x.toJson());
	}

	@Test
	public void test44() throws ItemNotFoundException {
		JadeDoc doc = JadeDoc.build().create();
		doc.add("action", "edit");
		doc.add("abc", "xxx");
		doc.add("edit/handler", "test");
		// var s = new CompiledPattern("@{@{action}/handler}");
		// .out.println(s.compile(doc));

		String expression = "@{@{action}/handler},@{action}/handler, @{abc}-@{action}";
		CompiledPattern pattern = new CompiledPattern(expression);
		System.out.println(pattern.compile(doc));

		expression = "@{edit2/handler}";
		pattern = new CompiledPattern(expression);
		System.out.println(pattern.compileX(doc));
	}
}
