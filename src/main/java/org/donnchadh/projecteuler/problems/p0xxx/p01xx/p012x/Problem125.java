package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p012x;

import java.util.Arrays;

import org.donnchadh.projecteuler.utils.Palindromes;
import org.donnchadh.projecteuler.utils.Palindromes.Generator;

public class Problem125 {
    public static void main(String[] args) {
        long[] sumsOfSquares = new long[10000];
        for (long i = 1; i < sumsOfSquares.length; i++) {
            sumsOfSquares[(int)i] = i*(i+1)*(2*i + 1)/6;
        }
        long sum = 0;
        int count = 0;
        long palindrome;
        Generator generator = Palindromes.generator();
        while ((palindrome = generator.next()) < 100000000) {
            for (int i = 0; i*i < palindrome; i++) {
                int index = Arrays.binarySearch(sumsOfSquares, palindrome + sumsOfSquares[i]);
                if (index > (i+1)) {
//                    System.out.println(palindrome + " " + (i + 1) + " " + index);
                    sum += palindrome;
                    count++;
                    break;
                }
            }
        }
        System.out.println(sum + "(" + count+ ")");
    }
}
