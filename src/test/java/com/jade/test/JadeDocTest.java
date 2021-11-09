package com.jade.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.jade.path.JadeDoc;
import com.jade.path.JadeDoc.Builder;
import com.jade.path.JadeDoc.Builder.RegularPattern;
import com.jade.path.JadeDoc.CompiledPattern;
import com.jade.path.exception.ItemNotFoundException;
import com.jade.path.processor.JPathAction;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

class JadeDocTest {

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
	void testSerialize() throws IOException {
		JadeDoc doc = JadeDoc.build().create();
		doc.add("test", 123);
		Integer x = doc.fromJson("test", Integer.class);
		System.out.println(x);
	}
	
	@Test
	void testCompileFunction() throws IOException {
		JadeDoc doc = JadeDoc.build().create(read("test2.json"));
		System.out.println(doc.fetch("properties[fn:equal(@name,'isName')]/*[0]"));
		CompiledPattern compiledPattern = new CompiledPattern(
				"I love @{name}, but hate @{properties[fn:equal(@name,'isName')]/*[0]/name}");
		String content = doc.compileX(compiledPattern);
		System.out.println(content);

		compiledPattern = new CompiledPattern(
				"I love #{name}, but hate #{properties[fn:equal(@name,'isName')]/*[0]/name}", "#");
		content = doc.compileX(compiledPattern);
		System.out.println(content);
	}

	@Test
	public void testRegulaxExpress() throws IOException {
		String regex = "(?<city>[A-Za-z]+),(?<state>[A-Z]{2,2}):(?<areaCode>[0-9]{3,3})";
		RegularPattern regularPattern = new RegularPattern(regex);
		JadeDoc doc = regularPattern.fromRegularExpression("Toront,ON:345");

		System.out.println(doc);
	}

	@Test
	public void testJsonFunction() throws IOException {
		JadeDoc doc = JadeDoc.build().create(read("mms.json"));
		JsonElement el = doc.fetch("payload/resource/properties[ft:json(@name,@values)]");
		System.out.println(el.toString());
	}
	
	@Test
	public void testRegex() {
		Pattern JSONKEY = Pattern.compile("(?<path>\\S+)\\-\\{(?<index>\\d+)(,(?<row>\\d+))?(,(?<col>\\d+))?\\}");
		Matcher matcher = JSONKEY.matcher("name-{0,1}");
		if (matcher.matches()) {
			System.out.println(matcher.group("index"));
			System.out.println(matcher.group("row"));
		}
		matcher = JSONKEY.matcher("name-{0}");
		if (matcher.matches()) {
			System.out.println(matcher.group("index"));
			System.out.println(matcher.group("row"));
		}
		matcher = JSONKEY.matcher("name-{0,1,2}");
		if (matcher.matches()) {
			System.out.println(matcher.group("index"));
			System.out.println(matcher.group("row"));
			System.out.println(matcher.group("col"));
		}
	}

	@Test
	public void testCompile() {
		Builder builder = JadeDoc.build();
		JadeDoc doc = builder.create();
		// add string object
		doc.add("a/b/c", "test");
		// add long
		doc.add("a/b/d", 123l);
		// add int
		doc.add("a/b/e", 12);
		// add float
		doc.add("a/b/f", 123.98);
		// add boolean
		doc.add("a/b/g", true);

		CompiledPattern compiledPattern = new CompiledPattern("@{a/b/dd:#34}");
		System.out.println(doc.compileX(compiledPattern));
	}

