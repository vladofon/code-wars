package com.codewars.tasks.sum_of_intervals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Interval {

	// my solution
	public static int sumIntervals(int[][] intervals) {
		List<Integer> checked = new ArrayList<>();
		int sum = 0;

		while (checked.size() < intervals.length) {
			int start = 0, end = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (!checked.contains(i)) {
					start = intervals[i][0];
					end = intervals[i][1];
					checked.add(i);
					break;
				}
			}
			for (int i = 0; i < intervals.length; i++) {
				if (!checked.contains(i) && intervals[i][0] < end && intervals[i][1] > start) {
					end = intervals[i][1] > end ? intervals[i][1] : end;
					start = intervals[i][0] < start ? intervals[i][0] : start;
					checked.add(i);
					i = 0;
				}
			}
			sum += end - start;
		}

		return sum;
	}

	// best solution
	public static int sumIntervalsBest(int[][] intervals) {
		Set<Integer> set = new HashSet<>();
		for (int[] interval : intervals) {
			for (int i = interval[0]; i < interval[1]; i++)
				set.add(i);
		}

		return set.size();
	}
}
