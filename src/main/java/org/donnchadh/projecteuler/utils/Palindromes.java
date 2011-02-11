package org.donnchadh.projecteuler.utils;

public class Palindromes {
    public static boolean isPalindrome(long number) {
        return number == decimalReverse(number);
    }
    
    public static long decimalReverse(long number) {
        long reverse = 0;
        while (number > 0) {
            reverse *= 10;
            reverse += number%10;
            number /= 10;
        }
        return reverse;
    }
}
