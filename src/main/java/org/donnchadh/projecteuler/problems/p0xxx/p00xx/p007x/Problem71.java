package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p007x;

public class Problem71 {
    public static void main(String[] args) {
        double difference = 1.0;
        int numerator = 1;
        for (int d = 5; d <= 1000000; d++) {
                int n;
                if (d%7 != 0) {
                    n = d*3/7;
                } else {
                    n = (d*3-1)/7;
                }
                double dif = 3.0/7.0 - ((double)n)/((double)d);
                if (dif < difference) {
                    difference = dif;
                    numerator = n;
                }
        }
        System.out.println(numerator);
    }
}
