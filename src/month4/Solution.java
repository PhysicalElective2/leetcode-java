package month4;

import java.util.Map;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-15 21:05
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int n=nums.length;
        int[] dp =new int[n];
        dp[0] =nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] =Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    public int rob2(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int n=nums.length;
        int[] dp =new int[n];
        dp[0] =nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i=2;i<n-1;i++){
            dp[i] =Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
//        return dp[n-1];
        int[] dp2 =new int[n];
        dp2[0] =0;
        dp2[1] =nums[1];
        for(int i=2;i<n;i++){
            dp2[i] =Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(dp[n-2],dp2[n-1]);

    }
}
