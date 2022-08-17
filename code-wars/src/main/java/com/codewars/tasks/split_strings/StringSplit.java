package com.codewars.tasks.split_strings;

public class StringSplit {

	// my solution
	public static String[] solution(String s) {
		return s.length() % 2 == 0 ? s.split("(?<=\\G.{2})") : (s + "_").split("(?<=\\G.{2})");
	}

	// best solution
	public static String[] solutionBest(String s) {
		return (s + (s.length() % 2 > 0 ? "_" : "")).split("(?<=\\G.{2})");
	}
}
