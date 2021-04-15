package month4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author beethoven
 * @date 2021-04-11 19:02:50
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author beethoven
 * @date 2021-04-11 19:02:50
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author beethoven
 * @date 2021-04-11 19:02:50
 */
public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        int x = Integer.parseInt(bufferedReader.readLine());

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < b.length(); i++) {
            set1.add(b.charAt(i));
            dp[0][i + 1] = set1.size();
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
            dp[i + 1][0] = set.size();
            Set<Character> temp = new HashSet<>(set);
            for (int j = 0; j < b.length(); j++) {
                temp.add(b.charAt(j));
                dp[i + 1][j + 1] = temp.size();
            }
        }

        while (x != 0) {
            String s = bufferedReader.readLine();
            String[] s1 = s.split(" ");
            int i = Integer.parseInt(s1[0]);
            int j = Integer.parseInt(s1[1]);
            System.out.println(dp[i][j]);
            x--;
        }
    }
}