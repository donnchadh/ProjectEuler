package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem58 {
    public static void main(String[] args) {
        int x = 1;
        int d = 1;
        int p = 0;
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        for (int i = 3; i <= 1000000; i+=2) {
            d += 4;
            if (primeGenerator.isPrime(x + (i - 1))) {
                p++;
            }
            if (primeGenerator.isPrime(x + 2*(i - 1))) {
                p++;
            }
            if (primeGenerator.isPrime(x + 3*(i - 1))) {
                p++;
            }
            if (primeGenerator.isPrime(x + 4*(i - 1))) {
                p++;
            }
            if (d > p*10) {
                System.out.println(i);
                break;
            }
            x += 4 *(i-1);
        }
        
    }
}
