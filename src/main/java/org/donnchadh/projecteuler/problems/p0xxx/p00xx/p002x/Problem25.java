package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.math.BigInteger;

import org.donnchadh.projecteuler.fibonacci.Fibonacci;

public class Problem25 {
    public static void main(String[] args) {
        double n = (1000 + 0.5d*Math.log10(5d))/Math.log10(1d+Math.sqrt(5d)/2d);
        System.out.println(n);
        double sqrt5 = Math.sqrt(5d);
        BigInteger fm2 = BigInteger.ONE;
        BigInteger fm1 = BigInteger.ONE;
        BigInteger fib = BigInteger.ONE;
        for (long i = 3; i <= 100000; i++) {
            fib = fm1.add(fm2);
            fm2 = fm1;
            fm1 = fib;
            if (fib.bitLength() > 3300) {
                BigInteger bigFib = fib;
                int digits = 0;
                BigInteger x = bigFib;
                while (x.bitLength() > 0) {
                    digits++;
                    x = x.divide(BigInteger.TEN);
                }
                if (digits >= 1000) {
                    System.out.println(bigFib);
                    System.out.println(i);
                    break;
                }
            }
        }
//        System.out.println(1d/sqrt5*(Math.pow((1+sqrt5)/2, n)-Math.pow((1-sqrt5)/2, n)));
        BigInteger bigFib = fib;
        System.out.println(bigFib);
        int digits = 0;
        while (bigFib.bitLength() > 0) {
            digits++;
            bigFib = bigFib.divide(BigInteger.TEN);
        }
        System.out.println(digits);
    }
}
