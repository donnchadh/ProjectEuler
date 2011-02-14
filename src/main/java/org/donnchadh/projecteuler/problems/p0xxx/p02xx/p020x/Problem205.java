package org.donnchadh.projecteuler.problems.p0xxx.p02xx.p020x;

public class Problem205 {
    /**
     * http://en.wikipedia.org/wiki/Dice#Probability
     */
    public static void main(String[] args) {
        double total = 0.0;
        double cubicProbability = 0.0;
        for (int i = 6; i < 9; i++) {
            cubicProbability += probability(6, 6, i);
        }
        for (int i = 9; i <= 36; i++) {
            total += probability(4, 9, i) * cubicProbability;
            cubicProbability += probability(6, 6, i);
        }
        System.out.println(total);
    }

    private static double probability(int s, int n, int k) {
        if (n == 1) {
            if (1 <= k && k <= s) {
                return 1.0/s;
            } else {
                return 0.0;
            }
        }
        double total = 0.0;
        for (int i = 1; i <= k-n+1 && i <= s; i++) {
            total += probability(s,n-1,k-i);
        }
        total /= s;
        return total;
    }
}
