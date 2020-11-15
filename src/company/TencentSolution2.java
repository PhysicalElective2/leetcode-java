package company;


import java.util.*;


public class TencentSolution2 {
    public static void main(String[] args) {
        System.out.println(new TencentSolution2().reverseWords("Let's take LeetCode contest"));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) return true;
        }
        return false;

    }
    //there way is better
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

    public int[] productExceptSelf(int[] nums) {
        int start[] =new int[nums.length];
        int end[] =new int[nums.length];
        start[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            start[i]=start[i-1]*nums[i];
        }
        end[nums.length-1]=nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--){
            end[i]=end[i+1]*nums[i];
        }
        int[] res=new int[nums.length];
        res[0]=end[1];
        res[nums.length-1]=start[nums.length-2];
        for(int i=1;i<nums.length-2;i++){
            System.out.println("start[i-1]"+start[i-1]);
            System.out.println("end[i+1]"+end[i+1]);
            res[i]=start[i-1]*end[i+1];
        }
        return res;


    }

    public void reverseString(char[] s) {
        int j = 0;
        int k = s.length - 1;
        char temp;
        while (j < k) {
            temp = s[j];
            s[j] = s[k];
            s[k] = temp;
            j++;
            k--;
        }


    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        if (ss.length == 0) return s;
        StringBuilder res = new StringBuilder();
        for (String oneS : ss) {
            char[] cs = new char[oneS.length()];
            for (int i = 0; i < cs.length; i++) {
                cs[i] = oneS.charAt(i);
            }
            reverseString(cs);
            res.append(cs);
            res.append(" ");
        }
        return res.substring(0, s.length());
    }


}
