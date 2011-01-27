package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p013x;

public class Problem138 {
    static long[] cache = new long[7*12];
    
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 12; i++) {
            long l = fib(6*(i+1)+3)/2;
            System.out.println(l);
            sum += l;
        }
        System.out.println(sum);
    }
    
    private static long fib(int n) {
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

    public static void main2(String[] args) {
        int count = 0;
        long sum = 0;
        long attempt = 2;
        while (count < 12) {
            long square = 5*attempt*attempt -1;
            long b = (long) Math.sqrt(square);
            if (b*b == square && ((2*b-4)%5 == 0 || (2*b+4)%5 == 0)) {
                System.out.println(attempt);
                count++;
                sum += attempt;
                attempt*= 10;
            }
            attempt++;
        }
        System.out.println(sum);
    }
    
}
