package solution;

import java.util.ArrayList;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println("ff");
    }
    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
    // 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
    public int FirstNotRepeatingChar(String str) {

        return 0;
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        if(array==null||array.length==0){
            return res;
        }
        int left=0;
        int right=array.length-1;
        while(left<right){
            if(array[left]+array[right]==sum){
                res.add(array[left]);
                res.add(array[right]);
                return  res;
            }else if(array[left]+array[right]>sum){
                right--;

            }else {
                left++;
            }
        }

        return res;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        int res=0;
        for(int i=0;i<=n;i++){
             res+=judge(i);
        }
        return  res;

    }
    public int judge(int num){
        int res=0;
        //判断num 是否有1;
        while(num>0){
           //最低位
            if(num%10==1) {
                res++;
                }
            num=num/10;
        }
        return res;

    }
    public int LastRemaining_Solution(int n, int m) {//报数
        if(n==0) return -1;
        boolean[] flag =new boolean[n];//默认是false
        int leftover=n;
        int ii=-1;

        while(leftover>1){
            //进行一次循环
            //怎么进行跟进啊
            int thiss=0;//一次循环的个数
            while(thiss!=m){
                ii=(ii+1)%n;
                if(!flag[ii]){
                    thiss++;
                }
            }
            flag[ii]=true;
           // System.out.println(ii);
            leftover--;
        }
        //找到最后剩的这个
        for(int i=0;i<n;i++){
            if(!flag[i]) return i;
        }
        return -1;

    }
    //任意一个重复的数字
    public boolean duplicate(int numbers[],int length,int [] duplication) {//
        int[] flag=new int[length];
        for(int i=0;i<length;i++){
            flag[i]=-1;
        }
        //遍历的是给的数组
        for(int i=0;i<length;i++){
            if(flag[numbers[i]]!=-1){
                duplication[0]=numbers[i];
                return true;
            }else {
                flag[numbers[i]]=1;
            }
        }
        return false;


    }
    public String LeftRotateString(String str,int n) {//左旋转字符串

        if(str.length()==0) return "";
        //保证旋转的位数大于字符串的长度，否则返回空字符串
        n=n%str.length();
        //把原字符串截取成俩字符串，然后拼接
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2 + s1;

    }
    public ListNode EntryNodeOfLoop(ListNode pHead){
        //精髓在于两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(low==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        low=pHead;
        while (fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
    public ListNode deleteDuplication2(ListNode pHead)//删除重复节点,删除所有重复，这个不对，要重新写
    {
        ListNode p=pHead;//标记初始节点
        while(pHead!=null&&pHead.next!=null){
            if(pHead.next.val==pHead.val){
                pHead.next=pHead.next.next;
            }
            if(pHead.next.val!=pHead.val) {
                pHead=pHead.next;
            }
        }
        return p;

    }
    public ListNode deleteDuplicationMy(ListNode pHead)//删除重复节点,删除所有重复节点
    {
        //用删除法
        ListNode pre =new ListNode(-1);
        ListNode res =new ListNode(-1);
        pre.next=pHead;
        if(pHead==null|| pHead.next==null) return pHead;
        //还是得先找到第一个不重复的
        boolean find = false;

        while(pHead.next!=null){
            if(pHead.val==pHead.next.val){
                while(pHead.next!=null&&pHead.val==pHead.next.val){
                    pHead.next=pHead.next.next;
                }
                //跳出来的时候已经移动到下一步了。
                //跳出来的时候已经没有空间了。
                pre.next=pHead.next;
                pHead=pre.next;
            }else {
                if(!find){
                    find=true;
                    res=pHead;
                }
                pHead=pHead.next;
                pre=pre.next;
            }

        }
        if(!find) return pHead;
        return res;
    }

    public ListNode deleteDuplication(ListNode pHead)//删除重复节点,删除所有重复节点,别人的递归解法
    {
        if(pHead==null||pHead.next==null) return pHead;
        if(pHead.val==pHead.next.val){
            ListNode pNode =pHead.next;
            while(pNode !=null&&pNode.val==pHead.val){
                pNode=pNode.next;
            }
            return deleteDuplication(pNode);
        }else {
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }

    }
}