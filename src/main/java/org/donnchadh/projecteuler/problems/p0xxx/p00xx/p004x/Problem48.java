package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import java.math.BigInteger;

public class Problem48 {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        System.out.println(sum.mod(BigInteger.TEN.pow(10)));
    }
}
