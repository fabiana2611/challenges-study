package br.study.java.algorithms;

/**
 * 
 * https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/
 * 
 * @author fabiana
 *
 */
public class StackUsingLinkedlist {

	private static final int NEGATIVE = -1;
	
	private class Node{
		int data;
		Node link;
	}
	
	private Node top;
	
	
	 public static void main(String[] args) 
	    { 
	        // create Object of Implementing class 
	        StackUsingLinkedlist obj = new StackUsingLinkedlist(); 
	        // insert Stack value 
	        obj.push(11); 
	        obj.push(22); 
	        obj.push(33); 
	        obj.push(44); 
	  
	        // print Stack elements 
	        obj.display(); 
	  
	        // pritn Top element of Stack 
	        System.out.printf("\nTop element is %d\n", obj.peek()); 
	  
	        // Delete top element of Stack 
	        obj.pop(); 
	        obj.pop(); 
	  
	        // pritn Stack elements 
	        obj.display(); 
	  
	        // print Top element of Stack 
	        System.out.printf("\nTop element is %d\n", obj.peek()); 
	    } 
	
	public void push(int x) {
		
		Node tmp = new Node();
		
		tmp.data = x;
		tmp.link = top;
		top = tmp;
	}
	
	public int pop() {
		if (!isEmpty()) {
			int data = top.data;
			top = top.link;
			return data;
		}
		return NEGATIVE;
	}
	
	public int peek() {
		return isEmpty() ? NEGATIVE : top.data;
	}
	
	private boolean isEmpty() {
		if (top == null) {
			System.out.printf("\nStack Underflow");
			return false;
		}
		return true;
	}
	
	public void display() {

		// check for stack underflow
		if (isEmpty()) {
			System.exit(1);
		} else {
			Node temp = top;
			while (temp != null) {

				// print node data
				System.out.printf("%d->", temp.data);

				// assign temp link to temp
				temp = temp.link;
			}
		}
	}
}
