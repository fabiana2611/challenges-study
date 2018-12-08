package br.study.java.challenges;

import java.util.Arrays;

public class MissingInteger {
	
	public int solution(int[] A) {
		
		if(!isValidated(A)) {
			return -1;
		}
		
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		
		int N = A.length;
		int result = 0;
		
		int  index = Arrays.binarySearch(A, 1);
		System.out.println("index: " + index);
		if (index < 0) {
			return 1;
		} else if(index == N-1) {
			return 2;
		}
		
		for (int i = index + 1; i < N; i++) {
			System.out.println("A[i-1]: " + A[i -1]);
			System.out.println("A[i]: " + A[i]);
			System.out.println("A[i-1] + 1: " + (A[i-1] + 1));
			
			
			if(A[i-1] != A[i] && A[i-1] +1 != A[i]) {
				result = A[i-1] +1;
				System.out.println("result: " + result);
				break;
			}
			
			if(i == N-1) {
				result = A[i] +1;
			}
			
		}
		
		return result;
	}

	
	private boolean isValidated(int[] A) {
		if(A == null || A.length == 0) {
			return false;
		}
		if( !(1<= A.length && A.length <= 1_00_000)) {
			return false;
		}
		return true;
	}
}
