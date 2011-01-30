package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem27 {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        int max = 0;
        int product = 0;
        for (Long b : primeGenerator) {
            if (b.intValue() >= 1000) {
                break;
            }
            for (int a = -999; a < 1000; a++) {
                int consecutivePrimes = countPrimes(primeGenerator, a,b.intValue());
                if (consecutivePrimes > max) {
                    System.out.println(a + "," +b+": "+consecutivePrimes);
                    product = a*b.intValue();
                    max = consecutivePrimes;
                }
            }
        }
        System.out.println(product);
    }

    private static int countPrimes(PrimeGenerator primeGenerator, int a, int b) {
        for (int i = 0; ; i++) {
            int value = i*i + a*i + b;
            if (value < 0 || !primeGenerator.isPrime(value)) {
                return i;
            }
        }
    }
}
