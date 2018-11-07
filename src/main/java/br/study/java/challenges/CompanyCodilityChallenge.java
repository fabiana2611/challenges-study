package br.study.java.challenges;

import java.util.Random;

public class CompanyCodilityChallenge {
	
	/**
	 * Random value bigger then N, less then 10ˆ9 and ending with '0
	 * 
	 * Challenge 2
	 */
	 public int solution2(int N) {
		 
	        Random gerador = new Random();
	        
	        int result = 0;
	        int max = (int)Math.pow(10, 9);
	        		
	        for(;;) {
	        	result = gerador.nextInt();
	        	if(result > N && result <= max && (result%10) == 0) {
	        		break;
	        	}
	        }
	        
	        return result;
	    }
	 

	 /**
	  * Largest period of time with no meeting
	  * 
	  * Challenge 1
	  */
	public int solution(String S) {
		
		String [] str = S.split(" ");
		
		int totalMinutesToSleep = 0;
		
		printArray(str);
		
		for(int i=1; i<str.length; i = i+2) {
			
			String [] s = str[i].split("-");
			String end = s[1];
			String[] endTime = end.split(":");
			int endHour = Integer.parseInt(endTime[0]);
			int endMinute = Integer.parseInt(endTime[1]);
			System.out.println("endHour:" + endHour + " endMinuteendMinute: "+ endMinute );
			
			int totalMinutes = endMinute + (59 * endHour);
			
			int totalMinutesDay = 24*59; 
			
			int minutesFirstDay = totalMinutesDay - totalMinutes;
			System.out.println("minutesFirstDay:" + minutesFirstDay);
		
			
			String [] s2 = str[i+2].split("-");
			String begin = s2[0];
			String [] beginTime = begin.split(":");
			int beginHour = Integer.parseInt(beginTime[0]);
			int beginMinute = Integer.parseInt(beginTime[1]);
			
			int totalMinutes2 = beginMinute + (59 * beginHour);
			
			int minutesSecondDay = totalMinutes2;
			System.out.println("minutesSecondDay:" + minutesSecondDay);
			
			int total = minutesFirstDay + minutesSecondDay;
			System.out.println("total:" + total);
			
			if(total > totalMinutesToSleep) {
				totalMinutesToSleep = total;
			}
			System.out.println();
			
		}
		
		System.out.println("total:" + totalMinutesToSleep);
		return totalMinutesToSleep;
		
	}
	
	private void printArray(String[] arr) {
		String str = "arr: [";
		for (String a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}
}
