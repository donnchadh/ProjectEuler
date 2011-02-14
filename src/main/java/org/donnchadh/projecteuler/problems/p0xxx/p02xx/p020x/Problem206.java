package org.donnchadh.projecteuler.problems.p0xxx.p02xx.p020x;

public class Problem206 {
    public static void main(String[] args) {
        tryThis(3);
        tryThis(7);
    }

    public static void tryThis(int x) {
        for (long i = 101010100+x; i < 138902662; i+=10) {
            long t = i*i/100;
            if (check(i*i/100)) {
                System.out.println(i*10);
                break;
            }
        }
    }

    public static boolean check(long t) {
        boolean matches = true;
        for (int j = 8; j > 0; j--) {
            if (t%10 != j) {
                matches = false;
                break;
            }
            t/=100;
        }
        return matches;
    }
}
