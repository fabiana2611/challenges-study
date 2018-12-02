package br.study.java.challenges;

import java.util.Arrays;

/**
 * Codility
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * 
 * A non-empty array A consisting of N integers is given. The consecutive elements 
 * of array A represent consecutive cars on a road.
 * 
 * Array A contains only 0s and/or 1s:
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * 
 * The goal is to count passing cars. We say that a pair of cars (P, Q), 
 * where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

 * @author fabiana
 *
 */
public class PassingCars {
	
	public static final int LIMIT = 1_000_000_000;

	public int solution(int[] A) {
		
		int result = 0;
		
		if(A == null || A.length == 0) {
			return -1;
		}
		
		int n = A.length;
		int[] orderArray = A.clone();
		Arrays.sort(orderArray);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(orderArray));
		
		int count_0 = 0;
		int count_1 = 0;
		
		for (int x = 0; x<n; x++) {
			if(orderArray[x] == 0) {
				count_0++;
			} else {
				count_1 = n-x;
				break;
			}
		}
		
		System.out.println("count_0: " + count_0 + " count_1: " + count_1);
		
		for (int x = 0; x < n; x++) {
			
			if(A[x] == 0) {
				result += count_1;
				count_0--;
				if(count_0 == 0) {
					break;
				}
			} else {
				count_1--;
			}
			
		}
		
		System.out.println("result: " + result);
		return (result > LIMIT) ? -1: result;
	}
}
