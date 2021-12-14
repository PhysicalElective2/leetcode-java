package last;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-23 18:00
 **/
public class Honor31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[m][];
        int index = 0;
        while (index < m) {

            String line = scanner.nextLine();
            int n = line.length();
            matrix[index] = new char[n];
            for (int i = 0; i < n; i++) {
                matrix[index][i] = line.charAt(i);
            }
            index++;

        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(maximalSquare(matrix));

    }

    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


}
