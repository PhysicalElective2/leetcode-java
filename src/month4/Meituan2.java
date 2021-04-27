package month4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-18 10:09
 **/
public class Meituan2 {
    public static void main(String[] args) {
        Boolean a=true;
        System.out.println(System.identityHashCode(Boolean.TRUE));
        Boolean b=false;
        Boolean c=new Boolean(true);
        Boolean d=new Boolean(false);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println();
        a=!a;
        b=!b;
        c=!c;
        d=!d;
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
    }
    // 回溯
    int res;
    public  int res(int[] nums,int n){
        //求和 为sum
        // 找到最长的 连续序列使得 和为 sum-n

        int sum =0;
        for(int i:nums){
            sum+=i;
        }
        int toSum =sum-n;
        int i=0;
        int j=1;
        int nowSum=nums[0];
        return sum;
    }
    public void dfs(int i,int j,int[] num,int n){
        if(i>j){

        }


    }

    public static void maidn(String[] args) throws IOException {
        //this.hashCode();
        BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
        String s=buf.readLine();
        String[] s1=s.split(" ");
        long n=Long.parseLong(s1[0]);
        long m=Long.parseLong(s1[1]);
        long k=Long.parseLong(s1[2]);
        long sumA=0,sumB=0;
        for(int i=0;i<n;i++){
            String[] temp=buf.readLine().split(" ");
            if(Integer.parseInt(temp[1])>=k){
                sumA+=Long.parseLong(temp[0])*Long.parseLong(temp[1]);
            }
        }
        for(int i=0;i<m;i++){
            String[] temp=buf.readLine().split(" ");
            if(Integer.parseInt(temp[1])>=k){
                sumB+=Long.parseLong(temp[0])*Long.parseLong(temp[1]);
            }
        }
        System.out.println(sumA+" "+sumB);
        System.out.println(sumA>sumB?"A":"B");



    }

}
