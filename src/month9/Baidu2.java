package month9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-14 20:15
 **/
public class Baidu2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int q = Integer.parseInt(line.split(" ")[1]);
        line = scanner.nextLine();
        String[] s = line.split(" ");
        int[] ii = new int[n];
        Arrays.fill(ii, 1);
//        int[] space=new int[s.length];
        for(int j=0;j<ii.length;j++){
            System.out.print(" "+ii[j]);
        }
        System.out.println();
        for (int i = 0; i < s.length; i++) {
            int moveNum = Integer.parseInt(s[i]);
            int count = 0;
            int index =0;
            for(int iii=0;iii<=ii.length&&count<moveNum;iii++){
                if(ii[iii]==1){
                    count++;
                }
            }
            while (count < moveNum-1) {
                if(ii[index]==1){
                    count++;
                }
                index++;
            }
            System.out.println("index: "+index);
            for(int j=0;j<moveNum;j++){
                ii[j]=1;
            }
            for(int j=moveNum;j<=index;j++){
                ii[j]=0;
            }
            System.out.println("one res: "+index);
            for(int j=0;j<ii.length;j++){
                System.out.print(" "+ii[j]);
            }
            System.out.println();

        }

    }
}
