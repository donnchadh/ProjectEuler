package org.donnchadh.projecteuler.primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PrimeGenerator implements Iterable<Long> {
    final List<Long> primes = new ArrayList<Long>();
    
    private PrimeGenerator() {
    }
    
    public java.util.Iterator<Long> primes() {
        return new java.util.Iterator<Long>() {
            
            private long lastPrime = 1;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Long next() {
                long next = lastPrime;
                while (!isPrime(++next)) {
                    ;
                }
                lastPrime = next;
                Long result = Long.valueOf(lastPrime);
                primes.add(result);
                return result;
            }

            private boolean isPrime(long l) {
                long midpoint = (long) Math.sqrt(l);
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

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

    public static PrimeGenerator instance() {
        return new PrimeGenerator();
    }

    @Override
    public Iterator<Long> iterator() {
        return primes();
    }
    
    public static void main(String[] args) {
        for (Long prime : instance()) {
            System.out.println(prime);
        }
    }
}