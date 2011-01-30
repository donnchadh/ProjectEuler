package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem12 {
    static PrimeGenerator primeGenerator = PrimeGenerator.instance();

    public static void main(String[] args) {
        long d = 0;
        long next = 0;
        for (long i = 1; ; i++) {
            next = next + i;
//            ((i + 1)*i)/(2);
            int dn = divisors(i%2 == 0 ? (i/2)  : i);
            int dnp1 = divisors(i%2 == 1 ? ((i + 1)/2)  : (i + 1));
            boolean found = false;
            d = dn * dnp1;
//            if (d >= 500) {
//                d = divisors(next);
//            }
//            d = divisors2(next);
                
//                System.out.println(next+","+ d);
            if (d >= 500) {
                found = true;
                System.out.println(i + "," + next + ": " + d);
//                int count = 0;
//                for (long j = 1; j <= next; j++ ) {
//                    if ((next%j)==0) {
//                        count++;
////                        System.out.println(j + ",");
//                    }
//                }
                System.out.println(divisors(next));
            }
            if (found) {
                System.out.println(i + "," + next + ": " + d);
                break;
            }
        }
//        System.out.p7589181600rintln(next);
    }
    private static int divisors2(long n) {
        int divisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                divisors++;
            }
        }
        return divisors;
    }

    private static int divisors(long n) {
        int divisors = 1;
        long remainingNumber = n;
        long midpoint = remainingNumber / 2;
        long primeFactor = 1L;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime.longValue() > midpoint) {
                break;
            }
            int repeats = 1;
            while ((remainingNumber % prime.longValue()) == 0) {
                    repeats++;
                primeFactor = prime.longValue();
                remainingNumber /= prime.longValue();
//                midpoint = remainingNumber / 2;
            }
            divisors *= repeats;
        }
        if (divisors == 1 && n > 1) {
            return 2;
        }
        return divisors;
    }
}
