package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

public class Problem21 {
    public static void main(String[] args) {
        int[] amicables = new int[10000];
        for (int i = 1; i < 10000; i++) {
            int sum = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i%j == 0) {
                    sum+=j;
                }
            }
            amicables[i] = sum;
        }
        int sum = 0;
        for (int i = 0; i < amicables.length; i++) {
            if (amicables[i] != i && amicables[i] < amicables.length && amicables[amicables[i]] == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
