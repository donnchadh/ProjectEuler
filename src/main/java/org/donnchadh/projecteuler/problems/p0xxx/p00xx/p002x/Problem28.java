package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

public class Problem28 {
    public static void main(String[] args) {
        int sum = 1;
        int x = 1;
        for (int i = 3; i <= 1001; i+=2) {
            sum += 4*x+10*i -10;
            x += 4 *(i-1);
        }
        System.out.println(sum);
    }
}
