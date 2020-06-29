package company;

import java.util.*;

public class TencentSolution {
    //删除重复
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[++index]=nums[i];

            }
        }
        return index+1;

    }
    //有效的括号
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map m1 = new HashMap();
        m1.put(')', '(');
        m1.put('}', '{');
        m1.put(']', '[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                //如果是，直接进入
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()){
                    return false;
                }
                Character temp = stack.pop();
                if(m1.get(s.charAt(i))!=temp){//并不是相等，而是匹配.g
                    return false;
                }
            }

        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }


    }

    //最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //直接遍历并不ok 答案不连续
        int res =nums[0]+nums[1]+nums[2];
        for(int i =0;i<nums.length-2;i++){
            int thisRes;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                thisRes=nums[i]+nums[j]+nums[k];
                if(thisRes==target){
                    return target;
                }
                if(thisRes<target){
                    j++;
                }
                if(thisRes>target){
                    k--;
                }
                res=Math.abs(res-target)<Math.abs(thisRes-target)?res:thisRes;

            }
        }
        return  res;

    }
    //三数之和,别人的思路更加严谨
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2; i++) {
            //去重复
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if(nums[j]+nums[k]==target){
                    ArrayList<Integer> oneRes= new ArrayList<Integer>();
                    oneRes.add(nums[i]);
                    oneRes.add(nums[j]);
                    oneRes.add(nums[k]);
                    res.add(oneRes);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                }
                if(nums[j]+nums[k]<target){
                    j++;
                }
                if(nums[j]+nums[k]>target){
                    k--;
                }


                }

        }
        return res;

    }
    //最长公共前缀，编写一个函数来查找字符串数组中的最长公共前缀。
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        if(strs[0].length()==0) return "";
        //还得二重遍历
        boolean continuFlag=true;
        int index=0;
        while(continuFlag){
            for(int i=1;i<strs.length;i++){
                if(index>=strs[0].length()||index>=strs[i].length()||strs[i].charAt(index)!=strs[0].charAt(index)){
                    continuFlag=false;
                    break;
                }

            }
            index++;
        }
        index--;
        StringBuilder res=new StringBuilder();
        for (int i=0;i<index;i++){
            res.append(strs[0].charAt(i));
        }
        return  res.toString();
    }


    // 字符串转换整数 (atoi)
    public int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        //得遍历
        int symbol =1;
        int res =0;
        int i =findStart(str);
        //这一位的i 已经可以了
        if(i==-1){
            return res;
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            symbol= str.charAt(i)=='+'? 1:-1;
            i++;
        }

        for(;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(str.charAt(i))) > 7)){
                return symbol>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+Integer.parseInt(String.valueOf(str.charAt(i)));

        }
        res=res*symbol;
        return res;

    }
    public int findStart(String str){
        //返回应该开始的下标，如果没有就返回-1
        int i=0;
        //去除空格
        while(i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i==str.length()){
            return -1;
        }
        if(str.charAt(i)!='-'&&str.charAt(i)!='+'&&!Character.isDigit(str.charAt(i))){
            return -1;
        }

        return i;

    }
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

//        int[]  res=t.twoSum(new int[]{2, 7, 11, 15},9);
//        for (int i = 0; i <res.length; i++) {
//            System.out.println(res[i]);
//        }
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(t.longestPalindrome("cdbbdccc"));
//        System.out.println(t.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
//
//        System.out.println("res"+t.myAtoi("2147483646"));
//        System.out.println(t.longestCommonPrefix(new String[]{"C","C"}));
//        t.threeSum(new int[]{-1,0,1,2,-1,-4});
//        System.out.println(t.myAtoi("   542"));
//        System.out.println(t.threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
//        System.out.println(t.threeSumClosest(new int[]{0,2,1,-3},1));
//        System.out.println(t.isValid(""));
        int nums[]={1,2,2,3,4,4,5,5,5};
        int res=t.removeDuplicates(nums);
       //System.out.println();
        for(int i=0;i<res;i++){
            System.out.println(nums[i]);
        }
    }

}
