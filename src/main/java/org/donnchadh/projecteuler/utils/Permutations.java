package org.donnchadh.projecteuler.utils;

public class Permutations {
    private static final int[][] EMPTY= {};
    
    public static int[][] permutations(int[] values) {
        int n = values.length;
        int[][] result1 = permutations(n);
        int[][] result = new int[result1.length][n];
        apply(values, result1, result, 0, 0);
        return result;
    }

    private static void apply(int[] values, int[][] result1, int[][] result, int x, int y) {
        for (int i = 0; i < result1.length; i++) {
            int[] sourceRow = result1[i];
            int[] destRow = result[y+i];
            for (int j = 0; j < sourceRow.length; j++) {
                destRow[x+j] = values[sourceRow[j]];
            }
        }
    }

    public static int[][] permutations(int n) {
        if (n == 0) {
            return EMPTY;
        }
        int[][] result1 = permutations(n-1);
        int[][] result = new int[(int)Factorials.factorial(n)][n];
        int[] values2 = new int[n-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < values2.length; j++) {
                values2[j] = j >= i ? j+1 : j;
            }
            apply(values2, result1, result, 1,i*result1.length);
            for (int j = 0; j < result1.length; j++) {
                result[i*result1.length+j][0] = i;
            }
        }
        return result;
    }
    
}
