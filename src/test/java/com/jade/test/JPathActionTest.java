package com.jade.test;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jade.path.processor.JPathAction;

public class JPathActionTest {
	@Test
	public void test1() {
		JsonObject elements = new JsonObject();
		JsonObject a = new JsonObject();
		JsonObject b = new JsonObject();
		elements.add("a", a);
		a.add("b", b);
		JsonArray c = new JsonArray();
		b.add("c", c);

		b.addProperty("test", "this is a test");
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

		JsonObject x = JPathAction.process(elements, "a/b[fm:remove(@test)]");
		System.out.println(x);

		x = JPathAction.process(elements, "a[fm:remove(@b)]");
		System.out.println(x);
		System.out.println(elements);
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

		b.addProperty("test", "this is a test");
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

		JsonObject x = JPathAction.process(elements, "a/b/c[fm:remove(@test)]");
		System.out.println(x);

		x = JPathAction.process(elements, "a/b/c[fm:add(@abc, 123)]");
		System.out.println(x);

		x = JPathAction.process(elements, "a/b[fm:add(@abc, 123)]");
		System.out.println(x);

		x = JPathAction.process(elements, "a/b[fm:default(@fxx, 123)]");
		System.out.println(x);

		x = JPathAction.process(x, "a/b[fm:rename(@fxx, 'xxxxx')]");
		System.out.println(x);
	}

}
