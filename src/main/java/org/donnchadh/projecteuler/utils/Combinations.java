package org.donnchadh.projecteuler.utils;

public class Combinations {

    public static int[][] combinations(int[] values) {
        int n = values.length;
        int num = 0;
        for (int r = 1; r <= n; r++) {
            num += Factorials.factorial(n) / (Factorials.factorial(r) * Factorials.factorial(n - r));
        }
        int[][] combinations = new int[num][];
        int nextIndex = 0;
        for (int r = 1; r <= n; r++) {
            int[] a = new int[r];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            long total = Factorials.factorial(n) / (Factorials.factorial(r) * Factorials.factorial(n - r));
            long numLeft = total;
            while (numLeft > 0) {
                if (numLeft != total) {
                    int i = r - 1;
                    while (a[i] == n - r + i) {
                        i--;
                    }
                    a[i] = a[i] + 1;
                    for (int j = i + 1; j < r; j++) {
                        a[j] = a[i] + j - i;
                    }
                }
                combinations[nextIndex] = new int[r];
                for (int i = 0; i < a.length; i++) {
                    combinations[nextIndex][i] = values[a[i]];
                }
                numLeft--;
                nextIndex++;
            }
        }
    
        return combinations;
    }

}
