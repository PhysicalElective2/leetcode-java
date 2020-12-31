package solution;


import java.awt.event.ActionListener;
import java.util.*;

public class Solution15 {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] stones =new int[]{2,2};

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int n =intervals.length;
        int[] f= new int[n];
        Arrays.fill(f,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(intervals[j][1]<=intervals[i][0]){
                    f[i]=Math.max(f[i],f[j]+1);
                }

            }
        }
        return n-Arrays.stream(f).max().getAsInt();

    }


    public int lastStoneWeight(int[] stones) {
        int res =0;
        List<Integer> list =new LinkedList<>();
        for(int i: stones){
            list.add(i);
        }
        Collections.sort(list);
        while (list.size()>1){
            int big1 = list.get(list.size()-1);
            int big2 = list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            int addNum;
            if(big1==big2){
                continue;
            }
            if(big1>big2){
                addNum =big1-big2;
                int addIndex =0;
//                while (list.get(addIndex)<addNum) addIndex++;
//                list.add(addIndex,addNum);
                while (addIndex<list.size()&&list.get(addIndex)<addNum) addIndex++;
                if(addIndex==list.size()){
                    list.add(addNum);
                }else {
                    list.add(addIndex,addNum);


                }


            }
            if(big2>big1){
                addNum=big2-big1;
                int addIndex =0;
                while (addIndex<list.size()&&list.get(addIndex)<addNum) addIndex++;
                if(addIndex==list.size()){
                    list.add(addNum);
                }else {
                    list.add(addIndex,addNum);


                }
            }
        }
        if(list.size()>0) {
            return list.get(0);
        }else {
            return 0;
        }

    }




    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        if(n==0) return 0;
        int[][] left =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (matrix[i][j] == '1') {
                    left[i][j]=(j==0?0:left[i][j-1])+1;
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    continue;
                }
                int width =left[i][j];
                int area =width;
                for(int k=i-1;k>=0;k--){
                    width=Math.min(width,left[k][j]);
                    area=Math.max(area,(i-k+1)*width);
                }
                res=Math.max(res,area);
            }
        }
        return res;




    }
    public List<String> getList(){
        return null;
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ng=g.length;
        int ns=s.length;
        int count =0;
        for(int i=0,j=0;i<ng&&j<ns;i++,j++){
            while (j<ns&&g[i]<s[j]){
                j++;
            }
            if(j<ns){
                count++;
            }
        }
        return count;

    }

    enum Size{
        S,M,L;
    }
    public int firstUniqChar(String s) {
        int res =-1;
        int[] haveChar=new int[26];
        for(int i=0;i<s.length();i++){
            haveChar[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(haveChar[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return res;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        boolean orderLeft=true;
        while (!queue.isEmpty()){
            // notice one while on line
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node =queue.poll();
                if(orderLeft){
                    levelList.addLast(node.val);
                }else {
                    levelList.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(new ArrayList<>(levelList));
            orderLeft=!orderLeft;

        }
        return res;



    }
    public int minCostClimbingStairs2(int[] cost) {
        if(cost.length<=1) return 0;
        int[] dp=new int[cost.length+1];
//        int[] dp1=new int[cost.length+1];
        dp[0] =cost[0];
        dp[1]=cost[1];
        for(int i =2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+(i==cost.length?0:cost[i]);
        }
        return dp[dp.length-1];


    }



    //this over time
    public int minCostClimbingStairs(int[] cost) {
        return Math.max(getCost(cost.length-1,cost),getCost(cost.length-2,cost));

    }

    private int getCost(int i, int[] cost) {
        if(i==0) return cost[0];
        if(i==1) return cost[1];
        int cost1=getCost(i-1,cost);
        int cost2=getCost(i-2,cost);
        return cost[i]+Math.min(cost1,cost2);
    }

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] temp=matrix.clone();
        List<Integer> nums=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums.add(temp[i][j]);

            }
        }
        int count=0;
        for(int j=n-1;j>=0;j--){
            for(int i=0;i<n;i++){
                matrix[i][j]=nums.get(count++);
            }
        }



    }
    public boolean wordPattern(String pattern, String s) {
        boolean res=false;
        Boolean ress=false;
        ActionListener a =e-> System.out.println("ff");
        Object o;
//        o.clone();
//        s.substring();
        String[] ss=s.split(" ");
        if(ss.length!=pattern.length()) return false;
        for(int i=0;i<ss.length;i++){
//            if()
        }

        return  res;


    }
    public int monotoneIncreasingDigits(int N) {
        char[] strN =Integer.toString(N).toCharArray();
        int i=1;
        while (i<strN.length&&strN[i-1]<=strN[i]){
            i++;
        }
        if(i<strN.length){
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }

        }
        return Integer.valueOf(strN.toString());

    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =new HashMap<String,List<String>>();
        for(String s:strs){
            char[] array =s.toCharArray();
            Arrays.sort(array);
            String key =new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);

        }
        return new ArrayList<List<String>>(map.values());
    }
    public ListNode sortList(ListNode head) {
        return sortList(head, null);


    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        //may have just two node
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow =head,fast=head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;



    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<2) return n;
        int[] up =new int[n];
        int[] down =new int[n];
        up[0] =down[0] =1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                down[i]=down[i-1];
                up[i]=Math.max(up[i-1],down[i-1]+1);

            }else if(nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=Math.max(down[i-1],up[i-1]+1);
            }else {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);


    }
}
