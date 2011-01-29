package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p001x;

public class Problem14 {
    static int[] values = new int[1000000];
    
    public static void main(String[] args) {
        int max = 2;
        max = 0;
        for (int i = 2; i < 1000000; i++) {
            int count = 0;
            long x = i;
            while (x != 1 && (x >= values.length || values[(int)x] == 0)) {
                count++;
                if (x%2 == 0) {
                    x = x/2;
                } else {
                    x = 3*x + 1;
                }
            }
            values[i] = (x < values.length ? values[(int)x] : 0)+ count;
            if (values[i] > values[max]) {
                max = i;
            } 
        }
        System.out.println(max + "," + values[max]);
    }

    protected static int eval(int x, int steps, int start) {
        if (x <= 1) {
            return 0;
        }
        if (x >= values.length) {
            return x;
        }
        values[x] = steps + start;
        if (steps > 20) {
            return x;
        }
        int max = eval(x * 2, steps + 1, start);
        if (x >= 4 &&(x-1) % 3 == 0) {
            int max2 = eval((x-1)/3, steps + 1, start);
            if (max2 < values.length && max < values.length && values[max2] > values[max]) {
                max = max2;
            }
        }
        if (max >= values.length) {
            return x;
        }
        return max;
    }
}
