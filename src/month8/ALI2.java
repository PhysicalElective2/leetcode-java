package month8;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-13 19:38
 **/
public class ALI2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line =scanner.nextLine();
        int n= Integer.parseInt(line.split(" ")[0]);
        int l= Integer.parseInt(line.split(" ")[1]);
        int r= Integer.parseInt(line.split(" ")[2]);
        System.out.println(qu(n,l,r));
    }

    private static Integer qu(int n, int l, int r) {
        return 0;
    }


}
