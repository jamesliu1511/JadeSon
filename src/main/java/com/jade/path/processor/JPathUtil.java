package com.jade.path.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JPathUtil {
	private static final Pattern LITTERPATTERN1 = Pattern.compile("'(?<content>[^']*)'");
	private static final Pattern LITTERPATTERN2 = Pattern.compile("\"(?<content>[^\"]*)\"");

	private JPathUtil() {
	}
	
	public static final String parseLiteral(String content) {
		Matcher matcher1 = LITTERPATTERN1.matcher(content);
		Matcher matcher2 = LITTERPATTERN2.matcher(content);
		if (matcher1.matches()) {
			return matcher1.group("content");
		} else if (matcher2.matches()) {
			return matcher2.group("content");
		}
		return content;
	}
}
