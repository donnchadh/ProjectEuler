package org.donnchadh.projecteuler.utils;

public class Palindromes {
    
    public static class Generator {
        long previousPalindrome = 0;
        
        public long next() {
            while (!isPalindrome(++previousPalindrome));
            return previousPalindrome;
        }
    }
    
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
    
    public static Generator generator() {
        return new Generator();
    }
    
    public static void main(String[] args) {
        Generator generator = Palindromes.generator();
        long palindrome = 0;
        while ((palindrome = generator.next()) < 1000) {
            System.out.println(palindrome);
        }
    }
}
