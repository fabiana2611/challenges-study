package br.study.java.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Based on GeeksfoGeeks
 * https://www.geeksforgeeks.org/fifo-first-in-first-out-approach-in-programming/
 * 
 * Working with Queue to demonstrate FIFO
 * 
 * Where use FIFO:
 * - Data Structures
 * - Disk Scheduling
 * - Communications and networking
 * 
 * @author fabiana
 *
 */
public class QueueExample {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		// First in = 0
		for (int i=0; i<5 ; i++) {
			queue.offer(i);
		}

		System.out.println("1. Elements of queue: " + queue); 
		
		// First out = 0
		int removedElement = queue.remove();
		System.out.println("removed element: " + removedElement);
		
		System.out.println("2. Elements of queue: " + queue);
		
		// View head
		int headElement = queue.peek();
		System.out.println("head element: " + headElement);
		
		System.out.println("3. Elements of queue: " + queue);
		
		int size = queue.size();
		System.out.println("4. Size of queue: " + size);
		
	}
	
}
