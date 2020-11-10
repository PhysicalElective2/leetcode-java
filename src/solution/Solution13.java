package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution13 {
    //since 11.5
    public static void main(String[] args){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//注意月份是MM
            Date date = simpleDateFormat.parse("2020-11-01 23:37:30");
            System.out.println(date);

        }catch (Exception e){
            System.out.println("parse Fail");
        }
        Date simpdate = new Date();

        SimpleDateFormat simpleDateFormattime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间："+simpleDateFormattime.format(simpdate));

    }
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while (j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);


    }

    private void reverse(int[] nums, int i) {
        int left =i;
        int right =nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] res=new int[K][2];
        int[] lens =new int[points.length];
        //first get the maxL
        for(int i=0;i<points.length;i++){
            lens[i]=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
        }
        Arrays.sort(lens);
        int maxL=lens[K-1];
        int index=0;
        for(int i=0;i<points.length;i++){
            if((points[i][0]*points[i][0])+(points[i][1]*points[i][1])<=maxL&&index<K){
                res[index][0]=points[i][0];
                res[index][1]=points[i][1];
                index++;
            }
        }
        return res;

    }
    //answer
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return + ,reverse order;often Ascending
                //return -; often Ascending
                return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]+o2[1]*o2[1];
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }



    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        // if have stock in hand
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],prices[i]+dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }


        return dp[n-1][0];

    }


    public int[] sortByBits(int[] arr) {
        int[] bit=new int[10001];
        List<Integer> list =new ArrayList<>();
        for(int i:arr){
            list.add(i);
            bit[i]=get(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bit[o1]!=bit[o2]){
                    return bit[o1]-bit[o2];

                }else {
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;


    }

    private int get(int x) {
        int res=0;
        while (x!=0){
            res+=x%2;
            x/=2;
        }
        return res;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String s:wordList){
            
        }
        return 0;


    }

}
