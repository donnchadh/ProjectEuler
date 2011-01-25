package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem3 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long remainingNumber = 600851475143L;
        long midpoint = (long) Math.sqrt(remainingNumber);
        long primeFactor = 1L;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime.longValue() > midpoint)
            {
                break;
            }

            while ((remainingNumber % prime.longValue()) == 0)
            {
                System.out.println(primeFactor);
                primeFactor = prime.longValue();
                remainingNumber /= prime.longValue();
                midpoint = (long)Math.sqrt(remainingNumber);
            }
        }
        System.out.println(remainingNumber);
        System.out.println("  ["+ (System.currentTimeMillis() - startTime) +" ms]");
    }
}
