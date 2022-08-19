package com.codewars.tasks.abbreviation;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbbreviateTwoWords {

	public static String abbrevName(String name) {
		return Stream.of(name.split(" ")).map(n -> n.substring(0, 1).toUpperCase()).collect(Collectors.joining("."));
	}
}
