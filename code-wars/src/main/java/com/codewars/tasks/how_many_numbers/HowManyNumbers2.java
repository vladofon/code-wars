package com.codewars.tasks.how_many_numbers;

import static java.util.Comparator.comparingLong;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.LongStream.rangeClosed;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HowManyNumbers2 {

	public static long[] maxSumDig(long nmax, int maxsm) {
		Predicate<String> seq = s -> rangeClosed(0, s.length() - 4)
				.allMatch(i -> s.substring(i, i + 4).chars().sum() <= '0' * 4 + maxsm);

		long[] items = rangeClosed(1000, nmax).filter(i -> seq.test(i + "")).toArray();

		long sum = Arrays.stream(items).sum();
		long average = Arrays.stream(items).boxed()
				.collect(Collectors.minBy(comparingLong(v -> Math.abs(v * items.length - sum)))).orElse(0L);

		return new long[] { items.length, average, sum };
	}
}
