package com.jade.path;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.w3c.dom.Text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jade.path.exception.ItemNotFoundException;
import com.jade.path.processor.JPathAction;
import com.jade.path.processor.JPathProcessor;
import com.jade.path.processor.JPathTemplate;

public final class JadeDoc {

	private static final String ATTRS = "attrs";
	private static final String SELF = "_self";
	private static final String NAME = "name";
	private static final String VALUE = "value";
	private static final String S_S = "%s{%s}";
	private final Gson gson;
	private final JsonObject root;

	private static final Pattern HASDEFAULT = Pattern.compile("(?<name>.+):#(?<value>.*)");
	private static final Pattern ARRAYTYPE = Pattern.compile("array<(?<name>.+)>");
	private static final Pattern LISTTYPE = Pattern.compile("list<(?<name>.+)>");
	private static final String KEYPATTERN = "%s\\{(?<name>[^\\{\\}]+)\\}";
	private static final Pattern DEFAULT_EXPATTERN = Pattern.compile("@\\{(?<name>[^\\{\\}]+)\\}");
	private static final Pattern GATHERPATTERN = Pattern.compile("\\(\\?<(?<name>[A-Za-z0-9$]+)>");
	private static final Pattern BYTEPATTERN = Pattern.compile("-?\\d{1,2}");
	private static final Pattern SHORTPATTERN = Pattern.compile("-?\\d{1,5}");
	private static final Pattern INTPATTERN = Pattern.compile("-?\\d{1,10}");
	private static final Pattern LONGPATTERN = Pattern.compile("-?\\d{11,}");
	private static final Pattern FLOATPATTERN = Pattern.compile("[+-]?(\\d+|\\d+\\.\\d+|\\.\\d+|\\d+\\.)([eE]\\d+)?");
	private static final Pattern BOOLPATTERN = Pattern.compile("([tT][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])");

	private static final DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		factory.setNamespaceAware(false);
		factory.setExpandEntityReferences(false);

