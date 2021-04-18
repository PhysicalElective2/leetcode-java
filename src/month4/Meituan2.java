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

    public static void main(String[] args) throws IOException {
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
