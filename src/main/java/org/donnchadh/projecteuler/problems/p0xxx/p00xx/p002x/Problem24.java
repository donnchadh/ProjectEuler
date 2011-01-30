package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.util.Arrays;

import org.donnchadh.projecteuler.utils.Permutations;

public class Problem24 {
    public static void main(String[] args) {
        int[][] panDigitals = Permutations.permutations(10);
        System.out.println(Arrays.toString(panDigitals[1000000-1]));
    }
}
