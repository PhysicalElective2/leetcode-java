package month5;

import java.util.Arrays;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-06 10:02
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
    public int deleteAndEarn(int[] nums) {
        int res=0;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum=new int[max+1];
        for(int val:nums){
            sum[val]+=val;
        }
        return rob(sum);
    }

    private int rob(int[] sum) {
        int size =sum.length;
        int first =sum[0];
        int second =sum[1];
        for(int i=2;i<size;i++){
            int temp=second;
            second=Math.max(second,first+sum[i]);
            first=temp;
        }
        return second;
    }

    public int[] decode(int[] encoded, int first) {
        int[] res=new int[encoded.length+1];
        res[0] =first;
        for(int i=1;i<res.length;i++){
            res[i]=res[i-1] ^ encoded[i-1];
        }
        return res;


    }

}
