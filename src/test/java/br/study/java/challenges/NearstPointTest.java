package br.study.java.challenges;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class NearstPointTest extends TestCase{
	
	public void testNear() {
		
		NearstPoint nearst = new NearstPoint();
		
        List<List<Integer>> allLocations = createData(); 
        int numLocation = 3;
		
        List<List<Integer>> result = nearst.solution(allLocations, numLocation);
        
        assertEquals(3,result.size() );
        assertEquals(createLocal(3,5),result.get(0));
        assertEquals(createLocal(1,-3),result.get(1));
        assertEquals(createLocal(1,2),result.get(2));
        
	}
	
	public void testNear2() {
		
		NearstPoint nearst = new NearstPoint();
		
        List<List<Integer>> allLocations = createData(); 
        int numLocation = 2;
		
        List<List<Integer>> result = nearst.solution(allLocations, numLocation);
        
        assertEquals(2,result.size() );
        assertEquals(createLocal(3,5),result.get(0));
        assertEquals(createLocal(1,-3),result.get(1));
        
	}

	private List<List<Integer>> createData() {
		  List<Integer> l1 = createLocal(1,-3);
		  List<Integer> l2 = createLocal(1,2);
		  List<Integer> l3 = createLocal(3,5);
		  
		  List<List<Integer>> all = new ArrayList<List<Integer>>();
		  all.add(l1);
		  all.add(l2);
		  all.add(l3);
		  
		  return all;
	}
	
	private List<Integer> createLocal(int x, int y) {
		 List<Integer> l1 = new ArrayList<Integer>();
		  l1.add(x);
		  l1.add(y);
		  return l1;
	}
}
