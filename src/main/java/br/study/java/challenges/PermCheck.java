package br.study.java.challenges;

import java.util.Arrays;

/**
 * Check whether array A is a permutation.
 * 
 * A non-empty array A consisting of N integers is given.
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [1..1,000,000,000].
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * 
 * Codility
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * 
 * @author fabiana
 *
 */
public class PermCheck {

	private static final int TRUE = 1;
	private static final int FALSE = 0;
	/**
	 * @return 1 if TRUE and 0 if FALSE
	 */
	public int solution(int[] A) {
		
		int result = 0;
		
		if (A == null || A.length == 0) {
			
			result = FALSE;
			
		} else if(A.length == 1) {
			
			result = A[0] == 1? TRUE : FALSE;
			
		} else if (A != null && A.length > 0) {

			printArray(A);

			Arrays.sort(A);

			printArray(A);

			result = isPermutation(A);
			
		}
		
		return result;
	}
	
	private int isPermutation(int[] A) {
		
		for (int i = 1; i <= A.length ; i++) {
			
			if(A[i-1] != i) {
				return 0;
			}
		}
		
		return 1;
	}
	
	private void printArray(int[] arr) {
		String str = "arr: [";
		for (int a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}
}
