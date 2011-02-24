package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p011x;

public class Problem113 {
    public static void main(String[] args) {
        long[] downValues = {1,1,1,1,1,1,1,1,1,1};
        long[] upValues = {1,1,1,1,1,1,1,1,1};
        long total = 9;
        for (int i = 1; i < 100; i++) {
            long sum = 1;
            for (int j = 1; j < downValues.length; j++) {
                downValues[j] = downValues[j] + downValues[j-1];
                sum += downValues[j];
            }
//            System.out.println(sum);
            for (int j = 1; j < upValues.length; j++) {
                upValues[j] = upValues[j] + upValues[j-1];
                sum += upValues[j];
            }
            sum -= 9;
            total += sum;
        }
        System.out.println(total);
    }
}
