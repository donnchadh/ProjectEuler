package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p009x;

public class Problem92 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 10000000; i++) {
            int x  = i;
            while (x != 1 && x != 89) {
                int y = x;
                x = 0;
                while (y > 0) {
                    x += (y%10)*(y%10);
                    y /= 10;
                }
            }
            if (x == 89) {
                count++;
            }
        }
        System.out.println(count);
    }
}
