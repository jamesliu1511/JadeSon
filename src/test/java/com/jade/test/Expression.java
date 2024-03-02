package com.jade.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import com.jade.path.JadeDoc;
import com.jade.path.exception.ItemNotFoundException;

public class Expression {

	@Test
	public void test1() {
		// String expression = "@{@{action@{abc}}/handler}, @abc, @{action}/handler,
		// @{abc}-@{action}";
		String expression = "action/handler";
		JadeDoc doc = JadeDoc.build().create();
		doc.add("action", "edit");
		doc.add("abc", "xxx");
		doc.add("edit/handler", "test");
		doc.add("actionxxx", "editxxx");
		doc.add("editxxx/handler", "12345");

		String result = parseExpression('@', expression, doc);
		System.out.println("Result: " + result);
	}

	@Test 
	void test2() throws ItemNotFoundException {
		JadeDoc doc = JadeDoc.build().create("{\"month\":[\"8\"]}");
		String[] months = doc.getAsArray("month", String.class);
		
		System.out.println(Arrays.toString(months));
	}
	
	public static String parseExpression(char prefix, String expression, JadeDoc doc) {
		Queue<String> stack = new LinkedList<String>();
		boolean started = false;
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
					stack.add(doc.getAsString(ret, "null"));
				} else {
					stack.add(doc.getAsString(expr, "null"));
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
}
