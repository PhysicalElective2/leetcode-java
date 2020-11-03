package solution;

import java.lang.reflect.Field;
import java.util.*;


public class Solution12 {
    public boolean validMountainArray(int[] A) {
        int n=A.length;
        int i=0;
        while (i+1<n&&A[i]<A[i+1]){
            i++;
        }
        if(i==0&&i==n-1)return false;
        while (i+1<n||A[i]>A[i+1]){
            i++;
        }
        return i==n-1;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> listNum2 =new ArrayList<Integer>();
        List<Integer> res =new ArrayList<Integer>();
        for(int i:nums2){
            listNum2.add(i);
        }
        Arrays.sort(nums1);

        for(int i=0;i<nums1.length;i++){
            if(i>=1&&nums1[i-1]==nums1[i]){
                continue;
            }
            if(listNum2.contains(nums1[i])){
                res.add(nums1[i]);
            }
        }
        int[] realRes = new int[res.size()];

        for (int i=0;i<realRes.length;i++){
            realRes[i]=res.get(i);
        }

        return realRes;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        //can give list value to set 
        Set<String> set= new HashSet<>(wordDict);
        boolean[] dp =new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    //one can ,then just break
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public int islandPerimeter(int[][] grid) {
        //
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    res+=num(grid,i,j);
                }

            }
        }
        return res;


    }
    public int num(int[][] grid,int i,int j){
        //find its edge of a stone
        int res=0;
        if(i-1<0||grid[i-1][j]==0)res++;
        if(i+1>=grid.length||grid[i+1][j]==0)res++;
        if(j-1<0||grid[i][j-1]==0)res++;
        if(j+1>=grid[i].length||grid[i][j+1]==0)res++;

        return res;

    }
    public boolean uniqueOccurrences(int[] arr) {
        //map is key and value
        //set is unique
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> set=new HashSet<>();
        for(Integer i:map.values()){
            set.add(i);
        }
        return set.size()==map.size();


    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count =new int[101];
        for(int i:nums){

            count[i]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        int[] res =new int[nums.length];
        for(int i=0;i<res.length;i++){
            //can not have 0-1
            res[i]= nums[i]==0? 0:count[nums[i]-1];

        }
        return res;

    }
    public int longestMountain(int[] A) {
//just give up
        int n=A.length;
        if(n==0)return 0;
        int[] left=new int[n];
        int[] right =new int[n];
        for(int i=1;i<n;i++){
            left[i]= A[i]>A[i-1]?left[i-1]+1:0;
        }
        for(int i=n-2;i>=0;i--){
            right[i]= A[i]>A[i+1]?right[i+1]+1:0;
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(left[i]>0&&right[i]>0){
                res=Math.max(res,left[i]+right[i]+1);
            }
        }
        return res;




    }


    public int videoStitching(int[][] clips, int T) {
        //Backpack problem ,no it is dp
        //dp is hard
        int t[] =new int[T+1];
        Arrays.fill(t,Integer.MAX_VALUE-1);
        t[0]=0;
        for(int i=0;i<=T;i++){
            for(int[] ii:clips){
                if(ii[0]<i && i<=ii[1]){
                    t[i]=Math.min(t[i],t[ii[0]]+1);
                }
            }
        }
        return t[T]==Integer.MAX_VALUE-1?-1:t[T];

    }
    public static void main(String[] args) {
        Solution12 s12=new Solution12();
        int i=100;
        char a='a';
        String aa="hhh你好";
        System.out.println(aa.getBytes().length);
        System.out.println(i>>5);
    }



    public boolean isPalindrome(ListNode head) {
        boolean res=true;
        List<Integer> array=new ArrayList<Integer>();
        while (head!=null){
            array.add(head.val);
            head=head.next;


        }
        //judge if is palindrom
        Integer i=0;
        Integer j=array.size()-1;
        System.out.println(array.size());
        while (i<=j){

            if(!(array.get(i).equals(array.get(j)))){
                System.out.println("is mot equal");
                System.out.println(array.get(i)+" "+array.get(j));
                res=false;
                break;
            }
            i++;
            j--;
        }
        return res;
    }

    public List<Integer> partitionLabels(String S) {
        int[] last =new int[26];
        int length=S.length();
        for(int i=0;i<length;i++){
            last[S.charAt(i)-'a']=i;
        }

        ArrayList<Integer> partition =new ArrayList<>();
        int start =0,end=0;
        for(int i=0;i<length;i++){
            end =Math.max(end,last[S.charAt(i)-'a']);
            //if the character's index is the end index of all character before the character,can  cut off
            if(i==end){
                partition.add(end-start+1);
                start=end+1;
            }
        }
        return partition;

    }
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while (j<typed.length()){
            if(i<name.length()&&name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j-1)==typed.charAt(j)){
                j++;
            }else {
               return  false;

            }
        }

        return i==name.length();
    }
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        ListNode anotherHead = head;

        while (anotherHead != null) {
            array.add(anotherHead);
            anotherHead = anotherHead.next;
        }

        ListNode p = head;
        p.next = array.get(array.size() - 1);
        p = p.next;
        for (int i = 1; i < array.size() / 2; i++) {
            p.next = array.get(i);
            p = p.next;
            p.next = array.get(array.size() - i - 1);
            p = p.next;
        }
        if (array.size() % 2 == 1) {
            p.next = array.get(array.size() / 2);
            p = p.next;
        }
        p.next = null;

    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder Sa = new StringBuilder();
        StringBuilder Sb = new StringBuilder();
        //        StringBuffer Sb=new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (Sa.length() > 0) {
                    Sa.deleteCharAt(Sa.length() - 1);
                }
            } else {
                Sa.append(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (Sb.length() > 0) {
                    Sb.deleteCharAt(Sb.length() - 1);
                }
            } else {
                Sb.append(T.charAt(i));
            }
        }
        return Sa.toString().equals(Sb.toString());

    }

}
