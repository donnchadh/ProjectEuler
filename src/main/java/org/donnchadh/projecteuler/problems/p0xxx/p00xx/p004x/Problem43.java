package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import org.donnchadh.projecteuler.fibonacci.utils.Permutations;

public class Problem43 {
    private static int primes[] = {2,3,5,7,11,13,17};
    
    public static void main(String[] args) {
        long sum = 0;
        int[] digits = {0,1,2,3,4,5,6,7,8,9};
        int[][] panDigitals = Permutations.permutations(digits);
        for (int i = 0; i < panDigitals.length; i++) {
            boolean interesting = true;
            long x = 0;
            for (int d : panDigitals[i]) {
                x *= 10;
                x += d;
            }
            long y = x;
            for (int j = 0; j <7; j++) {
                if (((y%1000)%primes[6-j]) != 0) {
                    interesting = false;
                    break;
                }
                y /= 10;
            }
            if (interesting) {
                System.out.println(x);
                sum += x;
            }
        }
        System.out.println("=====");
        System.out.println(sum);
    }
}
