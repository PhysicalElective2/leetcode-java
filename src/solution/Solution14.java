package solution;

import java.nio.file.Paths;
import java.util.*;

public class Solution14 {
    public static void main(String[] args) {
        // \u00A0 SDFSD
       Solution14 s=new Solution14();

//       s.reorganizeString("aabb");
//        System.out.println(s.reorganizeString("aaab"));
//        System.out.println('\u2122');
        String sss="sdfsdf sdfsf增高";
        //have startwith don not need re
        sss.startsWith("sd");
        System.out.println(System.getProperty("user.dir"));
        //Paths.get() get file
         System.out.println(sss.codePointCount(0,sss.length()));
         for(int i=10;i>0;i--) System.out.println("sdfsd"+i);

       // System.out.println(s.canCompleteCircuit(a,b));


//        System.out.println(s.canCompleteCircuit2(a,b));
    }
    public int maxDepth(TreeNode root) {
        //
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }

    //my false way
    public String reorganizeString2(String S){
        if(S.length()<2) return S;
        int[] count =new int[26];
        int maxCount =0;
        int length =S.length();
        for(int i=0;i<length;i++){
            char c=S.charAt(i);
            count[c-'a']++;
            maxCount=Math.max(maxCount,count[c-'a']);
        }
        if(maxCount>(length+1)/2){
            return "";
        }
        PriorityQueue<Character> queue =new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2-'a']-count[o1-'a'];
            }
        });
        for(char c= 'a';c<='z';c++){
            if(count[c-'a']>0){
                queue.offer(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (queue.size()>1){
            char letter1 =queue.poll();
            char letter2 =queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            count[letter1-'a']--;
            count[letter2-'a']--;
            if(count[letter1-'a']>0){
                queue.offer(letter1);
            }
            if(count[letter2-'a']>0){
                queue.offer(letter2);
            }

        }
        if(queue.size()>0){
            sb.append(queue.poll());

        }
        return sb.toString();


    }
    public String reorganizeString(String S) {
        if(S.length()==0) return "";
        StringBuilder res=new StringBuilder();
        char[] ss=S.toCharArray();
        boolean[] visit =new boolean[S.length()];

        Arrays.sort(ss);
        res.append(ss[0]);
        visit[0]=true;
        int index =1;
        //may  lost in loop
        while (res.length()<S.length()){
            if( ss[index]!=res.charAt(res.length()-1)&&!visit[index]){
                res.append(ss[index]);
                visit[index] =true;

            }else {
                index=(index+1)%S.length();
            }


        }
        boolean can=true;
        for(int i=1;i<res.length();i++){
            if(res.charAt(i)==res.charAt(i-1)){
                can=false;
                break;

            }
        }
        if(can){
            return res.toString();
        }else {
            return "";
        }





    }


    //since 11.16
    public int reversePairs(int[] nums) {
        //
        return 0;
    }
    //  they way is better ,just need keep A[i - 2] + A[i - 1] > A[i]
    public int largestPerimeter2(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int index= A.length-1;
        int a=A[index--];
        int b=A[index--];
        int c=A[index--];
        while ((!isTriangle(a,b,c))&&index>=0){
            a=b;
            b=c;
            c=A[index--];
        }
        if(isTriangle(a,b,c)) return a+b+c;
        return 0;

    }
    public boolean isTriangle(int a,int b,int c){
        return (a+b)>c&&(a+c)>b&&(b+c)>a;
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map =new HashMap();
        int res=0;
        for(int a:A){
            for(int b:B){
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }
        for(int c:C){
            for(int d:D){
                res+=map.getOrDefault(-c-d,0);
            }
        }
        return res;

    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        return (int) set.toArray()[0];
        //


    }
    // a better way use  XOR
    public int singleNumber2(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int res=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            res=Math.max(res,nums[i]-nums[i-1]);

        }
        return res;

    }
    public String sortString(String s) {
        //
        int[] num= new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }

        StringBuilder res=new StringBuilder();
        int length =s.length();
        while (res.length()<length){
            for(int i=0;i<26;i++){
                if(num[i]>0){
                    res.append((char)(i+'a'));
                    num[i]--;
                }
            }
            for(int i=25;i>=0;i--){
                if(num[i]>0){
                    res.append((char)(i+'a'));
                    num[i]--;
                }
            }


        }
        return res.toString();

    }
    public int countNodes(TreeNode root) {
       if(root==null){
           return 0;
       }
//       if(root.left==null&&root.right==null){
//           return 1;
//       }

        return countNodes(root.left)+countNodes(root.right)+1;

    }

    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        ListNode resPre =new ListNode(-1);
        resPre.next=head;
        return null;

    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode resPre=new ListNode(-1);
        resPre.next=null;
        ListNode tempNext=new ListNode(-1);
        ListNode pointPre =new ListNode(-1);

        while (head!=null){
            //find the index to insert the node to resPre
            pointPre=resPre;
            ListNode point =resPre.next;
            if(point==null){
                tempNext=head.next;
                resPre.next=head;
                head.next=null;
                head=tempNext;
                continue;
            }
            while (point.val<head.val&&point!=null){
                pointPre=pointPre.next;
                point=point.next;
            }
            //now point.val > =head.val
            tempNext=head.next;
            head.next=pointPre.next;
            pointPre.next=head;
            head=tempNext;
        }
        return resPre.next;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add=0;
        ListNode resPre=new ListNode(-1);
        ListNode pointPre=resPre;
        while (l1!=null&&l2!=null){
            ListNode res=new ListNode((l1.val+l2.val+add)%10);
            pointPre.next=res;
            pointPre=pointPre.next;
            add=(l1.val+l2.val+add)/10;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            ListNode res=new ListNode((l1.val+add)%10);
            pointPre.next=res;
            pointPre=pointPre.next;
            add=(l1.val+add)/10;
            l1=l1.next;
        }
        while (l2!=null){
            ListNode res=new ListNode((l2.val+add)%10);
            pointPre.next=res;
            pointPre=pointPre.next;
            add=(l2.val+add)/10;
            l2=l2.next;
        }
        if(add!=0){
            ListNode res=new ListNode(add);
            pointPre.next=res;
        }
        return  resPre.next;
    }
    public void moveZeroes(int[] nums) {
        List list =new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                if(o1==0){
                    return 1;
                }
                if(o2==0){
                    return -1;
                }
                return 0;
            }
        });
        for(int i=0;i<list.size();i++){
            nums[i]=(int)list.get(i);
        }



    }
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;

        // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
        while(i < n){
            int sumOfGas  = 0; // 总共加的油
            int SumOfCost = 0; // 总共消费的油
            int count = 0;     // 记录能走过几个站点
            while(count < n){  // 退出循环的条件是走过所有的站点
                int j = (i + count) % n; // 加油站是环形的
                sumOfGas += gas[j];
                SumOfCost += cost[j];
                if(SumOfCost > sumOfGas){ // 如果这个站点发现油不够了
                    break;
                }
                count++; // 这个站点满足情况
            }

            if(count == n){  // 如果能环绕一圈
                return i;
            }else{ // 不行的话 从下一个站点开始 检查
                i = i + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;
    }
    //improve method,have loop wrong method
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int res = -1;
        int n = gas.length;
        int i=0;
        while (i<n) {
            int haveGas = gas[i];
            int start = i;
            int nextIndex = (start + 1) % n;
            Boolean ok=true;

            while (nextIndex != i) {
                if(haveGas - cost[start]>=0){
                    haveGas = haveGas - cost[start] + gas[nextIndex];
                    start = nextIndex;
                    nextIndex = (start + 1) % n;
                }else {
                    //System.out.println("ok=false,because: havaGas:"+haveGas+"cost[i]:"+cost[i]);
                    ok=false;
                    break;
                }

            }
            //now next is i
            if(ok&&haveGas - cost[start]>=0){
                res=i;
                break;
            }else {
                i=start+1;
            }

        }
        return res;

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int n = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int haveGas = gas[i];
            int start = i;
            int nextIndex = (start + 1) % n;
            Boolean ok=true;

            while (nextIndex != i) {
                if(haveGas - cost[start]>=0){
                    haveGas = haveGas - cost[start] + gas[nextIndex];
                    start = nextIndex;
                    nextIndex = (start + 1) % n;
                }else {
                    //System.out.println("ok=false,because: havaGas:"+haveGas+"cost[i]:"+cost[i]);
                    ok=false;
                    break;
                }

            }
            //now next is i
            if(ok&&haveGas - cost[start]>=0){
                res=i;
            }

        }
        return res;

    }

    public int maxProfit2(int[] prices) {
        int[] dpNoInhand = new int[prices.length];
        int[] dpInhand = new int[prices.length];
        dpInhand[0] = -prices[0];//buy
        dpNoInhand[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dpNoInhand[i] = Math.max(dpInhand[i - 1] + prices[i], dpNoInhand[i - 1]);
            dpInhand[i] = Math.max(dpNoInhand[i - 1] - prices[i], dpInhand[i - 1]);


        }
        return dpNoInhand[prices.length - 1];

    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);


        }
        return res;
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];


    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[index][0] = i;
                res[index++][1] = j;
            }
        }
        int[] location = new int[]{r0, c0};
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ManhattanDistance(o1, location) - ManhattanDistance(o2, location);
            }
        });
        return res;

    }

    public int ManhattanDistance(int[] d1, int[] d2) {
        //If change - to = ,d1 will be changed
        return Math.abs(d1[0] - d2[0]) + Math.abs(d1[1] - d2[1]);

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[dp.length - 1];

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o1[2];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int n = people.length;
        int[][] answer = new int[n][];
        for (int[] p : people) {
            int spaces = p[1];
            for (int i = 0; i < n; i++) {
                if (answer[i] == null) {
                    if (spaces == 0) {
                        answer[i] = p;
                        break;
                    }
                    spaces--;
                }
            }

        }
        return answer;

    }

}
