package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

public class Problem34 {
    public static void main(String[] args) {
        int[] factorials = new int[10];
        factorials[0] = 1;
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i-1]*i;
        }
        for (int i = 10; i < 3000000; i++) {
            int sumOfFactorials = 0;
            int x = i;
            while (x > 0) {
                sumOfFactorials+=factorials[x%10];
                x /= 10;
            }
            if (i == sumOfFactorials) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
