package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p004x;

public class Problem40 {
    public static void main(String[] args) {
        int result = 1;
        long j = 0;
        long k = 1;
        int i = 0;
        long k2 = 1;
        int i2 = 1;
        while (k <= 1000000L) {
            System.out.print(k);
            System.out.print(" ");
            System.out.print(j);
            System.out.print(" ");
            i2 = i+1;
            long n = (k2 - 1) + (k - j)/i2;
            int m = (int) ((k - j) % i2);
            if (m != 0) {
                n++;
                m--;
            } else {
                m = i;
            }
            long pos = j+(n-(k2-1))*(i+1)+m;
            System.out.print(pos);
            System.out.print(" ");
            System.out.print(n);
            System.out.print(" ");
            System.out.print(m);
            System.out.print(" ");
            long x = n;
            for (int y = 0; y < i-m; y++) {
                x /= 10;
            }
            int d = (int) (x % 10);
            System.out.print(d);
            result *= d;
            long nextJ = j;
            int oldI = i;
            long oldK2 = k2;
            do {
                nextJ += k2*9*(i+1);
                k2*= 10;
                i++;
            } while (nextJ < k);
            k *= 10;
            i2++;
            if (nextJ < k) {
                j = nextJ;
            } else {
                i = oldI;
                k2 = oldK2;
            }
            System.out.println();
        }
        System.out.println(result);
    }
}
