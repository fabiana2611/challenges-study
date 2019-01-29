package br.study.java.algorithms;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * 
 * @author fabiana
 *
 */
public class StackSort {

	   // Driver method  
    public static void main(String[] args)  {
    	
        Stack<Integer> s = new Stack<>(); 
        s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        System.out.print(s);
       
        StackSort ss = new StackSort();
        ss.sortStack(s); 
       
        System.out.println(" \n\nStack elements after sorting:"); 
        System.out.print(s);
       
    } 
    
    public void sortStack(Stack<Integer> s) {
    	
    	if(!s.isEmpty()) {
    		
    		int x = s.pop();
    		
    		sortStack(s);
    		
    		sortedInsert(s,x);
    	}
    	
    }
    
    public void sortedInsert(Stack<Integer> s, int x) {
    	
    	if(s.isEmpty() || x > s.peek()) {
    		s.push(x);
    		return;
    	}
    	
    	int tmp = s.pop();
    	sortedInsert(s, x);
    	
    	s.push(tmp);
    }
    
    
}
