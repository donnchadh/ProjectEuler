package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p000x;

public class Problem4 {
    public static void main(String[] args) {
        boolean found = false;
        for (int i = 999; i > 99 && !found; i--) {
            int p = i *1000 + ((i/100)%10) + ((i/10)%10)*10 + (i%10)*100;
            for (int j = 999; j > 99; j--) {
                if (p%j == 0 && p/j > 99 && p/j <= 999) {
                    found = true;
                    System.out.print(p);
                    break;
                }
            }
        }
    }
}
