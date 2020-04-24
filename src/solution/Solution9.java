package solution;

public class Solution9 {
    /*
    剑指示offer刷完了，每天一题刷leetcode
     */
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


}
