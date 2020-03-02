package com.yunionyun.mcp.mcclient.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	public static String Camel2Kebab(String camel, String sep) {
		List<String> tokens = new ArrayList<String>();
		StringBuilder token = new StringBuilder();
		for (int i = 0; i < camel.length(); i++) {
			char ch = camel.charAt(i);
			boolean split = false;
			char nchar = 0;
			if (Character.isUpperCase(ch)) {
				if (i > 0 && Character.isUpperCase(camel.charAt(i - 1))) {
					if (i + 1 < camel.length() && Character.isLowerCase(camel.charAt(i + 1))) {
						split = true;
					}
				} else {
					split = true;
				}
				nchar = Character.toLowerCase(ch);
			} else if (Character.isLowerCase(ch) || Character.isDigit(ch)) {
				nchar = ch;
			} else {
				split = true;
			}
			if (split && token.length() > 0) {
				tokens.add(token.toString());
				token = new StringBuilder();
			}
			if (nchar != 0) {
				token.append(nchar);
			}
		}
		if (token.length() > 0) {
			tokens.add(token.toString());
		}
		return String.join(sep, tokens);
	}

	public static String CapitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i])
					|| chars[i] == '.'
					|| chars[i] == '\'') { // You can add other chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}

	public static String Kebab2Camel(String kebab, String sep) {
		String[] tokens = kebab.split(sep);
		StringBuilder camel = new StringBuilder();
		for (String token : tokens) {
			camel.append(CapitalizeString(token));
		}
		return camel.toString();
	}
}
