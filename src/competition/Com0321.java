package competition;

import java.util.*;

public class Com0321 {
    public static void main(String[] args) {
        Com0321 c=new Com0321();
        int[][] s2=new int[][]{
                {7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}

        };
        System.out.println(c.getNumberOfBacklogOrders(s2));
       // System.out.println(c.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));

    }
    public int maxAscendingSum(int[] nums) {

        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] =nums[i];
        }
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+nums[i];
            }

            res=Math.max(res,dp[i]);
        }
        return res;


    }
    public int maxValue(int n, int index, int maxSum) {
        int res=1;
        while (maxSum>=need(n,res+1)){
            res+=1;
        }
        return res;
//        int[] nums =new int[n];
//        Arrays.fill(nums,1);
//        maxSum-=n;
//        while (maxSum>0){
//            if(can(maxSum,nums,index)){
//
//            }
//        }


    }

    private int need(int n, int i) {
        return n*i;
    }

    private boolean can(int maxSum, int[] nums, int index) {
        return false;
    }

    public int getNumberOfBacklogOrders(int[][] orders) {

        PriorityQueue<int[]> type0 =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        PriorityQueue<int[]> type1 =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<orders.length;i++){
            if(i==0){
                if(orders[0][2]==0){
                    type0.add(orders[0]);
                }else {
                    type1.add(orders[0]);
                }
                continue;
            }
            if(orders[i][2]==0){
                // find the
                while (!type1.isEmpty()&&type1.peek()[0]<=orders[i][0]&& orders[i][1]>0){
                    int[] oneorder=type1.poll();
                    if(oneorder[1]>=orders[i][1]){
                        oneorder[1]-=orders[i][1];
                        orders[i][1]=0;
                        if(oneorder[1]>0){
                            type1.offer(oneorder);
                        }
                        break;
                    }else {
                        orders[i][1]-=oneorder[1];
                    }


                }
                if(orders[i][1]>0){
                    type0.add(orders[i]);
                }

            }else {
                while (!type0.isEmpty()&&type0.peek()[0]>=orders[i][0]&& orders[i][1]>0){
                    int[] oneorder=type0.poll();
                    if(oneorder[1]>=orders[i][1]){
                        oneorder[1]-=orders[i][1];
                        orders[i][1]=0;
                        if(oneorder[1]>0){
                            type0.offer(oneorder);
                        }
                        break;
                    }else {
                        orders[i][1]-=oneorder[1];
                    }
                }
                if(orders[i][1]>0){
                    type1.add(orders[i]);
                }

            }


        }
        int res=0;
        Iterator<int[]> iterator0 =type0.iterator();
        while (iterator0.hasNext()){
            res=(res+iterator0.next()[1])%(1000000007);
        }
        Iterator<int[]> iterator1 =type1.iterator();
        while (iterator1.hasNext()){
            res=(res+iterator1.next()[1])%(1000000007);


        }
        return res;


    }


}
