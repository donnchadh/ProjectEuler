package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p006x;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem63 {
    public static void main(String[] args) {
        int count = 0;
        Set<BigInteger> integers = new HashSet<BigInteger>();
        for (int n = 0; n <= 10; n++) {
            for (int p = 0; p < 30; p++) {
                BigInteger y = BigInteger.valueOf(n).pow(p);
                int c = 0;
                while (y.bitLength() > 0) {
                    y = y.divide(BigInteger.TEN);
                    c++;
                }
                if (c == p) {
                    count++;
                    integers.add(BigInteger.valueOf(n).pow(p));
                }
            }
        }
        System.out.println(count);
    }
}
