package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem10 {
    public static void main(String[] args) {
        long sum = 0;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime >= 2000000) {
                break;
            }
            sum += prime.longValue();
        }
        System.out.println(sum);
    }
}
