package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p011x;

public class Problem112 {
    public static void main(String[] args) {
        int bouncyCount = 0;
        for (int i = 100; i < 1000000000; i++) {
            int previousDigit = i%10;
            boolean up = false;
            boolean down = false;
            int x = i/10;
            while (x > 0) {
                if (x%10 > previousDigit) {
                    up = true;
                } else if (x%10 < previousDigit) {
                    down = true;
                }
                previousDigit = x%10;
                if (up && down) {
                    bouncyCount++;
                    break;
                }
                x /= 10;
            }
            if (bouncyCount*100 == i*99) {
                System.out.println(i);
                break;
            }
        }
        System.out.println(bouncyCount);
    }
}
