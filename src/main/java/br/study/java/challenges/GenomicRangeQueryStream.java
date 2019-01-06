package br.study.java.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Codility Challenge
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * @author fabiana
 *
 */
public class GenomicRangeQueryStream {

	public int[] solution(String S, int[] P, int[] Q) {
		
		if(!isValidInput(S,P,Q)) {
			return new int[1];
		}
		
		int M = P.length;
		
		int[] result = new int[M];
		
		char[] str = S.toUpperCase().toCharArray();
		
		for (int i = 0; i < M; i++) {
			
			Stream<Character> cStream = IntStream
					.rangeClosed(P[i], Q[i])
					.mapToObj(x -> str[x])
					.distinct();
			
			Map<Character, Integer> imp = mapImpact();
			result [i] = cStream.mapToInt(e -> imp.get(e)).min().getAsInt();
			
		}
		
		return  result;
	}
	
	private boolean isValidInput(String S, int[] P, int[] Q) {
		if(S == null || S.isEmpty() 
				|| P == null || P.length == 0 
				|| Q == null || Q.length == 0 
				|| Q.length != P.length
				|| Q.length > 50_000) {
			
			return false;
		}
		return true;
	}
	
	private Map<Character, Integer> mapImpact() {
		
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);
		
		return map;
	}
}
