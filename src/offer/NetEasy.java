package offer;

import sun.nio.cs.ext.MacThai;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-21 15:07
 **/
public class NetEasy {
    public char findKthBit (int n, int k) {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append('a');
        int index = 1;
        while (index<=n){
            char L= (char)('a' + index);
            StringBuilder temp =new StringBuilder();
            for(int i= 0;i<stringBuilder.length();i++){
                temp.append((char)('a'+'z'-stringBuilder.charAt(i)));
            }
            temp.reverse();
            stringBuilder.append(L);
            stringBuilder.append(temp.toString());
            index++;
//            System.out.println("stringBuilder: "+stringBuilder);
        }
        return stringBuilder.charAt(k-1);


        // write code here
    }
    public static int minSailCost (int[][] input) {
        int n=input.length;
        int m=input[0].length;
        boolean[][] used = new boolean[n][m];
        ans=Integer.MAX_VALUE;
        dfs(input,used,0,0,0);
        if(ans==Integer.MAX_VALUE) return -1;
        else {
            int temp =input[0][0]==0?2:1;
            return ans-temp;
        }
    }
    public static  int ans;
    public static void dfs(int[][] nums,boolean used[][],int i, int j,int temp){
        if(i<0||j<0||i>=nums.length||j>= nums[0].length|| used[i][j]||nums[i][j]==2){

            return;
        }
        if( i== nums.length-1 && j==nums[0].length-1){
            temp+=nums[i][j]==0?2:1;
            ans=Math.min(ans,temp);
        }
        used[i][j] =true;
        temp+=nums[i][j]==0?2:1;
        dfs(nums,used,i+1,j,temp);
        dfs(nums,used,i-1,j,temp);
        dfs(nums,used,j+1,j,temp);
        dfs(nums,used,j-1,j,temp);
        temp-=nums[i][j]==0?2:1;
        used[i][j]=false;

    }

    public static int candy(int[] ages){
        int n= ages.length;
        int[] left =new int[n];
        for(int i=0;i<n;i++){
            left[i]=1;
        }
        int start =0;
        if(ages[0]<=ages[n-1]){
            start=0;
        }else {
            for(int i=1;i<ages.length;i++){
                if(ages[i]<=ages[i-1]);
                start=i;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(i>0&& ages[i]>ages[i-1]){
                left[i] =left[i-1]+1;
            }else {
                left[i] =1;
            }
            if((i==0)&&(n-1!=0)&&ages[0]>ages[n-1]){
                left[0] =left[n-1]+1;
            }
        }

        int right =0;
        int ret =0;
        for(int i=n-1;i>=0;i--){
            if(i<n-1&& ages[i]>ages[i+1]){
                right++;
            }else {
                right=1;
            }
            if((i==n-1)&&(n-1!=0)&&ages[0]<ages[n-1]){
                right++;
            }
            ret += Math.max(left[i],right);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums =new int[][]{
                {1,1,1,1,0},
                {0,1,0,1,0},
                {1,1,2,1,1},
                {0,2,0,0,1}
        };
        System.out.println(minSailCost(nums));
    }

    public static void main3(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String[] nums=scanner.nextLine().split(" ");
        int[] ages =new int[nums.length];
        int index=0;
        for(String s: nums){
            ages[index++]=Integer.parseInt(s);
        }
        System.out.println(candy(ages));


      //  System.out.println(new NetEasy().findKthBit(3, 1));

    }
    public static void main1(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String[] nums=scanner.nextLine().split(" ");
        int m =Integer.parseInt(scanner.nextLine());
        int[] nn=new int[nums.length];
        int index=0;
        for(String s:nums){
            nn[index++] =Integer.parseInt(s);
        }
        Arrays.sort(nn);
        int j;
        int res=0;
        for(int i=0;i<nn.length;i++){
            j =i+1;
            while (j<nn.length&&nn[i]+nn[j]<=m){
                res++;
                j++;
            }
        }
        System.out.println(res);
    }
}