	@Test
	public void testCreate() {
		Builder builder = JadeDoc.build();
		JadeDoc doc = builder.create();
		// add string object
		doc.add("a/b/c", "test");
		// add long
		doc.add("a/b/d", 123l);
		// add int
		doc.add("a/b/e", 12);
		// add float
		doc.add("a/b/f", 123.98);
		// add boolean
		doc.add("a/b/g", true);

		JsonArray x = new JsonArray();
		JsonObject element = new JsonObject();
		JsonPrimitive v1 = new JsonPrimitive(true);
		JsonPrimitive v2 = new JsonPrimitive(233l);
		element.add("dcm", v1);
		element.add("test", v2);
		x.add(element);
		element = new JsonObject();
		element.add("dcm2", v1);
		element.add("test2", v2);
		x.add(element);
		doc.add("a/b/h", x);

		System.out.println(builder.toJson(doc));

		JadeDoc model = builder.create();

		String[] s = null;
		model.add("a/b", s);

		String sx = null;
		model.add("a/b", sx);

		model.add("a/b", "test1");
		model.add("a/c", "test1", "test2", "test3");

		JadeDoc model2 = builder.create();
		model2.add("a/b", "test1");
		model2.add("a/c", "test1", "test2", "test3");

		doc.join(model, model2);

		System.out.println(builder.toJson(doc));
	}

	@Test
	public void testCreate2() {
		Builder builder = JadeDoc.build();
		JadeDoc doc = builder.create();
		// add string object
		doc.add("a/b/c", "test");
		// add long
		doc.add("a/b/d", 123l);
		// add int
		doc.add("a/b/e", 12);
		// add float
		doc.add("a/b/f", 123.98);
		// add boolean
		doc.add("a/b/g", true);

		System.out.println(doc);

		System.out.println(doc.fetch("a/b"));

		Map<String, Object> values = new HashMap<>();
		values.put("test", "test");
		System.out.println(doc.fetch("*[fn:equalsignorecase(@a/b/c,$test)]", values));
		System.out.println(doc.fetch("a/b[@c]", values));
	}

	@Test
	public void test2() {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create();
		model.add("a/b/c", "test");
		model.add("a/b/d", 123l);
		model.add("a/b/e", 123.98);
		JsonArray x = new JsonArray();
		JsonObject element = new JsonObject();
		JsonPrimitive v1 = new JsonPrimitive(true);
		JsonPrimitive v2 = new JsonPrimitive(233l);
		element.add("dcm", v1);
		element.add("test", v2);
		x.add(element);
		element = new JsonObject();
		element.add("dcm2", v1);
		element.add("test2", v2);
		x.add(element);
		model.add("a/b/f", x);
		System.out.println(builder.toJson(model));
		System.out.println(model.fetch("a/b"));
	}

	@Test
	public void test3() throws ItemNotFoundException {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create();
		model.add("a/b/c", "test");
		model.add("a/b/d", 123l);
		model.add("a/b/e", 123.98);

		JadeDoc item = builder.create();
		item.add("dcm", true);
		item.add("test", 123l);

		JadeDoc item2 = builder.create();
		item2.add("dcm", true);
		item2.add("test", 1234);

		JadeDoc item3 = builder.create();
		item3.add("dcm", false);
		item3.add("test", 1230l);

		model.add("a/b/f", item.content(), item2.content(), item3.content());

		System.out.println(builder.toJson(model));
		System.out.println(model.fetch("a/b"));

		try {
			// thrown.expect(ItemNotFoundException.class);
			System.out.println(model.getAsDouble("a/b/e"));
		} catch (ItemNotFoundException ex) {

		}
	}

	@Test
	public void test6() {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create();

		String[] s = null;
		model.add("a/b", s);

		String sx = "xxx";
		model.add("a/b", sx);

		model.add("a/b", "test1");
		model.add("a/c", "test1", "test2", "test3");

		JadeDoc model2 = builder.create();
		model2.add("a/b", "test1");
		model2.add("a/c", "test1", "test2", "test3");

		JadeDoc all = builder.create();

		all.add("mx", model, model2);

		System.out.println(builder.toJson(all));
	}

	@Test
	public void test7() {
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

		System.out.println(builder.toJson(model));

		JadeDoc model2 = builder.create(builder.toJson(model));
		System.out.println(builder.toJson(model2));

		JadeDoc model3 = builder.create(new JsonObject());
		System.out.println(builder.toJson(model3));

		JadeDoc model4 = builder.create(new StringReader(builder.toJson(model)));
		System.out.println(builder.toJson(model4));
	}

