package br.study.java.challenges;

import junit.framework.TestCase;

public class LongestStringTest  extends TestCase{
	
	public void testLongestStringEqualValues() {

		String str = "ddd ddd dd";

		String longest = LongestString.LongestWord(str);

		assertEquals("ddd", longest);
	}
	
	public void testLongestStringDifferetValues() {

		String str = "ddd dddfffff dd";

		String longest = LongestString.LongestWord(str);

		assertEquals("dddfffff", longest);
	}

}
