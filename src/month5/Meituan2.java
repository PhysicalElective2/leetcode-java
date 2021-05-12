package month5;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-09 10:55
 **/
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t =Integer.valueOf(sc.nextLine());
        while (t-->0){
            String[] line =sc.nextLine().split(" ");
            int x,a,b,n;
            x=Integer.parseInt(line[0]);
            a=Integer.parseInt(line[1]);
            b=Integer.parseInt(line[2]);
            n=Integer.parseInt(line[3]);
            int res= qu2(x,a,b,n);
            System.out.println(res);
        }

    }
    public  static  int res;
    private static int qu2(int x, int a, int b, int n) {
        res=Integer.MIN_VALUE;
        //practice
        dfs(1,x,a,b,n,0);
        return res;

    }

    private static void dfs(int i, int x, int a, int b, int n, int get) {

        if(i>n){
            return;
        }

        int tempget=get;
        int tempx=x;
        //prectice
        get+=x;
        if(x>=a){
            x-=a;
        }else {
            x=0;
        }

        res=Math.max(res,get);
        dfs(i+1,x,a,b,n,get);
        // rest
        x=tempx+b;
        dfs(i+1,x,a,b,n,tempget);

    }
}
