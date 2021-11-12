package com.jade.path;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.apache.commons.lang3.StringUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.compiler.STLexer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jade.path.exception.ItemNotFoundException;
import com.jade.path.processor.JPathAction;
import com.jade.path.processor.JPathProcessor;
import com.jade.path.processor.JPathTemplate;

public final class JadeDoc {

	private static final JadeDoc.Builder jadeDocBuilder = JadeDoc.build();

	private static final String SELF = "_self";
	private static final String ATTRS = "attrs";
	private static final String NAME = "name";
	private static final String VALUE = "value";
	private static final String S_S = "%s{%s}";
	private final Gson gson;
	private final JsonObject root;

	private static final Pattern HASDEFAULT = Pattern.compile("(?<name>.+):#(?<value>.*)");
	private static final String KEYPATTERN = "%s\\{(?<name>[^\\{\\}]+)\\}";
	private static final Pattern GATHERPATTERN = Pattern.compile("\\(\\?<(?<name>[A-Za-z0-9$]+)>");
	private static final Pattern INTPATTERN = Pattern.compile("-?\\d{1,10}");
	private static final Pattern LONGPATTERN = Pattern.compile("-?\\d{11,20}");
	private static final Pattern FLOATPATTERN = Pattern.compile("[+-]?(\\d+|\\d+\\.\\d+|\\.\\d+|\\d+\\.)([eE]\\d+)?");
	private static final Pattern BOOLPATTERN = Pattern.compile("([tT][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])");

	private static DocumentBuilder dBuilder;
	static {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// to be compliant, completely disable DOCTYPE declaration:
			factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			// or completely disable external entities declarations:
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			// or prohibit the use of all protocols by external entities:
			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			dBuilder = factory.newDocumentBuilder(); // Noncompliant
			factory.setNamespaceAware(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private JadeDoc(Gson gson) {
		this(gson, null);
	}

	private JadeDoc(Gson gson, JsonObject root) {
		if (root == null) {
			this.root = new JsonObject();
		} else {
			this.root = root;
		}
		this.gson = gson;
	}

	public <T> T fromJson(Class<T> classOfT) {
		return gson.fromJson(this.toJson(), classOfT);
	}

	public <T> T fromJson(String pattern, Class<T> classOfT) {
		return gson.fromJson(this.get(pattern), classOfT);
	}

	private static class STObject extends AbstractMap<String, Object> {
		private JadeDoc root;

		private STObject(JsonElement root) {
			this.root = JadeDoc.build().create(root);
		}

		@Override
		public Object get(Object key) {
			return convert(this.root.fetch(key.toString()));
		}

		@Override
		public Set<Entry<String, Object>> entrySet() {
			final Map<String, Object> vs = new HashMap<>();
			this.root.content().entrySet().forEach(v -> vs.put(v.getKey(), v.getValue()));
			return vs.entrySet();
		}

		@Override
		public boolean containsKey(Object key) {
			return this.root.has(key.toString());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((root == null) ? 0 : root.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			STObject other = (STObject) obj;
			if (root == null) {
				if (other.root != null)
					return false;
			} else if (!root.equals(other.root))
				return false;
			return true;
		}
	}

	public JsonObject getRoot() {
		return root;
	}

	public final String compileST(String content) {
		ST st = new ST(content);
		Set<String> expressions = new HashSet<>();
		TokenStream tokens = st.impl.tokens;
		for (int i = 0; i < tokens.range(); i++) {
			Token token = tokens.get(i);
			if (token.getType() == STLexer.ID) {
				expressions.add(token.getText());
			}
		}
		for (String name : expressions) {
			st.add(name, convert(this.fetch(name)));
		}
		return st.render();
	}

	public final String compileST(char delimiterStartChar, char delimiterStopChar, String content) {
		ST st = new ST(content, delimiterStartChar, delimiterStopChar);
		Set<String> expressions = new HashSet<>();
		TokenStream tokens = st.impl.tokens;
		for (int i = 0; i < tokens.range(); i++) {
			Token token = tokens.get(i);
			if (token.getType() == STLexer.ID) {
				expressions.add(token.getText());
			}
		}
		for (String name : expressions) {
			st.add(name, convert(this.fetch(name)));
		}
		return st.render();
	}

	private static final Object convert(JsonElement value) {

		if (value == null) {
			return null;
		}

		if (value.isJsonNull()) {
			return null;
		}

		if (value.isJsonPrimitive()) {
			JsonPrimitive v = value.getAsJsonPrimitive();
			if (v.isBoolean()) {
				return v.getAsBoolean();
			} else if (v.isString()) {
				return v.getAsString();
			} else {
				return v.getAsNumber();
			}
		} else if (value.isJsonArray()) {
			List<Object> x = new ArrayList<>();
			for (JsonElement el : value.getAsJsonArray()) {
				x.add(convert(el));
			}
			return x;
		} else {
			return new STObject(value);
		}
	}

	public static final JsonPrimitive val(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		Matcher matcher = BOOLPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Boolean.parseBoolean(value.toLowerCase(Locale.ENGLISH)));
		}

		matcher = INTPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Integer.parseInt(value));
		}

