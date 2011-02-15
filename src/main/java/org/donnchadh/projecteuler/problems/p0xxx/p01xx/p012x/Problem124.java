package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p012x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

/**
 * @see http://projecteuler.net/index.php?section=problems&id=124
 * 
 * @author donnchadh
 * 
 */
public class Problem124 {
    private static PrimeGenerator primeGenerator = PrimeGenerator.instance();

    public static void main(String[] args) {
        solve(10, 4);
        solve(10, 6);
        solve(100000, 10000);
    }

    private static void solve(int limit, int index) {
        int count = 1;
        for (int i = 1; count <= index; i++) {
            List<Long> primeFactors = factorizeIfRadical(i);
            if (!primeFactors.isEmpty()) {
                Long[] primeFactorArray = primeFactors.toArray(new Long[primeFactors.size()]);
                int d = countCombinationsLessThan(primeFactorArray, limit);
                if (count + d >= index) {
                    // sort combinations to get solution = (count + d - 10000th)
                    // product of prime factors
                    int[] c = new int[d];
                    combinationsLessThan(1, primeFactorArray, limit, c, 0);
                    Arrays.sort(c);
                    System.out.println(i + ": " + c[index - count - 1]);
                    break;
                } else {
                    count += d;
                }
            }
        }
    }

    private static int countCombinationsLessThan(Long[] primeFactors, int limit) {
        int firstPrime = primeFactors[0].intValue();
        int x = firstPrime;
        int count = 0;
        if (primeFactors.length == 1) {
            while (x <= limit) {
                count++;
                x *= firstPrime;
            }
        } else {
            Long[] remainingPrimeFactors = new Long[primeFactors.length-1];
            for (int i = 0; i < remainingPrimeFactors.length; i++) {
                remainingPrimeFactors[i] = primeFactors[i+1];
            }
            while (x <= limit) {
                count+=countCombinationsLessThan(remainingPrimeFactors, limit/x);
                x *= firstPrime;
            }
        }
        return count;
    }

    private static int combinationsLessThan(int multiplier, Long[] primeFactors, int limit, int[] result, int index) {
        int firstPrime = primeFactors[0].intValue();
        int x = multiplier*firstPrime;
        int count = index;
        if (primeFactors.length == 1) {
            while (x <= limit) {
                result[count++] = x;
                x *= firstPrime;
            }
        } else {
            Long[] remainingPrimeFactors = new Long[primeFactors.length-1];
            for (int i = 0; i < remainingPrimeFactors.length; i++) {
                remainingPrimeFactors[i] = primeFactors[i+1];
            }
            while (x <= limit) {
                count = combinationsLessThan(x, remainingPrimeFactors, limit, result, count);
                x *= firstPrime;
            }
        }
        return count;
    }

    private static List<Long> factorizeIfRadical(int i) {
        if (primeGenerator.isPrime(i)) {
            return Arrays.asList(Long.valueOf(i));
        }
        List<Long> result = new ArrayList<Long>();
        int remainingNumber = i;
        int primeFactor = 1;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime.longValue() > i) {
                break;
            }

            int count = 0;
            while ((remainingNumber % prime.longValue()) == 0) {
                result.add(prime);
                count++;
                primeFactor = prime.intValue();
                remainingNumber /= prime.longValue();
                if (count > 1) {
                    return Collections.emptyList();
                }
            }
        }
        return result;
    }
}
