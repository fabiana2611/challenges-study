package br.study.java.algorithms;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/lifo-last-in-first-out-approach-in-programming/
 * 
 * @author fabiana
 *
 */
public class StackExample {

	public static void main(String[] args) 
	    { 
		   Stack<Integer> stack = new Stack<Integer>(); 
	  
		   StackExample stackExample = new StackExample();
		   
		   stackExample.stack_push(stack); 
		   stackExample.stack_pop(stack); 
		   stackExample.stack_push(stack); 
		   stackExample.stack_peek(stack); 
		   stackExample.stack_search(stack, 2); 
		   stackExample.stack_search(stack, 6); 
	    }

	private void stack_push(Stack<Integer> stack) {
		for (int i = 0; i < 5; i++) { 
			stack.push(i);
		}
	}

	private void stack_pop(Stack<Integer> stack) {
		
		System.out.println("Pop :"); 
		  
        for (int i = 0; i < 5; i++) { 
            Integer y = (Integer)stack.pop(); 
            System.out.println(y); 
        } 
	}

	private void stack_peek(Stack<Integer> stack) {
		Integer element = (Integer)stack.peek(); 
        System.out.println("Element on stack top : " + element); 
	}
	
	private void stack_search(Stack<Integer> stack, int element) {

		Integer pos = (Integer)stack.search(element); 
		  
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element is found at position " + pos);
        }
        
	}
}
