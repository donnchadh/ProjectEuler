package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

public class Problem15 {
    public static void main(String[] args) {
        long result = 1;
        // Central Binomial Coefficient
        for (int i = 1; i <= 20; i++) {
            result = result*4-2*result/i;
        }
        System.out.println(result);
    }
}
