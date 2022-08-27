package com.codewars.tasks.string_incrementer;

public class StringIncrementer {
	public static String incrementString(String str) {

		String strBody = str.replaceAll("\\d*$", "");
		String numBody = strBody.isEmpty() || strBody.equals(str) ? "0" : str.substring(strBody.length());

		long num = Integer.valueOf(numBody) + 1;
		int numLenght = String.valueOf(num).length();

		return strBody + (numBody.length() > numLenght ? "0".repeat(numBody.length() - numLenght) + num : num);
//		String strBody = str.replaceAll("(\\D)$", "");
//		String strNum = (strBody.length() != 0) ? strBody : "0";
//		int num = Integer.valueOf(strNum) + 1;
//		int numLenght = String.valueOf(num).length();
//		return str.replaceAll("\\d", "")
//				+ (strNum.length() > numLenght ? "0".repeat(strNum.length() - numLenght) + num : num);
	}

	public static String incrementStringnew(String str) {
		String strBody = str.replaceAll("\\d*$", "");
		StringBuilder numBody = new StringBuilder(strBody.equals(str) ? "0" : str.substring(strBody.length()));

		boolean remember = true;
		for (int i = numBody.length() - 1; i >= 0; i--) {
			if (!remember)
				break;
			String newNum = String.valueOf(Character.getNumericValue(numBody.charAt(i)) + 1);
			numBody.setCharAt(i, newNum.charAt(newNum.length() - 1));
			remember = (newNum.length() > 1) ? true : false;
		}

		return strBody + (remember ? "1" : "") + numBody.toString();
	}
}
