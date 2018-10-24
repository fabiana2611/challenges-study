package br.study.java.challenges;

import junit.framework.TestCase;

public class CountingElementsTest extends TestCase {

	public void testEmptyArray() {
		
		CountingElements counter = new CountingElements();
		int[] result = counter.solution(0, null);
		
		assertEquals(0, result.length);
	}
	
	public void testBasic() {
		
		int A[] = {3, 4,4,6,1,4,4};
		int N = 5;
		
		CountingElements counter = new CountingElements();
		int[] result = counter.solution(N, A);
		
		int[] expected = {3, 2, 2, 4, 2};
		
		assertEquals(expected.length, result.length);
		
		for (int i = 0; i<expected.length;i++) {
			assertEquals(expected[i], result[i]);
		}
		
	}
	
	public void testNoNplus1() {
		
		int A[] = {3,4,4,1,4,4};
		int N = 5;
		
		CountingElements counter = new CountingElements();
		int[] result = counter.solution(N, A);
		
		int[] expected = {1, 0, 1, 4, 0};
		
		assertEquals(expected.length, result.length);
		
		for (int i = 0; i<expected.length;i++) {
			assertEquals(expected[i], result[i]);
		}
		
	}
	
	public void testArrLessThen5() {
		
		int A[] = {3,4};
		int N = 5;
		
		CountingElements counter = new CountingElements();
		int[] result = counter.solution(N, A);
		
		int[] expected = {0, 0, 1, 1, 0};
		
		assertEquals(expected.length, result.length);
		
		for (int i = 0; i<expected.length;i++) {
			assertEquals(expected[i], result[i]);
		}
		
	}
	
	
}
