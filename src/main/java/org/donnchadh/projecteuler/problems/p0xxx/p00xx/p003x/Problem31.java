package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p003x;

import org.donnchadh.projecteuler.utils.Combinations;



public class Problem31 {
    private static final int[] coins = {1,2,5,10,20,50,100,200};
    
    public static void main(String[] args) {
        System.out.println(solve(coins, 200));
    }

    private static int solve(int[] coinsToUse, int sum) {
        if (sum == 0) {
            return 1;
        }
        int total = 0;
        int[][] p = Combinations.combinations(coinsToUse);
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
        if (sum >= x) {
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
}
