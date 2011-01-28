package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import java.util.ArrayList;
import java.util.List;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem37 {
    private static final int[] firstDigits = {2,5};
    private static final int[] middleDigits = {1,9};
    private static final int[] middleOrFinalOrFirstDigits = {3,7};
    
    public static void main(String[] args) {
        int sum = 0;
        int remaining = 11;
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        for(Long prime : primeGenerator) {
            long p = prime.longValue();
            boolean truncatable = p > 10;
            if (truncatable) {
                while (p > 10) {
                    p /= 10;
                    if (!primeGenerator.isPrime(p)) {
                        truncatable = false;
                        break;
                    }
                }
            }
            if (truncatable) {
                long x = 10;
                while (prime.longValue() > x) {
                    p = prime.longValue() %x;
                    if (!primeGenerator.isPrime(p)) {
                        truncatable = false;
                        break;
                    }
                    x *= 10;
                }
            }
            if (truncatable) {
                sum += prime.longValue();
                System.out.println(prime);
                remaining--;
                if (remaining == 0) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    
    public static void main2(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        List<Integer> candidates = new ArrayList<Integer>();
        for (int first : firstDigits) {
            candidates.add(Integer.valueOf(first));
        }
        while (!candidates.isEmpty()) {
            List<Integer> newCandidates = new ArrayList<Integer>();
            candidates = newCandidates;
        }
    }
}
