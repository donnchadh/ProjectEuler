package org.donnchadh.projecteuler.fibonacci;

import java.math.BigInteger;

public class Fibonacci {

    static long[] cache = new long[7*12];

    public static long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (cache[n] == 0) {
            long result = fib(n - 1) + fib(n-2);
            cache[n] = result;
            return result;
        } else {
            return cache[n];
        }
    }

    public static BigInteger bigFib(long n) {
        BigInteger fm2 = BigInteger.ONE;
        BigInteger fm1 = BigInteger.ONE;
        BigInteger fib = BigInteger.ONE;
        for (long i = 3; i <= n; i++) {
            fib = fm1.add(fm2);
            fm2 = fm1;
            fm1 = fib;
        }
        return fib;
    }
}
