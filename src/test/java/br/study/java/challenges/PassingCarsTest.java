package br.study.java.challenges;

import junit.framework.TestCase;

public class PassingCarsTest extends TestCase{
	
	public void testEmptyNull() {
		int[] A = null;
		
		PassingCars pc = new PassingCars();
		int result = pc.solution(A);
		
		assertEquals(-1, result);
	}
	
	public void testBasic() {
		
		int[] A = {0,1,0,1,1};
		
		PassingCars pc = new PassingCars();
		int result = pc.solution(A);
		
		assertEquals(5, result);
	}
	
	public void testBasic2() {
		
		int[] A = {1,1,0,0,1,1,0,1,0};
		
		PassingCars pc = new PassingCars();
		int result = pc.solution(A);
		
		assertEquals(7, result);
	}
	
	public void testBigResult() {
		
		int[] A = new int[100_000];
		
		for(int x = 1; x < 100_000; x+=2) {
			A[x] = 1;
		}
		
		PassingCars pc = new PassingCars();
		int result = pc.solution(A);
		
		assertEquals(-1, result);
	}

}
