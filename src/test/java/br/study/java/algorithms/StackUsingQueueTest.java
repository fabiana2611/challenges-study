package br.study.java.algorithms;

import junit.framework.TestCase;

/**
 * 
 * Problem to solve
 * 
 * https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
 * 
 * @author fabiana
 *
 */
public class StackUsingQueueTest extends TestCase{

	public void testBasic() {
		
		StackUsingQueue s = new StackUsingQueue();

		s.push(1);
		s.push(2);
		s.push(3);
		
		assertEquals(3, s.size());
		
		assertEquals(3, s.top());

		s.pop();
		
		assertEquals(2, s.top());
		
		assertEquals(2, s.size());
		
		s.pop();

		assertEquals(1, s.size());
		
		assertEquals(1, s.top());
		
		s.pop();
		
		assertEquals(0, s.size());
		
		assertTrue(s.isEmpty());
		
		
	}
}
