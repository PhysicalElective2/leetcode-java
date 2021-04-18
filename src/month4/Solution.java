package month4;

import tools.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-15 21:05
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        //System.out.println(s.massage(new int[]{1,2,3,4}));
        int[] ints =new int[]{1,1,2};
        System.out.println(s.removeDuplicates(ints));
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int res=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[res]){
                continue;
            }else{
                nums[++res]=nums[i];
            }
        }
        return res+1;
    }
    public int[][] multiSearch(String big, String[] smalls) {
        int n=smalls.length;
        int[][] res=new int[n][];
        for(int i=0;i<n;i++){
            List<Integer> oneres=new ArrayList<>();
            int start =0;
            if(smalls[i].length()==0){
                res[i]=new int[0];
                continue;
            }
            while (start>=0&&start<big.length()){
                int oneoneres=big.indexOf(smalls[i],start);
                if(oneoneres>=0){
                    oneres.add(oneoneres);
                    start=oneoneres+1;
                }else {
                    start=-1;
                }

            }
            int[] onearray =new int[oneres.size()];
            for(int ii=0;ii<oneres.size();ii++){
                onearray[ii]=oneres.get(ii);
            }
            res[i]=onearray;
        }
        return res;

    }
    public int massage(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp =new int[nums.length];
        dp[0] =nums[0];
        dp[1] =Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);

        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);

    }

    public int leastInterval(char[] tasks, int n) {
       Map<Character,Integer> map=new HashMap<>();
       if(n==0) return tasks.length;
       for(int i=0;i<n;i++){
           Integer num =map.getOrDefault(tasks[i],0)+1;
           map.put(tasks[i],num);
       }
       int m=map.size();
       List<Integer> nextValid=new ArrayList<>();
       List<Integer> rest=new ArrayList<>();
        for (Map.Entry<Character, Integer> entry :  map.entrySet()) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }
        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid =Integer.MAX_VALUE;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best =-1;
            for(int j=0;j<m;j++){
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best,time+n+1);
            rest.set(best,rest.get(best)-1);


        }
        return time;


    }
    public String largestNumber(int[] nums) {
        StringBuilder res=new StringBuilder();

        List<String> list =new ArrayList<>();
        for(int i:nums){
            list.add(String.valueOf(i));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(list.get(0).equals("0")){
            return "0";
        }
        for(String i:list){
            res.append(i);

        }
        return res.toString();


    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet=new TreeSet<Long>();
        //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
        for(int i=0;i<nums.length;i++){
            Long  ceil =treeSet.ceiling((long)nums[i]-(long)t);
            if(ceil!=null&&ceil<=(long) nums[i]+t){
                return true;
            }
            treeSet.add((long) nums[i]);
            if(treeSet.size()>k){
                treeSet.remove((long) nums[i-k]);
            }
        }
        return false;
    }
    Map<TreeNode,Integer> f=new HashMap<>();
    Map<TreeNode,Integer> n=new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),n.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        dfs(root.right);
        f.put(root,root.val+n.getOrDefault(root.left,0)+n.getOrDefault(root.right,0));
        n.put(root,Math.max(f.getOrDefault(root.left,0),n.getOrDefault(root.left,0))+
                Math.max(f.getOrDefault(root.right,0),n.getOrDefault(root.right,0)));
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
