package br.study.java.challenges;

import junit.framework.TestCase;

/**
 *  A non-empty array A consisting of N integers is given.
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [1..1,000,000,000].
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * 
 * Codility
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * @author fabiana
 *
 */
public class PermCheckTest extends TestCase{
	
	public void testArrayEmpty() {
		
		int[] A = {};
		
		PermCheck perm = new PermCheck();
		
		int result = perm.solution(A);
		
		assertEquals(0, result);
		
	}
	
	public void testArrayNull() {
		
		int[] A = null;
		
		PermCheck perm = new PermCheck();
		
		int result = perm.solution(A);
		
		assertEquals(0, result);
		
	}
	
	public void tesIsPermutation() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = {4,1,2,3};
		
		int result = perm.solution(A);
		
		assertEquals(1, result);
	}
	
	public void tesIsNotPermutation() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = {4,1,3};
		
		int result = perm.solution(A);
		
		assertEquals(0, result);
	}
	
	public void tesIsPermutationSingleElemento() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = {1};
		
		int result = perm.solution(A);
		
		assertEquals(1, result);
	}
	
	public void tesIsNotPermutationSingleElemento() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = {4};
		
		int result = perm.solution(A);
		
		assertEquals(0, result);
	}
	
	public void tesIsNotPermutationDeplicatedElemento() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = {4,1,3,1,2};
		
		int result = perm.solution(A);
		
		assertEquals(0, result);
	}
	
	public void tesIsPermutationFullArray() {
		
		PermCheck perm = new PermCheck();
		
		int[] A = createArrayFull();
		
		int result = perm.solution(A);
		
		assertEquals(1, result);
	}
	
	private int[] createArrayFull() {
		
		int N = 100000;
		
		int[] A = new int [N];
		
		for (int i = 1;i<=N;i++) {
			A[i-1] = i;
		}
		
		return A;
	}

}
