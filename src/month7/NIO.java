package month7;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-18 19:28
 **/
public class NIO {
    public static void main(String[] args) {
        System.out.println("hh");
        NIO n=new NIO();
        int[] nums =new int[]{};
//        System.out.println(n.FindGreatestSumOfSubArray(nums));
        System.out.println(n.minCoins(30,new int[]{25,10,5},3));
    }
    public boolean isValid (String s) {
        // write code here
        Queue<Character> stack =new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='['){
                stack.offer(s.charAt(i));
            }else {
                Character c=stack.poll();
                if(s.charAt(i)=='}'&&c=='{'||
                        s.charAt(i)=='}'&& c=='{'
                        || s.charAt(i)==']' &&c =='['
                ){
                    continue;
                }

            }

        }
        return true;
    }
    public int minCoins (int V, int[] coins, int M) {
        // write code here
        int max= V+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] =0;
        for(int i= 1;i<= V;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);

                }
            }
        }
        return dp[V]>V? -1:dp[V];

    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0) return 0;
        int pre =0;
        int res= array[0];
        for(int i=1;i<array.length;i++){
            pre =Math.max(pre+array[i],array[i]);
            res=Math.max(res,pre);
        }
        return res;

    }
    public int countArea(int[] A, int n) {
        // write code here
        //
        return 0;
    }
    public ArrayList<String> letterCombinations (String digits) {
        // write code here
        char[] nums =  digits.toCharArray();
        Map<Character, String> map= new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ArrayList<String> res=new ArrayList<>();
        StringBuilder tempres=new StringBuilder();
        dfs(res,nums,0,tempres,map);
        return res;

    }

    private void dfs(ArrayList<String> res, char[] nums, int i, StringBuilder tempres, Map<Character, String> map) {
        if(i==nums.length){
            res.add(new String(tempres));
            return;
        }
        String s =map.get(nums[i]);
        for(int j=0;j<s.length();j++){
            tempres.append(s.charAt(j));
            dfs(res,nums,i+1,tempres,map);
            tempres.deleteCharAt(i);
        }

    }

}
