package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

public class Problem45 {
    public static void main(String[] args) {
        for (long n = 144; ; n++) {
            long hex = n*(2*n-1);
            long a = 1+24*hex;
            long sqrta = (long) Math.sqrt(a);
            if (sqrta*sqrta == a && sqrta%6 == 5) {
                long b = 1+8*hex;
                long sqrtb = (long) Math.sqrt(b);
                if (sqrtb*sqrtb == b && sqrtb%2 == 1) {
                    System.out.println(hex);
                    break;
                }
            }
        }
    }
}
