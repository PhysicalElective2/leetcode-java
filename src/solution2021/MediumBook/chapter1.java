package solution2021.MediumBook;

import java.util.*;

public class chapter1 {
    public static void main(String[] args) {
        chapter1 c=new chapter1();
//        System.out.println(c.lengthOfLongestSubstring("pwwkew"));
        System.out.println(c.longestPalindrome("babad"));
        Integer i=0;
        Boolean j=false;
        int a;
        System.out.println(a=10);
    }
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int[] dp =new int[n];
        Arrays.fill(dp,1);
        int res=dp[0];
        for(int i=1;i<n;i++){


            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }
            res=Math.max(res,dp[i]);
            if(res>=3) return true;
        }
        return false;



    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp =new int[n];
        Arrays.fill(dp,1);
        int res=dp[0];
        for(int i=1;i<n;i++){


            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    public String longestPalindrome(String s) {
        int n =s.length();
        String res="";
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                int u=i;
                int v=i+j;
                while (u>=0&&v<n&&s.charAt(u)==s.charAt(v)){
                    u--;
                    v++;
                }
                if(v-u-1>res.length()){
                    res=s.substring(u+1,v);
                }

            }
        }
        return res;

    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int end = 0;
        int maxL=1;
        int n=s.length();
        if(n==0) return 0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (end<n&&!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;

            }
            maxL=Math.max(maxL,set.size());
        }

        return maxL;



    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =new HashMap<>();
        for(String s:strs){

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key =new String(chars);



            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);
        }
        //creat list by map.values
        return new ArrayList<>(map.values());

    }

    public void setZeroes(int[][] matrix) {
        int line1Flag = 1;
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                line1Flag = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = m-1; i >=1; i--) {
            for (int j = n-1; j >=0; j--) {
                if (matrix[i][0] == 0||matrix[0][j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = n-1; j >=0; j--) {
            if (line1Flag == 0) {
                matrix[0][j]=0;
            }
        }


    }
}
