package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import java.util.Arrays;

public class Problem44 {
    public static void main(String[] args) {
        boolean found = false;;
        long pentagonals[] = new long[1000000];
        for (long n = 1; n < pentagonals.length;n++) {
            pentagonals[(int)n] = n*(3L*n-1)/2L;
        }
        for (int i = 1; i < pentagonals.length;i++) {
            for (int j = i-1; j > 0; j--) {
                long pj = pentagonals[j];
                long pk = pentagonals[i] - pj;
                if (Arrays.binarySearch(pentagonals, pk) > 0) {
                    if (Arrays.binarySearch(pentagonals, Math.abs(pk - pj)) > 0) {
                        System.out.println(pj +"," + pk);
                        System.out.println(Math.abs(pk - pj));
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }
    }
}
