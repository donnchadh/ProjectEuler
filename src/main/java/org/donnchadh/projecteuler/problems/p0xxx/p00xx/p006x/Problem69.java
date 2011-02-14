package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p006x;

import java.util.Iterator;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem69 {
    public static void main(String[] args) {
        int product = 1;
        int max = 1;
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        Iterator<Long> iterator = primeGenerator.iterator();
        while (product < 1000000) {
            max = product;
            product *= iterator.next();
        }
        System.out.println(max);
    }
}
