package br.study.java.challenges;

/**
 * Using the Java language, have the function FirstFactorial(num) take the num parameter 
 * being passed and return the factorial of it (e.g. if num = 4, return (4 * 3 * 2 * 1)). 
 * For the test cases, the range will be between 1 and 18 and the input will always be an integer. 
 * 
 * Coderbyte
 * 
 * https://coderbyte.com/editor/First%20Factorial:Java
 * 
 * @author fabiana
 *
 */
public class FirstFactorial {

	public int process(int num) { 
		return (num > 1) ? num *= process(--num): num;
	}

}
