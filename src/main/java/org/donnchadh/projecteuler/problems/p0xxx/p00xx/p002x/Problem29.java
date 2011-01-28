package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {
    public static void main(String[] args) {
        HashSet<BigInteger> values = new HashSet<BigInteger>();
        for (int i = 2; i <= 100; i++) {
            BigInteger value = BigInteger.valueOf(i);
            for (int j = 2; j <= 100; j++) {
                values.add(value.pow(j));
            }
        }
        System.out.println(values.size());
    }
}
