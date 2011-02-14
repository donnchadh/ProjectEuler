package org.donnchadh.projecteuler.problems.p0xxx.p01xx.p010x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem102 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        InputStream stream = Problem102.class.getClassLoader().getResourceAsStream(
                "org/donnchadh/projecteuler/problems/p0xxx/p01xx/p010x/triangles.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = reader.readLine();
            while (line != null) {
                String[] numbers = line.split(",");
                int[][] points = new int[numbers.length/2][2];
                for (int i = 0; i < numbers.length; i++) {
                    points[i/2][i%2] = Integer.parseInt(numbers[i]);
                }
                int gc = 0;
                int lc = 0;
                for (int i = 0; i < points.length; i++) {
                    int test = points[(i+1)%points.length][0] * points[i][1] - points[(i+1)%points.length][1] * points[i][0];
                    if (test > 0) {
                        gc++;
                    } else if (test < 0) {
                        lc++;
                    }
                }
                if (gc == points.length || lc == points.length) {
                    count++;
                }
                line = reader.readLine();
            }
        } finally {
            stream.close();
        }
        System.out.println(count);
    }
}
