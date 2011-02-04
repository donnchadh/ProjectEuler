package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

public class Problem39 {
    public static void main(String[] args) {
        int pForMax = 0;
        int maxCount = 0;
        for (int p = 12; p <= 1000; p++) {
            int count = 0;
            for (int a = 1; a < p*292/1000; a++) {
                int b = (p*p - 2*a*p)/(2*p-2*a);
                int c = p - (a + b);
                if (c*c == a*a + b*b) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                pForMax = p;
            }
        }
        System.out.println(pForMax);
    }
}
