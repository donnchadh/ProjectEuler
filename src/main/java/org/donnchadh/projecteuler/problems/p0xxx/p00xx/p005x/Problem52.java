package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import org.donnchadh.projecteuler.utils.Permutations;

public class Problem52 {
    public static void main(String[] args) {
        long limit = 10;
        while (true) {
            for (long l = limit/10; l <= limit/6; l++) {
                boolean found = true;
                for (int i = 2; i <= 6; i++) {
                    if (!Permutations.isPermutation(l, l*i)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println(l);
                    return;
                }
            }
            limit *= 10;
        }
    }
}
