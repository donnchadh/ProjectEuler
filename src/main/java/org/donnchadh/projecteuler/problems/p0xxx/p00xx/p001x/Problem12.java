package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem12 {
    static PrimeGenerator primeGenerator = PrimeGenerator.instance();

    public static void main(String[] args) {
        int d = 0;
        for (long i = 1;; i++) {
            long next = ((i + 1)*i)/(2);
            int dn = divisors(i%2 == 0 ? i/2  : i);
            int dnp1 = divisors(i%2 == 1 ? (i + 1)/2  : i + 1);
            boolean found = false;
            d = dn * dnp1;
            if (d == 500) {
                found = true;
                System.out.println(i + "," + next + ": " + d);
            }
            if (found) {
                System.out.println(i + "," + next + ": " + d);
                break;
            }
        }
//        System.out.println(next);
    }

    private static int divisors(long n) {
        int divisors = 1;
        long remainingNumber = n;
        long midpoint = (long) Math.sqrt(remainingNumber);
        long primeFactor = 1L;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime.longValue() > midpoint) {
                break;
            }

            while ((remainingNumber % prime.longValue()) == 0) {
                divisors++;
                primeFactor = prime.longValue();
                remainingNumber /= prime.longValue();
                midpoint = (long) Math.sqrt(remainingNumber);
            }
        }
        if (n > 1) {
            divisors ++;
        }
        return divisors;
    }
}
