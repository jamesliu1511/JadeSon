package com.jade.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jade.path.JadeDoc;
import com.jade.path.JadeDoc.Builder;
import com.jade.path.processor.JPathProcessor;

public class JPathProcessorTest {

	@Test
	public void test1() {
		JadeDoc doc = JadeDoc.build().create();

		doc.add("a/b/c/e/num", 2);
		doc.add("a/b/c/e/a", 4);

		doc.add("a/b/d/c", 2);
		doc.add("a/b/d/a", 4);

		JsonElement el = doc.fetch("a/b/c{e,d}");
		System.out.println(el);
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

		System.out.println(doc);
		JsonElement el = doc.fetch("a/b/c[<0,3>,<0,0>, <1,2>]");
		System.out.println(el);
	}

	@Test
	public void test3() {
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

		JsonElement el = JPathProcessor.find("a/b/c[<0,3>,<1,2>]", elements);
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

		JsonElement el = JPathProcessor.find("a/b/c[<-4,-1>,<1,2>]", elements);
		System.out.println(el);
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

		JsonObject e = new JsonObject();
		e.addProperty("test", "ok");
		c.add(e);
		JsonObject d = new JsonObject();
		d.addProperty("num", 2);
		d.addProperty("a", 4);
		c.add(d);
		JsonObject d2 = new JsonObject();
		d2.addProperty("num2", true);
		d2.addProperty("a", 4);

		c.add(d2);

		JsonElement el = JPathProcessor.find("a/b/c[num>=2 && a > 3]", elements);
		System.out.println(el);
		el = JPathProcessor.find("a/b/c[num>=2 || a > 3]", elements);
		System.out.println(el);
		el = JPathProcessor.find("a/b/c[num>=2 && a > 3]", elements);
		System.out.println(el);

		assertThrows(Exception.class, () -> {
			JPathProcessor.find("a/b/c[num>=2 |&  a > 3]", elements);
		});
		System.out.println(el);
	}

