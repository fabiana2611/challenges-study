package br.study.java.challenges;

import junit.framework.TestCase;

/**
 * There is a secret string which is unknown to you. Given a collection of random triplets from the
 * string, recover the original string.
 * A triplet here is defined as a sequence of three letters such that each letter occurs somewhere
 * before the next in the given string. "whi" is a triplet for the string "whatisup".
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 * You can assume nothing about the triplets given to you other than that they are valid triplets and
 * that they contain sufficient information to deduce the original string. In particular, this means that
 * the secret string will never contain letters that do not occur in one of the triplets given to you.
 * 
 * secret_1 = "whatisup"
 * triplets_1 = [
 * ['t','u','p'],
 * ['w','h','i'],
 * ['t','s','u'],
 * ['a','t','s'],
 * ['h','a','p'],
 * ['t','i','s'],
 * ['w','h','s']
 * ]
 * Test.assert_equals(recover_secret(triplets_1), secret_1)
 * 
 * The solution is based in directed nodes (graph idea). Each node have a list of children nodes.
 * Ex: t->u->p
 * 
 * HashTable is used to consult existent node in O(1).
 * 
 * @author fabiana.araujo
 *
 */
public class SecretStringTest extends TestCase{
	
	public void testEmptyArray() {
		
		String secret = "";
		
		Character[][] triplets1 = { };
		
		test(triplets1, secret);
		
	}
	
	public void testFindSecretString() {
		
		String secret = "whatisup";
		
		Character[][] triplets1 = { { 't', 'u', 'p' }, { 'w', 'h', 'i' }, { 't', 's', 'u' },
	            { 'a', 't', 's' }, { 'h', 'a', 'p' }, { 't', 'i', 's' }, { 'w', 'h', 's' } };
		
		test(triplets1, secret);
		
	}
	
	private void test(Character[][] triplets1, String secret) {
		SecretString service = new SecretString();
		String result = service.process(triplets1);
		assertEquals(secret, result);
	}

}
