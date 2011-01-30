package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

public class Problem15 {
    public static void main(String[] args) {
        int result = 1;
        for (int i = 1; i <= 20; i++) {
            result = 2 *(result + i - 1);
            System.out.println(result);
        }
        System.out.println(result);
    }
}
