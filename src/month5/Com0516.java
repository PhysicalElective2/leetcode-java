package month5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-16 10:19
 **/
public class Com0516 {
    public static void main(String[] args) {

    }
    public int minSwaps(String s) {
        int res =0;
        int sumZero=0;
        int sunOne=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                sumZero++;
            }else {
                sunOne++;
            }
        }
        if(Math.abs(sumZero-sunOne)>1) return -1;
        if(sumZero>sunOne){
            for(int i=0;i<s.length();i+=2){
                if(s.charAt(i)!='0') res++;
            }

        }else if(sunOne>sumZero){
            for(int i=0;i<s.length();i+=2){
                if(s.charAt(i)!='1') res++;
            }
        }else {
            //sum zero == sumOne
            int zeroFirstNum =0;
            int oneFirstNum =0;
            for(int i=0;i<s.length();i+=2){
                if(s.charAt(i)!='0') zeroFirstNum++;

            }
            for(int i=0;i<s.length();i+=2){
                if(s.charAt(i)!='1') oneFirstNum++;

            }
            res=Math.min(zeroFirstNum,oneFirstNum);
        }
        return res;

    }

    public static int res;
    public int subsetXORSum(int[] nums) {
        res=0;
        int XORNow=0;
        dfs(nums,0,XORNow);
        return res;

    }

    private void dfs(int[] nums, int i,int XORNow) {
        if(i>=nums.length){
            res+=XORNow;
            return;
        }
        dfs(nums,i+1,XORNow);
        dfs(nums,i+1,XORNow ^nums[i]);


    }
}
