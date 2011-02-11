package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import org.donnchadh.projecteuler.utils.Palindromes;

public class Problem55 {
    public static void main(String[] args) {
        int count = 0;
        for (int n = 1; n < 10000; n++) {
            boolean lycherel = true;
            long x = n;
            for (int i = 0; i < 50; i++) {
                x += Palindromes.decimalReverse(x);
                if (Palindromes.isPalindrome(x)) {
                    lycherel =  false;
                    break;
                }
            }
            if (lycherel) {
                count++;
            }
        }
        System.out.println(count);
    }
}
