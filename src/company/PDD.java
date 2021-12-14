package company;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-11 19:12
 **/
public class PDD {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int t =Integer.parseInt(scanner.nextLine());
        while (t-->0){
            int n=Integer.parseInt(scanner.nextLine());
            String[] nums= new String[n];
            int index=0;
            while (index<n){
                nums[index++]=scanner.nextLine();
            }
            boolean res=qu3(nums);
            if(res){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
    private static int pre;

    private static boolean qu3(String[] nums) {
        boolean res=true;
        if(nums.length<=1) return res;
        pre=0;
        for(int i=0;i<nums.length;i++){
            try {
                int num=Integer.parseInt(nums[i]);
                if(num<=pre){
                    res=false;
                    break;
                }
                pre=num;

            }catch (Exception e){
                int min =minFromString(nums[i]);
                int max =maxFromString(nums[i]);
                System.out.println("nums[i]:"+nums[i]);
                System.out.println(" max: "+max+" min: "+min);
                if(max<=pre){
                    res=false;
                    break;

                }
                if(min>pre){
                    pre=min;
                }else {
                    pre=pre+1;
                }

            }
            finally {
                System.out.println("pre now: "+pre);
            }
        }
        return res;
    }

    private static int minFromString(String num) {
        int res=0;
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            if('0'<=c&&c<='9'){
                res=res*10+c-'0';

            }else if(i==0) {
                res=1;
            }else {

                res=res*10;
            }
        }
        return res;
    }
    private static int maxFromString(String num) {
        int res=0;
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            if('0'<=c&&c<='9'){
                res=res*10+c-'0';
            }else{
                res=res*10+9;
            }
        }
        return res;
    }
}
