package org.donnchadh.projecteuler.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeGenerator implements Iterable<Long> {
    private final class Iterator implements java.util.Iterator<Long> {
        long lastPrime = 1;
        int nextPrimeIndex = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Long next() {
            return nextPrime();
        }

        Long nextPrime() {
            if (primes.size() > nextPrimeIndex) {
                Long result = primes.get(nextPrimeIndex);
                nextPrimeIndex++;
                return result;
            }
            long next = lastPrime;
            while (!isPrime(++next)) {
                ;
            }
            lastPrime = next;
            Long result = Long.valueOf(lastPrime);
            if (primes.isEmpty() || lastPrime > primes.get(primes.size() -1) .longValue()) {
                primes.add(result);
            }
            nextPrimeIndex++;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    final List<Long> primes = new ArrayList<Long>();
    
    private final Iterator iterator = new Iterator();
    
    private PrimeGenerator() {
    }
    
    public Iterator primes() {
        return new Iterator();
    }

    public static PrimeGenerator instance() {
        return new PrimeGenerator();
    }

    @Override
    public Iterator iterator() {
        return primes();
    }
    
    public List<Long> getPrimes() {
        return primes;
    }
    
    public boolean isPrime(long l) {
        if (l == 1) {
            return false;
        }
        if (l <= 3) {
            return true;
        }
        if (!primes.isEmpty() && l < primes.get(primes.size() -1).longValue()) {
            return Collections.binarySearch(primes, Long.valueOf(l)) >= 0;
        }
        long midpoint = (long) Math.sqrt(l);
        while (primes.isEmpty() || primes.get(primes.size() -1).longValue() < midpoint) {
            iterator.next();
        }
        for (Long prime : primes) {
            if ((l % prime.longValue()) == 0) {
                return false;
            }
            if (prime.longValue() > midpoint) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (Long prime : instance()) {
            System.out.println(prime);
        }
    }
}