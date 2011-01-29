package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;

public class Problem5 {
    public static void main(String[] args) {
        int sum = 0;
        int sumOfSquares = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            sumOfSquares += i*i;
        }
        System.out.print(sum*sum - sumOfSquares);
    }
}
