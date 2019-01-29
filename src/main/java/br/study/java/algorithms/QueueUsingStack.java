package br.study.java.algorithms;

import java.util.Stack;

public class QueueUsingStack {

	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public static void main (String[] args) {
		
		
		QueueUsingStack qs = new QueueUsingStack();
		qs.enQueue(1);
		qs.enQueue(2);
		qs.enQueue(3);
		
		qs.print();
		
		System.out.println("deQueue: " + qs.deQueue());
		System.out.println("deQueue: " + qs.deQueue());
		System.out.println("deQueue: " + qs.deQueue());
		System.out.println("deQueue: " + qs.deQueue());
	}
	
	public void enQueue(int x) {
		
		while (!getStack1().isEmpty()) {
			getStack2().push(getStack1().pop());
		}
		
		getStack1().push(x);
		
		while (!getStack2().isEmpty()) {
			getStack1().push(getStack2().pop());
		}
		
	}
	
	public int deQueue() {
		if(getStack1().isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(0);
		}
		return	getStack1().pop();
	}
	
	private Stack<Integer> getStack1(){
		if(s1 == null) {
			s1 = new Stack<>();
		}
		return s1;
	}
	
	private Stack<Integer> getStack2(){
		if(s2 == null) {
			s2 = new Stack<>();
		}
		return s2;
	}
	
	public void print() {
		System.out.println(getStack1());
	}
}
