package com.codewars.tasks.descending_order;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class DescendingOrder {

	// my solution
	public static int sortDesc(final int num) {
		Long[] parts = String.valueOf(num).chars().mapToLong(c -> Character.getNumericValue(c)).boxed()
				.sorted(Collections.reverseOrder()).toArray(Long[]::new);
		return Integer.parseInt(Arrays.toString(parts).replaceAll("\\[|\\]|,|\\s", ""));
	}

	// best solution 1
	public static int sortDescBest1(final int num) {
		return Integer.parseInt(String.valueOf(num).chars().mapToObj(c -> String.valueOf(Character.getNumericValue(c)))
				.sorted(Collections.reverseOrder()).collect(Collectors.joining()));
	}

	// best solution 2
	public static int sortDescBest2(final int num) {
		String[] array = String.valueOf(num).split("");
		Arrays.sort(array, Collections.reverseOrder());
		return Integer.parseInt(String.join("", array));
	}
}
