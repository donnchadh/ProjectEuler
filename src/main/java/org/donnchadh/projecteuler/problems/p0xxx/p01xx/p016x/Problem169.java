package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p016x;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem169 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(split(BigInteger.valueOf(10))));
        System.out.println(Arrays.toString(split(BigInteger.valueOf(6))));
        System.out.println(Arrays.toString(split(BigInteger.valueOf(2))));
//        System.out.println(countPermutations(BigInteger.valueOf(1)));
//        System.out.println(countPermutations(BigInteger.valueOf(2)));
//        System.out.println(countPermutations(BigInteger.valueOf(3)));
//        System.out.println(countPermutations(BigInteger.valueOf(4)));
//        System.out.println(countPermutations(BigInteger.valueOf(5)));
//        System.out.println(countPermutations(BigInteger.valueOf(6)));
//        System.out.println(countPermutations(BigInteger.valueOf(7)));
//        System.out.println(countPermutations(BigInteger.valueOf(8)));
        System.out.println(countPermutations3(BigInteger.valueOf(9)));
        System.out.println(countPermutations3(BigInteger.TEN));
//        System.out.println(countPermutations(BigInteger.valueOf(11)));
//        System.out.println(countPermutations(BigInteger.valueOf(12)));
//        System.out.println(countPermutations(BigInteger.valueOf(13)));
//        System.out.println(countPermutations(BigInteger.valueOf(14)));
//        System.out.println(countPermutations(BigInteger.valueOf(15)));
//        System.out.println(countPermutations(BigInteger.valueOf(16)));
//        System.out.println(countPermutations(BigInteger.valueOf(20)));
//        System.out.println(countPermutations(BigInteger.valueOf(30)));
//        System.out.println(countPermutations(BigInteger.valueOf(40)));
//        System.out.println(countPermutations(BigInteger.valueOf(30)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(2)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(3)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(4)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(10)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(15)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(20)));
        System.out.println(countPermutations3(BigInteger.TEN.pow(25)));
    }

    private static int countPermutations3(BigInteger value) {
        if (value.bitLength() < 64) {
            return countPermutations3(value.longValue());
        } else {
            while (value.testBit(0)) {
                value = value.shiftRight(1);
            } 
            return countPermutations3(value.subtract(BigInteger.ONE)) + countPermutations3(value.shiftRight(1));
        }
    }

    private static int countPermutations3(long value) {
        while ((value & 1L) != 0) {
            value = value >> 1;
        }
        if (value == 0) {
            return 1;
        } else {
            return countPermutations3(value - 1) + countPermutations3(value >> 1);
        }
    }

    private static int countPermutationsByBruteForce(long value) {
        return 0;
    }

    private static int countPermutations2(BigInteger value) {
        if (value.bitLength() == value.bitCount()) {
            return 1;
        } else if (value.bitCount() == 1) {
            return value.bitLength();
        } else {
            return 0;
        }
    }

    private static void countZeroBits(BigInteger result) {
        System.out.println(result.bitLength());
        System.out.println(result.bitCount());
        System.out.println(result.bitLength()-result.bitCount());
    }
    
    private static int countPermutations(BigInteger value) {
        if (value.equals(value.ZERO)) {
            return 0;
        }
        if (value.bitLength() == value.bitCount()) {
            return 1;
        } else if (value.bitCount() == 1) {
            return value.bitLength();
        } else {
            BigInteger[] splits = split(value);
//            if (splits.length == 1 || splits[1] == null) {
//                return 1;
//            }
            int result = 0;
            result += countPermutations(splits[0]);
            if (splits.length > 1 && splits[1] != null) {
                if (splits[1].equals(value)) {
                    throw new IllegalStateException(""+value);
                }
                result += countPermutations(splits[1]);
            }
            return result;
        }
    }

    private static int countPermutations(BigInteger value, BigInteger value2) {
        if (value.bitLength() == value.bitCount()) {
            return 1;
        } else if (value.bitCount() == 1) {
            return value.bitLength();
        } else {
            BigInteger[] splits = split(value, value2);
            if (splits.length == 1 || splits[2] == null) {
                return 1;
            }
            int result = 0;
            result += countPermutations(splits[0], splits[1]);
            if (splits[1] != null && splits[2] != null) {
                if (splits[2].equals(value) && splits[3].equals(value2)) {
                    throw new IllegalStateException(value + "," +value2);
                }
                result += countPermutations(splits[2], splits[3]);
            }
            return result;
        }
    }

    private static BigInteger[] split(BigInteger value) {
        int bitLength = value.bitLength();
        BigInteger[] result = new BigInteger[2];
        BigInteger mask = BigInteger.ONE.shiftLeft(bitLength-1);
        result[0] = value.xor(mask);
        BigInteger factor = mask;
        do {
            factor = factor.shiftRight(1);
            result[1] = value.subtract(factor);
            result[0] = result[0].clearBit(factor.bitLength());
        } while (value.xor(factor).equals(result[1]));
        return result;
    }

    private static BigInteger[] split(BigInteger value, BigInteger value2) {
        int bitLength = value.bitLength();
//        if (value2.equals(value)) {
//            return new BigInteger[]{value, BigInteger.ZERO};
//        }
        BigInteger[] result = new BigInteger[4];
        result[0] = value.clearBit(value.bitLength() - 1);
        result[1] = BigInteger.ZERO;
        for (int i = bitLength - 1; i > 0; i--) {
            if (value.testBit(i) && !value2.testBit(i)) {
                result[2] = value.clearBit(i).setBit(i - 1);
                result[3] = value2.setBit(i - 1);
                break;
            }
        }
        return result;
    }
}
