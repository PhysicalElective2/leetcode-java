package company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TencentSolution {
    //寻找两个正序数组的中位数，时间复杂度有要求，二分法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //保证num1的长度更小
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        int totalLeft=(m+n+1)/2;

        int left=0;
        //这里已经越界了啊，允许越界一下
        int right=m;
        while(left<right){
            //这里的+1 是为了避免left+1=right的情况
            int i =left+(right-left+1)/2;
            int j =totalLeft-i;
            if(nums1[i-1]>nums2[j]){
                //用i-1 就是因为知道 i 可能越界啊
                //i 是边界，是不参与比较的也是个数
                right=i-1;
            }else {
                left=i;
            }

        }
        int i=left;
        int j =totalLeft-i;
        int num1RightMax = i==0?Integer.MIN_VALUE:nums1[i-1];
        int num1LeftMin = i==m? Integer.MAX_VALUE:nums1[i];
        int num2RightMax = j==0?Integer.MIN_VALUE:nums2[j-1];
        int num2LeftMin = j==n? Integer.MAX_VALUE:nums2[j];


        if((n+m)%2==1){
            //奇数
            return Math.max(num1RightMax,num2RightMax);
        }else {
            return (double) (Math.max(num1RightMax,num2RightMax)+Math.min(num1LeftMin,num2LeftMin))/2;
        }



    }
    public String spread(String s,int start,int end){
        //从中心向两边扩展
        StringBuilder res=new StringBuilder();
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        for(int i=start+1;i<end;i++){
            res.append(s.charAt(i));

        }
        return res.toString();

    }
    public String longestPalindrome(String s) {
        //最长回文子串
        String res="";
        for(int i=0;i<s.length();i++){
            String res1=spread(s,i,i);
            String res2=spread(s,i,i+1);
            res=res.length()>res1.length()?res:res1;
            res=res.length()>res2.length()?res:res2;
        }
        return res;


    }

    public int[] twoSum(int[] nums, int target) {
//        List<Integer> res=new ArrayList<Integer>();
        int[] res={-1,-1};

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;



    }

    public static void main(String[] args) {
        TencentSolution t =new TencentSolution();

        int[]  res=t.twoSum(new int[]{2, 7, 11, 15},9);
        for (int i = 0; i <res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println(t.longestPalindrome("cdbbdccc"));
        System.out.println(t.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

}
