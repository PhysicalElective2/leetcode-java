package solution2021;

import tools.ListNode;
import tools.TreeNode;

import java.util.*;

public class S1 {

    //    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//
//    }
    public int minPathSum(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int m =grid.length;
        int n =grid[0].length;
        int[][] dp =new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i =1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i =1;i<n;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    int parents[];
    private int find2(int index) {
        while (parents[index]!=index){
            parents[index]=find2(parents[index]);
            index= parents[index];
        }
        return index;
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parents =new int[s.length()];
        for(int i=0;i<s.length();i++){
            parents[i]=i;
        }
        for(int i=0;i<pairs.size();i++){
            int pa =find2(pairs.get(i).get(0));
            int pb =find2(pairs.get(i).get(1));
            parents[pa] =pb;
        }
        //get all circle
        Map<Integer,Queue> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Queue oneQueue =map.getOrDefault(find2(i),new PriorityQueue());
            oneQueue.add(s.charAt(i));
            map.put(find2(i),oneQueue);
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            res.append(map.get(find2(i)).poll());
        }
        return res.toString();



    }

    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
    public int[] dailyTemperatures(int[] T) {
        return null;


    }
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0) return res;
        int stat =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                continue;

            }else{
                if(i-stat==1){
                    res.add(String.valueOf(nums[stat]));
                }else {
                    StringBuilder oneRes =new StringBuilder();
                    oneRes.append(String.valueOf(nums[stat]));
                    oneRes.append("->");
                    oneRes.append(String.valueOf(nums[i-1]));
                    res.add(oneRes.toString());
                }
                stat=i;
            }

        }
        if(nums.length-stat==1){
            res.add(String.valueOf(nums[stat]));
        }else {
            StringBuilder oneRes =new StringBuilder();
            oneRes.append(String.valueOf(nums[stat]));
            oneRes.append("->");
            oneRes.append(String.valueOf(nums[nums.length-1]));
            res.add(oneRes.toString());
        }

        return res;


    }
    public static void main(String[] args) {
        S1 s = new S1();
        int[] nums =new int[]{3,1,3,4,2};
        System.out.println(s.findDuplicate(nums));
//        System.out.println(s.maxProfit(new int[]{2, 1, 4}));
    }
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])]<0){
                return Math.abs(nums[i]);
            }else {
                nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
            }
        }
        return 0;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy1=-prices[0];
        int sell1=0;
        int buy2=-prices[0];
        int sell2=0;
        for(int i=1;i<n;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;

    }



    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);



    }

    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }


    }

    public int numIslands(char[][] grid) {
        int res=0;
        return res;


    }
    public int findCircleNum(int[][] isConnected) {
        int size =isConnected.length;
        if(size<=1)  return size;
        int[] p =new int[size];
        for(int i=0;i<isConnected.length;i++){
            p[i]=i;
            //
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<i;j++){
                if(isConnected[i][j]==1){
                    //may lost connect info
                    union2(p,i,j);
                }
            }
        }
        int res=0;
//        Set<Integer> set=new HashSet<>();

        for(int i=0;i<size;i++){
            System.out.println(p[i]+"\r");
            if(p[i]==i) res++;
        }
        return res;


    }

    private void union2(int[] p, int i, int j) {
        p[find2(p, j)] = find2(p, i);

    }

    public int find2(int[] p,int i){
        while (p[i]!=i){
            p[i]=find2(p,p[p[i]]);
            i=p[i];
        }
        return i;

    }
    public int find3(int[] p,int i){
      if(p[i]!=i){return find3(p,p[i]);}
      else {
          return i;


      }

    }

    public boolean equationsPossible(String[] equations) {
        int[] parent =new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String s:equations){
            if(s.charAt(1)=='-'){
                int index1=s.charAt(0)-'a';
                int index2 =s.charAt(3)-'a';
                union(parent,index1,index2);
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int index1=s.charAt(0)-'a';
                int index2=s.charAt(3)-'a';
                if(find(parent,index1)==find(parent,index2)){
                    return false;
                }

            }
        }
        return true;


    }
    public void union(int[] parent,int index1,int index2){
        parent[find(parent, index1)] = find(parent, index2);

    }

    private int find(int[] parent, int index1) {
        while (parent[index1]!=index1){
            parent[index1]=find(parent,parent[parent[index1]]);
            index1=parent[index1];
        }
        return index1;
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);

    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s.length() <= 2) return res;
//        char lastChar =n
        int start = 0;
        s = s + "?";
        char startChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == startChar) {
                continue;
            } else {
                if (i - start >= 3) {
                    ArrayList<Integer> oneRes = new ArrayList<>();
                    oneRes.add(start);
                    oneRes.add(i - 1);
                    res.add(oneRes);
                }

                start = i;
                startChar = s.charAt(i);


            }

        }
        return res;

    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;


    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int nextIndex = Math.abs(nums[i]) - 1;
            if (nums[nextIndex] > 0) {
                nums[nextIndex] *= -1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;


    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (res.size() < nums.length) {
            res.add(1);
            index++;
        }
        for (Integer i : nums) {
            res.set(i, -1);
        }
        res.removeIf(e -> e == -1);
        return res;


    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);

    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;

            }
            curr = curr.right;
        }
    }




    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }
            if (i >= k - 1 && index < res.length) {
                res[index++] = nums[deque.peekFirst()];
            }
        }

        return res;

    }

    //out of time pass 49/60
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (deque.size() < k) {
                deque.addLast(nums[i]);
                i++;
            }
            if (deque.size() == k && i < nums.length) {
                res[index++] = getMaxOfDeque(deque);
                deque.removeFirst();
                deque.addLast(nums[i]);
            }

        }
        res[index] = getMaxOfDeque(deque);
        return res;

    }

    private int getMaxOfDeque(Deque<Integer> deque) {
        int res = Integer.MIN_VALUE;
        for (Integer i : deque) {
            res = Math.max(res, i);

        }
        return res;
    }

    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        midOrder(root);
        return res;


    }

    private void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;


    }

    public int hammingDistance(int x, int y) {
        int res = 0;
        int n = x ^ y;
        while (n != 0) {
            res++;
            // remove last 1 in Binary form
            n = n & (n - 1);
        }
        return res;

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        if(flowerbed.length==1)

        if (flowerbed[0] == 0 && (flowerbed.length == 1 || flowerbed[1] == 0)) {
            flowerbed[0] = 1;
            n--;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed[flowerbed.length - 1]] = 1;
            n--;
        }
        return n <= 0;

    }


    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i >> 1] + (i & 1);


        }
        return res;


    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] have = new int[n];
        int[] haveNot = new int[n];
        have[0] = -prices[0];
        haveNot[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i - 2 >= 0) {
                have[i] = Math.max(have[i - 1], haveNot[i - 2] - prices[i]);

            } else {
                have[i] = Math.max(have[i - 1], -prices[i]);
            }
            haveNot[i] = Math.max(haveNot[i - 1], have[i - 1] + prices[i]);
        }
        for (int i : have) {
            System.out.printf(i + "\t");
        }
        System.out.println();
        for (int i : haveNot) {
            System.out.printf(i + "\t");
        }
        return haveNot[n - 1];

    }
}
