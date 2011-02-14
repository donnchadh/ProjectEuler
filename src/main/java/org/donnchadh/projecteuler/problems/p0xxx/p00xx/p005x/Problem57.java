package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import java.math.BigInteger;

public class Problem57 {
    public static void main(String[] args) {
        int count = 0;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < 1000; i++) {
            a = a.add(b.shiftLeft(1));
            b = a.subtract(b);
            int numeratorDigits = 0;
            int denominatorDigits = 0;
            BigInteger n = a;
            while (n.bitLength() > 0) {
                numeratorDigits++;
                n = n.divide(BigInteger.TEN);
            }
            BigInteger d = b;
            while (d.bitLength() > 0) {
                denominatorDigits++;
                d = d.divide(BigInteger.TEN);
            }
            if (numeratorDigits > denominatorDigits) {
                count++;
            }
        }
        System.out.println(count);
    }
}
