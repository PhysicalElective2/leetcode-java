package last;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-24 10:46
 **/
public class Meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        int kk = k;
        int[][] m = new int[n][n];
        while (k-- > 0) {
            line = scanner.nextLine();
            int x1 = Integer.parseInt(line.split(" ")[0]);
            int y1 = Integer.parseInt(line.split(" ")[1]);
            int x2 = Integer.parseInt(line.split(" ")[2]);
            int y2 = Integer.parseInt(line.split(" ")[3]);
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    m[i][j] += 1;
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                map.put(m[i][j], map.getOrDefault(m[i][j], 0) + 1);
            }
        }

        for (int i = 0; i <= kk; i++) {
            System.out.print(map.get(i));
            if (i != kk - 1) {
                System.out.print(" ");
            }

        }

    }
}
