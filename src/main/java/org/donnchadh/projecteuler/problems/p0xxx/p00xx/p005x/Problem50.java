package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import java.util.ArrayList;
import java.util.List;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem50 {
    long firstPrime = 2;
    long lastPrime = 2;
    int lastCount = 1;

    public long findSolution(long max) {
        PrimeGenerator instance = PrimeGenerator.instance();
        List<Long> sumsList = new ArrayList<Long>();
        long maxSum = 0;
        for (Long prime : instance) {
            sumsList.add(Long.valueOf(maxSum));
            if (maxSum > max) {
                break;
            }
            maxSum += prime.longValue();
        }
        long[] sums = new long[sumsList.size()];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = sumsList.get(i).longValue();
        }
        for (int c = 0; c < sums.length; c++) {
            for (int i = 0; i <= c; i++) {
                long left = sums[i];
                long right = maxSum - sums[sums.length-(c-i)-1];
                long value = maxSum - (left + right);
                if (value < max && instance.isPrime(value)) {
                    firstPrime = sums[i+1]-left;
                    lastPrime = sums[sums.length-(c-i)-1]-sums[sums.length-(c-i)-2];
                    lastCount = sums.length - c - 1;
                    return value;
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        problem50(1000L);
        problem50(1000000L);
        problem50(1000000000000L);
    }

    private static void problem50(long max) {
        long startTime = System.currentTimeMillis();
        Problem50 problem50 = new Problem50();
        long solution = problem50.findSolution(max);
        System.out.println("Solution for " + max + ": " + solution + "("+problem50.firstPrime+" .. " + problem50.lastPrime + " "+problem50.lastCount +")");
        System.out.println("  ["+ (System.currentTimeMillis() - startTime) +" ms]");
        verifySolution(problem50, solution);
    }

    private static void verifySolution(Problem50 problem50, long solution) {
        long sum = 0;
        int count = 0;
        for (Long prime : PrimeGenerator.instance()) {
            if (prime.longValue() > problem50.lastPrime) {
                break;
            }
            if (prime.longValue() >= problem50.firstPrime) {
                sum += prime.longValue();
                count++;
            }
        }
        if (sum != solution) {
            System.out.println("Incorrect solution.");
        }
        if (count != problem50.lastCount) {
            System.out.println("Incorrect count (should be: " + count + ")");
        }
    }
}
