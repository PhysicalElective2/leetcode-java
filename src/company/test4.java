package company;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-10 11:21
 **/

import java.text.DecimalFormat;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if(i==1) System.out.println(1.00000);
        if(i==2) System.out.println(0.50000);
        int num = Math.round((i-2)/i);
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        String format = decimalFormat.format(1.0 * (i - 2) / i);
        System.out.println(format);
    }
}
