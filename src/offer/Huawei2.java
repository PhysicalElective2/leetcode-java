package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-18 19:14
 **/

public class Huawei2 {
    private static int res;
    public static void main(String[] args) {
        Map<Integer ,Integer> map =new HashMap<>();
        Scanner sc =new Scanner(System.in);
        String line =sc.nextLine();
        int x=Integer.parseInt(line.split(" ")[0]);
        int m=Integer.parseInt(line.split(" ")[1]);
        line=sc.nextLine();
        int[] nums=new int[m];
        int index=0;
        res=0;
        for(String s:line.split(" ")){
            nums[index++] =Integer.parseInt(s);
        }
        qu2(nums,x,0);
        System.out.println(res==0?-1:res);

    }
    public static void qu2(int[] nums){

        Map<Integer ,Integer> map =new HashMap<>();
        map.put(nums[0],1);
        for(int i=1;i<nums.length;i++){
//            map.put()
        }

    }

    private static void qu2(int[] nums, int rest,int index) {
        if(rest==0){
            res++;
            return;
        }
        if(rest<0){
            return;
        }
        if(index>=nums.length)return;
        qu2(nums,rest,index+1);
        qu2(nums,rest-nums[index],index+1);

    }


}
