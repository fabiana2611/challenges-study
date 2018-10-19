package br.study.java.challenges;

import java.util.HashMap;

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
public class SecretString {

	private String secret = "";
    
    public String process(Character[][] triplets1) {
    	
    	if(triplets1 == null || triplets1.length == 0) {
    		return "";
    	}

    	HashMap<Character, Node> directedGraphNodes = assembleStructure (triplets1);
    	
    	System.out.println("Hash key: "+directedGraphNodes.keySet());
    	
    	for (Node node: directedGraphNodes.values()) {
    		extractPath(node, "");
    	}
    	
    	System.out.println("Secret: "+secret);
        return secret;
    }
    
    private String extractPath(Node node, String str) {
    	
    	String path = str + node.getValor().toString();
    	
    	for (Node child: node.getChildren()) {
    		extractPath(child, path);
    	}
    	findSecret(path);
    	return path;
    }
    
    
    private void findSecret(String path) {
    	if(path.length() > secret.length()) {
			secret = path;
		}
    }
    
    /**
     * Assemble a structure with nodes and its references. Each node is add in a HashTable to consult in O(1).
     */
    private HashMap<Character, Node> assembleStructure(Character[][] triplets1) {
    	
    	 HashMap<Character, Node> listNodes = new HashMap<Character, Node>();
         
         for (int i = 0; i < triplets1.length; i++) {
         	
         	Character[] arr = triplets1[i];
         	
         	printArray(arr);

             for (int j = 0; j < arr.length; j++) {

                 Character item = arr[j];

                 Node node = listNodes.get(item);

                 Node parentNode = j > 0 ? listNodes.get(arr[j - 1]) : null;
                 
                 createNodeWithParentReference(item, node, parentNode, listNodes);

             }

         }
         
         return listNodes;
    }

    private void createNodeWithParentReference(Character item, Node node, 
    		Node parentNode, HashMap<Character, Node> graphNodes) {
    	
    	if(node == null) {
    		node = new Node(item);
    		graphNodes.put(item, node);
    	}
    	
        if(parentNode != null) {
        	parentNode.addChildren(node);
        }
        
    }
    
	private void printArray(Character[] arr) {
		String str = "arr: [";
		for (Character a: arr) {
			str+= a + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		System.out.println(str);
	}

}
