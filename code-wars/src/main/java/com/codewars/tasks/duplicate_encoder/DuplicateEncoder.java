package com.codewars.tasks.duplicate_encoder;

import java.util.stream.Collectors;

/*
 * The goal of this exercise is to convert a string to a new string 
 * where each character in the new string is "(" 
 * if that character appears only once in the original string, 
 * or ")" if that character appears more than once in the original string. 
 * Ignore capitalization when determining if a character is a duplicate.
 */
public class DuplicateEncoder {
	public static String encode_1(String word) {
		word = word.toLowerCase();
		String result = "";
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			result += word.indexOf(c) == word.lastIndexOf(c) ? "(" : ")";
		}
		return result;
	}

	public static String encode_2(String word) {
		return word.toLowerCase().chars().mapToObj(i -> String.valueOf((char) i))
				.map(i -> word.indexOf(i) == word.lastIndexOf(i) ? "(" : ")").collect(Collectors.joining());
	}
}
