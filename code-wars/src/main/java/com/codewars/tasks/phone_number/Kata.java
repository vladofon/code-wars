package com.codewars.tasks.phone_number;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
	// my solution
	public static String createPhoneNumber(int[] numbers) {
		return String.format("(%s) %s-%s%s",
				Arrays.stream(numbers).mapToObj(n -> String.valueOf(n)).collect(Collectors.joining("")).split("(?<=\\G.{3})"));
	}

	// best solution
	public static String createPhoneNumberBest(int[] numbers) {
		return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
	}
}
