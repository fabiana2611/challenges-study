package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Tow sorted arrays. Find duplicate values
 *
 * @author fabiana.araujo
 *
 */

public class FindDuplicateValues {

    public static void main(String[] args) {

        int[] x = new int[] { 2, 3, 4, 5, 7, 7, 8, 8, 9, 10, 11, 11, 14, 15, 15, 16 };
        // int[] x = { 2, 3, 4, 5, 7, 7, 8, 8 };

        int[] y = { 4, 5, 5, 5, 6, 7, 8, 11 };

        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));

        FindDuplicateValues process = new FindDuplicateValues();

        System.out.println("Null values: ");
        System.out.println(process.getSuplicateValues(null, null));

        System.out.println("\nFull arrays: ");
        System.out.println(process.getSuplicateValues(x, y));

    }

    private List<Integer> getSuplicateValues(int[] x, int[] y) {

        if (x == null || x.length == 0 || y == null || y.length == 0) {
            return Collections.emptyList();
        }

        int point = Arrays.binarySearch(x, y[0]);

        int startPoint = point < 0 ? Math.abs(point + 2) : point;

        System.out.println("startPoint: " + startPoint);

        int[] biggerArr;
        int[] smallerArr;

        if (x.length <= y.length) {
            smallerArr = x;
            biggerArr = y;
        } else {
            smallerArr = y;
            biggerArr = x;
        }

        List<Integer> result = new ArrayList<>();

        int j = startPoint;

        for (int i = 0; i < smallerArr.length; i++) {

            if (i > 0 && smallerArr[i] == smallerArr[i - 1]) {
                continue;
            }

            while (biggerArr[j] <= smallerArr[i] && j < biggerArr.length - 1) {

                if (j > startPoint && biggerArr[j] == biggerArr[j - 1]) {
                    j++;
                    continue;
                }

                if (biggerArr[j] == smallerArr[i]) {
                    result.add(smallerArr[i]);
                }
                j++;

            }

        }

        return result;
    }
}
