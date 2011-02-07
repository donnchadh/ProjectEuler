package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem47 {
    private static PrimeGenerator primeGenerator = PrimeGenerator.instance();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int first = 0;
        int count = 0;
        for (int i = 1; ; i++) {
            if (countPrimeFactors(i) == 4) {
                if (count == 0) {
                    first = i;
                }
                count++;
                if (count == 4) {
                    break;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(first);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static int countPrimeFactors(int test) {
        if (primeGenerator.isPrime(test)) {
            return 1;
        }
        long remainingNumber = test;
        int count = 0;
        for (Long prime : primeGenerator) {
            int primeValue = prime.intValue();
            if (primeValue > remainingNumber) {
                break;
            }

            if ((remainingNumber % primeValue) == 0) {
                count++;
            }
            while ((remainingNumber % primeValue) == 0) {
                remainingNumber /= primeValue;
            }
        }
        return count;
    }
}
