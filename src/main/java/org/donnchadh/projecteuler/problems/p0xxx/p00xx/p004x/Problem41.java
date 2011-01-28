package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem41 {
    int[] primeFinalDigits = {1,3,7,9};
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        int max = 987654321;
        for (int i = max; i > 0; i-=2) {
            int mask = 0;
            int x = i;
            boolean panDigital = true;
            int j;
            for (j = 0; j <9 && x > 0; j++) {
                if ((x%10) != 0) {
                    int maskBefore = mask;
                    mask |= (1 << (x%10));
                    if (maskBefore == mask) {
                        panDigital = false;
                        break;
                    }
                } else {
                    panDigital = false;
                    break;
                }
                x /= 10;
            }
            if (mask != (1<<(j+1))-2) {
                panDigital = false;
            }
            if (panDigital) {
                if (primeGenerator.isPrime(i)) {
                    System.out.println("---");
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
