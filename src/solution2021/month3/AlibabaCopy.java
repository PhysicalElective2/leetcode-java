package solution2021.month3;

import java.util.Scanner;

public class AlibabaCopy {


    public static void main(String[] args) {
//        int res = new AlibabaCopy().getMaxLen(new int[]{100, 4, 200, 1, 3, 4, 5, 2});
//        System.out.println(res);
        String res1=new AlibabaCopy().reverse("the sky is       blue   ");
        System.out.println(res1);
    }
    // 第二题的第二题

    private int getMaxLen(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int l = 0, r = 1, maxLen = 1;
        while (r < nums.length) {
            if (nums[r] > nums[r - 1]) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                l = r;
            }
            r++;
        }
        return maxLen;
    }

    public String reverse(String input){
        input=input.trim();
        String[] words=input.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(words[i].length()>0){
                res.append(words[i]);
                if(i!=0){
                    res.append(" ");
                }
            }


        }
        return res.toString();

    }



}
