package com.codewars.tasks.multiples_of_3_or_5;

import java.util.stream.IntStream;

public class Solution {

	// my solution
	public int solution(int number) {
		int sum = 0;
		while (number > 0)
			sum += (--number % 3 == 0 || number % 5 == 0) ? number : 0;
		return sum;
	}

	// best solution
	public int bestSolution(int number) {
		return IntStream.range(3, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
	}

}
