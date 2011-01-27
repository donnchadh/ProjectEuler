package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem7 {
    public static void main(String[] args) {
        int index = 1;
        for (Long prime : PrimeGenerator.instance()) {
            if (index == 10001) {
                System.out.println(prime);
                break;
            }
            index++;
        }
    }
}
