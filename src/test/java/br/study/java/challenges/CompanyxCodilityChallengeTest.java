package br.study.java.challenges;

import junit.framework.TestCase;

public class CompanyxCodilityChallengeTest extends TestCase{
	
	public void testBasic() {
		
		String S =  "Sun 10:00-20:00 Fri 05:00-10:00 Fri 16:30-23:50 Sat 10:00-24:00 Sun 01:00-04:00 Sat 02:00-06:00 Tue 03:30-18:15 Tue 19:00-20:00 Wed 04:25-15:14 Wed 15:14-22:40 Thu 00:00-23:59 Mon 05:00-13:00 Mon 15:00-21:00";
		
		CompanyCodilityChallenge emerald = new CompanyCodilityChallenge();
		int result = emerald.solution(S);
		
		assertEquals(502, result);
		
		
	}
	
	public void testBasic2() {
		
		int N = 30;
		int max = (int)Math.pow(10, 9);
		
		CompanyCodilityChallenge emerald = new CompanyCodilityChallenge();
		int result = emerald.solution2(N);
		
		assertTrue(result > N && result <= max && (result%10) == 0);
	}

}
