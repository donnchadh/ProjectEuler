package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import org.donnchadh.projecteuler.utils.Permutations;

public class Problem32 {
    public static void main(String[] args) {
        int sum = 0;
        int[][] panDigitals = Permutations.permutations(9);
        int lastProduct = 0;
        for (int i = 0; i < panDigitals.length; i++) {
            int[] x = panDigitals[i];
            int product = (x[0]+1)*1000+(x[1]+1)*100+(x[2]+1)*10+x[3]+1;
            if (((x[4]+1) * 10 + (x[5]+1))*((x[6]+1)*100 + (x[7]+1) * 10 + (x[8]+1)) == product) {
                sum += product;
                lastProduct = product;
            }
        }
        System.out.println(sum);
    }
}
