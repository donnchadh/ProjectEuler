package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p014x;

import org.donnchadh.projecteuler.utils.Palindromes;

public class Problem145 {
    public static void main(String[] args) {
        for (int limit = 10; limit <= 1000000000; limit *= 10) {
            int count = 0;
            for (int i = 1; i < limit; i++) {
                if (i % 10 != 0) {
                    int candidate = i + (int) Palindromes.decimalReverse(i);
                    boolean reversible = true;
                    while ((candidate & 1) == 1) {
                        candidate /= 10;
                    }
                    if (candidate == 0) {
                        count++;
                    }
                }
            }
            System.out.println(limit + ": " + count);
        }
    }
}
