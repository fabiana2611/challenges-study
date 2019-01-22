package br.study.java.challenges.plagiarism;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.TestCase;

public class PlagiarismDetectionTest  extends TestCase{
	
	public void testLessParam() {
		
		String[] args = new String[] { "synonyms.txt", "file1.txt" };
		
		PlagiarismDetection pd = new PlagiarismDetection();
		
		double result = pd.init(args);
		
		assertEquals(0d, result);
	}
	
	public void testNOptionNotANumber() {
		
		String[] args = new String[] { "synonyms.txt", "file1.txt" ,"file2.txt" ,"dddd" };
		
		PlagiarismDetection pd = new PlagiarismDetection();
		
		double result = pd.init(args);
		
		assertEquals(0d, result);
	}
	
	public void testPathNotFound() {
		
		String[] args = new String[] { "/x/j/synonyms.txt", "file1.txt" ,"file2.txt" ,"4" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(0d, result);		
	}
	
	public void testBasic() {
		
		String[] args = new String[] { "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/synonyms.txt", 
				"file1.txt" ,"file2.txt" ,"3" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(40.0d, result);		
	}
	
	public void testBasic3() {
		
		String[] args = new String[] { "synonyms.txt", "file1.txt" ,"file2.txt" ,"3" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(40.0d, result);		
	}
	
	public void testBasic4() {
		
		String[] args = new String[] { "synonyms.txt", "file1.txt" ,"file2.txt" ,"4" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(20.0d, result);		
	}
	
	public void testCreateBasic3() throws IOException{
		
		String[] linesSyn = new String[] { "run sprint jog", "andar caminhar passear" ,"bug problem error" ,"coder programmer developer" };
		String[] linesF1 = new String[] { "I go for I go for -a run.", "I go for a run" };
		String[] linesF2 = new String[] { "You go for â run." ,"You go for You go for a sprint."};
		
		String strPathSyn = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/syn.txt";
		String strPathF1 = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/f1.txt";
		String strPathF2 = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/f2.txt";
		
		createFile(linesSyn, strPathSyn );
		createFile(linesF1, strPathF1 );
		createFile(linesF2, strPathF2);
		
		String[] args = new String[] { "syn.txt", "f1.txt" ,"f2.txt" ,"3" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(40.0d, result);	
		
		Files.delete(Paths.get(strPathSyn));
		Files.delete(Paths.get(strPathF1));
		Files.delete(Paths.get(strPathF2));
	}
	
	public void testCreateBasic4() throws IOException{
		
		String[] linesSyn = new String[] { "run sprint jog", "andar caminhar passear" ,"bug problem error" ,"coder programmer developer" };
		String[] linesF1 = new String[] { "I go for I go for -a run.", "I go for a run" };
		String[] linesF2 = new String[] { "You go for â run." ,"You go for You go for a sprint."};
		
		String strPathSyn = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/syn.txt";
		String strPathF1 = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/f1.txt";
		String strPathF2 = "/Users/fabiana/Desenvolvimento/workspace-phonton/challenges/resource/f2.txt";
		
		createFile(linesSyn, strPathSyn );
		createFile(linesF1, strPathF1 );
		createFile(linesF2, strPathF2);
		
		String[] args = new String[] { "syn.txt", "f1.txt" ,"f2.txt" ,"4" };
		
		PlagiarismDetection pd = new PlagiarismDetection();

		double result = pd.init(args);
		assertEquals(20.0d, result);	
		
		Files.delete(Paths.get(strPathSyn));
		Files.delete(Paths.get(strPathF1));
		Files.delete(Paths.get(strPathF2));
	}
	
	// --- Utility--------------------------------------------
	
	private void createFile(String[] lines, String fileName) throws IOException{
		
		Path path = Paths.get(fileName);
		
		Files.createFile(path);
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			for (String line: lines) {
				writer.write(line+"\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

