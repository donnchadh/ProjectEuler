package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;


public class Problem53 {
    public static void main(String[] args) {
        int count = 0;
        for (long n = 1; n <= 100; n++) {
            for (long r = 1; r < n; r++) {
                long p = 1;
                long x = 1;
                for (long i = 1; i <= r; i++) {
                    if ((n - r + i)%i == 0) {
                        p *= ((n - r + i)/i);
                    } else if (p % i == 0){
                        p /= i;
                        p *= (n - r + i);
                    } else {
                        p *= (n - r + i);
                        x *= i;
                    }
                    if (p % x == 0) {
                        p /= x;
                        x = 1;
                    }
                    if (p/x > 1000000L) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
