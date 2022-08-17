package com.codewars.tasks.your_order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {

	// my solution
	public static String order(String words) {
		String[] parts = words.isBlank() ? new String[0] : words.split(" ");
		int[] indexes = words.chars().filter(c -> Character.isDigit(c)).map(c -> Character.getNumericValue(c)).toArray();
		String[] result = new String[parts.length];
		for (int i = 0; i < parts.length; i++) {
			result[indexes[i] - 1] = parts[i];
		}
		return Stream.of(result).collect(Collectors.joining(" "));
	}

	// best solution
	public static String orderBest(String words) {
		return Arrays.stream(words.split(" ")).sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
				.collect(Collectors.joining(" "));
	}
}
