package month4;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-29 19:43
 **/

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author beethoven
 * @date 2021-04-29 19:08:36
 */
public class TenXun {

    private static int count, n, m;
    private static int[] x = new int[]{1, -1, 0, 0};
    private static int[] y = new int[]{0, 0, 1, -1};
    private static int[][] g;
    private static boolean[][] isChecked;

    //    private static void bfs(int indexX, int indexY) {
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        queue.offer(new Pair<>(indexX, indexY));
//        isChecked[indexX][indexY] = true;
//        while (!queue.isEmpty()) {
//            Pair<Integer, Integer> index = queue.poll();
//            Integer tempX = index.getKey();
//            Integer tempY = index.getValue();
//            for (int i = 0; i < x.length; i++) {
//                int nextX = tempX + x[i], nextY = tempY + y[i];
//                if (isPossible(nextX, nextY, indexX, indexY)) {
//                    isChecked[tempX + x[i]][tempY + y[i]] = true;
//                    queue.offer(new Pair<>(nextX, nextY));
//                    count--;
//                }
//            }
//        }
//    }
    private static void bfs(int indexX, int indexY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{indexX, indexY});
        isChecked[indexX][indexY] = true;
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int tempX = index[0], tempY = index[1];
            for (int i = 0; i < x.length; i++) {
                int nextX = tempX + x[i], nextY = tempY + y[i];
                if (isPossible(nextX, nextY, indexX, indexY)) {
                    isChecked[tempX + x[i]][tempY + y[i]] = true;
                    queue.offer(new int[]{nextX, nextY});
                    count--;
                }
            }
        }
    }

    private static boolean isPossible(int nextX, int nextY, int indexX, int indexY) {
        return nextX < n && nextX >= 0 && nextY >= 0 && nextY < m && !isChecked[nextX][nextY] && g[indexX][indexY] == g[nextX][nextY];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        g = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < s1.length; j++) {
                g[i][j] = Integer.parseInt(s1[j]);
            }
        }

        count = n * m;
        isChecked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isChecked[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}
