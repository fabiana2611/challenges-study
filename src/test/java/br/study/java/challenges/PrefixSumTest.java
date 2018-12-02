package br.study.java.challenges;

import junit.framework.TestCase;

public class PrefixSumTest extends TestCase{

	public void testNullOrEmpty() {
		int[] A = null;
		int k = 0;
		int m = 0;
		
		PrefixSum pf = new PrefixSum();
		int result = pf.mushrooms(A, k, m);
		
		assertEquals(0, result);
	}
	
	public void testBasic() {
		int[] A = {2,3,7,5,1,3,9};
		int k = 4;
		int m = 6;
		
		PrefixSum pf = new PrefixSum();
		int result = pf.mushrooms(A, k, m);
		
		assertEquals(25, result);
	}
}
