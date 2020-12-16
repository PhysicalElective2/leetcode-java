package company;


import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TencentSolution3 {
    public int maxPathSum(TreeNode root) {
        List<Integer> num =new ArrayList<>();
        dfs(root,num);
        int[] dp =new int[num.size()];
        dp[0] =num.get(0);
        int res=dp[0];

        for(int i=1;i<dp.length;i++){
            System.out.println(num.get(i));
            dp[i]=Math.max(dp[i-1]+num.get(i),num.get(i));
            res=Math.max(res,dp[i]);
        }
        return dp[num.size()-1];


    }
    public void dfs(TreeNode node, List num){
        num.add(node.val);
        if(node!=null){
            num.add(node.val);
            dfs(node.left, num);
            dfs(node.right, num);
        }else {
            num.add(Integer.MIN_VALUE);
        }

    }

//    public int search(int[] nums, int target) {
//        int n= nums.length;
//        if(n==0){
//            return -1;
//        }
//        if(n==1) return nums[0]==target?0:-1;
//        int l=0,r=n-1;
//        while (l<=r){
//            int mid =(l+r)/2;
//            if(nums[mid]==target) return mid;
//            if(nums[0]<=nums[mid]){
//                // front is in order
//                if(nums[0]<=target&&target<nums[mid]){
//                    r=mid-1;
//                }else {
//                    l=mid+1;
//                }
//
//            }else {
//                if (nums[mid] < target && target <= nums[n - 1]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//
//
//            }
//
//        }
//        return -1;
//
//
//    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = len-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){//mid左侧为有序数组
                if(nums[left] <= target && nums[mid] >= target){//如果target在mid左侧的话
                    right = mid-1;
                }else{//在mid右侧
                    left = mid+1;
                }
            }else{//mid右侧为有序数组
                if(nums[mid] <= target && nums[right] >= target){//如果target在mid右侧的话
                    left = mid+1;
                }else{//在mid左侧
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
