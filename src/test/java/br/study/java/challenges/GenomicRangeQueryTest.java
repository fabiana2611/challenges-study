package br.study.java.challenges;

import junit.framework.TestCase;

public class GenomicRangeQueryTest extends TestCase{

	public void testNull() {
		
		String S = "";
		int[] P = null;
		int[] Q = null;
		
		GenomicRangeQuery obj = new GenomicRangeQuery();
		int[] result = obj.solution(S, P, Q);
		
		assertEquals(1, result.length);
		assertEquals(0, result[0]);
		
	}
	
	public void testBasic() {
		
		// CENARIO
		
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		// EXECUTE
		
		GenomicRangeQuery obj = new GenomicRangeQuery();
		int[] result = obj.solution(S, P, Q);
		
		// TESTE
		
		int[] expected = new int[] {2,4,1};
		
		assertEquals(expected.length, result.length);
		assertEquals(expected[0], result[0]);
		assertEquals(expected[1], result[1]);
		assertEquals(expected[2], result[2]);
		
	}
	
	public void testLowCase() {
		
		// CENARIO
		
		String S = "cagccta";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		// EXECUTE
		
		GenomicRangeQuery obj = new GenomicRangeQuery();
		int[] result = obj.solution(S, P, Q);
		
		// TESTE
		
		int[] expected = new int[] {2,4,1};
		
		assertEquals(expected.length, result.length);
		assertEquals(expected[0], result[0]);
		assertEquals(expected[1], result[1]);
		assertEquals(expected[2], result[2]);
		
	}
	
	public void testBasicStream() {
		
		// CENARIO
		
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		// EXECUTE
		
		GenomicRangeQueryStream obj = new GenomicRangeQueryStream();
		int[] result = obj.solution(S, P, Q);
		
		// TESTE
		
		int[] expected = new int[] {2,4,1};
		
		assertEquals(expected.length, result.length);
		assertEquals(expected[0], result[0]);
		assertEquals(expected[1], result[1]);
		assertEquals(expected[2], result[2]);
		
	}
}
