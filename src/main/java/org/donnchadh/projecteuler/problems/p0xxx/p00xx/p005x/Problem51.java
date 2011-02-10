package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p005x;

import org.donnchadh.projecteuler.primes.PrimeGenerator;

public class Problem51 {
    private static final char[] chars = {'0','1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = PrimeGenerator.instance();
        for (Long prime : primeGenerator) {
            if (prime.longValue() > 10) {
                String primeString = prime.toString();
                for (int i = 0; i < 3; i++) {
                    String template = primeString.substring(0, primeString.length()- 1).replace(chars[i], 'x') + primeString.charAt(primeString.length() - 1);
                    if (!template.equals(primeString)) {
                        int count = 1;
                        for (int j = i + 1; j < 10 ; j++) {
                            long test = Long.parseLong(template.replace('x', chars[j]));
                            if (primeGenerator.isPrime(test)) {
                                count++;
                            }
                        }
                        if (count >= 8) {
                            System.out.println(template);
                            System.out.println(prime.longValue());
                            return;
                        }
                    }
                }
            }
        }
    }

}
