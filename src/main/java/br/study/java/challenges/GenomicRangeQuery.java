package br.study.java.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Codility Challenge
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * @author fabiana
 *
 */
public class GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q) {
		
		int[] result = null;
		
		if(S == null || S.isEmpty() 
				|| P == null || P.length == 0 
				|| Q == null || Q.length == 0 
				|| Q.length != P.length
				|| Q.length > 50_000) {
			
			return new int[1];
		}
		
		int M = P.length;
		
		result = new int[M];
		
		char str[] = S.toUpperCase().toCharArray();
		int[] impact = getArrayImpact(str);
		
		for (int i = 0; i < M; i++) {
			
			int begin = P[i];
			int end = Q[i];
			
			int min = Integer.MAX_VALUE;
			
			for (int j = begin; j<=end; j++) {
				
				if(min > impact[j]) {
					min = impact[j];
				}
			}
			result [i] = min;
		}
		
		return  result;
	}
	
	private int[] getArrayImpact(char[] str) {
		
		Map<Character, Integer> map = mapImpact();
		
		int[] impact = new int[str.length];
		
		for (int i = 0; i < str.length; i++) {
			impact[i] = map.get(str[i]);
		}
		
		System.out.println("ImpactArray:" + Arrays.toString(impact));
		
		return impact;
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
