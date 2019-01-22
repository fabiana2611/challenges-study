package br.study.java.challenges.plagiarism;

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
public class PlagiarismDetectionMain {

	public static void main(String[] args) {

		// FIXME - REMOVE
		args = new String[] { "synonyms.txt", "file1.txt", "file2.txt", "3" };

		PlagiarismDetection solution = new PlagiarismDetection();
		double result = solution.init(args);

		System.out.println("Result: " + String.format("%.1f", result) + " %");

	}
    
}
