package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;


public class Problem2 {
    public static void main(String[] args) {
        long sum = 0;
        long fib = 1;
        long fibnm1 = 1, fibnm2 = 1;
        do {
            if ((fib & 1L) == 0) {
                sum += fib;
            }
            fibnm2 = fibnm1;
            fibnm1 = fib;
            fib = fibnm1 + fibnm2;
        } while (fib <= 4000000);
        System.out.println(sum);
    }
}