	@Test
	public void test8() {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/c/BigDecimal", new BigDecimal(1.0d));
		model.add("a/c/double", 1.0d);
		model.add("a/c/string", "abc");
		Number num = new Integer(2);
		model.add("a/c/number", num);
		model.add("a/c/number", 1);
		model.add("a/c/bool", true);
		model.add("a/c/object", new JsonObject());

		JadeDoc model2 = builder.create(builder.toJson(model));
		JadeDoc model3 = builder.create(new JsonObject());
		JadeDoc model4 = builder.create(new StringReader(builder.toJson(model)));

		JadeDoc[] v = null;
		System.out.println(JadeDoc.merge(v));
		System.out.println(JadeDoc.create("a/b", v));

		System.out.println(JadeDoc.merge(model, model2, model3));
		System.out.println(JadeDoc.create("a/b", model, model2, model3, model4));
		System.out.println(builder.toJson(model));
	}

	public void test9() throws ItemNotFoundException {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/c/BigDecimal", new BigDecimal(1.0d));
		model.add("a/c/double", 1.0d);
		model.add("a/c/string", "abc");
		Number num = new Integer(2);
		model.add("a/c/number", num);
		model.add("a/c/number2", 1);
		model.add("a/c/bool", true);
		model.add("a/c/x", new JsonPrimitive("abc"));
		model.add("a/c/x2", new JsonPrimitive("abc"));

		model.remove("a/c/x2");

		System.out.println(model);
		assertThrows(ItemNotFoundException.class, () -> {
			System.out.println(model.getAsDouble("a/c/double"));
			System.out.println(model.getAsString("a/c/string"));
			System.out.println(model.getAsInt("a/c/number"));
			System.out.println(model.getAsLong("a/c/number"));
			System.out.println(model.getAsBoolean("a/c/bool1"));
			System.out.println(model.fetch(""));
		});
	}

	@Test
	public void test10() throws ItemNotFoundException {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/b/c", 1.0d);
		model.add("a/b/d", "first", "second", "three");

		System.out.println(model);
	}

	@Test
	public void test11() {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/b/c", 1.0d);

		JadeDoc model1 = builder.create();
		model1.add("model1/a", 1.0d);
		model1.add("model1/b", true);
		model1.add("model1/c", "test");

		JadeDoc model2 = builder.create();
		model2 = builder.create();
		model2.add("model2/a", 3.0d);
		model2.add("model2/b", false);
		model2.add("model2/c", "test2");

		JadeDoc model3 = builder.create();
		model3 = builder.create();
		model3.add("model3/a", 3.0d);
		model3.add("model3/b", false);
		model3.add("model3/c", "test3");

		model.add("a/b/d", model1, model2, model3);

		System.out.println(model);
	}

	@Test
	public void test12() {
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);
		model.add("a/b/c", 1.0d);

		JadeDoc model1 = builder.create();
		model1.add("model1/a", 1.0d);
		model1.add("model1/b", true);
		model1.add("model1/c", "test");

		JadeDoc model2 = builder.create();
		model2 = builder.create();
		model2.add("model2/a", 3.0d);
		model2.add("model2/b", false);
		model2.add("model2/c", "test2");

		JadeDoc model3 = builder.create();
		model3 = builder.create();
		model3.add("model3/a", 3.0d);
		model3.add("model3/b", false);
		model3.add("model3/c", "test3");

		model.add("a/b/d", model1, model2, model3);

