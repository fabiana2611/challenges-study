package br.study.java.challenges;

import junit.framework.TestCase;

public class CrazyMatrixTest extends TestCase{

	/*
	 *  1010 
	 *  0101 
	 *  1010  
	 *  0101 
	 *  
	 */
	public void testBasic() {
		
		int x = 1;
		int qtdX = 4;
		int y = 1;
		int qtdY = 4;
		
		CrazyMatrix matrix = new CrazyMatrix();
		
		int [][] result = matrix.process(x, qtdX, y, qtdY );
		
		int expected[][] = {{1,0,1,0}, {0,1,0,1}, {1,0,1,0}, {0,1,0,1}};
		
		testResult(expected, result);
		
	}
	
	/*
	 *  110011
	 *  110011
	 *  110011
	 *  001100 
	 *  001100  
	 *  001100
	 *  110011
	 *  110011
	 *  110011
	 */
	public void testX24Y33() {
		
		int x = 2;
		int qtdX = 3;
		int y = 3;
		int qtdY = 3;
		
		CrazyMatrix matrix = new CrazyMatrix();
		
		int [][] result = matrix.process(x, qtdX, y, qtdY );
		
		int expected[][] = {
				{1,1,0,0,1,1}, {1,1,0,0,1,1}, {1,1,0,0,1,1},
				{0,0,1,1,0,0}, {0,0,1,1,0,0},{0,0,1,1,0,0}, 
				{1,1,0,0,1,1}, {1,1,0,0,1,1}, {1,1,0,0,1,1}};
		
		testResult(expected, result);
		
	}
	
	/*
	 *  1100
	 *  1100
	 *  0011 
	 *  0011  
	 */
	public void testX22Y22() {
		
		int x = 2;
		int qtdX = 2;
		int y = 2;
		int qtdY = 2;
		
		CrazyMatrix matrix = new CrazyMatrix();
		
		int [][] result = matrix.process(x, qtdX, y, qtdY );
		
		int expected[][] = {
				{1,1, 0,0}, {1,1, 0,0},
				{0,0,1,1}, {0,0,1,1} };
		
		testResult(expected, result);
		
	}
	
	public void testX44Y44() {
		
		int x = 4;
		int qtdX = 4;
		int y = 4;
		int qtdY = 4;
		
		CrazyMatrix matrix = new CrazyMatrix();
		
		int [][] result = matrix.process(x, qtdX, y, qtdY );
		
		assertNotNull(result);
		
	}
	
	private void testResult(int[][] expected, int[][] result) {
		
		for (int i = 0; i < result.length; i++) {

			int[] line = result[i];
			int[] expectedLine = expected[i];

			for (int j = 0; j < line.length; j++) {
				assertEquals(expectedLine[j], line[j]);
			}
		}
	}
}
