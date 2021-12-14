package last;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-08 20:09
 **/
public class Ali1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line =scanner.nextLine();
        int t=Integer.parseInt(line);
        while (t-->0) {
            line=scanner.nextLine();

            String sa =line.split(" ")[0];
            String sb =line.split(" ")[1];
            int a = (int) Long.parseLong(sa, 2);
            int b = (int) Long.parseLong(sb, 2);
            System.out.println(a + b);
            /*
            2
            00000000000000000000000000000101
            11111111111111111111111111111111
            00000000000000000000000000011111
            00000000000000000000000000000111

             */
        }

    }
}
