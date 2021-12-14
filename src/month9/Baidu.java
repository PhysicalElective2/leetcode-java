package month9;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-14 19:56
 **/
public class Baidu {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line=scanner.nextLine();
        int n=Integer.parseInt(line.split(" ")[0]);
        int k=Integer.parseInt(line.split(" ")[1]);
        int res=reverseNum(n);
        for(int i=2;i<=k;i++){
            res=Math.max(res,reverseNum(n*i));
        }
        System.out.println(res);
    }
    public static int reverseNum(int n){
        int res=0;
        while (n>0){
            res=res*10+n%10;
            n/=10;
        }
        return res;
    }
}
