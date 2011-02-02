package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;
import org.donnchadh.projecteuler.utils.PanDigitals;

public class Problem41 {
    int[] primeFinalDigits = {1,3,7,9};
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        int max = 987654321;
        for (int i = max; i > 0; i-=2) {
            boolean panDigital = PanDigitals.isPanDigital(i);
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
