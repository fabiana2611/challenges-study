package br.study.java.challenges;

import junit.framework.TestCase;

public class MissingIntegerTest extends TestCase {
	
	public void testBasicArray() {
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(null);
		assertEquals(-1, result);
	}
	
	public void testSimplePositive() {
		int[] A = {1, 2, 3};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(4, result);
	}
	
	public void testOnePositive() {
		int[] A = {1};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(2, result);
	}
	
	public void testOneNegative() {
		int[] A = {-3};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void test0() {
		int[] A = {0};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void test11() {
		int[] A = {1,1};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(2, result);
	}
	
	public void test0012() {
		int[] A = {0,0,1,2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(3, result);
	}
	
	public void testBasicPositive() {
		int[] A = {1, 3, 6, 4, 1, 2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(5, result);
	}
	
	public void testBasicPositive2() {
		int[] A = {4, 5, 6, 2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void testBasic0Positive() {
		int[] A = {0, 3, 6, 4};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void testBasicNegative() {
		int[] A = {-1,-3};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void tesPositiveNegative() {
		int[] A = {5,-1,7,-4,2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void tesPositiveNegative2() {
		int[] A = {-1, 1, 2, 3};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(4, result);
	}
	
	public void tes0PositiveNegative() {
		int[] A = {5,-1,0,7,-3,2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void tes01PositiveNegative() {
		int[] A = {5,-1,0,1,7,-3,2};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(3, result);
	}
	
	public void tesMinMax() {
		int[] A = {-999999, 999999};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}
	
	public void tesMinMaxPositive() {
		int[] A = {0, 999999};
		
		MissingInteger mi = new MissingInteger();
		int result = mi.solution(A);
		assertEquals(1, result);
	}

}
