package month8;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-13 18:58
 **/
public class ALI {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
         int n=Integer.parseInt(scanner.nextLine());
        List<Integer> list =new ArrayList<>();
         while (n-->0){
             list.add(scanner.nextInt());
         }
        System.out.println(qu1(list));

    }

    private static int qu1(List<Integer> list) {
        int[] sum=new int[list.size()];
        for(int i=0;i<list.size();i++){
            if(i==0){
                sum[i]=list.get(i);
            }else {
                sum[i]=list.get(i)+sum[i-1];
            }
        }
        int max= Integer.MIN_VALUE;
        int res=1;
        for(int i=0;i<sum.length;i++){
            if(sum[i]*(sum[sum.length-1]-sum[i])>max){
                res=i+1;
                max=sum[i]*(sum[sum.length-1]-sum[i]);
            }
        }
        return res;
    }


}
