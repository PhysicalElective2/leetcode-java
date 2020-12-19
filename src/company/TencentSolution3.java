package company;


import tools.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TencentSolution3 {
    public static void main(String[] args) {
        System.out.println("ff");
        TencentSolution3 t = new TencentSolution3();
//        char[] nu1 = {'9', '8', '7', '6', '5', '4', '3', '2', '1'};
//        char nu2 = '9';
//        t.mul(nu1, nu2);
        t.multiply("123","456");
    }

    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        maxGain(root);
        return maxSum;


    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        StringBuilder ress = new StringBuilder();
        for (int i = 0; i <n2.length; i++) {
//            res+=mul(n2,n1[i])*Math.pow(10,n1.length-1-i);
            StringBuilder oneRes = mul(n1, n2[i]);
            ress = add(ress.insert(0,'0'), oneRes);
            System.out.println("temp res:"+ress);

        }
        return String.valueOf(ress.reverse());


    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int add = 0;
        int index = 0;
        StringBuilder res=new StringBuilder();
        while (index<num1.length()&&index<num2.length()) {
            int oner = num1.charAt(index) - '0' + num2.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        while (index<num1.length()){
            int oner = num1.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        while (index<num2.length()){
            int oner = num2.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        if(add>0){
            res.append(add);
        }
        return res;
    }


    public StringBuilder mul(char[] num1, char num2) {
        int add = 0;
        StringBuilder ress = new StringBuilder();
        for (int i = num1.length - 1; i >= 0; i--) {
//            res+=(num1[i]-'0')*(num2-'0')*Math.pow(10,num1.length-1-i);
            int thisNum = (num1[i] - '0') * (num2 - '0') + add;
            System.out.println((num1[i] - '0') * (num2 - '0') + add);
            ress.append(thisNum % 10);
            add = thisNum / 10;
        }
        if (add > 0) {
            ress.append(add);
        }
        System.out.println(Arrays.toString(num1) + "*" + num2 + "=");

        System.out.println(ress);
        return ress;
    }




    private int maxGain(TreeNode root) {
        if (root == null) return 0;
//        if(root.left==null&&root.left==null) return root.val;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int thisGain = leftGain + rightGain + root.val;
        maxSum = Math.max(thisGain, maxSum);
        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        List<Integer> num = new ArrayList<>();
        dfs(root, num);
        int[] dp = new int[num.size()];
        dp[0] = num.get(0);
        int res = dp[0];

        for (int i = 1; i < dp.length; i++) {
            System.out.println(num.get(i));
            dp[i] = Math.max(dp[i - 1] + num.get(i), num.get(i));
            res = Math.max(res, dp[i]);
        }
        return dp[num.size() - 1];


    }

    public List<String> getList() {
        return null;
    }

    public void dfs(TreeNode node, List num) {
        num.add(node.val);
        if (node != null) {
            num.add(node.val);
            dfs(node.left, num);
            dfs(node.right, num);
        } else {
            num.add(Integer.MIN_VALUE);
        }

    }

    //    public int search(int[] nums, int target) {
//        int n= nums.length;
//        if(n==0){
//            return -1;
//        }
//        if(n==1) return nums[0]==target?0:-1;
//        int l=0,r=n-1;
//        while (l<=r){
//            int mid =(l+r)/2;
//            if(nums[mid]==target) return mid;
//            if(nums[0]<=nums[mid]){
//                // front is in order
//                if(nums[0]<=target&&target<nums[mid]){
//                    r=mid-1;
//                }else {
//                    l=mid+1;
//                }
//
//            }else {
//                if (nums[mid] < target && target <= nums[n - 1]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//
//
//            }
//
//        }
//        return -1;
//
//
//    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {//mid左侧为有序数组
                if (nums[left] <= target && nums[mid] >= target) {//如果target在mid左侧的话
                    right = mid - 1;
                } else {//在mid右侧
                    left = mid + 1;
                }
            } else {//mid右侧为有序数组
                if (nums[mid] <= target && nums[right] >= target) {//如果target在mid右侧的话
                    left = mid + 1;
                } else {//在mid左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
