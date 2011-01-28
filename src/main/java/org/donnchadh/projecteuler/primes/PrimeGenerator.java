package org.donnchadh.projecteuler.primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeGenerator implements Iterable<Long> {
    final List<Long> primes = new ArrayList<Long>();
    
    private long lastPrime = 1;
    
    private PrimeGenerator() {
    }
    
    public java.util.Iterator<Long> primes() {
        return new java.util.Iterator<Long>() {
            
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Long next() {
                return nextPrime();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

    Long nextPrime() {
        long next = lastPrime;
        while (!isPrime(++next)) {
            ;
        }
        lastPrime = next;
        Long result = Long.valueOf(lastPrime);
        if (primes.isEmpty() || lastPrime > primes.get(primes.size() -1) .longValue()) {
            primes.add(result);
        }
        return result;
    }
    
    public static PrimeGenerator instance() {
        return new PrimeGenerator();
    }

    @Override
    public Iterator<Long> iterator() {
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
        long midpoint = (long) Math.sqrt(l);
        while (primes.get(primes.size() -1).longValue() < midpoint) {
            nextPrime();
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