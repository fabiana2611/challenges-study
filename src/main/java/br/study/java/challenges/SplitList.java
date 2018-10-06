package br.study.java.challenges;
import java.util.ArrayList;
import java.util.List;

public class SplitList {

	public Object[] run(String size, String str) {
		
		//String size = "4";
		//String str = "1 2 3 4";
		
		int lenght = Integer.parseInt(size);
		int sizeList1 = new Double(Math.ceil((double)lenght/2)).intValue();
		
		System.out.println("sizeList1: " + sizeList1);
		System.out.println("-------------------------");
		
		char[] list = str.toCharArray();
		
		List<Character> list1 = new ArrayList<Character>();
		List<Character> list2 = new ArrayList<Character>();
		
		int count = 0;
		
		for (int i = 0; i < list.length ;i++) {
			if( list[i] != ' ') {
				if(count <sizeList1) {
					list1.add(list[i]);
					count++;
					System.out.println("count: " + count);
				} else{
					list2.add(list[i]);
				}
			}
				
		}
		
		System.out.println("list1: " + list1);
		System.out.println("list2: " +list2);
		
		Object[] obj = new Object[2];
		obj[0] = list1;
		obj[1] = list2;
		
		return obj;

	}
}
