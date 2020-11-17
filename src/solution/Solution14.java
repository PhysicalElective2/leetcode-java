package solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution14 {
    public static void main(String[] args) {
        int a =10;
        int b= 10;
        int c=11;
        System.out.println(Math.abs(a=b));
        System.out.println(Math.abs(a=c));
//        System.out.println(Math.abs(a=b));
    }
    //since 11.16
    public int maxProfit2(int[] prices) {
        int[] dpNoInhand=new int[prices.length];
        int[] dpInhand=new int[prices.length];
        dpInhand[0]=-prices[0];//buy
        dpNoInhand[0]=0;
        for(int i=1;i<prices.length;i++){
            dpNoInhand[i]=Math.max(dpInhand[i-1]+prices[i],dpNoInhand[i-1]);
            dpInhand[i]=Math.max(dpNoInhand[i-1]-prices[i],dpInhand[i-1]);


        }
        return dpNoInhand[prices.length-1];

    }
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int[] dp =new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);


        }
        return res;
    }
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];


    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res=new int[R*C][2];
        int index=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                res[index][0]=i;
                res[index++][1]=j;
            }
        }
        int[] location =new int[]{r0,c0};
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ManhattanDistance(o1,location)-ManhattanDistance(o2,location);
            }
        });
        return res;

    }
    public int ManhattanDistance(int[] d1,int[] d2){
        //If change - to = ,d1 will be changed
        return Math.abs(d1[0]-d2[0])+Math.abs(d1[1]-d2[1]);

    }
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[] dp =new int[prices.length];
        int min=prices[0];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            min=Math.min(min,prices[i]);
            dp[i]=Math.max(dp[i-1],prices[i]-min);
        }
        return dp[dp.length-1];

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o1[2];
                }else {
                    return o2[1]-o1[1];
                }
            }
        });
        int n=people.length;
        int[][] answer =new int[n][];
        for(int[] p:people){
            int spaces=p[1];
            for(int i=0;i<n;i++){
                if(answer[i]==null){
                    if(spaces==0){
                        answer[i]=p;
                        break;
                    }
                    spaces--;
                }
            }

        }
        return answer;

    }

}
