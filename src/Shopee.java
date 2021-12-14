import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-29 20:04
 **/
public class Shopee {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String m =sc.nextLine();
//        String n =sc.nextLine();
        String m = "a?**c#";
        String n = "accccc";
        res2 = 0;
        qu2(m, n, 0, 0);
        System.out.println(res2);
    }

    public static int res2 = 0;

    public static void qu2(String m, String n, int i, int j) {
        if (i == m.length() && j == n.length()) {
            res2 = 1;
            return;
        }
        if (i == m.length() || j == n.length()) {
            return;
        }

        while (i < m.length() && j < n.length()) {
//            System.out.println("i:" + i);
//            System.out.println("j:" + j);
            if (m.charAt(i) == n.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (m.charAt(i) == '?') {
                i++;
                j++;
                continue;
            }
            if (m.charAt(i) == '#') {
                // 0 or 1
                i++;
                qu2(m, n, i, j);
                j++;
                qu2(m, n, i, j);
                continue;
            }
            if (m.charAt(i) == '*') {
                i++;
                qu2(m, n, i, j);
                char c = n.charAt(j);
                while (j + 1 < n.length() && n.charAt(j + 1) == c) {
                    j++;
                    qu2(m, n, i, j);
                }
                continue;
            }

        }
        if (i == m.length() && j == n.length()) {
            res2 = 1;
            return;
        }

    }

    public static String qu2(int num) {
        StringBuilder res = new StringBuilder();
        if (num == 0) return "0";
        int count = 0;
        boolean po = true;
        if (num < 0) {
            po = false;
            num = -num;
        }
        while (num > 0) {
            if (count == 3) {
                res.append(",");
                count = 0;
                continue;
            } else {
                int oneNum = num % 10;
                num /= 10;
                res.append(oneNum);
                count++;
            }
        }
        if (!po) {
            res.append("-");
        }
        return res.reverse().toString();
    }

}
