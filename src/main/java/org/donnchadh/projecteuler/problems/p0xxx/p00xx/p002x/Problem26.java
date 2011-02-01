package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.util.HashMap;
import java.util.Map;


public class Problem26 {
    public static void main(String[] args) {
        int dForMaxK = 0;
        int maxK = 0;
        for (int d = 3; d <1000; d++) {
            int a = 1;
            Map<Integer, Integer> remainders = new HashMap<Integer, Integer>();
            for (int n = 0; ; n++) {
                a *= 10;
                if (a > d) {
                    a = a%d;
                    Integer a_ = Integer.valueOf(a);
                    if (a == 0) {
                        break;
                    }
                    if (remainders.containsKey(a_)) {
                        int period = n - remainders.get(a_).intValue();
                        if (period > maxK) {
                            maxK = period;
                            dForMaxK = d;
                        }
                        System.out.print(".");
                        break;
                    }
                    remainders.put(a_, n);
                }
            }
        }
        System.out.println();
        System.out.println(dForMaxK);
    }
}
