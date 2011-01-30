package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import java.math.BigInteger;

public class Problem36 {
    public static void main(String[] args) {
        int z = 10;
        int sum = 0;
        for (int j = 1; j <10; j+=2) {
            sum = check(sum, j);
        }
        for (int i = 1; i < 1000; i++) {
            if (i > z) {
                z*= 10;
            }
            int x = i;
            int y = 0;
            while (x > 0) {
                y*=10;
                y += x%10;
                x /=10;
            }
            int decimalPalindrome = i*z + y;
            sum = check(sum, decimalPalindrome);
            if (i <100) {
                for (int j = 0; j <10; j++) {
                    sum = check(sum, i*z*10+j*z + y);
                }
            }
        }
        System.out.println(sum);
    }

    protected static int check(int sum, int decimalPalindrome) {
        int reverse = Integer.reverse(decimalPalindrome<<1);
        while (reverse%2 == 0) {
            reverse>>=1;
        }
        if (reverse == decimalPalindrome) {
            sum += decimalPalindrome;
        }
        return sum;
    }
}
