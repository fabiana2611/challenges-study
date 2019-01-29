package br.study.java.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

/**
 * https://www.geeksforgeeks.org/program-page-replacement-algorithms-set-2-fifo/
 * 
 * @author fabiana
 *
 */
public class PageReplacement {
	
	// Driver method 
    public static void main(String args[]) { 
        
    	int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}; 
   
        int capacity = 4; 
        
        PageReplacement p = new PageReplacement();
        
        System.out.println(p.pageFaults(pages, pages.length, capacity)); 
    } 
    
    public int pageFaults(int[] pages, int length, int capacity) {
    	
    	// Verify if page exist
    	HashSet<Integer> setPage = new HashSet<>();
    	
    	Queue<Integer> indexes = new LinkedList<>();
    	
    	int pageFaults = 0;
    	
    	for (int item: pages) {
    		
    		if(indexes.size() < capacity) {
    			
    			if(!setPage.contains(item)) {
    				setPage.add(item);
    				pageFaults++;
    				indexes.add(item);
    			}
    			
    		} else {
    			if(!setPage.contains(item)) {
    				int value = indexes.poll();
    				setPage.remove(value);
    				
    				setPage.add(item);
    				indexes.add(item);
    				
    				pageFaults++;
    			}
    		}
    	}
    	
    	return pageFaults;
    }

}
