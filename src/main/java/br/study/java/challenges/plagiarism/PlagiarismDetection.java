package br.study.java.challenges.plagiarism;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Plagiarism Detection 
 * 
 * - The synonym file has lines each containing one group of synonyms. 
 * - The input files should be declared plagiarized based on the number 
 * of N-tuples in file1 that appear in file2, where the tuples are compared by
 * accounting for synonyms 
 * - The output of the program should be the percent of tuples in file1 which appear in file2.
 * 
 * @author Fabiana Araujo
 *
 */
public class PlagiarismDetection {

	private static final int N = 3;
    private static final int ARG_LIMIT = 4;
    
    private Map<String, List<String>> mapSynonyms;
    private HashSet<String> tupleCreated;

    public double init(String... args) {
    	
    	double result = 0;
    	
    	 if (args.length == 0) {
             instruction();
         } else if (args.length < 3) {
             System.out.println("Error: It's required at least 3 argumets.");
         } else {
         	
         	Path pathSyn = createPath (args[0]);
         	Path pathFile1 = createPath (args[1]);
         	Path pathFile2 = createPath (args[2]);
         	
         	int tupleSize = 0;
             
             try {
                 // the forth param is optional
                 // Ignore all parameters after 4
                 tupleSize = args.length >= ARG_LIMIT ? Integer.parseInt(args[3]) : N;
             } catch (NumberFormatException e) {
                 System.out.println("Error: The forth value have to be a number.");
                 return 0;
             }
             
             result = process(pathSyn, pathFile1, pathFile2, tupleSize);
             
             System.out.println("Result: " + String.format("%.1f", result) + " %");
         }
    	
    	return result;
    }
    
    private double process(Path pathSyn, Path pathFile1, Path pathFile2, int tupleSize) {

    	int totalSimilarTuples = 0;
    	
        try {
            List<String> linesSynonym = Files.lines(pathSyn).collect(Collectors.toList()); 
            List<String> lines1 = Files.lines(pathFile1).collect(Collectors.toList()); 
            List<String> lines2 = Files.lines(pathFile2).collect(Collectors.toList()); 
            
            mapSynonyms(linesSynonym);
            tupleCreated = new HashSet<>();
            HashSet<String> tupleVerified = new HashSet<>();
            
            for (String line: lines1) {
            	
            	String formatted1 = formatString(line);
            	
            	List<String> listTuple1 = createTupleListAndRegister(formatted1, tupleSize);
            	
            	System.out.println("listTuple1: "+ listTuple1);
            	
            	for (String line2: lines2) {
            		
            		String formatted2 = formatString(line2);
            		
            		List<String> listTuple2 = createTupleListNoRegister(formatted2, tupleSize);
            	
            		System.out.println("listTuple2: "+ listTuple2);
            		
            		totalSimilarTuples += searchForMatch(listTuple1, listTuple2, tupleVerified);
            	}
            	
            	
            }
            
            System.out.println("\ntotalSimilarTuples: "+ totalSimilarTuples);
            System.out.println("totalTuples:" + tupleCreated.size());
            
        } catch (IOException e) {
            System.out.println("Error to access the file");
            return 0;
        }

        
        return 100 * (tupleCreated.size() != 0 ? (double)totalSimilarTuples / tupleCreated.size() : 0);
    }
    
    /**
     * Verify each tuple if exist at least once in the second list (the reference) 
     * @param listTupleTarget - List in analysis
     * @param listTupleReference - List to compare
     * @param verifySet - store what was already processed (avoid duplicate process)
     * @return totalSimilarTuples - total of tuples in first list was found in second list
     */
    private int searchForMatch(List<String> listTupleTarget, 
    		List<String> listTupleReference, HashSet<String> verifySet) {

        int totalSimilarTuples = 0;
        
        for (String tuple1: listTupleTarget) {
        	
        	if(verifySet.contains(tuple1)) {
        		continue;
        	}
        	
        	verifySet.add(tuple1);
        	
        	for(String tuple2: listTupleReference) {
        		
        		if (tuple1.equals(tuple2)){
        			totalSimilarTuples++;
        			break;
                }
        	}
        }
        
        return totalSimilarTuples;
    }
    
    private List<String> createTupleListAndRegister(String line, int tupleSize) {
    	return createTupleList(line,tupleSize, true);
    }
    
    private List<String> createTupleListNoRegister(String line, int tupleSize) {
    	return createTupleList(line,tupleSize, false);
    }
    
	private List<String> createTupleList(String line, int tupleSize, boolean hasToRegister) {

		List<String> list = new ArrayList<>();

		String[] arr = line.split(" ");
		int endIndex = 0;

		for (int i = 0; i < arr.length; i++) {

			endIndex = i + tupleSize;

			if (endIndex > arr.length) {
				break;
			}

			String tuple = createTuples(arr, i, endIndex);
			
			if(hasToRegister) {
				
				if(!tupleCreated.contains(tuple)) {
					tupleCreated.add(tuple);
					list.add(tuple);
				}
			} else {
				list.add(tuple);
			}
		}

		return list;
	}
	
	/**
	 * Create N-tuples where each word that have a list of synonyms in the synonyms file will
	 * be replaced by the first synonyms. 
	 */
    private String createTuples(String[] line, int begin, int end) {
        
    	StringBuilder tuple = new StringBuilder();
        
    	for (int j = begin; j < end; j++) {
    		
    		String word = line[j];
        
    		List<String> synonyms = mapSynonyms.get(word);
    		
    		if(synonyms != null && !synonyms.isEmpty()) {
    			//Replace for the first synonym to facilitate the comparison between two tuples
    			word = synonyms.get(0);
    		}
    		
    		tuple.append(word);
        }
        
    	return tuple.toString();
    }
    
    // ---- Utility Methods --------------------------------------------
    
    private void instruction() {
        System.out.println("========================");
        System.out.println("Inform the parameters: ");
        System.out.println("========================");
        System.out.println("1. File name for a list of synonums ");
        System.out.println("2. Input file 1 ");
        System.out.println("3. Input file 2 ");
        System.out.println("4. (Optional) the number N, the tuple size. If not supplied, the default should be N=3");
        System.out.println("========================");
    }
    
    private Path createPath(String strPath) {
    	if(strPath.contains("\\") || strPath.contains("/")) {
    		return Paths.get(strPath);
    	} else {
    		return FileSystems.getDefault().getPath(System.getProperty("user.dir"), "resource", strPath);
    	}
    }
    
    /**
     * Map all synonyms to a a HashMap. The synonym consult will be O(1)
     */
    private void mapSynonyms(List<String> synonymsLines) {
    	
    	mapSynonyms = new HashMap<>();
    	
    	for (String line: synonymsLines) {
    		
    		line = formatString(line);
    		
    		String[] arr = line.split(" ");
    		
    		for (String syn: arr) {
    			List<String> listSyn = new ArrayList<>(Arrays.asList(arr));
    			mapSynonyms.put(syn, listSyn);
    		}
    	}
    }
    
    /**
     * Remove accents and punctuation
     */
    private String formatString(String str) {
    	
    	String normalized = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    	
    	normalized = normalized.replace( "." , ""); 
    	normalized = normalized.replace( "-" , "");  
    	normalized = normalized.replace( "/" , ""); 
    	normalized = normalized.replace( "-" , ""); 
    	normalized = normalized.replace( "  " , " "); 
    	
    	return normalized;
    }

}
