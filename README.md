Jadeson
==========
A Json tool base on Gson and Antlr4. It is very convenient and easy json tool in java. It have search by condition, filter, modify, and it can be extensible. Please refer to the junit test code for detail useful cases. 

# Change Log #

https://github.com/jamesliu1511/JadeSon

# Contact #
- email: `james.liu1511@gmail.com`

# JPath #

## Selecting Nodes：

| Expression | Description | 
| :---   |   :---:   |   
| nodename    | Selects all nodes with the name "nodename" in the current node|
| *    |Selects all chidlren in the current node|
| @    |Selects item value|

| Path Expression | Result |
| :---   |   :---:   | 
| bookstore    | Selects all child nodes in the node of "bookstore"|
| bookstore/*    | Selects all child nodes in the node of "bookstore"|
| bookstore/book    |Selects all child nodes in the node of "bookstore/book"|
| @lang    |Selects the value which is named lang|

## Predicates：

|Path Expression | Result | 
| :---   |   :---:   |   
| bookstore/book[0]    | Selects the first book element that is the child of the bookstore element.|
| bookstore/book[-1]    | Selects the last book element that is the child of the bookstore element.|
| bookstore/book[-2]    | Selects the last but one book element that is the child of the bookstore element.|
| bookstore/book[0,1,2] or bookstore/book[<0,2>]  | Selects the first three book elements that are children of the bookstore element.|
| title[@lang]    | Selects all the title elements that have an item named lang.|
| title[equal(@lang,'en')]   | Selects all the title elements that have a "lang" item with a value of "en".|
| bookstore/book[price>35.00]| Selects all the book elements of the bookstore element that have a price element with a value greater than 35.00.|
| bookstore/book?price>35.00 | Selects all the book elements of the bookstore element that have a price element with a value greater than 35.00.|
*'<','>','<=','>=','==' are used number value condition check

## Special operator：

|operator| Description | 
| :---   |   :---:   |   
| []  | condition check or array item selection|
| ? | condition check|
| {} | fetch item|

## supporting functions (function name insensitive)：
|function name| Description | 
| :---   |   :---:   |   
| fn:equal() | check string value equal|
| fn:equalsIgnoreCase() | check string value equalsIgnoreCase|
| fn:bool() | check content is boolean type|
| fn:float() | check content is float type|
| fn:int() | check content is integer type|
| fn:string() | check content is String type|
| fn:isNull()| the value of the item is null|
| fn:isNotNull()| the value of the item is not null|
| fn:isEmpty()| the value of the item is empty|
| fn:isNotEmpty()| the value of the item is empty|
| fn:isBlank()| the value of the item is null or empty|
| fn:isNotBlank()| the value of the item is null or empty|
| fn:false()| the boolean value of the item is false|
| fn:true()| the boolean value of the item is true|
| fn:reg()| regular expression check|
| fn:contain() | check content contains ...|
| fv:val() | fetch the value of the item|
| ft:json(@key, @value)| fetch the value of item as name, the content of the itme as value to combine as  a json node|
| ft:convert(@key, ....)| fetch the value of item as name, the content of the itmes as items to combine as  a json node|
| fm:remove(@key)| remove the children in the current node|
| fm:rename(@key,'name')| rename the child in the current node|
| fm:add(@key,value)| add the child into the current node|
| fm:format(@key, type)| format the child as 'type' in the current node|
| fm:default(@key, value)| set @key item as default value if it is null in the current node|

|expression| result | 
| :---   |   :---:   |   
|bookstore/book/discountEnabled[fn:bool()] | select the book item if discountEnabled is bool|
|bookstore/book[fn:bool(@discountEnabled)] | select the book item if discountEnabled is bool|
|bookstore/book/discount[fn:float()] | select the book item if it's discount is float type|
|bookstore/book[fn:float(@discount)] | select the book item if it's discount is float type|
|bookstore/book/discount[fn:int()] | select the book item if it's discount is integer type|
|bookstore/book[fn:int(@discount)] | select the book item if it's discount is integer type|
|bookstore/book/title[fn:contain('java')] | select the book item if it's title contain 'java'|
|bookstore/book[fn:contain(@title,'java')] | select the book item if it's title contain 'java'|
|bookstore/book/title[fn:isNull()] | select the book item if it's title is null|
|bookstore/book[fn:isNull(@title)] | select the book item if it's title is null|
|bookstore/book/title[fn:isNotNull()] | select the book item if it's title is not null|
|bookstore/book[fn:isNotNull(@title)] | select the book item if it's title is not null|
|bookstore/book/title[fn:isEmpty()] | select the book item if it's title is empty|
|bookstore/book[fn:isEmpty(@title)] | select the book item if it's title is empty|
|bookstore/book/title[fn:isNotEmpty()] | select the book item if it's title is not empty|
|bookstore/book[fn:isNotEmpty(@title)] | select the book item if it's title is not empty|
|bookstore/book/title[fn:isBlank()] | select the book item if it's title is null or empty|
|bookstore/book[fn:isBlank(@title)] | select the book item if it's title is null or empty|
|bookstore/book/title[fn:isNotBlank()] | select the book item if it's title is not null and empty|
|bookstore/book[fn:isNotBlank(@title)] | select the book item if it's title is not null and empty|
|bookstore/book/discountEnabled[fn:false()] | select the book item if discountEnabled is false|
|bookstore/book[fn:false(@discountEnabled)] | select the book item if discountEnabled is false|
|bookstore/book/discountEnabled[fn:true()] | select the book item if discountEnabled is true|
|bookstore/book[fn:true(@discountEnabled)] | select the book item if discountEnabled is true|
|bookstore/book[-1]]    | Selects the last book element that is the child of the bookstore element.|
|bookstore/book/title[fn:reg('java\|python')] | regular expression match. select the book item if it's title contain 'java' or 'python'|
|bookstore/book[fn:reg(@title,'java\|python')] | regular expression match. select the book item if it's title contain 'java' or 'python'|

|compound conditon| result | 
| :---   |   :---:   |   
|bookstore/book/discount[fn:val()<0.8] | select the book item if discound < 0.8|
|bookstore/book[fn:true(@discountEnabled) && fn:val(@discount)<0.8] | select the book item if discountEnabled is true and discound < 0.8|

## Create Json by JadeDoc

```
		Builder builder = JadeDoc.build();
		JadeDoc doc = builder.create();
		//add string object
		doc.add("a/b/c", "test");
		//add long 
		doc.add("a/b/d", 123l);
		//add int
		doc.add("a/b/e", 12);
		//add float
		doc.add("a/b/f", 123.98);
		//add boolean
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
		
output:
{"a":{"b":{"c":"test","d":123,"e":12,"f":123.98,"g":true,"h":[{"dcm":true,"test":233},{"dcm2":true,"test2":233}]}}}
{"a":{"b":"test1","c":["test1","test2","test3"]}}

```
## Parse String content by JadeDoc

```
		JadeDoc doc = JadeDoc.build().create(read("test2.json"));
		System.out.println(doc.fetch("properties[fn:equal(@name,'isTitle')]/*[0]"));
		String content = doc.compileX("I love @{name}, but hate @{properties[fn:equal(@name,'isTitle')]/*[0]/name}");
		System.out.println(content);
		
		content = doc.forCompile("#").compileX("I love #{name}, but hate #{properties[fn:equal(@name,'isTitle')]/*[0]/name}");
		System.out.println(content);

{"name":"isTitle","bundle":"common","values":[true],"attrTypeUrn":"attrType:Dboolean","multivalued":false,"propertyType":"attribute"}
I love Schedulefa52d0eb92213d4fa3d2256411dd99e3, but hate isTitle
I love Schedulefa52d0eb92213d4fa3d2256411dd99e3, but hate isTitle

```

## Fetching, formatting and remove... by template：
JadeDoc can fetch from source by template. JsonTemplate is a collection which you want to do on the json source.
for example: 
### 1. fetch items from the source, then save to the new json, template item can be write as
template.pattern("from path", "new path").
#### 1.1 template.pattern("a/b/c", "d"). Fetch the item of "a/b/c", save the item to new json object as "d".
#### 1.2 template.pattern("a/b/c"). Fetch the item of "a/b/c", if the item is jsonObject, then merge it with the root or create a node with "NULL".
### 2. change the itme, template item can be write as
template.action("path[fm:function(...)]").
#### 2.1 internal functions: remove, format, rename, default, add
this remove function just remove some parts in node
#### 2.2 customized functions: 
write customized function, then register to system by FunctionPool.registerFm
### 3. remove the whole node
```
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.pattern("header", "head");
		template.pattern("Resources[0]", "resource/a");
		template.pattern("Resources[1]", "resource/b");
		template.pattern("Resources[2]", "resource/c");
		template.pattern("Resources[<4,6>]", "resource/d");

		template.action("resource/d[startTime>155624970000][fm:remove(@program, @rating, @liveChannel)]");
		template.action("resource/b[fm:remove(@program, @rating, @liveChannel)]");
		template.remove("resource/a/program").remove("resource/a/rating");

		System.out.println(template);

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("schedules.json"));
		
		System.out.println(model.toJson());

```

## JadeDoc select：

```
		JadeDoc.JsonTemplate template = JadeDoc.createTemplate();
		template.pattern("header", "head");
		template.pattern("Resources[0]", "resource/a");
		template.pattern("Resources[1]", "resource/b");
		template.pattern("Resources[2]", "resource/c");
		template.pattern("Resources[<4,6>]", "resource/d");

		Builder builder = JadeDoc.template(template);
		JadeDoc model = builder.create(read("schedules.json"));
		System.out.println(model.toJson());

		JadeDoc doc = model.queryBuilder().where("startTime==1556517600000").select("resource/a", "page/page1")
				.select("resource/b", "rs/b").union("startTime==1556494200000").select("resource/c", "abc").build()
				.query(null);
		System.out.println(doc.toJson());

```

## JadeDoc query：

### fetch children by "p1/p2/p3{a,b,c}"

#### 1. JsonObject

```
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
```
result:
{"a":{"c":{"BigDecimal":1,"double":1.0,"string":"abc","string2":"abc","string3":"","number":1,"bool":true,"object":{}}}}
{"string":"abc","number":1,"object":{}}

#### 2. JsonArray

```
		Builder builder = JadeDoc.build();
		JsonElement el = new JsonObject();
		JadeDoc model = builder.create(el);

		JsonArray array = new JsonArray();
		for(int i = 0; i < 3; i++) {
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
```
result:
{"a":{"c":{"b":[{"content":"this is test -0","enabled":true,"value":0},{"content":"this is test -1","enabled":true,"value":1},{"content":"this is test -2","enabled":true,"value":2}]}}}
[{"content":"this is test -0","enabled":true},{"content":"this is test -1","enabled":true},{"content":"this is test -2","enabled":true}]


### fetch array node items by "p1/p2/p3[num1, num2,...]"
if num < 0, get from the end. 

```
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
```
result:
{"a":{"b":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}]}}}
[{"test":"ok"},{"num":2},{"num2":2,"a":3}]


### fetch array node items in the ranges "p1/p2/p3[<start, end>, <start,end>,...]"
if num < 0, get from the end. 

```
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
```
result:
{"a":{"b":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}]}}}
[{"test":"ok"},{"num":2},{"num2":2,"a":3},{"test":"ok"},{"num":2},{"num2":2,"a":3}]


### fetch node by condition "p1/p2/p3[num>=2 ||a > 3]"
if the condition "num>=2 ||a > 3" is satisfied, return "p1/p2/3" node, or return null  

```
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

		thrown.expect(ParseCancellationException.class);
		el = JPathProcessor.find("a/b/c[num>=2 |&  a > 3]", elements);
		System.out.println(el);
```

### fetch node items by condition "p1/p2/p3?num>=2 && a > 3"
if the condition "num>=2 && a > 3" is satisfied, return "p1/p2/3" node, or return null
```
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
		JsonElement el = doc.fetch("a/b?num>=2 && a > 3");
		System.out.println(el);
```

### fetch node items by function

#### 1. case 1
```
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
```

result:
{"a":{"b":{"c":{"num":2,"a":4,"x":"abc"},"d":{"num":2,"a":2,"x":"bc","y":"abc"}}}}
{"c":{"num":2,"a":4,"x":"abc"},"d":{"num":2,"a":2,"x":"bc","y":"abc"}}


#### 2. case 2
```
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

```
result:
{"a":{"b":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java","discount":0.8}}}
[{"num":2}]
{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java","discount":0.8}


#### 3. case 3
```
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
```
result:
{"a":{"b":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java"},"e":{"test":"test E","title":"thinking in java"}}}
{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java"}
[{"test":"ok"},{"num":2},{"num2":2,"a":3}]
{"test":"ok"}
"ok"
"ok"
["ok"]


#### 4. case 4 (customized function)
```
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
		
		BiFunction<JsonElement, Object[], Boolean> fun = (el, content) ->{
			String title = (String)content[0];
			String[] rs = title.split(",");
			for(String r : rs) {
				if(el.getAsString().contains(r)) {
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
```
result:
{"a":{"b":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java"},"x":{"c":[{"test":"ok"},{"num":2}],"disabled":true,"title":"thinking in c#"}}}
{"ab":{"ac":{"x1":{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java"}}}}
{"ab":{"ac":{"x2":{"c":[{"test":"ok"},{"num":2}],"disabled":true,"title":"thinking in c#"}}}}
{"ab":{"ac":{"v":[{"c":[{"test":"ok"},{"num":2},{"num2":2,"a":3}],"disabled":true,"title":"thinking in java"},{"c":[{"test":"ok"},{"num":2}],"disabled":true,"title":"thinking in c#"}]}}}
