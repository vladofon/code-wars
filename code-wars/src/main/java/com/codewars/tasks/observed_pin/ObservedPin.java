package com.codewars.tasks.observed_pin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObservedPin {

	// my solution
	public static List<String> getPINs(String observed) {
		Map<String, String> combs = Map.of("0", "08", "1", "124", "2", "1235", "3", "236", "4", "1457", "5", "24568", "6",
				"3569", "7", "478", "8", "07589", "9", "689");

		List<String> result = new ArrayList<>();
		result.add("");
		int resultSize = result.size();

		for (int i = 0; i < observed.length(); i++) {
			String operSymb = observed.charAt(i) + "";
			String[] comb = combs.get(operSymb).split("");
			for (int pre = 0; pre < resultSize; pre++) {
				for (int post = 0; post < comb.length; post++) {
					result.add(result.get(pre) + comb[post]);
				}
			}
			resultSize = result.size();
		}

		return result.stream().distinct().filter(i -> i.length() == observed.length()).collect(Collectors.toList());
	}

	// best solution
	public static List<String> getPINsBest(String observed) {
		Map<Character, String> combs = Map.of('0', "08", '1', "124", '2', "1235", '3', "236", '4', "1457", '5', "24568",
				'6', "3569", '7', "478", '8', "07589", '9', "689");
		List<String> result = List.of("");

		for (char c : observed.toCharArray()) {
			List<String> tmp = new ArrayList<>();
			for (char cc : combs.get(c).toCharArray()) {
				for (String s : result)
					tmp.add(s + cc);
			}
			result = tmp;
		}

		return result;
	}

}
