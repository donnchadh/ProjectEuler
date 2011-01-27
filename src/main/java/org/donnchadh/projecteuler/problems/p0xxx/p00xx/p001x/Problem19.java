package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

public class Problem19 {
    private static final int[] monthLengths = {
        31,28,31,30,31,30,31,31,30,31,30,31
    };
    public static void main(String[] args) {
        int count = 0;
        int days = 365;
        for (int y = 1901; y <= 2000; y++) {
            for (int m = 0; m < 12; m++) {
                if ((days%7)==6) {
                    count++;
                }
                days += monthLengths[m];
                if (m == 1 && (y%4)==0) {
                    days++;
                }
            }
        }
        System.out.println(count);
    }
}
