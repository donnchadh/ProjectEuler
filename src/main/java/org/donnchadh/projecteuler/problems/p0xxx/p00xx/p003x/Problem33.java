package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import java.math.BigInteger;

public class Problem33 {
    public static void main(String[] args) {
        int numeratorProduct = 1;
        int denomenatorProduct = 1;
        for (int d = 10; d < 99; d++) {
            int da = d % 10;
            if (da != 0) {
                for (int n = 10; n < d; n++) {
                    if (n % 10 != 0) {
                        if (n % 10 == (d / 10) % 10) {
                            int na = n / 10;
                            if (n*da == d*na) {
                                numeratorProduct *= n;
                                denomenatorProduct *= d;
                            }
                        }
                    }
                }
            }
        }
        int gcd = BigInteger.valueOf(numeratorProduct).gcd(BigInteger.valueOf(denomenatorProduct)).intValue();
        System.out.println(numeratorProduct / gcd);
        System.out.println(denomenatorProduct / gcd);
    }
}