		matcher = LONGPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Long.parseLong(value));
		}

		matcher = FLOATPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Double.parseDouble(value));
		}

		return new JsonPrimitive(value);
	}

	public static class CompiledPattern {
		private final List<String> names = new ArrayList<>();
		private final String content;
		private final String prefix;

		public CompiledPattern(String content) {
			this(content, "@");
		}

		public CompiledPattern(String content, String prefix) {
			this.prefix = prefix;
			this.content = content;
			if (StringUtils.isBlank(content)) {
				return;
			}
			Pattern expressionKeyPattern = Pattern.compile(String.format(KEYPATTERN, prefix));
			Matcher match = expressionKeyPattern.matcher(content);
			while (match.find()) {
				this.names.add(match.group(NAME));
			}
		}

		public String getContent() {
			return content;
		}

		public String getPrefix() {
			return prefix;
		}

		public boolean isEmpty() {
			return StringUtils.isBlank(content);
		}

		public final String compile(JadeDoc doc) throws ItemNotFoundException {
			if (names.isEmpty()) {
				return content;
			}
			String key = content;
			for (String v : this.names) {
				String value;
				Matcher matcher = HASDEFAULT.matcher(v);
				if (matcher.matches()) {
					String path = matcher.group(NAME);
					value = doc.getAsString(path, matcher.group(VALUE));
					key = key.replace(String.format(S_S, this.prefix, v), value);
				}
			}
			return key;
		}

		public final String compileX(JadeDoc doc) {
			if (names.isEmpty()) {
				return content;
			}
			String key = content;
			for (String v : this.names) {
				String value;
				Matcher matcher = HASDEFAULT.matcher(v);
				if (matcher.matches()) {
					String path = matcher.group(NAME);
					value = doc.getAsString(path, matcher.group(VALUE));
					key = key.replace(String.format(S_S, this.prefix, v), value);
				} 
			}
			return key;
		}

		public final List<String> compileXs(JadeDoc doc) {
			List<String> xs = new ArrayList<>();
			if (names.isEmpty()) {
				xs.add(content);
				return xs;
			}
			List<String> keys = new ArrayList<>();
			keys.add(content);
			Set<String> vkeys = new HashSet<>();
			for (String v : this.names) {
				String path = v;
				String defVal = "NULL";
				Matcher matcher = HASDEFAULT.matcher(v);
				if (matcher.matches()) {
					path = matcher.group(NAME);
					defVal = matcher.group(VALUE);
				}
				List<String> vals = new ArrayList<>();
				JsonElement vs = doc.fetch(path);
				if (vs == null || vs.isJsonNull()) {
					vals.add(defVal);
				} else if (vs.isJsonArray()) {
					for (JsonElement x : vs.getAsJsonArray()) {
						vals.add(x.getAsString());
					}
				} else {
					vals.add(vs.getAsString());
				}
				vkeys.clear();
				for (String key : keys) {
					for (String vStr : vals) {
						String nKey = key.replace(String.format(S_S, this.prefix, v), vStr);
						vkeys.add(nKey);
					}
				}
				keys.clear();
				keys.addAll(vkeys);
				vkeys.clear();
			}
			return keys;
		}
	}

	public final String compile(CompiledPattern compiledPattern) throws ItemNotFoundException {
		return compiledPattern.compile(this);
	}

	public final String compileX(CompiledPattern compiledPattern) {
		return compiledPattern.compileX(this);
	}

	public final List<String> compileXs(CompiledPattern compiledPattern) {
		return compiledPattern.compileXs(this);
	}

	public static JadeDoc merge(JadeDoc... docs) {
		if (docs == null || docs.length < 1) {
			return JadeDoc.build().create();
		}
		JsonObject jsonObject = new JsonObject();
		for (JadeDoc v : docs) {
			if (v == null) {
				continue;
			}
			merge(jsonObject, v.root);
		}
		return JadeDoc.build().create(jsonObject);
	}

	public static JadeDoc create(String pattern, JadeDoc... docs) {
		if (docs == null || docs.length < 1) {
			return JadeDoc.build().create();
		}
		if (StringUtils.isBlank(pattern)) {
			return merge(docs);
		} else {
			JadeDoc doc = JadeDoc.build().create();
			List<JadeDoc> contents = Arrays.asList(docs);
			return doc.add(pattern, contents);
		}
	}

	public void clear() {
		List<String> keys = this.root.entrySet().stream().map(Entry<String, JsonElement>::getKey)
				.collect(Collectors.toList());
		keys.forEach(this.root::remove);
	}

	public JadeDoc addElement(String name, JadeDoc content) {
		if (content == null) {
			return this;
		}

		if (StringUtils.isBlank(name)) {
			this.join(content);
		} else {
			this.root.add(name, content.content());
			return this;
		}
		return this;
	}

	public JadeDoc add(String pattern, JadeDoc... contents) {
		if (contents == null) {
			return this;
		}

		if (StringUtils.isBlank(pattern)) {
			this.join(contents);
		} else if (contents.length == 1) {
			JPathTemplate.add(this.root, pattern, contents[0].content());
			return this;
		} else {
			JsonArray array = new JsonArray();
			for (JadeDoc obj : contents) {
				array.add(obj.root);
			}
			JPathTemplate.add(this.root, pattern, array);
		}
		return this;
	}

	public JadeDoc add(String pattern, Collection<JadeDoc> contents) {
		if (contents == null) {
			return this;
		}
		if (StringUtils.isBlank(pattern)) {
			this.join(contents);
		} else {
			JsonArray array = new JsonArray();
			for (JadeDoc obj : contents) {
				array.add(obj.root.deepCopy());
			}
			JPathTemplate.add(this.root, pattern, array);
		}
		return this;
	}

	public JadeDoc join(Collection<JadeDoc> docs) {
		if (docs == null || docs.isEmpty()) {
			return this;
		}
		for (JadeDoc v : docs) {
			if (v == null || v.root == null) {
				continue;
			}
			for (Entry<String, JsonElement> x : v.root.entrySet()) {
				this.root.add(x.getKey(), x.getValue());
			}
		}

		return this;
	}

	private static final void merge(JsonObject target, JsonObject source) {

		if (source == null || target == null) {
			return;
		}

		for (Entry<String, JsonElement> x : source.entrySet()) {
			JsonElement e = x.getValue();
			if (e != null && e.isJsonObject() && target.has(x.getKey())) {
				JsonElement el = target.get(x.getKey());
				if (el.isJsonObject()) {
					merge(el.getAsJsonObject(), e.getAsJsonObject());
				} else {
					target.add(x.getKey(), x.getValue());
				}
			} else {
				target.add(x.getKey(), x.getValue());
			}
		}
	}

	public JadeDoc join(JadeDoc... docs) {
		if (docs == null || docs.length < 1) {
			return this;
		}
		for (JadeDoc v : docs) {
			if (v == null || v.root == null) {
				continue;
			}
			merge(this.root, v.root);
		}
		return this;
	}

	public JadeDoc join(JsonObject content) {
		if (content == null) {
			return this;
		}
		merge(this.root, content);
		return this;
	}

	public JadeDoc add(String targetPath, JsonElement... contents) {
		if (contents == null || contents.length < 1) {
			return this;
		}
		if (StringUtils.isBlank(targetPath)) {
			return this;
		}
		if (contents.length == 1) {
			JPathTemplate.add(this.root, targetPath, contents[0]);
			return this;
		}
		JsonArray array = new JsonArray();
		for (JsonElement obj : contents) {
			array.add(obj);
		}
		JPathTemplate.add(this.root, targetPath, array);
		return this;
	}

	public JadeDoc add(String targetPath, JsonElement content) {
		if (content == null) {
			return this;
		}
		if (StringUtils.isBlank(targetPath)) {
			return this;
		}
		JPathTemplate.add(this.root, targetPath, content);
		return this;
	}

	public JadeDoc addObject(String pattern, Object src, Type typeOfSrc) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		if (src == null) {
			return this;
		}
		JsonElement el = this.gson.toJsonTree(src, typeOfSrc);
		JPathTemplate.add(this.root, pattern, el);
		return this;
	}

	public JadeDoc addObject(String pattern, Object src) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		if (src == null) {
			return this;
		}
		JsonElement el = this.gson.toJsonTree(src);
		JPathTemplate.add(this.root, pattern, el);
		return this;
	}

	public JadeDoc add(String pattern, String element) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		String content = StringUtils.isBlank(element) ? "" : element;
		JPathTemplate.add(this.root, pattern, new JsonPrimitive(content));
		return this;
	}

	public JadeDoc add(String targetPath, String... contents) {
		if (contents == null || contents.length < 1) {
			return this;
		}

		if (StringUtils.isBlank(targetPath)) {
			return this;
		}

		if (contents.length == 1) {
			this.add(targetPath, contents[0]);
			return this;
		}

		JsonArray array = new JsonArray();
		for (String obj : contents) {
			array.add(new JsonPrimitive(obj));
		}
		JPathTemplate.add(this.root, targetPath, array);
		return this;
	}

	public JadeDoc add(String targetPath, JsonElement source, String sourcePath, Map<String, Object> values) {
		JPathTemplate.add(this.root, targetPath, source, sourcePath, values);
		return this;
	}

	public JadeDoc add(String targetPath, JsonElement source, String sourcePath) {
		JPathTemplate.add(this.root, targetPath, source, sourcePath);
		return this;
	}

	public JadeDoc process(String targetPath, Map<String, Object> values) {
		if (StringUtils.isBlank(targetPath)) {
			return this;
		}
		JPathAction.process(this.root, targetPath, values);
		return this;
	}

	public JadeDoc process(String targetPath) {
		if (StringUtils.isBlank(targetPath)) {
			return this;
		}
		JPathAction.process(this.root, targetPath);
		return this;
	}

	public JadeDoc remove(String... patterns) {
		if (patterns == null || patterns.length < 1) {
			return this;
		}
		for (String pattern : patterns) {
			JPathAction.remove(this.root, pattern);
		}
		return this;
	}

	public JadeDoc add(String pattern, List<String> values) {
		if (values == null) {
			return this;
		}
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JsonArray array = new JsonArray();
		for (String obj : values) {
			array.add(new JsonPrimitive(obj));
		}
		JPathTemplate.add(this.root, pattern, array);
		return this;
	}

	public boolean has(String pattern) {
		if (StringUtils.isBlank(pattern)) {
			return false;
		}
		return JPathProcessor.find(pattern, this.root) != null;
	}

	public boolean and(String... patterns) {
		if (patterns == null || patterns.length < 1) {
			return false;
		}
		for (String pattern : patterns) {
			boolean r = this.getAsBoolean(pattern, false);
			if (!r) {
				return false;
			}
		}
		return true;
	}

	public boolean or(String... patterns) {
		if (patterns == null || patterns.length < 1) {
			return false;
		}
		for (String pattern : patterns) {
			boolean r = this.getAsBoolean(pattern, false);
			if (r) {
				return true;
			}
		}
		return false;
	}

	public boolean regex(String pattern, String regularStr) {
		if (StringUtils.isBlank(pattern) || StringUtils.isBlank(regularStr)) {
			return false;
		}
		String val = this.getAsString(pattern, "");
		if (StringUtils.isBlank(val)) {
			return false;
		}
		return Pattern.matches(regularStr, val);
	}

	public boolean rename(String pattern, String newName) {
		if (StringUtils.isBlank(pattern)) {
			return false;
		}
		if (StringUtils.isBlank(newName)) {
			return false;
		}
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null) {
			return false;
		} else {
			add(newName, el);
			remove(pattern);
			return true;
		}
	}

	public JadeDoc add(String pattern, Number element) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JPathTemplate.add(this.root, pattern, new JsonPrimitive(element));
		return this;
	}

	public JadeDoc add(String pattern, boolean element) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JPathTemplate.add(this.root, pattern, new JsonPrimitive(element));
		return this;
	}

	public JadeDoc add(String pattern, JsonPrimitive element) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JPathTemplate.add(this.root, pattern, element);
		return this;
	}

	public JadeDoc add(String pattern, BigDecimal element) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JPathTemplate.add(this.root, pattern, new JsonPrimitive(element));
		return this;
	}

	public JsonElement check(String pattern) throws ItemNotFoundException {
		if (StringUtils.isBlank(pattern)) {
			throw new ItemNotFoundException(pattern);
		}
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null) {
			throw new ItemNotFoundException(pattern);
		}
		return el;
	}

	public String getAsString(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (el.isJsonPrimitive()) {
			JsonPrimitive v = el.getAsJsonPrimitive();
			if (v.isString()) {
				return v.getAsString();
			}
		}
		return el.toString();
	}

	public String getString(String pattern) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		return el.getAsString();
	}

	public long getAsLong(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsLong();
	}

	public int getAsInt(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsInt();
	}

	public double getAsDouble(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsDouble();
	}

	public boolean getAsBoolean(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsBoolean();
	}

	public Number getAsNumber(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsNumber();
	}

	public boolean isEmpty() {
		return this.root.entrySet().isEmpty();
	}

	public boolean isBoolean(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (!el.isJsonPrimitive()) {
			return false;
		}

		return el.getAsJsonPrimitive().isBoolean();
	}

	public boolean isNumber(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (!el.isJsonPrimitive()) {
			return false;
		}

		return el.getAsJsonPrimitive().isNumber();
	}

	public <T> T getWithDefault(String pattern, T defaultValue, Function<JsonElement, T> trieveFun) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null || el.isJsonNull() || !el.isJsonPrimitive()) {
			return defaultValue;
		}
		return trieveFun.apply(el);
	}

	public String getAsString(String pattern, String defaultValue) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null || el.isJsonNull()) {
			return defaultValue;
		}
		if (el.isJsonPrimitive()) {
			JsonPrimitive v = el.getAsJsonPrimitive();
			if (v.isString()) {
				return v.getAsString();
			}
		}
		return el.toString();
	}

	public long getAsLong(String pattern, long defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsLong);
	}

	public int getAsInt(String pattern, int defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsInt);
	}

	public double getAsDouble(String pattern, double defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsDouble);
	}

	public boolean getAsBoolean(String pattern, boolean defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsBoolean);
	}

	public void forEach(String arrayPattern, Consumer<JsonElement> action) throws ItemNotFoundException {
		JsonElement el = JPathProcessor.find(arrayPattern, this.root);
		if (el == null) {
			throw new ItemNotFoundException(arrayPattern);
		}
		if (!el.isJsonArray()) {
			throw new ItemNotFoundException(arrayPattern);
		}
		JsonArray array = el.getAsJsonArray();
		array.forEach(action);
	}

	public void forEachX(String arrayPattern, Consumer<JsonElement> action) {
		JsonElement el = JPathProcessor.find(arrayPattern, this.root);
		if (el == null) {
			return;
		}
		if (!el.isJsonArray()) {
			return;
		}
		JsonArray array = el.getAsJsonArray();
		array.forEach(action);
	}

	public String getFirstChildName(String pattern, String defaultValue) {
		JsonElement el = this.get(pattern);
		if (el == null) {
			return defaultValue;
		}
		if (el.isJsonObject()) {
			Set<Entry<String, JsonElement>> vs = el.getAsJsonObject().entrySet();
			Optional<Entry<String, JsonElement>> v = vs.stream().findFirst();
			if (v.isPresent()) {
				return v.get().getKey();
			}
		}
		return defaultValue;
	}

	public JsonElement select(String pattern, String as) {
		JsonElement content;
		if (StringUtils.isBlank(pattern) || "*".equals(pattern)) {
			content = this.root;
		} else {
			content = JPathProcessor.find(pattern, this.root);
			if (content == null) {
				return null;
			}
		}

		if (StringUtils.isBlank(as) || "*".equals(as)) {
			return content;
		}

		return JPathTemplate.add(as, content);
	}

	public QueryBuilder queryBuilder() {
		return new QueryBuilder(this);
	}

	public static class QueryBuilder {
		private final JadeDoc doc;
		private final Set<Selector> selects = new HashSet<>();

		private QueryBuilder(JadeDoc doc) {
			this.doc = doc;
		}

		public Selector where() {
			Selector selector = new Selector();
			this.selects.add(selector);
			return selector;
		}

		public Selector where(String where) {
			Selector selector = new Selector(where);
			this.selects.add(selector);
			return selector;
		}

		public QueryBuilder remove(Selector selector) {
			if (this.selects.contains(selector)) {
				this.selects.remove(selector);
			}
			return this;
		}

		public JadeDoc query(Map<String, Object> values) {
			JadeDoc newDoc = this.doc.empty();

			for (Selector select : this.selects) {
				newDoc.join(select.collect(this.doc, values));
			}
			return newDoc;
		}

		public class Selector {
			private static final String WHERE = "%s[%s]";

			private final Set<String> simpleSelects = new HashSet<>();
			private final Map<String, String> selects = new HashMap<>();
			private final String whereClause;

			private Selector() {
				this.whereClause = null;
			}

			private Selector(String whereClause) {
				this.whereClause = whereClause;
			}

			public Selector select(String select, String as) {
				if (StringUtils.isBlank(select)) {
					return null;
				}

				if (StringUtils.isBlank(as)) {
					this.simpleSelects.add(select);
					return this;
				}

				this.selects.put(as, select);
				return this;
			}

			public Selector select(String select) {
				if (StringUtils.isBlank(select)) {
					return null;
				}

				this.simpleSelects.add(select);
				return this;
			}

			public Selector union(String where) {
				return QueryBuilder.this.where(where);
			}

			public QueryBuilder build() {
				return QueryBuilder.this;
			}

			private JadeDoc collect(JadeDoc doc, Map<String, Object> values) {
				String sourcePath;
				JadeDoc newDoc = doc.empty();

				for (Entry<String, String> entry : selects.entrySet()) {
					if (StringUtils.isBlank(this.whereClause)) {
						sourcePath = entry.getValue();
					} else {
						sourcePath = String.format(WHERE, entry.getValue(), this.whereClause);
					}

					JsonElement el = JPathProcessor.find(sourcePath, doc.content(), values);
					if (null != el) {
						newDoc.add(entry.getKey(), el);
					}
				}

				for (String r : this.simpleSelects) {
					if (StringUtils.isBlank(this.whereClause)) {
						sourcePath = r;
					} else {
						sourcePath = String.format(WHERE, r, this.whereClause);
					}

					JsonElement el = JPathProcessor.find(sourcePath, doc.content(), values);
					if (null != el && el.isJsonObject()) {
						newDoc.join(el.getAsJsonObject());
					}
				}
				return newDoc;
			}
		}
	}

	public JsonElement get(String... pattern) {
		if (pattern == null) {
			return null;
		}
		for (String p : pattern) {
			JsonElement e = JPathProcessor.find(p, this.root);
			if (e != null) {
				return e;
			}
		}
		return null;
	}

	public JsonElement fetch(String pattern) {
		if (StringUtils.isBlank(pattern) || "*".equals(pattern)) {
			return this.root;
		}
		return JPathProcessor.find(pattern, this.root);
	}

	public JsonElement fetch(String pattern, Map<String, Object> values) {
		if (StringUtils.isBlank(pattern) || "*".equals(pattern)) {
			return this.root;
		}
		return JPathProcessor.find(pattern, this.root, values);
	}

	public JsonObject content() {
		return this.root;
	}

	@Override
	public String toString() {
		return this.root.toString();
	}

	public String toJson() {
		return this.root.toString();
	}

	private static String nodeName(String prefix, String name) {
		if (StringUtils.isNotBlank(prefix)) {
			return String.join(":", prefix, name);
		}
		return name;
	}

	private static void parse(Document document, Element node, String name, JsonElement el, String prefix) {
		if (ATTRS.equals(name)) {
			el.getAsJsonObject().entrySet().forEach(x -> node.setAttribute(x.getKey(), x.getValue().getAsString()));
		} else if (el.isJsonPrimitive()) {
			Element child = document.createElement(nodeName(prefix, name));
			child.setTextContent(el.getAsString());
			node.appendChild(child);
		} else if (el.isJsonObject()) {
			JadeDoc doc = jadeDocBuilder.create(el);
			String self = name + SELF;
			Element child = document.createElement(nodeName(prefix, name));
			node.appendChild(child);
			if (doc.has(self)) {
				child.setTextContent(doc.getAsString(self, ""));
				if (doc.has(ATTRS)) {
					JsonElement attrEl = doc.get(ATTRS);
					if (attrEl != null) {
						attrEl.getAsJsonObject().entrySet()
								.forEach(x -> child.setAttribute(x.getKey(), x.getValue().getAsString()));
					}
				}
			} else {
				el.getAsJsonObject().entrySet().forEach(v -> {
					String key = v.getKey();
					if (ATTRS.equals(key)) {
						v.getValue().getAsJsonObject().entrySet()
								.forEach(x -> child.setAttribute(x.getKey(), x.getValue().getAsString()));
					} else {
						parse(document, child, v.getKey(), v.getValue(), prefix);
					}
				});
			}
		} else if (el.isJsonArray()) {
			el.getAsJsonArray().forEach(v -> parse(document, node, name, v, prefix));
		}
	}

	public Document toXml(String path, String prefix, Map<String, String> attrs) {
		Document document = dBuilder.newDocument();
		JsonElement el = this.get(path);
		if (el == null) {
			return null;
		}

		String xPath;
		if ("*".equals(path)) {
			xPath = "root";
		} else {
			String[] paths = path.split("/");
			xPath = paths[paths.length - 1];
		}
		Element rootEl = document.createElement(nodeName(prefix, xPath));

		attrs.forEach(rootEl::setAttribute);
		document.appendChild(rootEl);

		if (el.isJsonObject()) {
			el.getAsJsonObject().entrySet().forEach(v -> parse(document, rootEl, v.getKey(), v.getValue(), prefix));
		} else if (el.isJsonPrimitive()) {
			rootEl.setTextContent(el.getAsString());
		} else if (el.isJsonArray()) {
			el.getAsJsonArray().forEach(v -> parse(document, rootEl, path, v, prefix));
		}

		return document;
	}

	public static Builder build() {
		return new Builder();
	}

	public static Builder build(GsonBuilder builder) {
		return new Builder(builder);
	}

	public static Builder template(GsonBuilder builder, JsonTemplate template, Map<String, Object> values) {
		return new Builder(builder, template, values);
	}

	public static Builder template(GsonBuilder builder, JsonTemplate template) {
		return new Builder(builder, template);
	}

	public static Builder template(JsonTemplate template, Map<String, Object> values) {
		return new Builder(template, values);
	}

	public static Builder template(JsonTemplate template) {
		return new Builder(template);
	}

	public static final JsonTemplate createTemplate() {
		return new JsonTemplate();
	}

	private static class PatternPair {
		private final String source;
		private final String target;

		private PatternPair(String source, String target) {
			this.source = source;
			this.target = target;
		}

		public String getKey() {
			return String.format("%s-%s", this.source, this.target);
		}
	}

	public static class JsonTemplate {
		private final Set<String> simplePattern;
		private final Map<String, PatternPair> patterns;
		private final Set<String> actions;
		private final Set<String> removes;

		private JsonTemplate() {
			this.patterns = new HashMap<>();
			this.actions = new HashSet<>();
			this.removes = new HashSet<>();
			this.simplePattern = new HashSet<>();
		}

		public JsonTemplate pattern(String source, String target) {
			PatternPair pair = new PatternPair(source, target);
			this.patterns.put(pair.getKey(), pair);
			return this;
		}

		public JsonTemplate pattern(String source) {
			this.simplePattern.add(source);
			return this;
		}

		public JsonTemplate action(String target) {
			this.actions.add(target);
			return this;
		}

		public JsonTemplate remove(String target) {
			this.removes.add(target);
			return this;
		}

		public static final JsonTemplate parse(String jsonContent) {
			Builder builder = new Builder();

			JsonTemplate template = new JsonTemplate();
			if (StringUtils.isBlank(jsonContent)) {
				return template;
			}

			JadeDoc doc = builder.create(jsonContent);

			doc.forEachX("patterns", el -> {
				JsonObject v = el.getAsJsonObject();
				String source = v.get("source").getAsString();
				if (v.has("target")) {
					String target = v.get("target").getAsString();
					if (StringUtils.isBlank(target)) {
						template.pattern(source);
					} else {
						template.pattern(source, target);
					}
				} else {
					template.simplePattern.add(source);
				}
			});

			doc.forEachX("actions", el -> template.action(el.getAsString()));

			doc.forEachX("removes", el -> template.remove(el.getAsString()));

			return template;
		}

		@Override
		public String toString() {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.disableHtmlEscaping().create();
			return gson.toJson(this);
		}
	}

	public static class Builder {

		private final Gson gson;

		private Builder(GsonBuilder builder) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(null)).disableHtmlEscaping();
			this.gson = builder.disableHtmlEscaping().create();
		}

		private Builder() {
			this(new GsonBuilder());
		}

		private Builder(GsonBuilder builder, JsonTemplate template, Map<String, Object> values) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(template, values));
			this.gson = builder.disableHtmlEscaping().create();
		}

		private Builder(GsonBuilder builder, JsonTemplate template) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(template));
			this.gson = builder.disableHtmlEscaping().create();
		}

		private Builder(JsonTemplate template, Map<String, Object> values) {
			this(new GsonBuilder(), template, values);
		}

		private Builder(JsonTemplate template) {
			this(new GsonBuilder(), template);
		}

		public JadeDoc create() {
			return new JadeDoc(this.gson);
		}

		public JadeDoc create(JsonObject jsonObject) {
			return new JadeDoc(this.gson, jsonObject);
		}

		public JadeDoc fromArrayString(String nodeName, String jsonArrayString) {
			JsonArray array = gson.fromJson(jsonArrayString, JsonArray.class);
			JadeDoc doc = new JadeDoc(this.gson);
			doc.add(nodeName, array);
			return doc;
		}

		public JadeDoc create(String jsonString) {
			if (StringUtils.isBlank(jsonString)) {
				return new JadeDoc(this.gson);
			}
			String content = jsonString.trim();
			if (content.startsWith("[")) {
				return this.fromArrayString("root", jsonString);
			} else if (!content.startsWith("{")) {
				JadeDoc doc = new JadeDoc(this.gson);
				doc.add("body", jsonString);
				return doc;
			} else {
				return gson.fromJson(jsonString, JadeDoc.class);
			}
		}

		public JadeDoc create(JsonElement jsonElement) {
			return gson.fromJson(jsonElement, JadeDoc.class);
		}

		private JadeDoc parseNode(Node node, boolean keepNamespace) {
			JadeDoc doc = new JadeDoc(this.gson);

			String nodeName = node.getNodeName().replace(":", "_");
			if (StringUtils.isBlank(nodeName)) {
				return doc;
			}
			NamedNodeMap attrList = node.getAttributes();

			if (node.hasAttributes()) {
				for (int i = 0; i < attrList.getLength(); i++) {
					Node attr = attrList.item(i);
					String xn = "attrs/" + parseNodename(attr.getNodeName(), keepNamespace);
					doc.add(xn, attr.getNodeValue());
				}
			}

			if (node.hasChildNodes() && node.getChildNodes().getLength() == 1
					&& node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
				doc.add(nodeName + SELF, node.getTextContent());
				return doc;
			}

			NodeList nodeList = node.getChildNodes();

			Map<String, List<Node>> nodes = new HashMap<>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node child = nodeList.item(i);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					if (!child.hasAttributes() && child.hasChildNodes() && child.getChildNodes().getLength() == 1
							&& child.getFirstChild().getNodeType() == Node.TEXT_NODE) {
						doc.add(parseNodename(child.getNodeName(), keepNamespace), child.getTextContent());
						continue;
					}
					String name = child.getNodeName();
					List<Node> v;
					if (nodes.containsKey(name)) {
						v = nodes.get(name);
					} else {
						v = new ArrayList<>();
						nodes.put(name, v);
					}
					v.add(child);
				}
			}

			nodes.forEach((key, v) -> {
				if (v.size() == 1) {
					doc.add(parseNodename(key, keepNamespace), this.parseNode(v.get(0), keepNamespace));
				} else {
					List<JadeDoc> xs = new ArrayList<>();
					for (Node x : v) {
						xs.add(this.parseNode(x, keepNamespace));
					}
					doc.add(parseNodename(key, keepNamespace), xs);
				}
			});
			return doc;
		}

		private static String parseNodename(String name, boolean keepNamespace) {
			if (keepNamespace) {
				return name.replace(":", "_");
			}
			String[] ns = name.split("\\s*:\\s*");
			return ns[ns.length - 1];
		}

		public JadeDoc create(InputStream xmlStream, boolean keepNamespace) throws SAXException, IOException {
			Document doc = dBuilder.parse(xmlStream);
			return this.create(doc, keepNamespace);
		}

		public JadeDoc create(byte[] xmlBytes, boolean keepNamespace) throws SAXException, IOException {
			Document doc = dBuilder.parse(new ByteArrayInputStream(xmlBytes));
			return this.create(doc, keepNamespace);
		}

		public JadeDoc create(Document document, boolean keepNamespace) {
			JadeDoc doc = new JadeDoc(this.gson);
			Element rootElement = document.getDocumentElement();
			rootElement.normalize();
			String root = parseNodename(rootElement.getNodeName(), keepNamespace);
			NamedNodeMap attrList = rootElement.getAttributes();

			String content = rootElement.getTextContent();
			if (StringUtils.isNotBlank(content)) {
				doc.add(root, content);
			}

			if (rootElement.hasAttributes()) {
				for (int i = 0; i < attrList.getLength(); i++) {
					Node attr = attrList.item(i);
					doc.add(root + "/attrs/" + parseNodename(attr.getNodeName(), keepNamespace), attr.getNodeValue());
				}
			}

			if (rootElement.hasChildNodes() && rootElement.getChildNodes().getLength() == 1
					&& rootElement.getFirstChild().getNodeType() == Node.TEXT_NODE) {
				doc.add(root + "/" + root + SELF, rootElement.getTextContent());
				return doc;
			}
			NodeList nodeList = rootElement.getChildNodes();

			Map<String, List<Node>> nodes = new HashMap<>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node child = nodeList.item(i);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					String name = parseNodename(child.getNodeName(), keepNamespace);
					if (!child.hasAttributes() && child.hasChildNodes() && child.getChildNodes().getLength() == 1
							&& child.getFirstChild().getNodeType() == Node.TEXT_NODE) {
						doc.add(root + "/" + name, child.getTextContent());
						continue;
					}
					List<Node> v;
					if (nodes.containsKey(name)) {
						v = nodes.get(name);
					} else {
						v = new ArrayList<>();
						nodes.put(name, v);
					}
					v.add(child);
				}
			}

			nodes.forEach((key, v) -> {
				if (v.size() == 1) {
					doc.add(root + "/" + parseNodename(key, keepNamespace), this.parseNode(v.get(0), keepNamespace));
				} else {
					List<JadeDoc> xs = new ArrayList<>();
					for (Node x : v) {
						xs.add(this.parseNode(x, keepNamespace));
					}
					doc.add(root + "/" + parseNodename(key, keepNamespace), xs);
				}
			});

			return doc;
		}

		public JadeDoc create(Reader reader) {
			return gson.fromJson(reader, JadeDoc.class);
		}

		public JadeDoc create(byte[] data) {
			return gson.fromJson(StringUtils.toEncodedString(data, StandardCharsets.UTF_8), JadeDoc.class);
		}

		public JadeDoc create(Object object) {
			if (object == null) {
				return null;
			}
			if(object instanceof String) {
				return this.create(object.toString());
			}
			return gson.fromJson(gson.toJson(object), JadeDoc.class);
		}

		public JadeDoc create(JadeDoc model) {
			return gson.fromJson(model.root.deepCopy(), JadeDoc.class);
		}

		public String toJson(JadeDoc model) {
			return gson.toJson(model);
		}

		public static class RegularPattern {
			private final String regularExpress;
			private final List<String> names = new ArrayList<>();
			private final Builder builder = new Builder();

			public RegularPattern(String regularExpress) {
				this.regularExpress = regularExpress;
				if (StringUtils.isBlank(regularExpress)) {
					return;
				}
				Matcher matcher = GATHERPATTERN.matcher(regularExpress);

				while (matcher.find()) {
					names.add(matcher.group(NAME));
				}
			}

			public JadeDoc fromRegularExpression(String content) {
				JadeDoc doc = builder.create();
				if (this.names.isEmpty()) {
					return doc;
				}
				Pattern pattern = Pattern.compile(regularExpress);
				Matcher contentPattern = pattern.matcher(content);
				if (contentPattern.matches()) {
					for (String r : this.names) {
						doc.add(r, val(contentPattern.group(r)));
					}
				}
				return doc;
			}
		}

		private class JadeDocAdapter implements JsonSerializer<JadeDoc>, JsonDeserializer<JadeDoc> {
			private final JsonTemplate template;
			private final Map<String, Object> values = new HashMap<>();

			public JadeDocAdapter(JsonTemplate template) {
				this.template = template;
			}

			public JadeDocAdapter(JsonTemplate template, Map<String, Object> values) {
				this.template = template;
				if (values != null) {
					this.values.putAll(values);
				}
			}

			@Override
			public JadeDoc deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) {
				JsonObject source = null;
				if (element.isJsonObject()) {
					source = element.getAsJsonObject();
				} else {
					source = new JsonObject();
					source.add("root", element);
				}
				if (this.template == null) {
					return new JadeDoc(Builder.this.gson, source);
				}

				if (this.template.patterns.isEmpty() && this.template.actions.isEmpty()
						&& this.template.removes.isEmpty() && this.template.simplePattern.isEmpty()) {
					return new JadeDoc(Builder.this.gson, source);
				}

				JadeDoc model = new JadeDoc(Builder.this.gson);

				for (Entry<String, PatternPair> pattern : this.template.patterns.entrySet()) {
					String sourceStr = pattern.getValue().source;
					String target = pattern.getValue().target;
					if (StringUtils.isBlank(target) || "*".equals(target)) {
						JsonElement el = JPathProcessor.find(sourceStr, source);
						if (el != null && el.isJsonObject()) {
							model.join(el.getAsJsonObject());
						} else {
							model.add("NULL", el);
						}
						continue;
					}
					JPathTemplate.add(model.root, target, source, sourceStr, this.values);
				}

				for (String pattern : this.template.simplePattern) {
					if ("*".equals(pattern)) {
						model.join(source);
						continue;
					}
					JPathTemplate.add(model.root, pattern, source, pattern, this.values);
				}

				for (String pattern : this.template.actions) {
					JPathAction.process(model.root, pattern, values);
				}

				for (String pattern : this.template.removes) {
					JPathAction.remove(model.root, pattern);
				}

				return model;
			}

			@Override
			public JsonElement serialize(JadeDoc model, Type arg1, JsonSerializationContext arg2) {
				return model.content();
			}
		}
	}

	public JadeDoc empty() {
		return new JadeDoc(this.gson);
	}
}