	@Test
	public void test6a() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonObject c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 4);
		b.add("c", c);

		c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 2);
		b.add("d", c);

		JadeDoc doc = JadeDoc.build().create(elements);
		JsonElement el = doc.fetch("a/b?c/num>=2 && c/a > 3");
		System.out.println(el);
	}

	@Test
	public void test6() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonObject c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 4);
		b.add("c", c);

		c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 2);
		b.add("d", c);

		JsonElement el = JPathProcessor.find("a/b?num>=2 && a > 3", elements);
		System.out.println(el);

		el = JPathProcessor.find("a/b[num>=2 && a > 3]", elements);
		System.out.println(el);
	}

	@Test
	public void test7a() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonObject c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 4);
		b.add("c", c);

		c.addProperty("x", "abc");

		c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 2);
		c.addProperty("x", "bc");
		c.addProperty("y", "abc");
		b.add("d", c);

		JadeDoc doc = JadeDoc.build().create(elements);
		System.out.println(doc);
		JsonElement el = doc.fetch("a/b[fn:reg(@d/x,'^a*bc$') && fn:reg(@d/y,'^a*bc$')]");
		System.out.println(el);
	}

	@Test
	public void test7() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonObject c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 4);
		b.add("c", c);

		c.addProperty("x", "abc");

		c = new JsonObject();
		c.addProperty("num", 2);
		c.addProperty("a", 2);
		c.addProperty("x", "bc");
		b.add("d", c);

		System.out.println(elements);
		JsonElement el = JPathProcessor.find("a/b/c?fn:reg(@x,'^a*bc$')", elements);
		System.out.println(el);

		el = JPathProcessor.find("a/b/c/e", elements);
		System.out.println(el);
	}

	@Test
	public void test8() {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/c/BigDecimal", new BigDecimal(1.0d));
		model.add("a/c/double", 1.0d);
		model.add("a/c/string", "abc");
		model.add("a/c/string2", new String[] { "abc" });
		model.add("a/c/string3", "");
		Number num = new Integer(2);
		model.add("a/c/number", num);
		model.add("a/c/number", 1);
		model.add("a/c/bool", true);
		model.add("a/c/object", new JsonObject());

		System.out.println(model);
		el = JPathProcessor.find("a/c{string, number, object}", model.content());
		System.out.println(el);
	}

	@Test
	public void test8a() {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);

		JsonArray array = new JsonArray();
		for (int i = 0; i < 3; i++) {
			JsonObject content = new JsonObject();
			content.addProperty("content", "this is test -" + i);
			content.addProperty("enabled", true);
			content.addProperty("value", i);
			array.add(content);
		}
		model.add("a/c/b", array);

		System.out.println(model);
		el = JPathProcessor.find("a/c/b{content, enabled}", model.content());
		System.out.println(el);
	}

	@Test
	public void test9() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);
		b.addProperty("disabled", true);

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

		JsonElement el = doc.fetch("a/b/disabled[fn:bool()]");
		System.out.println(el);
		el = doc.fetch("a/b/disabled[fn:true()]");
		System.out.println(el);
		el = doc.fetch("a/b/disabled[fn:false()]");
		el = doc.fetch("a/b/disabled[fn:bool() && fn:true()]");
		System.out.println(el);
	}

	@Test
	public void test10() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonObject f = new JsonObject();
		a.add("e", f);

		f.addProperty("test", "test E");
		f.addProperty("title", "thinking in java");
		
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
		JsonElement el = JPathProcessor.find("a/b/title[fn:contain($title)]", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/b/title[fn:contain($title)]/c", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/b/title[fn:contain($title)]/c[0]/*", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/b/title[fn:contain($title)]/c[0]/test", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/*/title[fn:contain($title)]/*/test", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/*/title[fn:contain($title)]/c[*]/test", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/*/title[fn:contain($title)]/c[*]/test[0]", elements, values);
		System.out.println(el);
	}

	@Test
	public void test11() {
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
		JsonElement el = JPathProcessor.find("a/b/title[fn:contain($title)]/c[*]/test", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/b/title[fn:contain($title)]/c[0]/test", elements, values);
		System.out.println(el);
		el = JPathProcessor.find("a/b/title[fn:contain($title)]/c[1]/test", elements, values);
		System.out.println(el);
	}

	@Test
	public void test12() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonArray c = new JsonArray();
		b.add("c", c);

		b.addProperty("disabled", true);
		b.addProperty("title", "thinking in java");

		for (int i = 0; i < 10; i++) {
			JsonObject v = new JsonObject();
			v.addProperty("name", "name_" + i);
			v.addProperty("value", i);
			v.addProperty("enable", true);
			c.add(v);
		}

		System.out.println(elements);
		JsonElement el = JPathProcessor.find("a/b/c[ft:json(@name,@value, @enable)]", elements);
		System.out.println(el);
	}

	private String read(String file) throws IOException {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);

		final char[] buffer = new char[10000];
		final StringBuilder out = new StringBuilder();
		Reader reader = new InputStreamReader(in, "UTF-8");
		while (true) {
			int rsz = reader.read(buffer, 0, buffer.length);
			if (rsz < 0)
				break;
			out.append(buffer, 0, rsz);
		}
		return out.toString();
	}

	@Test
	public void test12b() throws IOException {
		JadeDoc doc = JadeDoc.build().create(read("test2.json"));
		JsonElement el = JPathProcessor.find("properties[ft:convert(@name, @bundle, @values, @multivalued, @propertyType)]", doc.content());
		System.out.println(el);
		el = JPathProcessor.find("properties[ft:json(@name, @values)]", doc.content());
		System.out.println(el);
	}

	@Test
	public void test13() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);

		JsonArray c = new JsonArray();
		b.add("c", c);

		b.addProperty("disabled", true);
		b.addProperty("title", "thinking in java");

		for (int i = 0; i < 10; i++) {
			JsonObject v = new JsonObject();
			v.addProperty("name", "name_" + i);
			v.addProperty("value", i);
			v.addProperty("enable", true);
			c.add(v);
		}

		System.out.println(elements);
		JsonElement el = JPathProcessor.find("a/b[ft:combine(@c/name,@c/value)]", elements);
		System.out.println(el);
	}

	@Test
	public void test14() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);
		b.addProperty("disabled", true);
		b.addProperty("title", "thinking in java");
		b.addProperty("discount", 0.8);

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

		JsonElement el = JPathProcessor.find("a/b/c[fv:val(@num)==2]", elements);
		System.out.println(el);

		el = JPathProcessor.find("a/b/discount[fv:val()> 0.5]", elements);
		System.out.println(el);
	}
}
