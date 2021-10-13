package com.jade.path.fn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public final class FunctionPool {
	private static final String COL = "col";
	private static final String PATH = "path";
	private static final String INDEX = "index";
	private static final String ROW = "row";
	private static final Pattern INTPATTERN = Pattern.compile("-?\\d+");
	private static final Pattern FLOATPATTERN = Pattern.compile("[+-]?(\\d+|\\d+\\.\\d+|\\.\\d+|\\d+\\.)([eE]\\d+)?");
	private static final Pattern BOOLPATTERN = Pattern.compile("([tT][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])");

	private static final Pattern JSONKEY = Pattern
			.compile("(?<path>\\S+)\\-\\{(?<index>\\d+)(,(?<row>\\d+))?(,(?<col>\\d+))?\\}");

	public static final String SPLIT_COMMA = "\\s*,\\s*";

	private static final Map<String, Predicate<JsonElement>> fnStore = new ConcurrentHashMap<>();
	private static final Map<String, Function<JsonElement, Object>> fvStore = new ConcurrentHashMap<>();
	private static final Map<String, BiPredicate<JsonElement, Object[]>> biFnStore = new ConcurrentHashMap<>();

	private static final Map<String, BiFunction<JsonElement, Map<String, JsonElement>, JsonElement>> ftStore = new ConcurrentHashMap<>();
	private static final Map<String, BiConsumer<JsonElement, Object[]>> fmStore = new ConcurrentHashMap<>();

	private static final Gson gson;

	static {
		gson = new GsonBuilder().create();

		fnStore.put("bool", FunctionPool::fnBool);
		fnStore.put("float", FunctionPool::fnFloat);
		fnStore.put("string", FunctionPool::fnString);
		fnStore.put("int", FunctionPool::fnInt);
		fnStore.put("isnull", FunctionPool::fnIsNull);
		fnStore.put("isnotnull", FunctionPool::fnIsNotNull);
		fnStore.put("isempty", FunctionPool::fnIsEmpty);
		fnStore.put("isnotempty", FunctionPool::fnIsNotEmpty);
		fnStore.put("isblank", FunctionPool::fnIsBlank);
		fnStore.put("isnotblank", FunctionPool::fnIsNotBlank);
		fnStore.put("false", FunctionPool::fnFalse);
		fnStore.put("true", FunctionPool::fnTrue);

		fvStore.put("val", FunctionPool::fvVal);

		biFnStore.put("contain", FunctionPool::fnContain);
		biFnStore.put("reg", FunctionPool::fnReg);
		biFnStore.put("equal", FunctionPool::fnEqual);
		biFnStore.put("equalsignorecase", FunctionPool::fnEqualsIgnoreCase);
		biFnStore.put("has", FunctionPool::fnHas);

		fmStore.put("remove", FunctionPool::fmRemove);
		fmStore.put("format", FunctionPool::fmFormat);
		fmStore.put("rename", FunctionPool::fmRename);
		fmStore.put("default", FunctionPool::fmDefault);
		fmStore.put("add", FunctionPool::fmAdd);

		ftStore.put("convert", FunctionPool::ftConvert);
		ftStore.put("json", FunctionPool::ftJson);
		ftStore.put("combine", FunctionPool::ftCombine);
	}

	private FunctionPool() {
	}

	public static final boolean registerFt(String functionName,
			BiFunction<JsonElement, Map<String, JsonElement>, JsonElement> fun) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (ftStore.containsKey(funName)) {
			return false;
		}
		ftStore.put(funName, fun);
		return true;
	}

	public static final boolean registerFm(String functionName, BiConsumer<JsonElement, Object[]> fun) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (fmStore.containsKey(funName)) {
			return false;
		}
		fmStore.put(funName, fun);
		return true;
	}

	public static final boolean registerFn(String functionName, Predicate<JsonElement> fun) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (fnStore.containsKey(funName)) {
			return false;
		}
		fnStore.put(funName, fun);
		return true;
	}

	public static final boolean registerFv(String functionName, Function<JsonElement, Object> fun) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (fvStore.containsKey(funName)) {
			return false;
		}
		fvStore.put(funName, fun);
		return true;
	}

	public static final boolean registerFn(String functionName, BiPredicate<JsonElement, Object[]> fun) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (biFnStore.containsKey(funName)) {
			return false;
		}
		biFnStore.put(funName, fun);
		return true;
	}

	public static final Object process(String functionName, JsonElement el) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (!fvStore.containsKey(funName)) {
			return null;
		}
		Function<JsonElement, Object> fun = fvStore.get(funName);
		return fun.apply(el);
	}

	public static final JsonElement process(String functionName, JsonElement el, Map<String, JsonElement> params) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (!ftStore.containsKey(funName)) {
			return null;
		}
		BiFunction<JsonElement, Map<String, JsonElement>, JsonElement> fun = ftStore.get(funName);
		return fun.apply(el, params);
	}

	public static final void execute(String functionName, JsonElement el, Object[] content) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (!fmStore.containsKey(funName)) {
			return;
		}
		BiConsumer<JsonElement, Object[]> fun = fmStore.get(funName);
		fun.accept(el, content);
	}

	public static final boolean invoke(String functionName, JsonElement el) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (!fnStore.containsKey(funName)) {
			return false;
		}
		Predicate<JsonElement> fun = fnStore.get(funName);
		return fun.test(el);
	}

	public static final boolean invoke(String functionName, JsonElement el, Object[] content) {
		String funName = functionName.toLowerCase(Locale.ENGLISH);
		if (!biFnStore.containsKey(funName)) {
			return false;
		}
		BiPredicate<JsonElement, Object[]> fun = biFnStore.get(funName);
		return fun.test(el, content);
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
			return new JsonPrimitive(Long.parseLong(value));
		}

		matcher = FLOATPATTERN.matcher(value);
		if (matcher.matches()) {
			return new JsonPrimitive(Double.parseDouble(value));
		}

		return new JsonPrimitive(value);
	}

	private static final boolean fnBool(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		return el.getAsJsonPrimitive().isBoolean();
	}

	private static final boolean fnString(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		return el.getAsJsonPrimitive().isString();
	}

	private static final boolean fnFloat(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isNumber()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsNumber().toString();
		return FLOATPATTERN.matcher(val).matches();
	}

	private static final boolean fnInt(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isNumber()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsNumber().toString();
		return INTPATTERN.matcher(val).matches();
	}

	private static final boolean fnIsNull(JsonElement el) {
		return (el == null || el.isJsonNull());
	}

	private static final boolean fnIsNotNull(JsonElement el) {
		return (el != null && !el.isJsonNull());
	}

	private static final boolean fnIsEmpty(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isString()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.isEmpty(val);
	}

	private static final boolean fnIsNotEmpty(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isString()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.isNotEmpty(val);
	}

	private static final boolean fnIsBlank(JsonElement el) {
		if (el == null) {
			return true;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isString()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.isBlank(val);
	}

	private static final boolean fnIsNotBlank(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isString()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.isNotBlank(val);
	}

	private static final boolean fnTrue(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isBoolean()) {
			return false;
		}
		return el.getAsBoolean();
	}

	private static final boolean fnFalse(JsonElement el) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isBoolean()) {
			return false;
		}
		return !el.getAsBoolean();
	}

	private static final boolean fnEqual(JsonElement el, Object[] content) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}

		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.equals(val, (String) content[0]);
	}

	private static final boolean fnEqualsIgnoreCase(JsonElement el, Object[] content) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}

		String val = el.getAsJsonPrimitive().getAsString();
		return StringUtils.equalsIgnoreCase(val, (String) content[0]);
	}

	private static final boolean fnHas(JsonElement el, Object[] content) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonObject()) {
			return false;
		}
		return el.getAsJsonObject().has((String) content[0]);
	}

	private static final boolean fnReg(JsonElement el, Object[] regex) {
		if (el == null) {
			return false;
		}
		if (!el.isJsonPrimitive()) {
			return false;
		}
		if (!el.getAsJsonPrimitive().isString()) {
			return false;
		}
		String val = el.getAsJsonPrimitive().getAsString();
		Pattern pattern = Pattern.compile((String) regex[0]);
		return pattern.matcher(val).matches();
	}

	private static final JsonPrimitive fromObject(Object value) {
		if (value instanceof Integer) {
			return new JsonPrimitive((Integer) value);
		} else if (value instanceof Double) {
			return new JsonPrimitive((Double) value);
		} else if (value instanceof Boolean) {
			return new JsonPrimitive((Boolean) value);
		} else if (value instanceof String) {
			return new JsonPrimitive((String) value);
		} else {
			return null;
		}
	}

	private static final boolean fnContain(JsonElement el, Object[] content) {
		if (el == null) {
			return false;
		}

		if (el.isJsonPrimitive()) {
			if (!el.getAsJsonPrimitive().isString()) {
				return false;
			}
			String val = el.getAsJsonPrimitive().getAsString();
			for (Object r : content) {
				if (!val.contains((String) r)) {
					return false;
				}
			}
			return true;
		} else if (el.isJsonArray()) {
			List<JsonPrimitive> ps = new ArrayList<>();
			for (JsonElement e : el.getAsJsonArray()) {
				if (e.isJsonPrimitive()) {
					ps.add(e.getAsJsonPrimitive());
				}
			}
			for (Object r : content) {
				if (!ps.contains(fromObject(r))) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	private static void collect(JsonArray array, List<JsonElement> es, int index) {
		int i = index;
		int size = array.size();
		if (index < 0) {
			if (Math.abs(index) > size) {
				return;
			}
			i = size + index;
		} else {
			if (index >= size) {
				return;
			}
		}
		es.add(array.get(i));
	}

	private static final void fmRemove(JsonElement el, Object[] params) {
		if (el == null) {
			return;
		}
		if (el.isJsonArray()) {
			// if param is integer, remove all itmes in the children with index
			// if param is string, remove the item in children in the array
			List<JsonElement> es = new ArrayList<>();
			List<String> items = new ArrayList<>();
			JsonArray array = el.getAsJsonArray();
			for (Object p : params) {
				if (p instanceof String) {
					items.add((String) p);
				} else {
					collect(array, es, (Integer) p);
				}
			}
			for (JsonElement e : es) {
				JsonObject r = e.getAsJsonObject();
				Set<Entry<String, JsonElement>> vs = r.entrySet();
				Set<String> names = new HashSet<>();
				for (Entry<String, JsonElement> v : vs) {
					names.add(v.getKey());
				}
				for (String name : names) {
					r.remove(name);
				}
			}

			for (JsonElement e : array) {
				for (String name : items)
					if (e.isJsonObject()) {
						JsonObject v = e.getAsJsonObject();
						v.remove(name);
					}
			}
		} else if (el.isJsonObject()) {
			JsonObject parent = el.getAsJsonObject();
			for (Object p : params) {
				parent.remove((String) p);
			}
		}
	}

	private static JsonPrimitive convert(String type, JsonElement element) {
		JsonPrimitive result = element.getAsJsonPrimitive();
		if ("string".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsString());
		} else if ("int".equalsIgnoreCase(type) || "integer".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsInt());
		} else if ("long".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsLong());
		} else if ("boolean".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsBoolean());
		} else if ("number".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsNumber());
		} else if ("decimal".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsBigDecimal());
		} else if ("double".equalsIgnoreCase(type)) {
			return new JsonPrimitive(result.getAsDouble());
		} else {
			return result;
		}
	}

	private static final void fmFormat(JsonElement el, Object[] params) {
		if (el == null || params == null || params.length != 2) {
			return;
		}

		String name = (String) params[0];
		String type = (String) params[1];
		if (el.isJsonArray()) {
			JsonArray array = el.getAsJsonArray();
			for (JsonElement e : array) {
				if (!e.isJsonObject()) {
					continue;
				}
				JsonObject current = e.getAsJsonObject();
				JsonElement v = current.get(name);
				current.add(name, convert(type, v));
			}
		} else if (el.isJsonObject()) {
			JsonObject current = el.getAsJsonObject();
			JsonElement v = current.get(name);
			current.add(name, convert(type, v));
		}
	}

	private static final void fmAdd(JsonElement el, Object[] params) {
		if (el == null || params == null || params.length != 2) {
			return;
		}

		String name = (String) params[0];
		if (el.isJsonArray()) {
			JsonArray array = el.getAsJsonArray();
			JsonObject current = new JsonObject();
			current.add(name, gson.fromJson(gson.toJson(params[1]), JsonElement.class));
			array.add(current);
		} else if (el.isJsonObject()) {
			JsonObject current = el.getAsJsonObject();
			current.add(name, gson.fromJson(gson.toJson(params[1]), JsonElement.class));
		}
	}

	private static final void fmRename(JsonElement el, Object[] params) {
		if (el == null || params == null || params.length != 2) {
			return;
		}
		String name = (String) params[0];
		String newName = (String) params[1];
		if (el.isJsonArray()) {
			JsonArray array = el.getAsJsonArray();
			for (JsonElement e : array) {
				if (!e.isJsonObject()) {
					continue;
				}
				JsonObject current = e.getAsJsonObject();
				if (current.has(name)) {
					JsonElement v = current.get(name);
					current.remove(name);
					current.add(newName, v);
				}
			}
		} else if (el.isJsonObject()) {
			JsonObject current = el.getAsJsonObject();
			if (current.has(name)) {
				JsonElement v = current.get(name);
				current.remove(name);
				current.add(newName, v);
			}
		}
	}

	private static final void fmDefault(JsonElement el, Object[] params) {
		if (el == null || params == null || params.length != 2) {
			return;
		}

		String name = (String) params[0];
		if (el.isJsonArray()) {
			JsonArray array = el.getAsJsonArray();
			for (JsonElement e : array) {
				if (e.isJsonObject()) {
					JsonObject current = e.getAsJsonObject();
					if (current.has(name)) {
						JsonElement child = current.get(name);
						if (child != null && !child.isJsonNull()) {
							continue;
						}
					}
					current.add(name, gson.fromJson(gson.toJson(params[1]), JsonElement.class));
				}
			}
		} else if (el.isJsonObject()) {
			JsonObject current = el.getAsJsonObject();
			if (current.has(name)) {
				JsonElement child = current.get(name);
				if (child != null && !child.isJsonNull()) {
					return;
				}
			}
			current.add(name, gson.fromJson(gson.toJson(params[1]), JsonElement.class));
		}
	}

	private static final Object fvVal(JsonElement el) {
		if (el == null) {
			return null;
		}
		if (!el.isJsonPrimitive()) {
			return el;
		}
		JsonPrimitive jp = el.getAsJsonPrimitive();
		if (jp.isBoolean()) {
			return jp.getAsBoolean();
		}

		if (jp.isNumber()) {
			String val = el.getAsJsonPrimitive().getAsNumber().toString();

			if (INTPATTERN.matcher(val).matches()) {
				return Long.parseLong(val);
			} else {
				return Double.parseDouble(val);
			}
		}

		return jp.getAsString();
	}

	private static class Pair<K, V> {
		private K key;
		private V value;

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	private static final JsonElement jsonArrayFilter(JsonElement e) {
		if (e.isJsonArray()) {
			if (e.getAsJsonArray().size() > 1) {
				return e;
			} else {
				return e.getAsJsonArray().get(0);
			}
		} else {
			return e;
		}
	}

	private static final Pair<String, JsonElement> fetch(Map<Integer, Map<Integer, Pair<String, JsonElement>>> store,
			int col, int row) {
		Map<Integer, Pair<String, JsonElement>> v;
		if (store.containsKey(col)) {
			v = store.get(col);
		} else {
			v = new HashMap<>();
			store.put(col, v);
		}

		if (v.containsKey(row)) {
			return v.get(row);
		} else {
			Pair<String, JsonElement> pair = new Pair<>();
			v.put(row, pair);
			return pair;
		}
	}

	private static final JsonElement ftJson(JsonElement el, Map<String, JsonElement> params) {
		if (el == null || el.isJsonNull()) {
			return null;
		}

		Map<Integer, Map<Integer, Pair<String, JsonElement>>> store = new HashMap<>();

		String indexStr;
		String rowStr;
		String colStr;
		int index = 0;
		int row = 0;
		int col = 0;
		for (Entry<String, JsonElement> entry : params.entrySet()) {
			Matcher matcher = JSONKEY.matcher(entry.getKey());
			if (!matcher.matches()) {
				return null;
			}
			indexStr = matcher.group(INDEX);
			rowStr = matcher.group(ROW);
			colStr = matcher.group(COL);
			row = StringUtils.isBlank(rowStr) ? 0 : Integer.parseInt(rowStr);
			col = StringUtils.isBlank(colStr) ? 0 : Integer.parseInt(colStr);
			index = Integer.parseInt(indexStr);
			Pair<String, JsonElement> pair = fetch(store, col, row);
			if (index == 0) {
				pair.setKey(entry.getValue().getAsString());
			} else {
				JsonElement e = entry.getValue();
				JsonElement r = jsonArrayFilter(e);
				pair.setValue(r);
			}
		}

		return convert2Json(store);
	}

	private static JsonElement convert2Json(Map<Integer, Map<Integer, Pair<String, JsonElement>>> store) {
		int keySize = store.keySet().size();
		if (keySize > 1) {
			JsonArray js = new JsonArray();
			for (Entry<Integer, Map<Integer, Pair<String, JsonElement>>> r : store.entrySet()) {
				JsonObject ret = new JsonObject();
				for (Pair<String, JsonElement> v : r.getValue().values()) {
					String key = StringUtils.isBlank(v.key) ? UUID.randomUUID().toString() : v.key;
					ret.add(key, v.value);
				}
				js.add(ret);
			}
			return js;
		} else {
			JsonObject ret = new JsonObject();
			for (Pair<String, JsonElement> v : store.get(0).values()) {
				ret.add(v.key, v.value);
			}
			return ret;
		}
	}

	private static void convertFilter(int index, String path, Entry<String, JsonElement> entry,
			Pair<String, JsonElement> pair) {
		if (index == 0) {
			pair.setKey(entry.getValue().getAsString());
		} else {
			JsonObject content;
			if (pair.value == null) {
				content = new JsonObject();
			} else {
				content = (JsonObject) pair.value;
			}
			content.add(path, entry.getValue());
			pair.setValue(content);
		}
	}

	private static final JsonElement ftConvert(JsonElement el, Map<String, JsonElement> params) {
		if (el == null || el.isJsonNull()) {
			return null;
		}

		Map<Integer, Map<Integer, Pair<String, JsonElement>>> store = new HashMap<>();

		String indexStr;
		String rowStr;
		String colStr;
		String path;
		int index = 0;
		int row = 0;
		int col = 0;
		for (Entry<String, JsonElement> entry : params.entrySet()) {
			Matcher matcher = JSONKEY.matcher(entry.getKey());
			if (!matcher.matches()) {
				return null;
			}
			indexStr = matcher.group(INDEX);
			rowStr = matcher.group(ROW);
			colStr = matcher.group(COL);
			path = matcher.group(PATH);
			row = StringUtils.isBlank(rowStr) ? 0 : Integer.parseInt(rowStr);
			col = StringUtils.isBlank(colStr) ? 0 : Integer.parseInt(colStr);
			index = Integer.parseInt(indexStr);
			Pair<String, JsonElement> pair = fetch(store, col, row);
			convertFilter(index, path, entry, pair);
		}

		return convert2Json(store);
	}

	private static final JsonElement ftCombine(JsonElement el, Map<String, JsonElement> params) {
		if (el == null || el.isJsonNull()) {
			return null;
		}

		JsonObject ret = new JsonObject();
		String path;
		for (Entry<String, JsonElement> entry : params.entrySet()) {
			Matcher matcher = JSONKEY.matcher(entry.getKey());

			if (matcher.matches()) {
				path = matcher.group(PATH);
			} else {
				continue;
			}
			ret.add(path, entry.getValue());
		}
		return ret;
	}
}
