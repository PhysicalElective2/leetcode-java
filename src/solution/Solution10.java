package solution;

import java.util.*;

public class Solution10 {
    //整数转化为罗马数字
    public String intToRoman(int num) {
        StringBuilder res =new StringBuilder();
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int j=0;
        while(num>0){
            if(num>=nums[j]){
                num=num-nums[j];
                res.append(strs[j]);
            }else {
                j++;
            }
        }
        return res.toString();

    }
    /**
     * 12.15开始
     * 三数之和为0
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>(); // 也可以用于初始化
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    res.add(curr);
                    j++;
                    k--;
                    while (j < k & nums[j] == nums[j - 1]) j++;
                    while (k > j & nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;

                } else {
                    j++;
                }
            }


        }
        return res;


    }
    public int threeSumClosest(int[] nums, int target) {
        //最接近的三数之和,排序后遍历
        //可以打表
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            int thisRes=res;
            while (j<k){
                thisRes=nums[i]+nums[j]+nums[k];
                if(thisRes==target){
                    return target;
                }else if(thisRes<target){
                    j++;
                }else {
                    k--;
                }
                res=Math.abs(res-target)<Math.abs(thisRes-target)?res:thisRes;

            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution10 s =new Solution10();
//        System.out.println(s.threeSum(new int[]{0,0,0}));
        System.out.println(s.intToRoman(1994));
    }


}
