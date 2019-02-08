package teste;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Tow sorted arrays. Find duplicate values
 *
 * This refactor to use stream have worst performance that the class FindDuplicateValues that use only arrays
 *
 * @author fabiana.araujo
 *
 */

public class FindDuplicateValuesRefactor {

    static List<Integer> bigest = new ArrayList<>();
    static List<Integer> shortest = new ArrayList<>();

    public static void main(String[] args) {

        Instant begin = Instant.now();
        // test0();
        test1();
        // test2();
        // test3();
        // test4();
        Instant end = Instant.now();
        System.out.println("\nDuration: " + end.compareTo(begin));

    }

    private static void test0() {
        Integer[] x = {};
        Integer[] y = {};
        run(x, y);
    }

    private static void test1() {
        Integer[] x = { 2, 3, 4, 5, 7, 7, 8, 8, 9, 10, 11, 11, 14, 15, 15, 16 };
        Integer[] y = { 4, 5, 5, 5, 6, 7, 8, 11 };
        run(x, y);
    }

    private static void test2() {
        Integer[] x = { 2, 3, 4, 5, 7, 7, 8, 8 };
        Integer[] y = { 4, 5, 5, 5, 6, 7, 8, 11 };
        run(x, y);
    }

    private static void test3() {
        Integer[] x = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        Integer[] y = { 4, 5, 5, 5, 6, 7, 8, 11 };
        run(x, y);
    }

    private static void test4() {
        Integer[] x = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
        // int[] x = { 2, 3, 4, 5, 7, 7, 8, 8 };
        Integer[] y = { 4, 5, 5, 5, 6, 7, 8, 11 };
        run(x, y);
    }

    private static void run(Integer[] x, Integer[] y) {

        Set<Integer> result = new HashSet<>();

        if (x == null || x.length == 0 || y == null || y.length == 0) {
            System.out.println("Result: " + result);
            return;
        }

        if (y.length < x.length) {
            addValues(x, y);
        } else {
            addValues(y, x);
        }

        System.out.println("bigest: " + bigest);
        System.out.println("shortest: " + shortest);

        if (bigest.isEmpty()) {
            System.out.println("Result: " + result);
            return;
        }

        shortest.stream().forEach(s -> {

            Optional<Integer> r = bigest.stream().filter(b -> b.intValue() == s.intValue()).findFirst();
            if (r.isPresent()) {
                result.add(r.get());
            }
            bigest.remove(0);

        });

        System.out.println("Result: " + result);
    }

    private static void addValues(Integer[] bigger, Integer[] smaller) {

        List<Integer> subList = getSubList(bigger, smaller);

        if (subList.size() > smaller.length) {
            swap(subList, Arrays.asList(smaller));
        } else {
            swap(Arrays.asList(smaller), subList);
        }
    }

    private static void swap(List<Integer> toBig, List<Integer> toSmall) {
        bigest.clear();
        bigest.addAll(toBig);
        shortest.clear();
        shortest.addAll(toSmall);
    }

    private static List<Integer> getSubList(Integer[] bigger, Integer[] smaller) {

        int startInBigger = Arrays.binarySearch(bigger, smaller[0]);
        int begin = startInBigger < 0 ? Math.abs(startInBigger + 1) : startInBigger;

        int endInBigger = Arrays.binarySearch(bigger, smaller[smaller.length - 1]);
        int end = endInBigger < 0 ? Math.abs(endInBigger + 1) : endInBigger;

        return Arrays.asList(bigger).subList(begin, end);
    }

}
