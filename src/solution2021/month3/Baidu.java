package solution2021.month3;

import java.util.Scanner;

public class Baidu {
    public static void main(String[] args) {
//        int[] nums =new int[]{0,1,2,1,2};
//        Scanner sc = System.in;
        Scanner input=new Scanner(System.in);
        while (input.hasNextLine()){
            int n =Integer.parseInt(input.nextLine());
            int[] nums=new int[n];
            String numString =input.nextLine();
            for(int i=0;i<n;i++){
                nums[i]=numString.charAt(i)-'0';
            }
            System.out.println(new Baidu().re(nums));
        }



    }
//    void rrrr(){
//        double d = 3.1415926;
//        String result = String .format("%.2f");
//        Math.ceil();
//
//    }
    int re(int[] nums){

        int n=nums.length;
        if(n<=1) return 0;
        int[] dp =new int[nums.length];
        for(int i=0;i<n;i++){
            dp[i]=i;
        }
        for(int i=1;i<n;i++){
            int oneRes=dp[i];
            for(int j=0;j<i;j++){
                if(nums[i]==nums[j]){
                    oneRes=Math.min(oneRes,dp[j]+1);
                }
            }
            oneRes=Math.min(dp[i-1]+1,oneRes);
            dp[i] =oneRes;
        }
        return dp[n-1];
    }

}
