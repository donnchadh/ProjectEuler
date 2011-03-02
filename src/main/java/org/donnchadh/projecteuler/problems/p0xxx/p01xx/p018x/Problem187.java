package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p018x;

import java.util.Arrays;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem187 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        long max = 100000000;
        for (Long prime : primeGenerator) {
            if (prime.longValue()*2 > max) {
                break;
            }
        }
        long[] primes = new long[primeGenerator.getPrimes().size()];
        int i = 0;
        for (Long prime : primeGenerator.getPrimes()) {
            primes[i++] = prime.longValue();
        }
        int count = 0;
        for (int j = 0; j < primes.length; j++) {
            int index = Arrays.binarySearch(primes, max/primes[j]);
            if (index < 0) {
                index = -index - 2;
            }
            if (index < j) {
                break;
            }
            System.out.println(primes[j] + ": " + (index + 1 - j));
            count += index + 1 - j;
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start);
    }
}
