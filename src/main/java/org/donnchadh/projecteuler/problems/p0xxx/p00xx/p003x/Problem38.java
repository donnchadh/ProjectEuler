package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import org.donnchadh.projecteuler.utils.PanDigitals;

public class Problem38 {
    public static void main(String[] args) {
        int max = 1000000000;
        int maxPan = 918273645;
        int shiftValue = 100000000;
        int limit = 10;
        for (int i = 2; i < 5; i++) {
            shiftValue /= 10;
            limit *= 10;
            int start = maxPan/shiftValue;
            for (int j = start; j < limit; j++) {
                long p = 0;
                int digits = 0;
                for (int n = 1; digits < 9; n++) {
                    int x = j*n;
                    while (x > 0) {
                        p *= 10;
                        digits++;
                        x /= 10;
                    }
                    p += j*n;
                }
                if (digits == 9 && p < max && p > maxPan && PanDigitals.isPanDigital((int)p)) {
                    maxPan = (int) p;
                }
            }
        }
        System.out.println(maxPan);
    }
}
