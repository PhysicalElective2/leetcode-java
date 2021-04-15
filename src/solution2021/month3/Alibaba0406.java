package solution2021.month3;

import java.util.Scanner;

public class Alibaba0406 {






































    public String reverse(String input){
        input=input.trim();
        String[] words=input.split(" ");
        StringBuilder res=new StringBuilder();


        // 第一题
        // i  从 words.length -1 开始 ,zhie

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

    public static void main(String[] args) {
        int res = new Alibaba0406().getMaxLen(new int[]{100, 4, 200, 1, 3, 4, 5, 2});
        System.out.println(res);
    }
    // 第二题的第二题

    private int getMaxLen(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //改了 maxleb =1
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


}
