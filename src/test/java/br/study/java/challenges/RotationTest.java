package br.study.java.challenges;

import junit.framework.TestCase;

public class RotationTest extends TestCase{

	 public void testRotation(){

		int[] arr = { 3, 8, 9, 7, 6 };
		int K = 3;

		Rotation service = new Rotation();

		int[] result = service.solution(arr, K);

		int[] expected = new int[] { 9, 7, 6, 3, 8 };

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
	 
	 public void testRotationZero(){

		int[] arr = { 0, 0, 0};
		int K = 3;

		Rotation service = new Rotation();

		int[] result = service.solution(arr, K);

		int[] expected = new int[] { 0, 0, 0 };

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
	 
	 public void testRotationVazio(){

		int[] arr = { };
		int K = 3;

		Rotation service = new Rotation();

		int[] result = service.solution(arr, K);

		int[] expected = new int[] {};

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
}
