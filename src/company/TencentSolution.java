package company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TencentSolution {
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
    }

}
