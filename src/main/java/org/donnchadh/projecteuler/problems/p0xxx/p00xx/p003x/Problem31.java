package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;


public class Problem31 {
    private static final int[] coins = {1,2,5,10,20,50,100,200};
    
    public static void main(String[] args) {
        System.out.println(solve(coins,200));
    }
    private static int solve(int[] coinsToUse, int sum) {
        int total = 0;
        int[][] p = combinations(coinsToUse);
        for (int i = 0; i < p.length; i++) {
            total += solve2(p[i], sum);
        }
        return total;
    }
        
    private static int solve2(int[] coinsToUse, int sum) {
        if (coinsToUse.length == 1) {
            return (sum % coinsToUse[0]) == 0 ? 1 : 0;
        }
        int x = sum(coinsToUse);
        if (sum > x) {
            return solve(coinsToUse, sum - x);
        }
        return 0;
    }
    protected static int sum(int[] coinsToUse) {
        int x = 0;
        for (int c : coinsToUse) {
            x += c;
        }
        return x;
    }

    private static int[][] combinations(int[] coinsToUse) {
        int n = coinsToUse.length;
        int num = 0;
        for (int r = 1; r <= n; r++) {
            num += factorial(n) / (factorial(r) * factorial(n - r));
        }
        int[][] combinations = new int[num][];
        int nextIndex = 0;
        for (int r = 1; r <= n; r++) {
            int[] a = new int[r];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            long total = factorial(n) / (factorial(r) * factorial(n - r));
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
                    combinations[nextIndex][i] = coinsToUse[a[i]];
                }
                numLeft--;
                nextIndex++;
            }
        }

        return combinations;
    }   
    
    private static long factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