		System.out.println(model);
	}

	@Test
	public void test20() throws IOException {
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.pattern("header", "head");

		template.pattern("payload[0]", "resource/a");
		template.pattern("payload[1]", "resource/b");
		template.pattern("payload[2]", "resource/c");
		template.pattern("payload[<4,6>]", "resource/d");

		template.action("resource/d[id<4][fm:remove(@program, @rating)]");
		template.action("resource/b[fm:remove(@program, @rating, @channel)]");
		template.remove("resource/a/program").remove("resource/a/rating");

		System.out.println(template);

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("testA.json"));

		System.out.println(model.toJson());
	}

	@Test
	public void test21() throws IOException {
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.pattern("header", "head");
		template.pattern("payload[0]", "resource/a");
		template.pattern("payload[1]", "resource/b");
		template.pattern("payload[2]", "resource/c");

		template.pattern("payload[<4,6>]", "resource/d");

		template.action("resource/d[id>1][fm:remove(0,1)]");
		template.action("resource/b[fm:remove(@program, @rating, @channel)]");
		template.remove("resource/a/program").remove("resource/a/rating");
		template.remove("resource/d[0]");

		System.out.println(template);

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("testA.json"));
		System.out.println(model.toJson());
	}

	@Test
	public void test22() throws IOException {
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.pattern("header", "head");
		template.pattern("payload[0]", "resource/a");
		template.pattern("payload[1]", "resource/b");
		template.pattern("payload[2]", "resource/c");

		template.pattern("payload[<4,6>]", "resource/d");

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("testA.json"));
		System.out.println(model.toJson());

		JadeDoc doc = model.queryBuilder().where("id==1").select("resource/a", "page/page1")
				.select("resource/b", "rs/b").union("id==2").select("resource/c", "abc").build()
				.query(null);
		System.out.println(doc.toJson());
	}

	@Test
	public void test23() throws IOException {
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.remove("header");
		template.pattern("payload[0]", "");

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("test1.json"));
		System.out.println(model.toJson());
	}

	@Test
	public void test25() {
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

		JadeDoc doc = JadeDoc.build().create(elements);

		Map<String, Object> values = new HashMap<>();
		values.put("title", "java");
		JsonElement el = doc.fetch("a/b/title[fn:contain($title)]", values);
		System.out.println(el);
		el = doc.fetch("a/b/title[fn:contain($title)]/c", values);
		System.out.println(el);
		el = doc.fetch("a/b/title[fn:contain($title)]/c[0]/*", values);
		System.out.println(el);
		el = doc.fetch("a/b/title[fn:contain($title)]/c[0]/test", values);
		System.out.println(el);
		el = doc.fetch("a/*/title[fn:contain($title)]/c[0]/test", values);
		System.out.println(el);
		el = doc.fetch("a/*/title[fn:contain($title)]/*/test", values);
		System.out.println(el);
	}

	@Test
	public void test26() {
		JadeDoc doc = JadeDoc.build().create();
		doc.add("abc", "java", "python", "c++", "go");
		System.out.println(doc.fetch("abc[fn:contain('java', 'go')]"));
		System.out.println(doc.fetch("*abc[fn:contain('java', 'go')]"));
	}

	@Test
	public void test27() throws IOException {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create(read("test3.json"));

		System.out.println(model.fetch("asset[fn:equal(@name, 'test1')]/*[0]"));
	}

	@Test
	public void test28() throws IOException {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create(read("test4.json"));
		String fs = "key_%s_v2";
		model.forEachX("materialId", id -> {
			System.out.println(String.format(fs, id.getAsString()));
		});
	}

	@Test
	public void test29() throws IOException {
		Builder builder = JadeDoc.build();
		JadeDoc model = builder.create(read("test4.json"));
		JadeDoc.CompiledPattern fs = new JadeDoc.CompiledPattern("key-@{name}_@{Ids}_v2")  ;

		List<String> xs = fs.compileXs(model);
		for (String x : xs) {
			System.out.println(x);
		}
	}

	@Test
	public void test30() throws IOException, Exception {
		Builder builder = JadeDoc.build();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputStream inputFile = this.getClass().getClassLoader().getResourceAsStream("testxml.xml");
		Document doc = dBuilder.parse(inputFile);
		JadeDoc model = builder.create(doc, false);
		System.out.println(model.toJson());
	}

	@Test
	public void test31() throws IOException, Exception {
		Builder builder = JadeDoc.build();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputStream inputFile = this.getClass().getClassLoader().getResourceAsStream("employees.xml");
		Document doc = dBuilder.parse(inputFile);
		JadeDoc model = builder.create(doc, false);
		System.out.println(model.toJson());
	}
}
