package month8;

import company.ListNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 15:57
 **/
public class Solution {
    private int[] twoSum(int[] nums,int target){
        int[] res=new int[2];
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while (i<j&&i<nums.length&&j>=0){
            int sum=nums[i]+nums[j];
            if(sum==target){
                res[0]=i;
                res[1]=j;
                break;

            }
            if(sum>target){
                j--;

            }else {
                i++;
            }
        }
        return res;
    }
    private int[] twoSum2(int[] nums,int target){
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
//    private int maxGet(int[] prices){
//
//        int[] dp =new int[prices.length];
//        int max=Integer.MIN_VALUE;
//
//        for(int i=1;i<prices.length;i++){
//            int get =Math.max(dp[i-1],)
//            dp[i]=Math.max(dp[i-1],)
//
//        }
//
//    }


    public static void main(String[] args) {
        Solution s=new Solution();
        int[] res=s.twoSum2(new int[]{1,2,3,4,5},5);
        System.out.println(res[0]+" "+res[1]);
    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments=new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments= new int[SEG_COUNT];
        dfs(s,0,0);

        return ans;

    }

    private void dfs(String s, int count,int index) {
        if(count==SEG_COUNT){
            if(index==s.length()){
                StringBuilder oneAdd =new StringBuilder();
                for (int i=0;i<SEG_COUNT;i++){
                    oneAdd.append(segments[i]);
                    if(i!=SEG_COUNT-1){
                        oneAdd.append(".");
                    }
                }
                ans.add(oneAdd.toString());
            }
            return;

        }
        if(index==s.length()){
            return;
        }
        if(s.charAt(index)=='0'){
            segments[count]=0;
            dfs(s,count+1,index+1);
        }
        int addr = 0;
        for (int segEnd = index; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[count] = addr;
                dfs(s,count + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }

}
