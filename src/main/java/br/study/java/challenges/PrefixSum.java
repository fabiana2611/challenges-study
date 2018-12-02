package br.study.java.challenges;

import java.util.Arrays;

/**
 * Codility
 * https://codility.com/media/train/3-PrefixSums.pdf
 * 
 * Problem: You are given a non-empty, zero-indexed array A of n integers (a0, a1, . . . , an−1). 
 * This array represents number of mushrooms growing on the consecutive spots along a road. 
 * You are also given integers k and m (0 < k, m < n).
 * A mushroom picker is at spot number k on the road and should perform m moves. In
 * one move she moves to an adjacent spot. She collects all the mushrooms growing on spots
 * she visits. The goal is to calculate the maximum number of mushrooms that the mushroom
 * picker can collect in m moves.
 * 
 * @author fabiana
 *
 */
public class PrefixSum {

	public int mushrooms(int[] A, int k, int m) {
		
		if(!isValidated(A,k,m)) {
			return 0;
		}
		
		int n = A.length;
		
		int result = -1;
		
		int[] pref = prefixSum(A);
		
		System.out.println("--- A ---");
		System.out.println(Arrays.toString(A));
		System.out.println("--- pref ---");
		System.out.println(Arrays.toString(pref));
		System.out.println("-------------");
		
		for (int p = 0; p < min(m,k) + 1 ; p++) {
			int left_pos = k-p;
			int right_pos = min(n-1, max(k, k + m - 2*p));
			result = max(result, countTotal(pref,left_pos,right_pos));
			
			System.out.println("p : " + p + " m : " + m + " k: " + k + " n: " + n);
			System.out.println("left_pos: " + left_pos);
			System.out.println("right_pos: " + right_pos);
			System.out.println("countTotal: " + countTotal(pref,left_pos,right_pos));
			System.out.println("result: " + result);
			System.out.println();

		}
		System.out.println("-------------");
		for (int p = 0; p < min(m+1,n-k); p++) {
			int right_pos = k + p;
			int left_pos = max(0, min(k, k - (m - 2*p)));
			result = max(result, countTotal(pref,left_pos,right_pos));
			
			System.out.println("p : " + p + " m : " + m + " k: " + k + " n: " + n);
			System.out.println("right_pos: " + right_pos);
			System.out.println("left_pos: " + left_pos);
			System.out.println("countTotal: " + countTotal(pref,left_pos,right_pos));
			System.out.println("result: " + result);
			System.out.println();
		}
		
		
		return result;
	}
	
	private boolean isValidated(int[] A, int k, int m) {
		if(A == null || A.length == 0) {
			return false;
		}
		if(k < 0 || m > A.length) {
			return false;
		}
		return true;
	}
	
	private int min(int m, int k) {
		return ( m <= k ) ? m : k;
	}
	
	private int max(int m, int k) {
		return (m > k) ? m : k;
	}
	
	private int[] prefixSum(int[] A) {
		int n = A.length;
		int[] P = new int[n + 1];
		
		for(int k = 1; k < n+1; k++) {
			P[k] = P[k-1] + A[k-1];
		}
		
		return P;
	}
	
	private int countTotal(int[] P, int left_pos, int right_pos) {
		return P[right_pos+1] - P[left_pos];
	}
	
}
