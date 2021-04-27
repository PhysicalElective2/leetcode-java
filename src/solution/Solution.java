package solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
         Arrays.sort(nums);
         int[] dp=new int[nums.length];
         Arrays.fill(dp,1);
         int maxSize =1;
         int maVal =dp[0];
         for(int i=1;i<len;i++){
             for(int j=0; j< i;j++){
                 if(nums[i]%nums[j]==0){
                     dp[i]=Math.max(dp[i],dp[j]+1);
                 }


             }
             if(dp[i]>maxSize){
                 maxSize=dp[i];
                 maVal=nums[i];
             }

         }
         List<Integer> res=new ArrayList<>();
         if(maxSize==1){
             res.add(nums[0]);
             return res;
         }
         for(int i=len-1;i>=0&&maxSize>0;i--){
             if(dp[i]==maxSize&&maVal% nums[i]==0){
                 res.add(nums[i]);
                 maVal=nums[i];
                 maxSize--;
             }
         }
         return res;




    }

    public ListNode FindKthToTail(ListNode head,int k) {//倒数第k个节点
        ListNode res=head;

        while(k>0){
            res=res.next;
            k--;
            if (res==null&&k!=0) return null;
        }
        while(res!=null){
            res=res.next;
            head=head.next;
        }
        return  head;

    }
    public void reOrderArray(int [] array) {//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
        // 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
        int len=array.length;
        int temp[]=new int[len];
        for(int i=0;i<len;i++){
            temp[i]=array[i];
        }
        int q=0;
        //int i=0;i 表示扫描的
        for(int i=0;i<len;i++){
            if(temp[i]%2!=0){
                array[q++]=temp[i];
            }
        }
        for(int i=0;i<len;i++){
            if(temp[i]%2==0){
                array[q++]=temp[i];
            }
        }

    }
    public double Power(double base, int exponent) {//可以是复数形式
        if(exponent==0) return 1;
        if(base==0) return 0;
        if(exponent>0){
            double res=base;
            for(int i=1;i<exponent;i++){
                res=res*base;
            }
            return  res;
        }else {
            double res=base;
            for(int i=1;i<exponent*-1;i++){
                res=res*base;
            }
            return 1/res;

        }


    }
    public void Mirror(TreeNode root) {//二叉树的镜像
        if(root.left!=null||root.right!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        if(root.left!=null){
            Mirror(root.left);

        }
        if(root.right!=null){
            Mirror(root.right);

        }


    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {//顺时针打印
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix.length==0) return res;
        boolean isVisit[][]=new boolean[matrix.length][matrix[0].length];//初始化，全都没有被访问过
        //第一个方向为0
        int x=0;
        int y=0;
        int direction=0;
        isVisit[x][y]=true;
        res.add(matrix[x][y]);
        while(true) {
            if(res.size()==matrix.length*matrix.length) break;
            switch (direction) {
                case 0:
                    if (!isVisit[x][y + 1] && x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
                        y++;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = swich(direction);

                    }
                    break;
                case 1:
                    if (!isVisit[x+1][y] && x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
                        x++;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = swich(direction);

                    }
                    break;
                case 2:
                    if ( x >= 0 && y >= 0 &&!isVisit[x][y-1] && x < matrix.length && y < matrix[0].length) {
                        y--;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = swich(direction);
                    }
                    break;
                case 3:
                    if ( x >= 0 && y >= 0 &&!isVisit[x-1][1] && x < matrix.length && y < matrix[0].length) {
                        x--;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = swich(direction);
                    }
                    break;

            }

        }
        return res;

    }
    public int swich(int th){
        return (th+1)%4;
    }

}
