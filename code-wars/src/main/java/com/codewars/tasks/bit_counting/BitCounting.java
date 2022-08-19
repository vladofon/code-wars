package com.codewars.tasks.bit_counting;

public class BitCounting {

	// my solution
	public static int countBits(int n) {
		return Integer.toBinaryString(n).replaceAll("0", "").length();
	}

	// best solution
	public static int countBitsBest(int n) {
		return Integer.bitCount(n);
	}

}
