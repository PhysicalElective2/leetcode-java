package month4;

import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-15 21:05
 **/
public class Solution {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
    public void  dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc =grid[0].length;
        if(r<0||r>=nr||c<0||c>=nc||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<Integer> list = new ArrayList<>();
       return false;



    }
    public int numIslands(char[][] grid) {
        if (grid == null||grid.length==0||grid[0].length==0) {
            return 0;
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;



    }
    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }

    public int reverse(int x) {
        int res=0;
        while (x!=0){
            if((res*10)/10 !=res){
                res=0;
                break;
            }
            res =res*10 + x%10;
            x/=10;
        }
        return res;

    }


    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map =new HashMap();
        for(List<Integer> w:wall){
            int sum=0;
            for(int i=0;i<w.size()-1;i++){
                sum+=w.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int max=0;
        for(Integer i:map.values()){
            max=Math.max(max,i);
        }
        return wall.size()-max;

    }
    public boolean canCross(int[] stones) {
        boolean res=true;
        boolean[] river=new boolean[stones.length];
        river[0]=true;
        return res;

    }
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<32;i++){
            int total =0;
            for(int num:nums){
                total+=((num>>i)&1);
            }
            if(total%3!=0){
                res|=(1<<i);
            }
        }
        return  res;
    }



    public static void main(String[] args) {
        Meituan m=new Meituan();
        System.out.println(m.val);
    }
    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int res=0;
        if(root.val>=low&&root.val<=high){
            res+=root.val;
        }
        res+=rangeSumBST(root.left,low,high);
        res+=rangeSumBST(root.right,low,high);
        return res;

    }
    public boolean judgeSquareSum(int c) {
       long left =0;
       long right =(long) Math.sqrt(c);
       while (left<=right){
           long sum =left*left+right*right;
           if(sum==c){
               return true;
           }else if(sum>c){
               right--;
           }else {
               left++;
           }

       }
       return false;
    }

    private int dfs(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int res=0;
        if(root.val>=low&&root.val<=high){
            res+=root.val;
        }
        res+=dfs(root.left,low,high);
        res+=dfs(root.right,low,high);
        return res;
    }

    public int findUnsortedSubarray(int[] nums) {
        int res=0;
        if(nums.length<=1) return res;
        return res;


    }
    public int shipWithinDays(int[] weights, int D) {
        int left =Arrays.stream(weights).max().getAsInt();
        int right =Arrays.stream(weights).sum();
        while (left<right){
            int mid =(left+right)/2;
            int need =1;
            int cur=0;
            for(int w:weights){
                if(cur+w>mid){
                    ++need;
                    cur=0;
                }
                cur+=w;
            }
            if(need<=D){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;

    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    dp[i] +=dp[i-num];
                }
            }
        }
        return dp[target];
    }
    private TreeNode resNode;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummpyNode =new TreeNode(-1);
        resNode =dummpyNode;
        inOrder(root);
        return dummpyNode.right;
    }
    public void inOrder(TreeNode treeNode){
        if(treeNode==null) return;
        inOrder(treeNode.left);

        resNode.right=treeNode;
        treeNode.left=null;
        resNode=treeNode;

        inOrder(treeNode.right);
    }
    public int strStr(String haystack, String needle){
        int n=haystack.length();
        int m=needle.length();
        if(m==0) return 0;
        int[] pi =new int[m];
//        for()
        return 0;
    }
    public int numDecodings(String s) {
        int res=0;
        return res;

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
