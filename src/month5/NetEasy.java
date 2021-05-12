package month5;

import tools.TreeNode;

import java.io.LineNumberReader;
import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-08 15:01
 **/
public class NetEasy {
    public static void main(String[] args) {
        ThreadLocal<String> s= new ThreadLocal<>();
        s.set("fff");
        String sS="abbaca";
        char[] chars =new char[]{'b','x'};
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18],1
        int[] ss=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(new NetEasy().GetMaxCoverage(ss,1));
                //"abbaca",[b,x]

    }
    public int[] getColMax (TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list =new ArrayList<>();
        dfs(root,map,list,0);
        Collections.sort(list);
        int[] res=new int[list.size()];
        int index =0;
        for(Integer i:list){
            res[index++] =map.get(i);
        }
        return res;
        // write code here
    }
    public int GetMaxCoverage (int[] populationDistribute, int stationCoverage) {
        // write code here
        int len =populationDistribute.length;
        int[] can =new int[len];
        int[] dp =new int[len-stationCoverage*2];
        int index =0;
        int sum =0;
        for(int ii=0;ii<stationCoverage;ii++){
            sum+=populationDistribute[ii];
        }
        while (index<len){
            if(index-stationCoverage-1>=0){
                sum-=populationDistribute[index-stationCoverage-1];

            }
            if(index+stationCoverage<len){
                sum+=populationDistribute[index+stationCoverage];

            }
            can[index]=sum;
            index++;
        }
        int index2=0;
        for(int i=0;i<dp.length;i++){
           if(i-stationCoverage>=0&&i+stationCoverage<len){
               dp[index2++]=can[i];
           }
        }
        for(int i=1;i<dp.length;i++){
            int max =0;
            for(int j=1;j<=stationCoverage*2;j++){
                if(i-j>=0){
                    max=Math.max(dp[i-j],max);
                }
            }
            if(i-stationCoverage-stationCoverage-1>=0){
//                dp[i] =Math.max(dp[i],max);
                dp[i] =Math.max(dp[i-stationCoverage-stationCoverage-1]+dp[i],max);
            }else {
                dp[i] =Math.max(max,dp[i]);
            }
        }
        return dp[dp.length-1];



    }
    public int GetMaxCoverage2 (int[] populationDistribute, int stationCoverage) {
        // write code here
        int len =populationDistribute.length;
        int[] can =new int[len];
        int[] dp =new int[len];
        int index =0;
        int sum =0;
        for(int ii=0;ii<stationCoverage;ii++){
            sum+=populationDistribute[ii];
        }
        while (index<len){
            if(index-stationCoverage-1>=0){
                sum-=populationDistribute[index-stationCoverage-1];

            }
            if(index+stationCoverage<len){
                sum+=populationDistribute[index+stationCoverage];

            }
            can[index]=sum;
            index++;
        }
        for(int i=0;i<dp.length;i++){
            dp[i]=can[i];
        }
        for(int i=1;i<dp.length;i++){
            int max =0;
            for(int j=1;j<=stationCoverage*2;j++){
                if(i-j>=0){
                    max=Math.max(dp[i-j],max);
                }
            }
            if(i-stationCoverage-stationCoverage-1>=0){
//                dp[i] =Math.max(dp[i],max);
                dp[i] =Math.max(dp[i-stationCoverage-stationCoverage-1]+dp[i],max);
            }else {
                dp[i] =Math.max(max,dp[i]);
            }
        }
        return dp[len-1];


    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, List<Integer> list,int index) {
        if(root==null) return;
        if(list.contains(index)){
            map.put(index,Math.max(map.get(index),root.val));
        }else {
            list.add(index);
            map.put(index,root.val);
        }
        dfs(root.left,map,list,index-1);
        dfs(root.left,map,list,index+1);
    }


    public int specialStr (String inputStr, char[] cList) {
        // write code here
        Set<Character> set =new HashSet<>();
        for(char c:cList){
            set.add(c);
        }
        int res=0;
        for(int i=0;i< inputStr.length();i++){
            int l =i;
            int r =i;
            if(!set.contains(inputStr.charAt(i))){
                while (l-1>=0&&r+1<inputStr.length()&&!set.contains(inputStr.charAt(l-1))&&!set.contains(inputStr.charAt(r+1))&&inputStr.charAt(l-1)==inputStr.charAt(r+1)){
                    l--;
                    r++;
                }
                res=Math.max(res,r-l+1);
            }

            l=i;
            r=i+1;
            while (l>=0&&r<inputStr.length()&&!set.contains(inputStr.charAt(l))&&!set.contains(inputStr.charAt(r))&&inputStr.charAt(l)==inputStr.charAt(r)){
                l--;
                r++;
            }
            res=Math.max(res,r-l-1);

        }
        return res;
    }
    public String getMostStr (String s0, String s1, char[] cList) {
        return null;

        // write code here
    }
}
