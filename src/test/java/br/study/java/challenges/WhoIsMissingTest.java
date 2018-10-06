package br.study.java.challenges;

import junit.framework.TestCase;

public class WhoIsMissingTest extends TestCase  {

	public void testSolution() {
		
		int[] A = {2,3,1,5};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(4,result);
	}
	
	public void testSolutionNoOne() {
		
		int[] A = {2,3,1};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(0,result);
	}
	
	public void testSolutionFirst() {
		
		int[] A = {2,3,4};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(1,result);
	}
	
	public void testSolutionLast(){
		
		int N = 100000;
		
		int[] A = new int [N];
		
		for (int i = 1;i<=N;i++) {
			A[i-1] = i;
		}
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(100001,result);
	}
	
	public void testSolutionEmpty() {
		
		int[] A = {};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(0,result);
	}
	
	public void testSolutionSingle() {
		
		int[] A = {3};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(1,result);
	}
	
	public void testSolutionDoble() {
		
		int[] A = {1,3};
		
		WhoIsMissing solution = new WhoIsMissing();
		
		int result = solution.solution(A);
		
		assertEquals(2,result);
	}
	
	
}
