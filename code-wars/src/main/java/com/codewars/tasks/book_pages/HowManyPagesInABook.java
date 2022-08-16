package com.codewars.tasks.book_pages;

public class HowManyPagesInABook {

	// my solution
	public static int amountOfPages(int summary) {

		int pageNumber = 0;
		int digitsNumber = 0;

		while (digitsNumber != summary) {
			pageNumber++;
			digitsNumber += String.valueOf(pageNumber).length();
		}

		return pageNumber;
	}

	// best solution
	public static int amountOfPagesBest(int summary) {
		int pageNumber = 0;

		while (summary > 0) {
			summary -= String.valueOf(++pageNumber).length();
		}

		return pageNumber;
	}

}