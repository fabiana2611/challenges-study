package teste;

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

public class PlagiarismDetectionRefactored {

    private static final int N = 3;
    private static final int ARG_LIMIT = 4;

    private Map<String, List<String>> mapSynonyms;
    private HashSet<String> tupleCreated;
    private HashSet<String> tupleVerified;

    private int totalSimilarTuples;
    private int tupleSize;

    public static void main(String[] args) {

        // FIXME - REMOVE
        args = new String[] { "synonyms.txt", "file1.txt", "file2.txt", "3" };

        PlagiarismDetectionRefactored p = new PlagiarismDetectionRefactored();
        double result = p.init(args);

        System.out.println("\ntotalSimilarTuples: " + p.totalSimilarTuples);
        System.out.println("totalTuples:" + p.tupleCreated.size());
        System.out.println("Result: " + String.format("%.1f", result) + " %");

    }

    public double init(String... args) {

        double result = 0;

        if (args.length == 0) {
            instruction();
        } else if (args.length < 3) {
            System.out.println("Error: It's required at least 3 argumets.");
        } else {
            return run(args);
        }

        return result;
    }

    private double run(String[] args) {

        try {
            // the forth param is optional
            // Ignore all parameters after 4
            tupleSize = args.length >= ARG_LIMIT ? Integer.parseInt(args[3]) : N;

            List<String> linesSynonym = Files.lines(createPath(args[0])).collect(Collectors.toList());
            List<String> lines1 = Files.lines(createPath(args[1])).collect(Collectors.toList());
            List<String> lines2 = Files.lines(createPath(args[2])).collect(Collectors.toList());

            preProcess(linesSynonym);
            return process(linesSynonym, lines1, lines2);

        } catch (NumberFormatException | IOException e) {
            if (e instanceof IOException) {
                System.out.println("Error to access the file");
            } else {
                System.out.println("Error: The forth value have to be a number.");
            }
            return 0;
        }

    }

    private void preProcess(List<String> linesSynonym) {
        tupleCreated = new HashSet<>();
        tupleVerified = new HashSet<>();
        mapSynonyms = new HashMap<>();
        linesSynonym.stream().forEach(l -> addSynonimsToMap(l, mapSynonyms));
    }

    private double process(List<String> linesSynonym, List<String> lines1, List<String> lines2) {

        lines1.stream().map(line -> createTupleListAndRegister(line)).peek(System.out::println)
                .forEach(listTuple1 -> verifyWithFile2(lines2, listTuple1));

        return 100 * (tupleCreated.size() != 0 ? (double) totalSimilarTuples / tupleCreated.size() : 0);
    }

    private List<String> createTupleListAndRegister(String line) {
        return createTupleList(line, true);
    }

    private void verifyWithFile2(List<String> lines2, List<String> listTuple1) {
        lines2.stream().map(line2 -> createTupleListNoRegister(line2)).peek(System.out::println)
                .forEach(listTuple2 -> searchForMatch(listTuple1, listTuple2));
    }

    private List<String> createTupleListNoRegister(String line) {
        return createTupleList(line, false);
    }

    private List<String> createTupleList(String line, boolean hasToRegister) {

        line = formatString(line);

        List<String> list = new ArrayList<>();

        String[] arr = line.split(" ");
        int endIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            endIndex = i + tupleSize;

            if (endIndex > arr.length) {
                break;
            }

            String tuple = createTuples(arr, i, endIndex);

            if (hasToRegister) {

                if (!tupleCreated.contains(tuple)) {
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
     * Create N-tuples where each word that have a list of synonyms in the synonyms file will be replaced by the first
     * synonyms.
     */
    private String createTuples(String[] line, int begin, int end) {

        StringBuilder tuple = new StringBuilder();

        for (int j = begin; j < end; j++) {

            String word = line[j];

            List<String> synonyms = mapSynonyms.get(word);

            if (synonyms != null && !synonyms.isEmpty()) {
                // Replace for the first synonym to facilitate the comparison between two tuples
                word = synonyms.get(0);
            }

            tuple.append(word);
        }

        return tuple.toString();
    }

    /**
     * Verify each tuple if exist at least once in the second list (the reference)
     * @param listTupleTarget
     *            - List in analysis
     * @param listTupleReference
     *            - List to compare
     * @param verifySet
     *            - store what was already processed (avoid duplicate process)
     * @return totalSimilarTuples - total of tuples in first list was found in second list
     */
    private void searchForMatch(List<String> listTupleTarget, List<String> listTupleReference) {

        listTupleTarget.stream().filter(tupla -> !tupleVerified.contains(tupla)).forEach(tupla -> {
            tupleVerified.add(tupla);
            verify(tupla, listTupleReference);
        });

    }

    private void verify(String tuple1, List<String> listTupleReference) {
        for (String tuple2 : listTupleReference) {
            if (tuple1.equals(tuple2)) {
                totalSimilarTuples++;
                break;
            }
        }
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
        if (strPath.contains("\\") || strPath.contains("/")) {
            return Paths.get(strPath);
        } else {
            return FileSystems.getDefault().getPath(System.getProperty("user.dir"), "resource", strPath);
        }
    }

    private void addSynonimsToMap(String line, Map<String, List<String>> mapSynonyms) {
        line = formatString(line);
        String[] arr = line.split(" ");
        Arrays.stream(arr).forEach(syn -> mapSynonyms.put(syn, new ArrayList<>(Arrays.asList(arr))));
    }

    /**
     * Remove accents and punctuation
     */
    private String formatString(String str) {

        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        normalized = normalized.replace(".", "");
        normalized = normalized.replace("-", "");
        normalized = normalized.replace("/", "");
        normalized = normalized.replace("-", "");
        normalized = normalized.replace("  ", " ");

        return normalized;
    }

}
