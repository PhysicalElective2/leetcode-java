package company;

import java.util.ArrayList;
import java.util.List;

public class TencentSolution {
    public int[] twoSum(int[] nums, int target) {
//        List<Integer> res=new ArrayList<Integer>();
        int[] res={-1,-1};

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;



    }

    public static void main(String[] args) {
        TencentSolution t =new TencentSolution();

        int[]  res=t.twoSum(new int[]{2, 7, 11, 15},9);
        for (int i = 0; i <res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
