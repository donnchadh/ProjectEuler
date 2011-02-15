package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p012x;

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
            int[] primeFactors = factorize(i);
            int d = combinationsLessThan(primeFactors, 100000);
            if (count + d >= 10000) {
                // sort combinations to get solution = (count + d - 10000th) product of prime factors
            }
        }
    }

    private static int combinationsLessThan(int[] primeFactors, int limit) {
        // TODO Auto-generated method stub
        return 0;
    }

    private static int[] factorize(int i) {
        // TODO Auto-generated method stub
        return null;
    }
}
