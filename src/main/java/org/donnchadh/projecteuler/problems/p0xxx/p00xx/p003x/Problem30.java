package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

public class Problem30 {
    public static void main(String[] args) {
        int total = 0;
        int[] powers = new int[10];
        for (int i = 0; i < powers.length; i++) {
            powers[i] = i*i*i*i*i;
        }
        for (int i = 2; i < 999999; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += powers[x%10];
                x /= 10;
            }
            if (sum == i) {
                total += i;
            }
        }
        System.out.println(total);
    }
}
