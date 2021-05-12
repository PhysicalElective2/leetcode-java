package month5;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-06 10:02
 **/
public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n= arr.length;
        int[] xors =new int[n+1];
        for(int i=0;i<n;i++){
            xors[i+1] =xors[i]^ arr[i];

        }
        int m =queries.length;
        int[] ans =new int[m];
        for(int i=0;i<m;i++){
            ans[i]=xors[queries[i][0]]^xors[queries[i][1]+1];
        }
        return ans;


    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
    List<Integer> list;
    List<Integer> list2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       list =new ArrayList<>();
       list2=new ArrayList<>();
       dfs(root1);
       dfs2(root2);
       return list.equals(list2);


    }

    private void dfs2(TreeNode root) {

        if(root==null) return;
        if(root.right==null&&root.left==null){
            list2.add(root.val);
            return;
        }
        dfs2(root.right);
        dfs2(root.left);
    }

    private void dfs(TreeNode root1) {
        if(root1==null) return;
        if(root1.right==null&&root1.left==null){
            list.add(root1.val);
            return;
        }
        dfs(root1.right);
        dfs(root1.left);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] anoNums =nums.clone();
        Arrays.sort(anoNums);
        int start = anoNums.length;
        int end = 0;
        for(int i=0;i<anoNums.length;i++){
            if(anoNums[i]!=nums[i]){
                start=Math.min(start,i);
                end =Math.max(end,i);
            }
        }
        return (end-start>=0? end-start+1: 0);


    }
    public int deleteAndEarn(int[] nums) {
        int res=0;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum=new int[max+1];
        for(int val:nums){
            sum[val]+=val;
        }
        return rob(sum);
    }

    private int rob(int[] sum) {
        int size =sum.length;
        int first =sum[0];
        int second =sum[1];
        for(int i=2;i<size;i++){
            int temp=second;
            second=Math.max(second,first+sum[i]);
            first=temp;
        }
        return second;
    }

    public int[] decode(int[] encoded, int first) {
        int[] res=new int[encoded.length+1];
        res[0] =first;
        for(int i=1;i<res.length;i++){
            res[i]=res[i-1] ^ encoded[i-1];
        }
        return res;


    }

}
