package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p009x;


public class Problem97 {
    public static void main(String[] args) {
        long x = 1;
        long m = 10000000000L;
        for (int i = 1; i <= 7830457; i++) {
            x = (2*x)%m;
        }
        x = (28433*x)%m;
        x = (x+1)%m;
        System.out.println(x);
    }
}
