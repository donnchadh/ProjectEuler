package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

import java.math.BigInteger;

import org.donnchadh.projecteuler.utils.BigIntegerUtils;

public class Problem16 {
    public static void main(String[] args) {
        BigInteger number = BigInteger.valueOf(2).pow(1000);
        int sum = BigIntegerUtils.sumOfDigits(number);
        System.out.println(sum);
    }
}
