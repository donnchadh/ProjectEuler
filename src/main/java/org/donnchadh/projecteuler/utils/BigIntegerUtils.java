package org.donnchadh.projecteuler.utils;

import java.math.BigInteger;

public class BigIntegerUtils {

    public static int sumOfDigits(BigInteger number) {
        int sum = 0;
        do {
            sum += number.mod(BigInteger.TEN).intValue();
            number = number.divide(BigInteger.TEN);
        } while (number.bitLength() > 0);
        return sum;
    }

}
