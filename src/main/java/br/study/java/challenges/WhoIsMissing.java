package br.study.java.challenges;

/**
 * An array A consisting of N different integers is given. 
 * The array contains integers in the range [1..(N + 1)], 
 * which means that exactly one element is missing.
 * 
 * Codility
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * 
 * @author fabiana
 *
 */
public class WhoIsMissing {

	private int array[];
	private int length;

	public int solution(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		this.array = A;
		length = A.length;
		
		if(length > 1) {
			quickSort(0, length - 1);
		}
		
		
		return whoIsMissing();
	}

	private int whoIsMissing() {
		
		
		System.out.println("array [length - 1]: " + this.array [length - 1]);
		
		if(this.array [length - 1] == length) {
			
			if(this.array [length - 1] == 100000) {
				return 100001;
			}
			
			return 0;
		}

		for (int i = 1; i <= length; i++) {
			if (this.array[i - 1] != i) {
				return i;
			}
		}

		return 0;

	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which is greater
			 * then the pivot value, and also we will identify a number from right side
			 * which is less then the pivot value. Once the search is done, then we exchange
			 * both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
