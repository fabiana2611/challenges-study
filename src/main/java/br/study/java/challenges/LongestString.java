package br.study.java.challenges;

import java.util.Scanner;

/**
 * This challenge requires you to return the longest word in a sentence. 
 * Our goal is therefore to somehow loop through the string and compare the 
 * lengths of the words. 
 * 
 * Coderbyte
 * https://www.coderbyte.com/challenges
 * 
 * @author fabiana
 *
 */
public class LongestString {

	public static String LongestWord(String sen) {

		String[] arr = sen.split(" ");
		printArray(arr);
		String longest = arr[0];
		
		for (String a: arr) {
			if (a.length() > longest.length()) {
				longest = a;
			}
		}
		return longest;
		
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		String str= s.nextLine();
		System.out.print(LongestWord(str));
	}
	
	private static void printArray(String[] arr) {
		String str = "arr: [";
		for (String a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}
}
