package com.codewars.tasks.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	// my solution
	public static List<String> singlePermutations(String s) {
		List<String> result = List.of("");

		for (char c : s.toCharArray()) {
			List<String> temp = new ArrayList<>();
			for (char cc : s.toCharArray()) {
				for (String i : result) {
					if (i.split(cc + "", -1).length - 1 != s.split(cc + "", -1).length - 1 && !temp.contains(i + cc))
						temp.add(i + cc);
				}
			}
			result = temp;
		}

		return result;
	}

	// best solution
	public static List<String> singlePermutationsBest(String s) {
		Set<String> set = new HashSet<>();
		if (s.length() == 1)
			return List.of(s);
		for (int i = 0; i < s.length(); i++) {
			for (String ss : singlePermutationsBest(s.substring(0, i) + s.substring(i + 1)))
				set.add(s.charAt(i) + ss);
		}

		return List.copyOf(set);
	}
}