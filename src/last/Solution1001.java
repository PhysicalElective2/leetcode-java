package last;

import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-01 11:33
 **/
public class Solution1001 {
    public static void main(String[] args) {
        Solution1001 solution1001 =new Solution1001();
        int[] nums=new int[]{};
        int[] res =solution1001.maxSlidingWindow(nums,0);
        for (Integer i:res){
            System.out.println(i);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        if(n==0) return new int[0];
        Deque<Integer> deque =new LinkedList<>();
        for(int i=0;i<k;i++){
            while (!deque.isEmpty() && deque.peekLast()<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        if(ans.length==0) return ans;
        ans[0]=nums[deque.peekFirst()];
        for(int i=k;i<n;i++){
            while (!deque.isEmpty() && deque.peekLast()<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            ans[i-k+1] =nums[deque.peekFirst()];


        }
        return ans;

    }
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;

    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor=root;
        while (true){
            if(p.val<ancestor.val&& q.val<ancestor.val){
                ancestor=ancestor.left;
            }else if(p.val>ancestor.val&& q.val>ancestor.val){
                ancestor=ancestor.right;
            }else {
                break;
            }
        }
        return ancestor;
    }
    public int maxProfit(int[] prices) {
        int res=0;
        int minP=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minP){
                minP=prices[i];
            }else if(prices[i]-minP>res){
                res=prices[i]-minP;
            }
        }
        return res;

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int lenL=height(root.left);
        int lenR=height(root.right);
        return Math.abs(lenL-lenR)<=1&&isBalanced(root.left)&&isBalanced(root.right);

    }
    public int height(TreeNode root){
        if(root==null) return 0;
        else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat =new HashSet<>();
        int max =0;
        int min =14;
        for(Integer i:nums){
            if(i==0) continue;
            max=Math.max(max,i);
            min =Math.min(min,i);
            if(repeat.contains(i)) return false;
            repeat.add(i);
        }
        return max-min<5;
    }
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for(int i=2;i<=n;i++){
            double[] temp =new double[5*i+1];
            for(int j=0;j<dp.length;j++){
                for(int k=0;k<6;k++){
                    temp[j+k]+=dp[j]/6.0;
                }

            }
            dp=temp;
        }
        return dp;
    }
    public int[] constructArr(int[] a){
        if(a==null||a.length==0) return a;
        int len=a.length;
        int[] left =new int[len];
        int[] right =new int[len];
        left[0] =right[len-1]=1;
        for(int i =1;i<len;i++){
            left[i]=left[i-1]*a[i-1];
        }
        for(int i =len-2;i>=0;i--){
            right[i]=right[i+1]*a[i+1];
        }
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;

    }
    public int add(int a, int b) {
        while (b!=0){
            int c =(a&b)<<1;
            a ^=b;
            b=c;
        }
        return a;
    }

    public int nthUglyNumber(int n) {
        int[] dp =new int[n+1];
        dp[1] =1;
        int p2=1;
        int p3=1;
        int p5=1;
        for(int i=2;i<=n;i++){
            int num2=dp[p2]*2;
            int num3=dp[p3]*3;
            int num5=dp[p5]*5;
            dp[i]=Math.min(num2,num3);
            dp[i]=Math.min(dp[i],num5);
            if(dp[i]==num2){
                p2++;

            }
            if(dp[i]==num3){
                p3++;
            }
            if(dp[i]==num5){
                p5++;
            }

        }
        return dp[n];

    }
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        inorder(root);
        return res;


    }

    private void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.right);
        if(k==0){
            return;
        }
        if(--k==0)res=root.val;
        inorder(root.left);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map =new HashMap<>();
        int i=-1;
        int res=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res =Math.max(res,j-i);
        }
        return res;
    }
    public int missingNumber(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<=j){
            int m=(i+j)/2;
            if(nums[m]==m){
                i=m+1;
            }else {
                j=m-1;
            }
        }
        return i;

    }
}
