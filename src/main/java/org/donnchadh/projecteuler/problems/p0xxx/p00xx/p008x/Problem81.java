package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p008x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem81 {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[80][80];
        InputStream stream = Problem81.class.getClassLoader().getResourceAsStream(
                "org/donnchadh/projecteuler/problems/p0xxx/p00xx/p008x/matrix.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            for (int i = 0; i < matrix.length; i++) {
                String line = reader.readLine();
                String[] numbers = line.split(",");
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                }
            }
        } finally {
            stream.close();
        }
//        matrix = new int[][] { { 131, 673, 234, 103, 18 }, { 201, 96, 342, 965, 150 }, { 630, 803, 746, 422, 111 },
//                { 537, 699, 497, 121, 956 }, { 805, 732, 524, 37, 331 } };
        int[] currentRow = { matrix[0][0] };
        for (int i = 1; i < 2 * matrix.length - 1; i++) {
            int[] previousRow = currentRow;
            if (i < matrix.length) {
                currentRow = new int[i + 1];
            } else {
                currentRow = new int[2 * matrix.length - i - 1];
            }
            if (previousRow.length < currentRow.length) {
                currentRow[0] = previousRow[0] + matrix[i][0];
                for (int j = 1; j < currentRow.length - 1; j++) {
                    currentRow[j] = Math.min(previousRow[j - 1], previousRow[j]) + matrix[i - j][j];
                }
                currentRow[currentRow.length - 1] = previousRow[previousRow.length - 1] + matrix[0][i];
            } else {
                for (int j = 0; j < currentRow.length; j++) {
                    currentRow[j] = Math.min(previousRow[j], previousRow[j + 1])
                            + matrix[matrix.length - j - 1][i - matrix.length + j + 1];
                }
            }
        }
        System.out.println(currentRow[0]);
    }
}
