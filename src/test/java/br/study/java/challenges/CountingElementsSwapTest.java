package br.study.java.challenges;

import junit.framework.TestCase;

public class CountingElementsSwapTest extends TestCase{
	
	public void testSlowSolutionBasic() {
		
		int[] A = {};
		int[] B = {};
		int m = 0;
		
		CountingElementsSwap swap = new CountingElementsSwap();
		boolean result = swap.slowSolution(A, B, m);
		assertEquals(false, result);
	}
	
	public void testSlowSolution() {
		
		int[] A = {1,2,4};
		int[] B = {0,2,3};
		int m = 1;
		
		CountingElementsSwap swap = new CountingElementsSwap();
		boolean result = swap.slowSolution(A, B, m);
		assertEquals(true, result);
	}
	
	public void testSlowSolution2() {
		
		int[] A = {0,0,4,2,4,2};
		int[] B = {2,7,9,0,3,1};
		int m = 9;
		
		CountingElementsSwap swap = new CountingElementsSwap();
		boolean result = swap.slowSolution(A, B, m);
		assertEquals(true, result);
	}
	
	public void testBestSolution() {
		
		int[] A = {1,2,4};
		int[] B = {0,2,3};
		int m = 4;
		
		CountingElementsSwap swap = new CountingElementsSwap();
		boolean result = swap.bestSolution(A, B, m);
		assertEquals(true, result);
	}
	
	public void testBestSolution2() {
		
		int[] A = {0,0,4,2,4,2};
		int[] B = {2,7,9,0,3,1};
		int m = 5;
		
		CountingElementsSwap swap = new CountingElementsSwap();
		boolean result = swap.bestSolution(A, B, m);
		assertEquals(true, result);
	}

}
