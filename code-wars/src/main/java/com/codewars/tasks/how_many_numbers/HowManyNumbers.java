package com.codewars.tasks.how_many_numbers;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class HowManyNumbers {

	// my solution
	public static int selNumber(int n, int d) {
		return IntStream.range(10, n + 1).filter(e -> {
			int item = e / (int) Math.pow(10, String.valueOf(e).length() - 1);
			for (int i = 1; i < String.valueOf(e).length(); i++) {
				int nextItem = Character.getNumericValue(String.valueOf(e).toCharArray()[i]);
				if (nextItem - item > d || nextItem - item <= 0) {
					return false;
				}
				item = nextItem;
			}
			System.out.println(e);
			return true;
		}).toArray().length;
	}

	// best solution
	public static int selNumberBest(int n, int d) {
		Predicate<String> seq = s -> IntStream.rangeClosed(0, s.length() - 2).map(i -> s.charAt(i + 1) - s.charAt(i))
				.allMatch(i -> i > 0 && i <= d);

		return (int) IntStream.rangeClosed(12, n).filter(i -> seq.test(i + "")).count();
	}
}
