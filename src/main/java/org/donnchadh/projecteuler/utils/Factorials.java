package org.donnchadh.projecteuler.utils;

public class Factorials {

    public static long factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

}
