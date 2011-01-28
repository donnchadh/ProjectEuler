package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.util.Set;
import java.util.TreeSet;

public class Problem23 {
    public static void main(String[] args) {
        Set<Integer> abundantNumbers = new TreeSet<Integer>();
        for (int i = 10; i < 29000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if ((i%j)==0) {
                    sum+=j;
                }
            }
            if (sum > i) {
                abundantNumbers.add(Integer.valueOf(i));
            }
        }
        int sum = 0;
        for (int i = 1; i <= 28123; i++) {
            boolean can = false;
            for (Integer number : abundantNumbers) {
                if (number.intValue() > i) {
                    break;
                }
                if (abundantNumbers.contains(Integer.valueOf(i - number.intValue()))) {
                    can = true;
                    break;
                }
            }
            if (!can) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
