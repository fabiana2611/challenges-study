package br.study.java.challenges;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each 
 * element is shifted right by one index, and the last element of the array is moved to 
 * the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
 * (elements are shifted right by one index and 6 is moved to the first place).
 * 
 * Codility
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * 
 * @author fabiana
 *
 */
public class Rotation {

	public int[] solution(int[] A, int K) {
		
		int lenght = A.length;
		
		System.out.println("lenght: " + lenght);
		
		while (lenght> 0 && K > 0) {
			
			int last = A[lenght-1];
			
			for(int i = lenght-1; i > 0 ; i--) {
				A[i] = A[i-1];
			}
			A[0] = last;
			K--;
			
			printArray(A);
		}
		

		return A;
	}
	
	private static void printArray(int[] arr) {
		String str = "arr: [";
		for (int a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}

}
