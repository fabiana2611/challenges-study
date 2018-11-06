package br.study.java.challenges;

import junit.framework.TestCase;

public class FirstFactorialTest extends TestCase{
	
	public void testFist4() {
		
		int input = 4;
		int output = 24;
		
		FirstFactorial solution = new FirstFactorial();
		int result = solution.process(input);
		
		assertEquals(output, result);
			
	}
	
	public void testFist8() {
		
		int input = 8;
		int output = 40320;
		
		FirstFactorial solution = new FirstFactorial();
		int result = solution.process(input);
		
		assertEquals(output, result);
			
	}
	
	public void testFist0() {
		
		int input = 0;
		int output = 0;
		
		FirstFactorial solution = new FirstFactorial();
		int result = solution.process(input);
		
		assertEquals(output, result);
			
	}

}
