package solution2021;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S1 {
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int nextIndex=Math.abs(nums[i])-1;
            if(nums[nextIndex]>0){
                nums[nextIndex]*=-1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;




    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int index=0;
        while (res.size()<nums.length){
            res.add(1);
            index++;
        }
        for(Integer i:nums){
            res.set(i,-1);
        }
        res.removeIf(e->e==-1);
        return res;


    }
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);

    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2 ==null) return true;
        if(root1==null||root2==null) return false;
        return (root1.val==root2.val)&&check(root1.left,root2.right)&&check(root1.right,root2.left);
    }

    public void flatten(TreeNode root) {
        TreeNode curr =root;
        while (curr!=null){
            if(curr.left!=null){
                TreeNode next =curr.left;
                TreeNode predecessor =next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right=curr.right;
                curr.left=null;
                curr.right=next;

            }
            curr=curr.right;
        }
    }


    public static void main(String[] args) {
        S1 s=new S1();
        int[] res=s.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7,3},3);
        for(int i =0;i<res.length;i++){
            System.out.println(res[i]);
        }
//        System.out.println(s.maxProfit(new int[]{2, 1, 4}));
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res =new int[nums.length-k+1];
        Deque<Integer> deque =new LinkedList<>();
        int index =0;
        for(int i=0;i<nums.length;i++){
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i])
                deque.removeLast();
            deque.addLast(i);
            if(i-deque.peekFirst()>= k){
                deque.removeFirst();
            }
            if(i>=k-1&&index<res.length){
                res[index++] =nums[deque.peekFirst()];
            }
        }

        return res;

    }

    //out of time pass 49/60
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res =new int[nums.length-k+1];
        Deque<Integer> deque =new LinkedList<>();
        int index =0;
        for(int i=0;i<nums.length;i++){
            while(deque.size()<k){
                deque.addLast(nums[i]);
                i++;
            }
            if(deque.size()==k&&i<nums.length){
                res[index++]=getMaxOfDeque(deque);
                deque.removeFirst();
                deque.addLast(nums[i]);
            }

        }
        res[index]=getMaxOfDeque(deque);
        return res;

    }

    private int getMaxOfDeque(Deque<Integer> deque) {
        int res=Integer.MIN_VALUE;
        for(Integer i:deque){
            res=Math.max(res,i);

        }
        return res;
    }

    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res=new ArrayList<>();
        midOrder(root);
        return res;


    }

    private void midOrder(TreeNode root) {
        if(root==null) return;
        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode left =root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;


    }
    public int hammingDistance(int x, int y) {
        int res=0;
        int n=x^y;
        while (n!=0){
            res++;
            // remove last 1 in Binary form
            n=n&(n-1);
        }
        return res;

    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        if(flowerbed.length==1)

        if(flowerbed[0]==0&&(flowerbed.length==1||flowerbed[1]==0)){
            flowerbed[0]=1;
            n--;
        }
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
            flowerbed[flowerbed[flowerbed.length-1]]=1;
            n--;
        }
        return n<=0;

    }


    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for(int i=1;i<res.length;i++){
            res[i]=res[i>>1]+(i&1);


        }
        return res;


    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)return 0;
        int[] have =new int[n];
        int[] haveNot =new int[n];
        have[0] =-prices[0];
        haveNot[0]=0;
        for(int i=1;i<n;i++){
            if(i-2>=0){
                have[i]=Math.max(have[i-1],haveNot[i-2]-prices[i]);

            }else {
                have[i]=Math.max(have[i-1],-prices[i]);
            }
            haveNot[i]=Math.max(haveNot[i-1],have[i-1]+prices[i]);
        }
        for(int i:have){
            System.out.printf(i+"\t");
        }
        System.out.println();
        for(int i:haveNot){
            System.out.printf(i+"\t");
        }
        return haveNot[n-1];

    }
}
