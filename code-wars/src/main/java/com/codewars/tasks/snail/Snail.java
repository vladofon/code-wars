package com.codewars.tasks.snail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Snail {

	public static int[] snail(int[][] array) {
		int[] row = Stream.of(array).flatMapToInt(IntStream::of).toArray();
		List<Integer> result = new ArrayList<>();

		int rungLength = array[0].length, i = 0, group = 1, side = 1;
		if (rungLength != 0)
			result.add(row[i]);
		boolean isblank = rungLength <= 1;

		while (rungLength > 0 && !isblank) {

			if (group == rungLength) {
				side += (side != 4) ? 1 : -3;
				group = 0;
				if (side % 2 == 0) {
					rungLength--;
				}
			}

			if (side == 1) {
				i++;
			} else if (side == 2) {
				i += array[0].length;
			} else if (side == 3) {
				i--;
			} else if (side == 4) {
				i -= array[0].length;
			}

			result.add(row[i]);
			group++;
		}

		if (!isblank)
			result.remove(result.size() - 1);

		return result.stream().mapToInt(Integer::valueOf).toArray();
	}
}
