package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem46 {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        for (long i = 5;; i += 2) {
            if (!primeGenerator.isPrime(i)) {
                boolean can = false;
                for (int j = 1; j*j*2 < i; j++) {
                    if (primeGenerator.isPrime(i - (j*j*2))) {
                        can = true;
                        break;
                    }
                }
                if (!can) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
