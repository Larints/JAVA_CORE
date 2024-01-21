package task_1;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {

        System.out.println(oddCount(new int[]{2, 1, 2, 3, 4}));
        System.out.println(minMaxDiff(new int[]{2, 1, 2, 3, 4}));
        System.out.println(zeroNeighbours(new int[]{2, 1, 2, 3, 4}));
    }

    public static int oddCount(int[] array) {
        int count = 0;
        for (int n : array) {
            if (n % 2 == 0) count++;
        }
        return count;
    }

    public static int minMaxDiff(int[] array) {
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }

    public static boolean zeroNeighbours(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
