package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p012x;

import java.util.Arrays;

/**
 * @see http://projecteuler.net/index.php?section=problems&id=124
 * 
 * @author donnchadh
 *
 */
public class Problem124 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; count <= 10000; i++) {
            int[] primeFactors = factorizeIfRadical(i);
            int[] c = combinationsLessThan(primeFactors, 100000);
            if (count + c.length >= 10000) {
                // sort combinations to get solution = (count + d - 10000th) product of prime factors
                Arrays.sort(c);
                System.out.println(c[count + c.length - 10000]);
            } else {
                count += c.length;
            }
        }
    }

    private static int[] combinationsLessThan(int[] primeFactors, int limit) {
        // TODO Auto-generated method stub
        return new int[] {};
    }

    private static int[] factorizeIfRadical(int i) {
        // TODO Auto-generated method stub
        return new int[] {};
    }
}
