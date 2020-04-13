package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution5 {
    //Count the number of pairs in reverse order
    public void testthreepoin(int... nums){
        //三个点实现用数组传递参数，不定参数
        for(int i=0;i< nums.length;i++){
            System.out.println(i + " " +nums[i]);
        }
        //nums.fori 快捷遍历nums数组
        
        for (int i = 0; i < nums.length; i++) {

        }
    }
    int cnt;

    public int InversePairs(int[] array) {
        if (array.length != 0){
            //ok ,now,I can not write chinese
            //the index of last number is array.length-1
            divide(array,0,array.length-1);
        }
        return cnt;
    }
    //divide in merge sort
    private void divide(int[] array, int start, int end) {
        //termination condition
        // the judgment condition requires parentheses

        if (start >= end) {
            return;
        }
        //calculate the median
        int mid =start+(end-start)/2;
        //recursion
        divide(array,start,mid);
        divide(array,mid+1,end);
        
        merge(array,start,mid,end);

    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp =new int [end-start+1];
        int i =start,j= mid+1,k=0;
        while(i<=mid && j<=end){
            //when the loop end,i>mid or j> end
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else {
                temp[k++]=array[j++];
                cnt=(cnt+mid-i+1)%1000000007;
            }
        }
        //There are still unfinished parts, you can directly assign values
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=end){
            temp[k++]=array[j++];
        }
        //Overwrite the original array
        for(k=0;k<temp.length;k++){
            array[start+k]=temp[k];
        }
    }


    public int FindGreatestSumOfSubArray(int[] array) {//连续子数组的最大和
        int res =array[0];
        int max=array[0];
        for(int i=1;i<array.length;i++){
            max =Math.max(max+array[i],array[i]);//如果加上更大，则更新，否则，断开就行了。
            res=Math.max(max,res);
        }
        return  res;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {//判断能否形成弹出顺序
        //模拟栈的过程
        Stack<Integer> s =new Stack<Integer>();
        int p=0;//标志入栈的位置
        int q=0;//标志出栈的位置

        while (q<popA.length){//以出栈 为边界
            if(s.isEmpty())  s.push(pushA[p++]);
            while(popA[q]!=s.peek()&&p<pushA.length){
                s.push(pushA[p]);
                p++;
            }
            if(popA[q]==s.peek()){
                s.pop();
                q++;
            }else {
                return false;
            }

        }
        return  true;
    }
    public boolean VerifySquenceOfBST(int [] sequence) {//二叉搜索树的后序遍历的结果，参考，太难了。
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return judge(sequence,0,sequence.length-1);

    }

    private boolean judge(int[] a, int start, int end) {
        if(start>=end){
            return true;
        }
        int i= start;
        while (a[i]<a[end]){
            i++;
        }
        for(int j=i;j<end;j++){
            if(a[j]<a[end]){
                return false;
            }
        }
        return judge(a,start,i-1)&&judge(a,i,end-1);
    }
    public int MoreThanHalfNum_Solution(int [] array) {//出现次数超过一半。
        //对数组排序，如果存在答案，一定是中间的那一个。
        if(array.length<1){
            return 0;
        }
        Arrays.sort(array);
        int flag=array[array.length/2];//如果存在，一定是这个
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==flag) count++;
        }
        if(count>array.length/2) {
            return flag;
        }else {
            return  0;
        }

    }
    public int NumberOf1(int n) {//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
        //如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
        int count =0;
        while(n!=0){
            count++;
            n=n&(n-1);

        }
        return count;

    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {//根据前序和中序重建二叉树
        TreeNode root =reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if(startPre>endPre||startIn>endIn){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);

                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        }
        return root;
    }
    private ArrayList<ArrayList<Integer>> listall= new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list =new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {//某一值的路径
        if(root==null) return listall;
        list.add(root.val);
        target-=root.val;
        if(root.left==null&&root.right==null&&target==0){
            listall.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        //不用改变target ，因为没有意义，改变list 因为是全局的变量
        return listall;

    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {//最小的k个数
        ArrayList<Integer> res= new ArrayList<>();
        if(k>input.length) return res;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;

    }



}
