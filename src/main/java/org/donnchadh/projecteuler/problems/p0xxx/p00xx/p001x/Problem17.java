package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

public class Problem17 {
    private static int[] digitLengths = {
        "one".length(),
        "two".length(),
        "three".length(),
        "four".length(),
        "five".length(),
        "six".length(),
        "seven".length(),
        "eight".length(),
        "nine".length(),
    };
    private static int[] teenLengths = {
        "ten".length(),
        "eleven".length(),
        "twelve".length(),
        "thirteen".length(),
        "fourteen".length(),
        "fifteen".length(),
        "sixteen".length(),
        "seventeen".length(),
        "eighteen".length(),
        "nineteen".length(),
    };

    private static int[] decadeLengths = {
        "twenty".length(),
        "thirty".length(),
        "forty".length(),
        "fifty".length(),
        "sixty".length(),
        "seventy".length(),
        "eighty".length(),
        "ninety".length(),
    };

    public static void main(String[] args) {
        int digitSum = 0;
        for (int i : digitLengths) {
            digitSum += i;
        }
        int teenSum = 0;
        for (int i : teenLengths) {
            teenSum += i;
        }
        int decadeSum = 0;
        for (int i : decadeLengths) {
            decadeSum += i;
        }
        int andSum = "and".length()*99*9;
        int hundredSum = "hundred".length()*100*9;
        int hundredDigitSum = digitSum*100;
        int totalDigitSum = 9*digitSum*10;
        int totalTeenSum = teenSum*10;
        int totalDecadeSum = decadeSum*10*10;
        int result = "one".length()+"thousand".length() + hundredDigitSum + hundredSum + andSum + totalDecadeSum + totalTeenSum + totalDigitSum;
        System.out.println(result);
    }
}
