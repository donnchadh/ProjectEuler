package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.math.BigInteger;

import org.donnchadh.projecteuler.utils.BigIntegerUtils;

public class Problem20 {
    public static void main(String[] args) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        int sum = BigIntegerUtils.sumOfDigits(factorial);
        System.out.println(sum);
    }
}
