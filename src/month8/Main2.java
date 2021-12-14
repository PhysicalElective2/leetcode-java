package month8;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 19:24
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line =scanner.nextLine();
        int n= Integer.valueOf(line.split(" ")[0]);
        int t= Integer.valueOf(line.split(" ")[1]);
        int c= Integer.valueOf(line.split(" ")[2]);
        int[] nums=new int[n];

        line =scanner.nextLine();
        String[] sline =line.split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(sline[i]);
        }
        int res=0;
        int left =0;
        boolean flag =true;
        for(int i=0;i<n;i++){
           if(nums[i]>t){
               int len = i-left;
               if(len>=c){
                   res+=len-c+1;
               }
               while (i<n){
                   if(nums[i]<=t){
                       left=i;
                       break;
                   }
                   i++;
               }
           }else {
               flag=false;
           }

           }
        if(flag&&n-left>=c){
            res+=n-left-c+1;
        }
        System.out.println(res);

    }
}
