package month6;

import tools.ListNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-02 19:10
 **/
public class Solution {
    public int openLock(String[] deadends, String target) {
        if("0000".equals((target))){
            return 0;
        }
        Set<String> dead =new HashSet<>();
        for(String deaded:deadends){
            dead.add(deaded);
        }
        if(dead.contains("0000")){
            return -1;
        }
        int step=0;
        Queue<String> queue =new LinkedList<>();
        queue.offer("0000");
        Queue<String> seen =new LinkedList<>();
        seen.offer("0000");
        while (!queue.isEmpty()){
            ++step;
            int size =queue.size();
            for(int i=0;i<size;++i){
                String status = queue.poll();
                for(String nextStatus:get(status)){
                    if(!seen.contains(nextStatus)&&!dead.contains(nextStatus)){
                        if(nextStatus.equals(target)){
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }

                }

            }

        }
        return -1;
    }
    public List<String> get(String status) {
        List<String> ret= new ArrayList<>();
        char[] array = status.toCharArray();
        for(int i=0;i<4;i++){
            char num =array[i];
            array[i] =numPre(num);
            ret.add(new String(array));
            array[i] =numSuc(num);
            ret.add(new String(array));
            array[i]=num;
        }
        return ret;
    }

    private char numPre(char num) {
        return num =='0'?9:(char)(num-1);
    }
    private char numSuc(char num) {
        return num =='9'?0:(char)(num+1);
    }
    List<String> rec;
    boolean[] vis;


    public String[] permutation(String s) {
        List<String> res=new ArrayList<>();
        int n =s.length();
        rec =new ArrayList<>();
        vis =new boolean[n];
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr,0,n,perm);
        int size =rec.size();
        String[] recArr =new String[size];
        for(int i=0;i<size;i++){
            recArr[i] = rec.get(i);
            
        }
        return recArr;

    }

    private void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if(i==n){
            rec.add(perm.toString());
            return;
        }
        for(int j=0;j<n;j++){
            // the after use need the before is used
            if(vis[j]||(j>0&&!vis[j-1]&&arr[j-1]==arr[j])){
                continue;
            }
            vis[j]=true;
            perm.append(arr[j]);
            backtrack(arr,i+1,n,perm);
            perm.deleteCharAt(perm.length()-1);
            vis[j]=false;
        }
    }

    public int change(int amount, int[] coins) {
        int[] dp =new int[amount+1];
        dp[0] =1;
        for (int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i] +=dp[i-coin];
            }
        }
        return amount;
    }
    public int lastStoneWeightII(int[] stones) {
        return 0;

    }
    public ListNode removeElements (ListNode head, int val){
        ListNode pre =new ListNode(-1);
        ListNode respre =pre;
        pre.next=head;
        while (pre.next!=null){
            if(pre.next.val==val){
                pre.next=pre.next.next;
            }else{
                pre=pre.next;
            }

        }
        return respre.next;

    }
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int counter =0;
        map.put(counter,-1);
        int n= nums.length;
        for(int i=0;i<n;i++){
            int num =nums[i];
            if(num==1){
                counter++;
            }else {
                counter--;
            }
            if(map.containsKey(counter)){
                int preIndex =map.get(counter);
                maxLen=Math.max(maxLen,i-preIndex);
            }else {
                map.put(counter,i);
            }


        }
        return maxLen;
    }
    public static void main(String[] args) {

    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m<2) return false;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int remainder =0;
        boolean res =true;
        for(int i=0;i<m;i++){
            remainder=(remainder+nums[i])%k;
            if(map.containsKey(remainder)){
                int preIndex =map.get(remainder);
                if(i-preIndex>=2){
                    res=true;
                    break;
                }
            }else {
                map.put(remainder,i);
            }

        }
        return res;


    }
}