		return factory.newDocumentBuilder(); // Noncompliant
	}

	@FunctionalInterface
	public interface JadeDocFunction<T, R> {
		R apply(T t) throws ItemNotFoundException;
	}

	public static int getAsInt(JsonElement el) {
		return el.getAsInt();
	}

	public static Short getAsShort(JsonElement el) {
		return el.getAsShort();
	}

	public static long getAsLong(JsonElement el) {
		return el.getAsLong();
	}

	public static String getAsString(JsonElement el) {
		return el.getAsString();
	}

	public static double getAsDouble(JsonElement el) {
		return el.getAsDouble();
	}

	public static float getAsFloat(JsonElement el) {
		return el.getAsFloat();
	}

	public static boolean getAsBoolean(JsonElement el) {
		return el.getAsBoolean();
	}

	public static byte getAsByte(JsonElement el) {
		return el.getAsByte();
	}

	public static char getAsChar(JsonElement el) {
		return el.getAsString().charAt(0);
	}

	public static BigDecimal getAsBigDecimal(JsonElement el) {
		return el.getAsBigDecimal();
	}

	public static Date getAsDate(JsonElement el) {
		try {
			return DateFormat.getDateInstance().parse(el.getAsString());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Instant getAsInstant(JsonElement el) {
		return Instant.parse(el.getAsString());
	}

	public static LocalDateTime getAsLocalDateTime(JsonElement el) {
		return LocalDateTime.parse(el.getAsString());
	}

	public static LocalDate getAsLocalDate(JsonElement el) {
		return LocalDate.parse(el.getAsString());
	}

	public static OffsetDateTime getAsOffsetDateTime(JsonElement el) {
		return OffsetDateTime.parse(el.getAsString());
	}

	public static OffsetTime getAsOffsetTime(JsonElement el) {
		return OffsetTime.parse(el.getAsString());
	}

	public static ZonedDateTime getAsZonedDateTime(JsonElement el) {
		return ZonedDateTime.parse(el.getAsString());
	}

	public static Timestamp getAsTimestamp(JsonElement el) {
		return Timestamp.valueOf(el.getAsString());
	}

	public static Time getAsTime(JsonElement el) {
		return Time.valueOf(el.getAsString());
	}

	public static YearMonth getAsYearMonth(JsonElement el) {

		return YearMonth.parse(el.getAsString());
	}

	public static Number getAsNumber(JsonElement el) {

		return el.getAsNumber();
	}

	private final Map<Class<?>, JadeDocFunction<JsonElement, Object>> getJsonElementAsFuns = Map.ofEntries(
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(short.class,
					JadeDoc::getAsShort),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Short.class,
					JadeDoc::getAsShort),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(int.class, JadeDoc::getAsInt),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Integer.class,
					JadeDoc::getAsInt),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(long.class, JadeDoc::getAsLong),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Long.class, JadeDoc::getAsLong),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(float.class,
					JadeDoc::getAsFloat),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Float.class,
					JadeDoc::getAsFloat),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(double.class,
					JadeDoc::getAsDouble),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Double.class,
					JadeDoc::getAsDouble),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(boolean.class,
					JadeDoc::getAsBoolean),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Boolean.class,
					JadeDoc::getAsBoolean),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(byte.class, JadeDoc::getAsByte),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Byte.class, JadeDoc::getAsByte),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(char.class, JadeDoc::getAsChar),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Character.class,
					JadeDoc::getAsChar),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(String.class,
					JadeDoc::getAsString),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(BigDecimal.class,
					JadeDoc::getAsBigDecimal),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Instant.class,
					JadeDoc::getAsInstant),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(LocalDateTime.class,
					JadeDoc::getAsLocalDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(LocalDate.class,
					JadeDoc::getAsLocalDate),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(OffsetDateTime.class,
					JadeDoc::getAsOffsetDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(OffsetTime.class,
					JadeDoc::getAsOffsetTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(ZonedDateTime.class,
					JadeDoc::getAsZonedDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Timestamp.class,
					JadeDoc::getAsTimestamp),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Time.class, JadeDoc::getAsTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(YearMonth.class,
					JadeDoc::getAsYearMonth),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<JsonElement, Object>>(Number.class,
					JadeDoc::getAsNumber));

	private final Map<Class<?>, JadeDocFunction<String, Object>> getAsFuns = Map.ofEntries(
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(short.class, this::getAsShort),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Short.class, this::getAsShort),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(int.class, this::getAsInt),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Integer.class, this::getAsInt),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(long.class, this::getAsLong),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Long.class, this::getAsLong),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(float.class, this::getAsFloat),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Float.class, this::getAsFloat),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(double.class, this::getAsDouble),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Double.class, this::getAsDouble),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(boolean.class, this::getAsBoolean),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Boolean.class, this::getAsBoolean),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(byte.class, this::getAsByte),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Byte.class, this::getAsByte),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(char.class, this::getAsChar),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Character.class, this::getAsChar),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(String.class, this::getAsString),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(BigDecimal.class,
					this::getAsBigDecimal),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Instant.class, this::getAsInstant),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(LocalDateTime.class,
					this::getAsLocalDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(LocalDate.class,
					this::getAsLocalDate),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(OffsetDateTime.class,
					this::getAsOffsetDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(OffsetTime.class,
					this::getAsOffsetTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(ZonedDateTime.class,
					this::getAsZonedDateTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Timestamp.class,
					this::getAsTimestamp),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Time.class, this::getAsTime),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(YearMonth.class,
					this::getAsYearMonth),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Map.class, this::getAsMap),
			new AbstractMap.SimpleEntry<Class<?>, JadeDocFunction<String, Object>>(Number.class, this::getAsNumber));

	private final Map<String, Class<?>> simpleTypes = Map.ofEntries(
			new AbstractMap.SimpleEntry<String, Class<?>>("int", Integer.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("integer", Integer.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("long", Long.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("float", Float.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("double", Double.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("boolean", Boolean.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("byte", Byte.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("char", Character.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("character", Character.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("string", String.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("decimal", BigDecimal.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("bigdecimal", BigDecimal.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("instant", Instant.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("localdatetime", LocalDateTime.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("datetime", LocalDateTime.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("date", LocalDate.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("localdate", LocalDate.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("offsetdatetime", OffsetDateTime.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("offsettime", OffsetTime.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("zoneddatetime", ZonedDateTime.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("timestamp", Timestamp.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("time", Time.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("yearmonth", YearMonth.class),
			new AbstractMap.SimpleEntry<String, Class<?>>("number", Number.class));

	private final Map<String, JadeDocFunction<String, Object>> getStrAsFuns = Map.ofEntries(
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("int", this::getAsInt),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("integer", this::getAsInt),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("long", this::getAsLong),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("float", this::getAsFloat),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("double", this::getAsDouble),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("boolean", this::getAsBoolean),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("byte", this::getAsByte),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("char", this::getAsChar),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("character", this::getAsChar),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("string", this::getAsString),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("decimal", this::getAsBigDecimal),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("bigdecimal", this::getAsBigDecimal),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("instant", this::getAsInstant),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("localdatetime",
					this::getAsLocalDateTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("datetime", this::getAsLocalDateTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("date", this::getAsLocalDate),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("localdate", this::getAsLocalDate),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("offsetdatetime",
					this::getAsOffsetDateTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("offsettime", this::getAsOffsetTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("zoneddatetime",
					this::getAsZonedDateTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("timestamp", this::getAsTimestamp),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("time", this::getAsTime),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("yearmonth", this::getAsYearMonth),
			new AbstractMap.SimpleEntry<String, JadeDocFunction<String, Object>>("number", this::getAsNumber));

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
		return from(this.toJson(), classOfT);
		// return gson.fromJson(this.toJson(), classOfT);
	}

	public <T> T fromJson(String pattern, Class<T> classOfT) {
		if (StringUtils.isBlank(pattern)) {
			return this.fromJson(classOfT);
		}
		JsonElement content = this.get(pattern);
		if (content == null) {
			return null;
		}
		var json = content.toString();
		return gson.fromJson(json, classOfT);
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

		matcher = BYTEPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Byte.parseByte(value));
		}

		matcher = SHORTPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Short.parseShort(value));
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

	public static final Number parseNumber(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		Matcher matcher = null;
		try {
			matcher = SHORTPATTERN.matcher(value);
			if (matcher.matches()) {
				return Short.parseShort(value);
			}
		} catch (NumberFormatException ex) {
		}

		try {
			matcher = INTPATTERN.matcher(value);
			if (matcher.matches()) {
				return Integer.parseInt(value);
			}
		} catch (NumberFormatException e) {
		}
		try {
			matcher = LONGPATTERN.matcher(value);
			if (matcher.matches()) {
				return Long.parseLong(value);
			}
		} catch (NumberFormatException x) {
			return Double.parseDouble(value);
		}
		return Double.parseDouble(value);
	}

	public static class CompiledPattern {
		private final String content;
		private final char prefix;

		public CompiledPattern(String content) {
			this(content, '@');
		}

		public CompiledPattern(String content, char prefix) {
			this.prefix = prefix;
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public char getPrefix() {
			return prefix;
		}

		public boolean isEmpty() {
			return StringUtils.isBlank(content);
		}

		public static String parseExpression(char prefix, String expression, JadeDoc doc) throws ItemNotFoundException {
			Queue<String> stack = new LinkedList<String>();
			boolean started = false;
			if (expression == null) {
				return null;
			}
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == prefix && expression.charAt(i + 1) == '{') {
					started = true;
				} else if (started && c == '{') {
					int nesting = 1;
					StringBuilder nestedExpression = new StringBuilder();
					while (nesting > 0) {
						c = expression.charAt(++i);
						if (c == '{')
							nesting++;
						if (c == '}')
							nesting--;
						if (nesting > 0)
							nestedExpression.append(c);
					}
					String expr = nestedExpression.toString();

					if (expr.contains(prefix + "{")) {
						String ret = parseExpression(prefix, expr, doc);
						String ds = fetchString(ret, doc);
						stack.add(ds);
					} else {
						String ds = fetchString(expr, doc);
						stack.add(ds);
					}
				} else {
					stack.add(c + "");
				}
			}
			StringBuilder curr = new StringBuilder();
			for (var s : stack) {
				curr.append(s);
			}
			return curr.toString();
		}

		public static String parseExpressionX(char prefix, String expression, JadeDoc doc) {
			Queue<String> stack = new LinkedList<String>();
			boolean started = false;
			if (expression == null) {
				return null;
			}
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == prefix && expression.charAt(i + 1) == '{') {
					started = true;
				} else if (started && c == '{') {
					int nesting = 1;
					StringBuilder nestedExpression = new StringBuilder();
					while (nesting > 0) {
						c = expression.charAt(++i);
						if (c == '{')
							nesting++;
						if (c == '}')
							nesting--;
						if (nesting > 0)
							nestedExpression.append(c);
					}
					String expr = nestedExpression.toString();

					if (expr.contains(prefix + "{")) {
						String ret = parseExpressionX(prefix, expr, doc);
						String ds = fetchStringX(ret, doc);
						stack.add(ds);
					} else {
						String ds = fetchStringX(expr, doc);
						stack.add(ds);
					}
				} else {
					stack.add(c + "");
				}
			}
			StringBuilder curr = new StringBuilder();
			for (var s : stack) {
				curr.append(s);
			}
			return curr.toString();
		}

		public final String compile(JadeDoc doc) throws ItemNotFoundException {
			return parseExpression('@', this.content, doc);
		}

		private static final String fetchString(String key, JadeDoc doc) throws ItemNotFoundException {
			Matcher matcher = HASDEFAULT.matcher(key);
			if (matcher.matches()) {
				String path = matcher.group(NAME);
				return doc.getAsString(path, matcher.group(VALUE));
			} else {
				return doc.getAsString(key);
			}
		}

		private static final String fetchStringX(String key, JadeDoc doc) {
			Matcher matcher = HASDEFAULT.matcher(key);
			if (matcher.matches()) {
				String path = matcher.group(NAME);
				return doc.getAsString(path, matcher.group(VALUE));
			} else {
				return doc.getAsString(key, "null");
			}
		}

		public final String compileX(JadeDoc doc) {
			return parseExpressionX('@', this.content, doc);
		}

		public final List<String> compileXs(JadeDoc doc) {
			List<String> xs = new ArrayList<>();
			if (StringUtils.isBlank(content)) {
				return xs;
			}

			List<String> names = new ArrayList<>();
			Pattern expressionKeyPattern = Pattern.compile(String.format(KEYPATTERN, prefix));
			Matcher match = expressionKeyPattern.matcher(content);
			while (match.find()) {
				names.add(match.group(NAME));
			}

			if (names.isEmpty()) {
				xs.add(content);
				return xs;
			}
			List<String> keys = new ArrayList<>();
			keys.add(content);
			Set<String> vkeys = new HashSet<>();
			for (String v : names) {
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

//	public final List<String> compileXs(CompiledPattern compiledPattern) {
//		return compiledPattern.compileXs(this);
//	}

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
		List<String> keys = this.root.entrySet().stream().map(Entry<String, JsonElement>::getKey).toList();
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

	public JadeDoc add(String pattern, Map<String, Object> contents) {
		if (contents == null) {
			return this;
		}

		if (StringUtils.isBlank(pattern)) {
			contents.forEach(this::addObject);
		} else {
			contents.forEach((key, value) -> this.addObject(String.join("/", pattern, key), value));
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
					if (target.get(x.getKey()) == null) {
						target.add(x.getKey(), x.getValue());
					} else {
						if (x.getValue() != null) {
							target.add(x.getKey(), x.getValue());
						}
					}
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

	public JadeDoc add(String pattern, Number[] bs) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JsonArray js = new JsonArray();
		for (int i = 0; i < bs.length; i++) {
			js.add(new JsonPrimitive(bs[i]));
		}
		JPathTemplate.add(this.root, pattern, js);
		return this;
	}

	public JadeDoc add(String pattern, char[] bs) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JsonArray js = new JsonArray();
		for (int i = 0; i < bs.length; i++) {
			js.add(new JsonPrimitive(bs[i]));
		}
		JPathTemplate.add(this.root, pattern, js);
		return this;
	}

	public JadeDoc add(String pattern, byte[] bs) {
		if (StringUtils.isBlank(pattern)) {
			return this;
		}
		JsonArray js = new JsonArray();
		for (int i = 0; i < bs.length; i++) {
			js.add(new JsonPrimitive(bs[i]));
		}
		JPathTemplate.add(this.root, pattern, js);
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
		} else if (el.isJsonNull()) {
			return null;
		}
		return el.toString();
	}

	public String getString(String pattern) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el.isJsonNull()) {
			return null;
		}
		return el.getAsString();
	}

	@SuppressWarnings("unchecked")
	public <T> T[] getAsArray(String pattern, Class<T> requiredType) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		T[] result = null;

		if (el.isJsonArray()) {
			var es = el.getAsJsonArray();
			result = (T[])java.lang.reflect.Array.newInstance(requiredType, es.size());
			for (int i = 0; i < es.size(); i++) {
				result[i] = (T) this.getJsonElementAsFuns.get(requiredType).apply(es.get(i));
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAsList(String pattern, Class<T> requiredType) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		List<T> result = new ArrayList<>();

		if (el.isJsonArray()) {
			var es = el.getAsJsonArray();
			for (int i = 0; i < es.size(); i++) {
				Object x;
				x = this.getJsonElementAsFuns.get(requiredType).apply(es.get(i));
				result.add((T) x);
			}
		} else {
			var x = this.getJsonElementAsFuns.get(requiredType).apply(el);
			result.add((T) x);
		}
		return result;
	}

	public long getAsLong(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsLong();
	}

	public int getAsInt(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsInt();
	}

	public short getAsShort(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsShort();
	}

	public double getAsDouble(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsDouble();
	}

	public float getAsFloat(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsFloat();
	}
	
	public float getAsFloat(String pattern, float defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsFloat);
	}

	public boolean getAsBoolean(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsBoolean();
	}

	public byte getAsByte(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsByte();
	}

	public Number[] getAsNumbers(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		List<Number> lst = new ArrayList<>();
		el.getAsJsonArray().forEach(v -> lst.add(v.getAsNumber()));
		return lst.toArray(new Number[0]);
	}

	public Byte[] getAsBytes(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		List<Byte> lst = new ArrayList<>();
		el.getAsJsonArray().forEach(v -> lst.add(v.getAsByte()));
		return lst.toArray(new Byte[0]);
	}

	public char getAsChar(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsString().charAt(0);
	}

	public BigDecimal getAsBigDecimal(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsBigDecimal();
	}

	public Date getAsDate(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		try {
			return DateFormat.getDateInstance().parse(el.getAsString());
		} catch (ParseException e) {
			throw new ItemNotFoundException(pattern);
		}
	}

	public Date getAsDate(String pattern, Date defValue) {
		try {
			JsonElement el = check(pattern);
			return DateFormat.getDateInstance().parse(el.getAsString());
		} catch (Exception e) {
			return defValue;
		}
	}

	public Instant getAsInstant(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return Instant.parse(el.getAsString());
	}

	public LocalDateTime getAsLocalDateTime(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return LocalDateTime.parse(el.getAsString());
	}

	public LocalDate getAsLocalDate(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return LocalDate.parse(el.getAsString());
	}

	public OffsetDateTime getAsOffsetDateTime(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return OffsetDateTime.parse(el.getAsString());
	}

	public OffsetTime getAsOffsetTime(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return OffsetTime.parse(el.getAsString());
	}

	public ZonedDateTime getAsZonedDateTime(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return ZonedDateTime.parse(el.getAsString());
	}

	public Timestamp getAsTimestamp(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return Timestamp.valueOf(el.getAsString());
	}

	public Time getAsTime(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return Time.valueOf(el.getAsString());
	}

	public YearMonth getAsYearMonth(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return YearMonth.parse(el.getAsString());
	}

	public Number getAsNumber(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		return el.getAsNumber();
	}

	public Map<String, ?> getAsMap(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (!el.isJsonObject()) {
			return new HashMap<>();
		}
		Map<String, Object> result = new HashMap<>();
		el.getAsJsonObject().entrySet().forEach(ev -> result.put(ev.getKey(), ev.getValue()));
		return result;
	}

	public Object getObject(String name) throws ItemNotFoundException {
		JsonElement el = check(name);
		if (!el.isJsonPrimitive()) {
			return el.toString();
		}
		JsonPrimitive val = el.getAsJsonPrimitive();
		Field f;
		try {
			f = JsonPrimitive.class.getDeclaredField("value");
			f.setAccessible(true);
			return f.get(val);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			throw new ItemNotFoundException(name);
		}
	}

	public Object getObject(String name, Class<?> cls) throws ItemNotFoundException {
		if (cls == null) {
			return this.getObject(name);
		}

		if (this.getAsFuns.containsKey(cls)) {
			return this.getAsFuns.get(cls).apply(name);
		}

		return this.fromJson(name, cls);
	}

	public Object getObject(String name, Class<?> cls, boolean ignoreCase) throws ItemNotFoundException {
		if (!ignoreCase) {
			return this.getObject(name, cls);
		}

		if (cls == null) {
			var first = this.root.entrySet().stream().filter((v) -> v.getKey().equalsIgnoreCase(name)).findFirst();
			if (first.isPresent()) {
				return first.get().getValue();
			}
			return null;
		}

		if (this.getAsFuns.containsKey(cls)) {
			var first = this.root.entrySet().stream().filter((v) -> v.getKey().equalsIgnoreCase(name)).findFirst();
			if (first.isPresent()) {
				if (first.get().getValue().isJsonNull()) {
					return null;
				}
				return this.getAsFuns.get(cls).apply(first.get().getKey());
			}
			return null;
		}
		var first = this.root.entrySet().stream().filter((v) -> v.getKey().equalsIgnoreCase(name)).findFirst();
		if (first.isPresent()) {
			if (first.get().getValue().isJsonNull()) {
				return null;
			}
			try {
				Object x = this.fromJson(name, cls);
				if (x != null) {
					return x;
				}
			} catch (Exception ex) {

			}
		}
		return this.fromJson(cls);
	}

	public Object getObject(String name, String type) throws ItemNotFoundException, ClassNotFoundException {

		if (type == null || type.length() < 1) {
			return this.getObject(name);
		}

		String xType = type.toLowerCase();
		if (this.getStrAsFuns.containsKey(xType)) {
			return this.getStrAsFuns.get(xType).apply(name);
		}

		Matcher match = ARRAYTYPE.matcher(xType);
		if (match.find()) {
			var t = match.group(NAME);
			return this.getAsArray(name, this.simpleTypes.get(t));
		}

		match = LISTTYPE.matcher(xType);
		if (match.find()) {
			var t = match.group(NAME);
			return this.getAsList(name, this.simpleTypes.get(t));
		}

		return this.fromJson(name, Class.forName(type));
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

	public boolean isPrimitive(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (el == null) {
			return false;
		}

		return el.isJsonPrimitive();
	}

	public boolean isArray(String pattern) throws ItemNotFoundException {
		JsonElement el = check(pattern);
		if (el == null) {
			return false;
		}

		return el.isJsonArray();
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

	public boolean getAsBoolean(String pattern, Boolean defaultValue) {
		return this.getWithDefault(pattern, defaultValue, JsonElement::getAsBoolean);
	}

	public JadeDoc getStrAsJson(String pattern) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null || el.isJsonNull() || !el.isJsonPrimitive()) {
			return JadeDoc.build().create();
		}
		String str = el.getAsString();

		return JadeDoc.build().create(str);
	}

	public JadeDoc getBase64AsJson(String pattern) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		if (el == null || el.isJsonNull() || !el.isJsonPrimitive()) {
			return JadeDoc.build().create();
		}
		String base64Str = el.getAsString();

		return JadeDoc.build().create(Base64.getDecoder().decode(base64Str));
	}

	public JadeDoc getAsJson(String pattern) {
		JsonElement el = JPathProcessor.find(pattern, this.root);
		return JadeDoc.build().create(el);
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

	public void forEach(BiConsumer<String, JsonElement> action) {
		this.root.entrySet().forEach(v -> action.accept(v.getKey(), v.getValue()));
	}

	public List<String> keys() {
		return this.root.entrySet().stream().map(v -> v.getKey()).toList();
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
		return this.gson.toJson(root);
	}

	private static String nodeName(String prefix, String name) {
		if (StringUtils.isNotBlank(prefix)) {
			return String.join(":", prefix, name);
		}
		return name;
	}

	private static void parse(Document document, Element node, String name, JsonElement el) {
		if ("_".equals(name)) {
			el.getAsJsonObject().entrySet().forEach(x -> node.setAttribute(x.getKey(), x.getValue().getAsString()));
		} else if ("@".equals(name)) {
			Text textNode = document.createTextNode(el.getAsString());
			node.appendChild(textNode);
		} else if ("$".equals(name)) {
			el.getAsJsonArray().forEach(v -> parse(document, node, null, v));
		} else if (el.isJsonObject()) {
			if (StringUtils.isNotBlank(name)) {
				Element child = document.createElement(name);
				node.appendChild(child);
				el.getAsJsonObject().entrySet().forEach(v -> parse(document, child, v.getKey(), v.getValue()));
			} else {
				el.getAsJsonObject().entrySet().forEach(v -> parse(document, node, v.getKey(), v.getValue()));
			}
		}
	}

	public Document toXml() throws ParserConfigurationException {
		Document document = createDocumentBuilder().newDocument();

		Set<Entry<String, JsonElement>> first = this.getRoot().entrySet();
		var size = this.getRoot().entrySet().size();

		Element rootEl = null;
		if (size == 1) {
			@SuppressWarnings("unchecked")
			Entry<String, JsonElement>[] xs = new Entry[1];
			var vs = first.toArray(xs);
			rootEl = document.createElement(vs[0].getKey());
		} else {
			rootEl = document.createElement("root");
		}

		for (var r : first) {
			parse(document, rootEl, r.getKey(), r.getValue());
		}

		document.appendChild(rootEl);

		return document;
	}

	private static void parseX(Document document, Element node, String name, JsonElement el, String prefix) {
		if (ATTRS.equals(name)) {
			el.getAsJsonObject().entrySet().forEach(x -> node.setAttribute(x.getKey(), x.getValue().getAsString()));
		} else if (el.isJsonPrimitive()) {
			Element child = document.createElement(nodeName(prefix, name));
			child.setTextContent(el.getAsString());
			node.appendChild(child);
		} else if (el.isJsonObject()) {
			JadeDoc doc = JadeDoc.build().create(el);
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
						parseX(document, child, v.getKey(), v.getValue(), prefix);
					}
				});
			}
		} else if (el.isJsonArray()) {
			el.getAsJsonArray().forEach(v -> parseX(document, node, name, v, prefix));
		}
	}

	public Document toXml(String path, String prefix, Map<String, String> attrs) throws ParserConfigurationException {
		Document document = createDocumentBuilder().newDocument();
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
			el.getAsJsonObject().entrySet().forEach(v -> parseX(document, rootEl, v.getKey(), v.getValue(), prefix));
		} else if (el.isJsonPrimitive()) {
			rootEl.setTextContent(el.getAsString());
		} else if (el.isJsonArray()) {
			el.getAsJsonArray().forEach(v -> parseX(document, rootEl, path, v, prefix));
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

		public String getSource() {
			return source;
		}

		public String getTarget() {
			return target;
		}

		public String getKey() {
			return String.format("%s-%s", this.source, this.target);
		}
	}

	public record CPattern(CompiledPattern source, CompiledPattern target) {
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

		public Map<String, CPattern> getCompilePattern() {
			Map<String, CPattern> compiledPatterns = new HashMap<>();

			for (var p : this.patterns.values()) {
				CompiledPattern source = null;
				CompiledPattern target = null;
				Matcher match = DEFAULT_EXPATTERN.matcher(p.getSource());
				if (match.find()) {
					source = new CompiledPattern(p.getSource());
				}
				if (p.getTarget() != null) {
					match = DEFAULT_EXPATTERN.matcher(p.getTarget());
					if (match.find()) {
						target = new CompiledPattern(p.getTarget());
					}
				}
				if (source != null || target != null) {
					compiledPatterns.put(p.getKey(), new CPattern(source, target));
				}
			}

			for (var v : this.simplePattern) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					compiledPatterns.put(v, new CPattern(new CompiledPattern(v), null));
				}
			}

			for (var v : this.actions) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					compiledPatterns.put(v, new CPattern(new CompiledPattern(v), null));
				}
			}

			for (var v : this.removes) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					compiledPatterns.put(v, new CPattern(new CompiledPattern(v), null));
				}
			}

			return compiledPatterns;
		}

		public JsonTemplate generate(JadeDoc doc, Map<String, CPattern> compiledPatterns) {
			JsonTemplate template = new JsonTemplate();

			for (var v : this.actions) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					CPattern cp = compiledPatterns.get(v);
					template.actions.add(cp.source().compileX(doc));
				} else {
					template.actions.add(v);
				}
			}

			for (var v : this.removes) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					CPattern cp = compiledPatterns.get(v);
					template.removes.add(cp.source().compileX(doc));
				} else {
					template.removes.add(v);
				}
			}

			for (var p : this.patterns.values()) {
				String source = p.getSource();
				String target = p.getTarget();
				if (compiledPatterns.containsKey(p.getKey())) {
					CPattern cp = compiledPatterns.get(p.getKey());
					if (cp.source() != null) {
						source = cp.source().compileX(doc);
					}
					if (cp.target() != null) {
						target = cp.target().compileX(doc);
					}
				}
				template.pattern(source, target);
			}

			for (var v : this.simplePattern) {
				Matcher match = DEFAULT_EXPATTERN.matcher(v);
				if (match.find()) {
					CPattern cp = compiledPatterns.get(v);
					template.simplePattern.add(cp.source().compileX(doc));
				}
			}

			return template;
		}

		public final void add(String jsonContent) {
			Builder builder = new Builder();
			JadeDoc doc = builder.create(jsonContent);

			doc.forEachX("patterns", el -> {
				JsonObject v = el.getAsJsonObject();
				String source = v.get("source").getAsString();
				if (v.has("target")) {
					String target = v.get("target").getAsString();
					if (StringUtils.isBlank(target)) {
						this.pattern(source);
					} else {
						this.pattern(source, target);
					}
				} else {
					this.simplePattern.add(source);
				}
			});

			if (doc.has("simplePattern")) {
				var rs = doc.get("simplePattern").getAsJsonArray();
				for (var r : rs) {
					this.simplePattern.add(r.getAsString());
				}
			}

			doc.forEachX("actions", el -> this.action(el.getAsString()));
			doc.forEachX("removes", el -> this.remove(el.getAsString()));
		}

		public static final JsonTemplate parse(String jsonContent) {
			JsonTemplate template = new JsonTemplate();
			if (StringUtils.isBlank(jsonContent)) {
				return template;
			}
			template.add(jsonContent);
			return template;
		}

		@Override
		public String toString() {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.disableHtmlEscaping().create();
			return gson.toJson(this);
		}
	}

	public static class MapAdapter
			implements JsonSerializer<Map<String, Object>>, JsonDeserializer<Map<String, Object>> {
		@Override
		public JsonElement serialize(Map<String, Object> src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject jsonObject = new JsonObject();
			for (Object key : src.keySet()) {
				jsonObject.addProperty(String.valueOf(key), String.valueOf(src.get(key)));
			}
			return jsonObject;
		}

		@Override
		public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			Map<String, Object> map = new HashMap<>();
			JsonObject jsonObject = json.getAsJsonObject();
			for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
				var v = entry.getValue();
				if (v.isJsonPrimitive()) {
					JsonPrimitive jp = v.getAsJsonPrimitive();
					if (jp.isBoolean()) {
						map.put(entry.getKey(), jp.getAsBoolean());
					} else if (jp.isNumber()) {
						map.put(entry.getKey(), parseNumber(jp.getAsString()));
					} else {
						map.put(entry.getKey(), jp.getAsString());
					}
				} else if (v.isJsonNull()) {
					map.put(entry.getKey(), null);
				} else {
					map.put(entry.getKey(), v.getAsString());
				}
			}
			return map;
		}
	}

	public class DataTypeAdapter extends TypeAdapter<Object> {

		private final TypeAdapter<Object> delegate = new Gson().getAdapter(Object.class);

		@Override
		public void write(JsonWriter out, Object value) throws IOException {
			delegate.write(out, value);
		}

		@Override
		public Object read(JsonReader in) throws IOException {
			JsonToken token = in.peek();
			switch (token) {
			case BEGIN_ARRAY:
				List<Object> list = new ArrayList<Object>();
				in.beginArray();
				while (in.hasNext()) {
					list.add(read(in));
				}
				in.endArray();
				return list;

			case BEGIN_OBJECT:
				Map<String, Object> map = new LinkedTreeMap<String, Object>();
				in.beginObject();
				while (in.hasNext()) {
					map.put(in.nextName(), read(in));
				}
				in.endObject();
				return map;

			case STRING:
				return in.nextString();

			case NUMBER:
				// return in.nextDouble();
				String n = in.nextString();
				if (n.indexOf('.') != -1) {
					return Double.parseDouble(n);
				}
				return Long.parseLong(n);

			case BOOLEAN:
				return in.nextBoolean();

			case NULL:
				in.nextNull();
				return null;

			default:
				throw new IllegalStateException();
			}
		}
	}

//	public static class DateTypeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
//		private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//        private final SimpleDateFormat[] dateFormats = {
//                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
//                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"),
//                new SimpleDateFormat("yyyy-MM-dd HH:mm"),
//                new SimpleDateFormat("yyyy-MM-dd")
//                // Add more date formats as needed
//        };
//
//	    @Override
//	    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//	        String dateStr = json.getAsString();
//            for (SimpleDateFormat dateFormat : dateFormats) {
//                try {
//                    return dateFormat.parse(dateStr);
//                } catch (ParseException ignored) {
//                    // Try the next date format
//                }
//            }
//            return null;
//	    }
//	    
//	    @Override
//	    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
//	        JsonObject jsonObject = new JsonObject();
//	        jsonObject.addProperty("date", dateFormat.format(src));
//	        return jsonObject;
//	    }
//	}

	private static class DateTypeAdapter extends TypeAdapter<Date> {
		private final SimpleDateFormat dateFormatT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		private final SimpleDateFormat dateFormatD = new SimpleDateFormat("yyyy-MM-dd");

		private final SimpleDateFormat[] dateFormats = { new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd")
				// Add more date formats as needed
		};

		@Override
		public void write(JsonWriter out, Date value) throws IOException {
			if (value == null) {
				out.nullValue();
				return;
			}
			String v = dateFormatT.format(value);
			if(v.contains("00:00:00")) {
				out.value(dateFormatD.format(value));
			} else {
				out.value(v);
			}
		}

		@Override
		public Date read(JsonReader in) throws IOException {
			if (in.peek() == JsonToken.NULL) {
				in.nextNull();
				return null;
			}
			String dateString = in.nextString();
			for (SimpleDateFormat dateFormat : dateFormats) {
				try {
					return dateFormat.parse(dateString);
				} catch (ParseException ignored) {
					// Try the next date format
				}
			}
			throw new IOException("Unparseable date: " + dateString);
		}
	}

	private static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {
		private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		private final SimpleDateFormat[] dateFormats = { new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
				new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm")
				// Add more date formats as needed
		};

		@Override
		public void write(JsonWriter out, java.sql.Date value) throws IOException {
			if (value == null) {
				out.nullValue();
				return;
			}
			out.value(dateFormat.format(value));
		}

		@Override
		public java.sql.Date read(JsonReader in) throws IOException {
			if (in.peek() == JsonToken.NULL) {
				in.nextNull();
				return null;
			}
			String dateString = in.nextString();
			for (SimpleDateFormat dateFormat : dateFormats) {
				try {
					Date dt = dateFormat.parse(dateString);
					return new java.sql.Date(dt.getTime());
				} catch (ParseException ignored) {
					// Try the next date format
				}
			}
			throw new IOException("Unparseable date: " + dateString);
		}
	}

	private static class TimestampTypeAdapter extends TypeAdapter<java.sql.Timestamp> {
		private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		private final SimpleDateFormat[] dateFormats = { new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd") };

		@Override
		public void write(JsonWriter out, java.sql.Timestamp value) throws IOException {
			if (value == null) {
				out.nullValue();
				return;
			}

			out.value(dateFormat.format(value));
		}

		@Override
		public java.sql.Timestamp read(JsonReader in) throws IOException {
			if (in.peek() == JsonToken.NULL) {
				in.nextNull();
				return null;
			}
			String dateString = in.nextString();
			for (SimpleDateFormat dateFormat : dateFormats) {
				try {
					Date dt = dateFormat.parse(dateString);
					return new java.sql.Timestamp(dt.getTime());
				} catch (ParseException ignored) {
					// Try the next date format
				}
			}
			throw new IOException("Unparseable date: " + dateString);
		}
	}

	public static class LazilyParsedNumber implements ToNumberStrategy {
		@Override
		public Number readNumber(JsonReader in) throws IOException {
			String v = in.nextString();
			return parseNumber(v);
		}
	}

	public static Object convert(Object obj, Type type) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
		builder.setObjectToNumberStrategy(new LazilyParsedNumber());
		builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
		builder.registerTypeAdapter(java.sql.Timestamp.class, new TimestampTypeAdapter());
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		var gson = builder.disableHtmlEscaping().create();
		return gson.toJson(obj, type);
	}

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
		builder.setObjectToNumberStrategy(new LazilyParsedNumber());
		builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		var gson = builder.disableHtmlEscaping().create();
		return gson.toJson(obj);
	}

	public static <T> T from(String data, Class<T> classOfT) {
		if (data == null) {
			return null;
		}
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
		builder.setObjectToNumberStrategy(new LazilyParsedNumber());
		builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
		builder.registerTypeAdapter(java.sql.Timestamp.class, new TimestampTypeAdapter());
		// builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		var gson = builder.disableHtmlEscaping().create();
		return gson.fromJson(data, classOfT);
	}

	public static class Builder {

		private final Gson gson;

		private Builder(GsonBuilder builder) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(null)).disableHtmlEscaping();
			builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
			builder.setObjectToNumberStrategy(new LazilyParsedNumber());
			builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
			builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
			builder.registerTypeAdapter(java.sql.Timestamp.class, new TimestampTypeAdapter());
			builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
			this.gson = builder.disableHtmlEscaping().create();
		}

		private Builder() {
			this(new GsonBuilder());
		}

		private Builder(GsonBuilder builder, JsonTemplate template, Map<String, Object> values) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(template, values));
			builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
			builder.setObjectToNumberStrategy(new LazilyParsedNumber());
			builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
			builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
			builder.registerTypeAdapter(java.sql.Timestamp.class, new TimestampTypeAdapter());
			builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
			this.gson = builder.disableHtmlEscaping().create();
		}

		private Builder(GsonBuilder builder, JsonTemplate template) {
			builder.registerTypeAdapter(JadeDoc.class, new JadeDocAdapter(template));
			builder.registerTypeAdapter(Map.class, new MapAdapter()).disableHtmlEscaping();
			builder.setObjectToNumberStrategy(new LazilyParsedNumber());
			builder.registerTypeAdapter(Date.class, new DateTypeAdapter());
			builder.registerTypeAdapter(java.sql.Date.class, new SqlDateTypeAdapter());
			builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
			builder.registerTypeAdapter(java.sql.Timestamp.class, new TimestampTypeAdapter());
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

		public JadeDoc create(Dictionary<String, Object> values) {
			JadeDoc doc = new JadeDoc(this.gson);

			Enumeration<String> e = values.keys();
			while (e.hasMoreElements()) {
				String key = e.nextElement();
				doc.addObject(key, values.get(key));
			}

			return doc;
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

		public JadeDoc createFromXml(InputStream xmlStream) throws Exception {
			return XmlParser.parse(new InputStreamReader(xmlStream));
		}

		public JadeDoc createFromXml(byte[] xmlBytes) throws Exception {
			return this.createFromXml(new ByteArrayInputStream(xmlBytes));
		}

		public JadeDoc create(InputStream xmlStream, boolean keepNamespace) throws Exception {
			Document doc = createDocumentBuilder().parse(xmlStream);
			return this.create(doc, keepNamespace);
		}

		public JadeDoc create(byte[] xmlBytes, boolean keepNamespace) throws Exception {
			Document doc = createDocumentBuilder().parse(new ByteArrayInputStream(xmlBytes));
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
			if (object instanceof String) {
				return this.create(object.toString());
			}
			return gson.fromJson(gson.toJson(object), JadeDoc.class);
		}

		public JadeDoc create(Object object, Class<?> cls) {
			if (object == null) {
				return null;
			}
			if (object instanceof String) {
				return this.create(object.toString());
			}
			return gson.fromJson(gson.toJson(object, cls), JadeDoc.class);
		}

		public JadeDoc create(JadeDoc model) {
			return gson.fromJson(model.root.deepCopy(), JadeDoc.class);
		}

		public String toJson(JadeDoc model) {
			return gson.toJson(model);
		}

		public String toJson(Object model) {
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

				for (String pattern : this.template.simplePattern) {
					if ("*".equals(pattern)) {
						model.join(source);
						continue;
					}
					JPathTemplate.add(model.root, pattern, source, pattern, this.values);
				}

				for (Entry<String, PatternPair> pattern : this.template.patterns.entrySet()) {
					String sourceStr = pattern.getValue().source;
					String target = pattern.getValue().target;
					if (StringUtils.isBlank(target) || "*".equals(target)) {
						JsonElement el = JPathProcessor.find(sourceStr, source);
						if (el != null && el.isJsonObject()) {
							var obj = el.getAsJsonObject();
							model.join(obj);
						} else {
							model.add("NULL", el);
						}
						continue;
					}
					JPathTemplate.add(model.root, target, source, sourceStr, this.values);
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
				return gson.fromJson(model.toJson(), JsonObject.class);
			}
		}
	}

	public JadeDoc empty() {
		return new JadeDoc(this.gson);
	}
}
