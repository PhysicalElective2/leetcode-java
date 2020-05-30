package solution;

public class Solution9 {
    /*
    剑指示offer刷完了，每天一题刷leetcode
     */
    public static void main(String[] args) {
        Solution9 s=new Solution9();
//        int[] a ={1,2,3,4};
//        System.out.println(s.rob(a));
        String b="A";
        System.out.println(s.convert(b,1));
    }
    public String convert(String s, int numRows) {
        //Z 字变换
       // String res;
        StringBuilder res = new StringBuilder("");
        int row=0;
        while(row<numRows){
            StringBuilder thisRow = new StringBuilder("");
            for(int i=0;i<s.length();i++){
                if(judge(i,numRows)==row){
                    thisRow.append(s.charAt(i));

                }
            }
            res.append(thisRow.toString());
            row++;
        }
        return res.toString();

    }
    public int judge(int index,int row){
        //根据index 和总共的row 判断这是第几row,index 从0开始
        if(row==1){
            return 0;
        }
        index=index%(2*row-2);
        int res;
        if(index<row){
            res=index;

        }else {
            res=(2*row-2)-index;
        }
        return res;
    }
    public int rob(int[] nums) {
        //打家劫舍
        if(nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] s=new int[nums.length];
        s[0]=nums[0];
        s[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            //
            s[i]=Math.max(s[i-1],s[i-2]+nums[i]);
        }
        return s[nums.length-1];

    }
    int count=0;
    public int reversePairs(int[] nums) {
        //归并排序，分治法
        System.out.println(nums.length);
        if(nums.length>0){
            divide(0,nums.length-1,nums);
        }

        return count;


    }
    public void divide(int start,int end,int[] nums){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        divide(start,mid,nums);
        divide(mid+1,end,nums);
        //
        merge(start,mid,end,nums);

    }
    public void merge(int start,int mid,int end,int[] nums){
        int[] temp=new int[end-start+1];
        int tempi=0;
        int i=start;
        int j=mid+1;
        while(i<=mid&&j<=end){
            if(nums[i]<=nums[j]){
                temp[tempi++]=nums[i++];
            }else {
                temp[tempi++]=nums[j++];
                count+=(mid-i+1);
                System.out.println(count);

            }
        }
        //还会有剩余的数字,但是不构成逆序对了
        while (i<=mid){
            temp[tempi++]=nums[i++];
        }
        while(j<=end){
            temp[tempi++]=nums[j++];
        }
        tempi=0;
        for(int k=start;k<=end;k++){
            nums[k]=temp[tempi++];
        }


    }
    public int maxProfit(int[] prices) {
        //买入股票的最佳时机
        int res=0;
        for(int i=0;i<prices.length;i++){
            int resOne=0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>resOne) resOne=prices[j]-prices[i];
            }
            res= res>=resOne?res:resOne;

        }
        return res;


    }
    public int maxProfit2(int prices[]) {
        //厉害了，先找到最低点，然后再线性遍历，肯定先找到最低点，以后再买才能盈利
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


}
