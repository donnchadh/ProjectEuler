package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p016x;

import java.math.BigInteger;

public class Problem169 {
    private static long[] cache = new long[Short.MAX_VALUE + 1];
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(countPermutations3(BigInteger.TEN.pow(25)));
        System.out.println("  ["+ (System.currentTimeMillis() - startTime) +" ms]");
    }

    private static long countPermutations3(BigInteger value) {
        if (value.bitLength() < 64) {
            return countPermutations3(value.longValue());
        } else {
            while (value.testBit(0)) {
                value = value.shiftRight(1);
            } 
            return countPermutations3(value.subtract(BigInteger.ONE)) + countPermutations3(value.shiftRight(1));
        }
    }

    private static long countPermutations3(long value) {
        while ((value & 1L) != 0) {
            value = value >> 1;
        }
        if (value == 0) {
            return 1;
        } else {
            if (value < cache.length) {
                if (cache[(int)value] != 0) {
                    return cache[(int)value];
                } else {
                    long result = countPermutations3(value - 1) + countPermutations3(value >> 1);
                    cache[(int)value] = result;
                    return result;
                }
            } else {
                return countPermutations3(value - 1) + countPermutations3(value >> 1);
            }
        }
    }
}
