package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem35 {
    public static void main(String[] args) {
        int count = 0;
        PrimeGenerator instance = PrimeGenerator.instance();
        for (Long prime : instance) {
            if (prime.longValue() >= 1000000) {
                break;
            }
            int z = 1;
            int x = prime.intValue()/10;
            while (x > 0) {
                x /= 10;
                z *=10;
            }
            x = prime.intValue();
            boolean circular = true;
            do {
                x = x%10 *z + x/10;
                if (!instance.isPrime(x)) {
                    circular = false;
                    break;
                }
            } while (x != prime.intValue());
            if (circular) {
                count++;
            }
        }
        System.out.println(count);
    }
}
