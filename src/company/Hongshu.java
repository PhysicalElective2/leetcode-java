package company;

import month4.Main4;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-11-05 14:25
 **/
public class Hongshu {
    public static  int res;
    public static void main(String[] args) {
//        var s="dfsd";

        int count =5;
        int[] nums =new int[]{1,2,3};
        res=-1;
        dfs(nums,count,0,0,0);
        System.out.println(res);


    }
    public static void dfs(int[] nums,int count,int num,int now,int index){
//        System.out.println("now:"+now);
//        System.out.println("index:"+index);
//        System.out.println("count:"+count);
//        System.out.println("num:"+num);
//        System.out.println();

        if(now==count){
            System.out.println(" should change");
            if(res>0){
                res= Math.min(res,num);
            }else {
                res=num;
            }

        }
        if(index>=nums.length){
            return;
        }
        dfs(nums,count,num+1,now+nums[index],index+1);
        dfs(nums,count,num,now,index+1);
    }
}
