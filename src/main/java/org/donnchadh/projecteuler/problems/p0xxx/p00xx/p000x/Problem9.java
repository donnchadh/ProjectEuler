package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;

public class Problem9 {
    public static void main(String[] args) {
        for (int i = 3; i < 1000; i++) {
            int x = 1000000 - 2000*i + 2*i*i;
            int y = 2000-2*i;
            if (x%y == 0) {
                int a = i;
                int c = x/y;
                int b = (int) Math.sqrt(c*c - a*a);
                if (a*a + b*b == c*c && a +b + c == 1000) {
                    System.out.println(a*b*c);
                    break;
                }
            }
        }
    }
}
