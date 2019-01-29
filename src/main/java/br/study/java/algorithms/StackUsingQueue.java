package br.study.java.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: -
 * https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
 * 
 * First line of each test case contains an integer Q denoting the number of
 * queries . A Query Q is of 2 Types (i) 1 x (a query of this type means pushing
 * 'x' into the stack) (ii) 2 (a query of this type means to pop element from
 * stack and print the poped element) The second line of each test case contains
 * Q queries seperated by space.
 * 
 * Solution - https://www.geeksforgeeks.org/implement-stack-using-queue/
 *
 * @author fabiana
 *
 */
public class StackUsingQueue {

	// push operation costly

	/**
	 * The newly entered element is always at the front of ‘q1. The pop operation
	 * just dequeues from q1.
	 */
	private Queue<Integer> q1 = new LinkedList<>();

	/**
	 * It is used to put every new element at front of q1
	 */
	private Queue<Integer> q2 = new LinkedList<>();

	private int size = 0;

	public void push(int x) {

		size++;

		q2.add(x);

		// Push all the remaining
		// elements in q1 to q2.
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}

		// swap the names of two queues
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;

	}

	public void pop() {
		if (!q1.isEmpty()) {
			q1.remove();
			size--;
		}
	}

	public int top() {
		if (q1.isEmpty()) {
			return -1;
		}
		return q1.peek();
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public String toString() {
		return q1.toString();
	}

}
