package br.study.java.challenges;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * 
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * 
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * 
 * For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].

 * Codility:
 * https://app.codility.com/demo/results/trainingQS25W6-FHN/
 * 
 * @author fabiana
 *
 */
public class CountingElements {
	
	int[] result;
	int max;
	
	public int[] solution(int N, int[] A) {
		
		result = new int[N];
		
		if(A == null || A.length == 0) {
			return result;
		}
		
		printArray(A);
		
		for (int k = 0; k < A.length; k++) {
			
			if(A[k] <= N) {
				increase(A[k]);
			} else {
				maxCounter();
			}
			printArray(result);
		}
		System.out.println();
		printArray(result);
		return result;
	}
	
	private void increase(int x) {
		result[x-1]++;
		swapMax(result[x-1]);
	}
	
	private void maxCounter() {
		for (int i = 0; i < result.length; i++) {
			result[i] = max;
		}
	}
	
	private void swapMax(int value) {
		if(max < value) {
			max = value;
		}
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
