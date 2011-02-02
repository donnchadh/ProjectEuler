package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

import java.util.Arrays;

import org.donnchadh.projecteuler.primes.PrimeGenerator;
import org.donnchadh.projecteuler.utils.Permutations;

public class Problem49 {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        int[] values = new int[4];
        for (Long prime : primeGenerator) {
            if (prime.longValue() > 9999) {
                break;
            }
            int x = prime.intValue();
            for (int i = 3; i >= 0; i--) {
                values[i] = x % 10;
                x /= 10;
            }
            if (prime.longValue() > 1000) {
                int[][] permutations = Permutations.permutations(values);
                int[] primes = new int[permutations.length];
                int numPrimes = 0;
                int lastPrime = 0;
                for (int i = 0; i < permutations.length; i++) {
                    if (permutations[i][3] != 0) {
                        int value = 0;
                        for (int j = 3; j >= 0; j--) {
                            value *= 10;
                            value += permutations[i][j];
                        }
                        if (primeGenerator.isPrime(value) && value != lastPrime) {
                            lastPrime = value;
                            primes[i] = value;
                            numPrimes++;
                        }
                    }
                }
                if (numPrimes >= 3) {
                    // System.out.println(prime + " " + numPrimes);
                    Arrays.sort(primes);
                    int count = 0;
                    int previous = 0;
                    for (int i = 0; i < primes.length; i++) {
                        if (primes[i] != previous) {
                            primes[count] = primes[i];
                            count++;
                        }
                        previous = primes[i];
                    }
                    if (count >= 3) {
                        boolean found = false;
                        int[] uniquePrimes = new int[count];
                        for (int i = 0; i < uniquePrimes.length; i++) {
                            uniquePrimes[i] = primes[i];
                        }
                        for (int i = 0; i < uniquePrimes.length - 2; i++) {
                            for (int j = i + 1; j < uniquePrimes.length; j++) {
                                int k = Arrays.binarySearch(uniquePrimes, 2 * uniquePrimes[j] - uniquePrimes[i]);
                                if (k > 0) {
                                    if (uniquePrimes[j] != 4817) {
                                        System.out.println(uniquePrimes[i] + " " + uniquePrimes[j] + " "
                                                + uniquePrimes[k]);
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
