package com.jade.test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.jade.path.JadeDoc;


public class JPatternTemplateTest {
	@Test
	public void test1() throws IOException {
		String content = "this is a test <xys>";
		JadeDoc doc = JadeDoc.build().create();
		doc.add("xys", "james");
		String s = doc.compileST(content);
		System.out.println(s);
	}

	@Test
	public void test2() throws IOException {
		String content = "[<vs:{ v | { name: \"<v.name>\", age: \"<v.age>\" \\}, }>]";
		JadeDoc doc = JadeDoc.build().create();
		JadeDoc doc1 = JadeDoc.build().create();
		JadeDoc doc2 = JadeDoc.build().create();
		JadeDoc doc3 = JadeDoc.build().create();
		doc1.add("name", "Tom");
		doc1.add("age", 20);
		doc2.add("name", "James");
		doc2.add("age", 30);
		doc3.add("name", "Peter");
		doc3.add("age", 40);
		doc.add("vs", doc1, doc2, doc3);
		
		String s = doc.compileST(content);
		System.out.println(s);
	}
	
	@Test
	public void test3() throws IOException {
		String content = "<vs:{ v | \\<name=\"<v.name>\", age=\"<v.age>\">}>";
		JadeDoc doc = JadeDoc.build().create();
		JadeDoc doc1 = JadeDoc.build().create();
		JadeDoc doc2 = JadeDoc.build().create();
		JadeDoc doc3 = JadeDoc.build().create();
		doc1.add("name", "Tom");
		doc1.add("age", 20);
		doc2.add("name", "James");
		doc2.add("age", 30);
		doc3.add("name", "Peter");
		doc3.add("age", 40);
		doc.add("vs", doc1, doc2, doc3);
		
		String s = doc.compileST(content);
		System.out.println(s);
	}
	
	@Test
	public void test4() throws IOException {
		String content = "<cuePoints>$cuePoints:{cuePoint|<cuePoint><contentEndTimePosition>$cuePoint.contentEndTimePosition$</contentEndTimePosition><contentTimePosition>$cuePoint.contentTimePosition$</contentTimePosition><customSlotId>$cuePoint.customSlotId$</customSlotId><timePositionClass>$cuePoint.timePositionClass$</timePositionClass><timeToNextAdUnit>$cuePoint.timeToNextAdUnit$</timeToNextAdUnit></cuePoint>}$</cuePoints>";
 		JadeDoc doc = JadeDoc.build().create();
		JadeDoc doc1 = JadeDoc.build().create();
		JadeDoc doc2 = JadeDoc.build().create();
		JadeDoc doc3 = JadeDoc.build().create();
		doc1.add("contentEndTimePosition", 123);
		doc1.add("contentTimePosition", 2);
		doc1.add("customSlotId", 345);
		doc1.add("timePositionClass", 4566);
		doc1.add("timeToNextAdUnit", 0);
		doc2.add("contentEndTimePosition", 123);
		doc2.add("contentTimePosition", 2);
		doc2.add("customSlotId", 345);
		doc2.add("timePositionClass", 4566);
		doc2.add("timeToNextAdUnit", 1);
		doc3.add("contentEndTimePosition", 123);
		doc3.add("contentTimePosition", 2);
		doc3.add("customSlotId", 345);
		doc3.add("timePositionClass", 4566);
		doc3.add("timeToNextAdUnit", 2);
		
		doc.add("cuePoints", doc1, doc2, doc3);
		
		String s = doc.compileST('$', '$', content);
		System.out.println(s);
	}
}
