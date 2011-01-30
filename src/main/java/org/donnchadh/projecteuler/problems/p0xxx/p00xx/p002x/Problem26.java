package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p002x;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Problem26 {
    public static void main(String[] args) {
        BigDecimal one = new BigDecimal(1.0, MathContext.UNLIMITED);
        for (int d = 3; d <1000; d++) {
            BigDecimal bd = BigDecimal.ONE.divide(BigDecimal.valueOf(d));
            System.out.println(bd.toString());
        }
    }
}
