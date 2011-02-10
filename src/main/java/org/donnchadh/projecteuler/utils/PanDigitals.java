package org.donnchadh.projecteuler.utils;

public class PanDigitals {

    public static boolean isPanDigital(int i) {
        int mask = 0;
        int x = i;
        boolean panDigital = true;
        int j;
        for (j = 0; j <9 && x > 0; j++) {
            if ((x%10) != 0) {
                int maskBefore = mask;
                mask |= (1 << (x%10));
                if (maskBefore == mask) {
                    panDigital = false;
                    break;
                }
            } else {
                panDigital = false;
                break;
            }
            x /= 10;
        }
        if (mask != (1<<(j+1))-2) {
            panDigital = false;
        }
        return panDigital;
    }

}
