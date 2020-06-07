package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {
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

    public static void main(String[] args) {
        Solution10 s =new Solution10();
        System.out.println(s.threeSum(new int[]{0,0,0}));
    }


}
