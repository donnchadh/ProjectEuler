package org.donnchadh.projecteuler.fibonacci;

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

}
