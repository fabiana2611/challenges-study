package br.study.java.challenges;

import java.util.Arrays;

/**
 * Coldility
 * https://codility.com/media/train/2-CountingElements.pdf
 * 
 * Problem: You are given an integer m (1 ¬ m ¬ 1 000 000) and two non-empty, zero-indexed
 * arrays A and B of n integers, a0, a1, . . . , an−1 and b0, b1, . . . , bn−1 respectively (0 ¬ ai, bi ¬ m).
 * The goal is to check whether there is a swap operation which can be performed on these
 * arrays in such a way that the sum of elements in array A equals the sum of elements in
 * array B after the swap. By swap operation we mean picking one element from array A and
 * one element from array B and exchanging them.
 */
public class CountingElementsSwap {

	//O(n^2)
	/**
	 * Solution O(n2): The simplest method is to swap every pair of 
	 * elements and calculate the totals. Using that approach gives us O(n3) 
	 * time complexity. A better approach is to calculate the sums of 
	 * elements at the beginning, and check only how the totals change during 
	 * the swap operation.
	 */
	public Boolean slowSolution(int[] A, int[] B, int m) {
		
		if(!isDataValidated(A,B,m)) {
			return false;
		}
		
		int sum_a = sum(A);
		int sum_b = sum(B);
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				int change = B[j] - A[i];
				sum_a += change;
				sum_b -= change;
				if(sum_a == sum_b) {
					return true;
				}
				sum_a -= change;
				sum_b += change;
			}
		}
		
		return false;
	}
	
	/**
	 * Solution O(n + m): The best approach is to count the elements of array A and calculate
	 * the difference d between the sums of the elements of array A and B.
	 */
	public boolean bestSolution(int[] A, int[] B, int m) {
		
		if(!isDataValidated(A,B,m)) {
			return false;
		}
		
		int sum_a = sum(A);
		int sum_b = sum(B);
		
		System.out.println("sum_a: " + sum_a);
		System.out.println("sum_b: " + sum_b);
		
		int d = sum_b - sum_a;
		
		System.out.println("d: " + d);
		
		if(d % 2 == 1) {
			return false;
		}
		
		d /= 2;
		
		System.out.println("d/2: " + d);
		
		System.out.println();
		
		int[] count = counting (A,m);
		
		System.out.println(Arrays.toString(count));
		
		for (int i = 0; i < A.length; i++) {
			
			if( (0 <= B[i] - d) 
					&& (B[i] - d <= m) 
					&& (count[B[i] - d] > 0)) {
				
				System.out.println("B[i] - d : " + (B[i] - d));
				System.out.println("count[B[i] - d] : " + (count[B[i] - d]));
				return true;
			}
		}
		
		return false;
		
	}
	
	private boolean isDataValidated(int[] A, int[] B, int m) {
		if(A == null || B == null 
				|| A.length == 0 || B.length == 0
				|| !(m >= 1 && m <= 1_000_000 )) {
			return false;
		}
		return true;
	}
	
	private int sum(int[] A) {
		int sum = 0;
		for (int x = 0; x < A.length ; x++) {
			sum += A[x];
		}
		return sum;
	}
	
	private int[] counting(int[] A, int m) {
		int n = A.length;
		int[] count = new int[m+1];
		for (int k = 0; k < n; k++ ) {
			count[A[k]] += 1;
		}
		return count;
	}
}
