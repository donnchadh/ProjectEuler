package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import java.util.Iterator;
import java.util.List;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem50 {
    long lastSum = 0;
    long firstPrime = 2;
    long lastPrime = 2;
    int lastCount = 0;

    public long findSolution() {
        long max = 1000000L;
        PrimeGenerator instance = PrimeGenerator.instance();
        for (Long prime : instance) {
            if (prime.longValue() > max) {
                break;
            }
        }
        List<Long> primeList = instance.getPrimes();
        long[] primes = new long[primeList.size()];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = primeList.get(i).longValue();
        }
        int firstPrimeIndex = 0;
        int lastPrimeIndex = 0;
        int firstPrimeIndexUsed = 0;
        long sum = primes[firstPrimeIndex];
        while (primes[firstPrimeIndex] < max) {
            int nextCandidatePrimeIndex = lastPrimeIndex;
            for (;;) {
                long nextPrime = primes[++nextCandidatePrimeIndex];
                if ((sum + nextPrime) > max) {
                    break;
                }
                sum += nextPrime;
                int count = nextCandidatePrimeIndex - firstPrimeIndex + 1;
                if (instance.isPrime(sum) && count >= lastCount) {
                    lastPrime = nextPrime;
                    lastSum = sum;
                    lastCount = count;
                    firstPrime = primes[firstPrimeIndex];
                    firstPrimeIndexUsed = firstPrimeIndex;
                    lastPrimeIndex = nextCandidatePrimeIndex;
                }
            }
            firstPrimeIndex++;
            sum = 0;
            for (int i = firstPrimeIndex; i <= lastPrimeIndex; i++) {
                sum += primes[i];
            }
        }   
        long sum2 = 0;
        for (int i = firstPrimeIndexUsed; i <= lastPrimeIndex; i++) {
            sum2 += primes[i];
        }
        if (sum2 != lastSum) {
            System.out.println("Error " + sum2 + " != " + lastSum);
        }
        return lastSum;
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Problem50 problem50 = new Problem50();
        long solution = problem50.findSolution();
        System.out.println(solution + "("+problem50.firstPrime+" .. " + problem50.lastPrime + " "+problem50.lastCount +")");
        System.out.println("  ["+ (System.currentTimeMillis() - startTime) +" ms]");
    }
}
