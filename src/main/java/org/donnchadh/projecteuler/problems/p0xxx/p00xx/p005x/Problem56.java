package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import java.math.BigInteger;

import org.donnchadh.projecteuler.utils.BigIntegerUtils;

public class Problem56 {
    public static void main(String[] args) {
        int max = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                int sum = BigIntegerUtils.sumOfDigits(BigInteger.valueOf(a).pow(b));
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
