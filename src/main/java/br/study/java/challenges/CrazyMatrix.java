package br.study.java.challenges;

public class CrazyMatrix {
	
	/*
	 *  1010 
	 *  0101 
	 *  1010  
	 *  0101 
	 */
	public int[][] process(int x, int qdtX, int y, int qtdY){
		
		int indexX = 0;
		int indexY = 0;
		
		int [][] result = new int[y * qtdY][x * qdtX];
		
		int aux = 1;
		
		for (int m = 0; m < qtdY; m++) {
			
			for (int k = 0; k < y; k++) {
				
				int tmp = aux;

				for (int j = 0; j < qdtX; j++) {
					
					for (int i = 0; i < x; i++) {
						System.out.print(tmp);
						result [indexY][indexX++] = tmp;
					}

					tmp = tmp == 1 ? 0 : 1;
				}
				System.out.println();
				
				indexX = 0;
				indexY++;
			}

			aux = aux == 1 ? 0 : 1;
			
		}
		
		print(result); 
		
		return result;
	}
	
	private void print(int [][] array) {
		for (int i = 0 ; i < array.length ;i++) {
			printArray(array[i]);
		}
	}
	
	private void printArray(int[] arr) {
		String str = "arr: [";
		for (int a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}

}
