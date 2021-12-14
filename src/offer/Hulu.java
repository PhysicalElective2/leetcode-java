package offer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-26 19:00
 **/
public class Hulu {
    public  static int lastNum=-1;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line = scanner.nextLine();
        p =Integer.parseInt(line.split(" ")[0]);
        int a =Integer.parseInt(line.split(" ")[1]);
        int b =Integer.parseInt(line.split(" ")[2]);
        int res=init(b)-init(a);
        System.out.println(res);
//        int res=0;
//
//        for(int i=a;i<=b;i++){
//            if(sophie(i,N)){
//                res++;
//
//            }
//
//        }
//        System.out.println(res);

    }
    public static int[][] dp=new int[30][110];
    public static int p;
    public static int[] a=new int[30];
    public static int[] b=new int[30];
    public static int dfs(int pos,int pre, boolean limit){
        if(pos!=0){
            if(pre%p==0){
                return 1;
            }else {
                return 0;
            }
        }
        if(!limit&& dp[pos][pre]!=-1){
            return dp[pos][pre];
        }
        int up;
        if(limit){
            up=a[pos];
        }else {
            up=9;
        }
        int ans=0;
        for(int i=0;i<=up;i++){
            ans+=dfs(pos-1,pre+i%p,limit&&i==up);
        }
        if(!limit){
            dp[pos][pre]=ans;
        }
      return ans;
    }

    public static int init(int n){
        int len =0;
        while (n>0){
            a[++len] =n%10;
            n/=10;
        }
        return dfs(len,0,true);
    }
    public static  boolean sophie(int num,int N){
        if(lastNum==-1||num%10==0){
            System.out.println("+");
            int sum =0;
            while (num>0){
                sum+=num%10;
                num/=10;
            }
            lastNum=sum;
            return sum%N==0;

        }else {
            System.out.println("-");
            lastNum=lastNum+1;
            return lastNum%N==0;
        }

    }
}
