package month4;

import java.io.*;
import java.io.InputStreamReader;


/**
 * @author beethoven
 * @date 2021-04-11 19:02:50
 */
public class ByteDance4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        while (x != 0) {
            int num = Integer.parseInt(bufferedReader.readLine());
            int[][] books = new int[num][5];
            int count = 0;
            while (count < num) {
                String[] s = bufferedReader.readLine().split(" ");
                for (int i = 0; i < s.length; i++) {
                    books[count][i] = Integer.parseInt(s[i]);
                }
                count++;
            }
            int[] res = new int[2];
            int max = findMax(books, res);
            System.out.println(max + " " + Math.min(res[0], res[1]) + " " + Math.max(res[0], res[1]));
            x--;
        }
    }
//    private static int findMax(int[][] books, int[] x) {
//        int res = 0;
//        for (int i = 0; i < books.length; i++) {
//            int temp = Integer.MAX_VALUE;
//            for (int j = i + 1; j < books.length; j++) {
//                for (int k = 0; k < 5; k++) {
//                    temp = Math.min(temp, Math.max(books[i][k], books[j][k]));
//                }
//                if (res < temp) {
//                    res = temp;
//                    x[0] = i + 1;
//                    x[1] = j + 1;
//                }
//            }
//        }
//        return res;
//    }
    private static int findMax(int[][] books, int[] x) {
        int res = 0;
        for (int i = 0; i < books.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < books.length; j++) {
                if (i != j) {
                    for (int k = 0; k < 5; k++) {
                        temp = Math.min(temp, Math.max(books[i][k], books[j][k]));
                    }
                    if (res < temp) {
                        res = temp;
                        x[0] = i + 1;
                        x[1] = j + 1;
                    }
                }
            }
        }
        return res;
    }
}