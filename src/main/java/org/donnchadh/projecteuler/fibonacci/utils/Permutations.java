package org.donnchadh.projecteuler.fibonacci.utils;

public class Permutations {
    public static int[][] permutations(int[] values) {
        if (values.length == 2) {
            return new int[][]{values,{values[1],values[0]}};
        } else if (values.length == 3) {
            return new int[][]{values, {values[0],values[2],values[1]},
                    {values[1],values[0],values[2]},{values[1],values[2],values[0]},
                    {values[2],values[0],values[1]},{values[2],values[1],values[0]}};
        }
        int[][] result = new int[(int)Factorials.factorial(values.length)][values.length];
        for (int i = 0; i < values.length; i++) {
            int[] values2 = new int[values.length-1];
            for (int j = 0; j < values2.length; j++) {
                values2[j] = j >= i ? values[j+1] : values[j];
            }
            int[][] result2 = permutations(values2);
            for (int j = 0; j < result2.length; j++) {
                result[i*result2.length+j][0] = values[i];
                System.arraycopy(result2[j], 0, result[i*result2.length+j], 1, result2[j].length);
            }
        }
        return result;
    }
}
