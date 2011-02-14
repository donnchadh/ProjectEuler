package org.donnchadh.projecteuler.problems.p0xxx.p03xx.p030x;

public class Problem301 {
    public static void main(String[] args) {
        for (long limit = 1; limit <= 1<<30; limit <<=1) {
            int count = 0;
            for (long i = 1; i <= limit; i++) {
                if ((i^(i<<1))==i*3) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
