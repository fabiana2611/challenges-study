package br.study.java.algorithms;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * 
 * @author fabiana
 *
 */
public class LRUCache {

	private Deque<Integer> dq;
	private HashSet<Integer> map;
	
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public static void main(String[] str) {
		
		LRUCache lru = new LRUCache(4);
		lru.dq = new LinkedList<>();
		lru.map = new HashSet<>();
		
		lru.refer(1);  
		lru.refer(2);  
		lru.refer(3);  
		lru.refer(1);  
		lru.refer(4);  
		lru.refer(5);  
		
        System.out.println(lru.dq);
	}
	
	public void refer(int x) {
		if(!map.contains(x)) {
			if(dq.size() == capacity) {
				int last = dq.removeLast();
				map.remove(last);
			}
		} else {
			dq.remove(x);
		}
		
		dq.push(x);
		map.add(x);
	}
	
}
