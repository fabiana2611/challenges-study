package br.study.java.challenges;

import java.util.List;

import junit.framework.TestCase;

public class SplitListTest extends TestCase {
	
	SplitList service;
	
    public void testSplitListImpar(){
    	
    	SplitList service = new SplitList();
    	
    	Object[] result = service.run("5", "1 2 3 4 5");
    	
        assertEquals(2,result.length );
        assertEquals(3,((List<Character>)result[0]).size() );
        assertEquals(2,((List<Character>)result[1]).size() );
    }
    
    public void testSplitListPar(){
    	
    	SplitList service = new SplitList();
    	
    	Object[] result = service.run("4", "1 2 3 4");
    	
        assertEquals(2,result.length );
        assertEquals(2,((List<Character>)result[0]).size() );
        assertEquals(2,((List<Character>)result[1]).size() );
    }
}