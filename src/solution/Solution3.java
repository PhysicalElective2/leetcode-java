package solution;

import java.util.*;

//
public class Solution3 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {//二叉树层次遍历
        ArrayList<Integer> res= new ArrayList<Integer>();
        if(root==null) return res;

        //要一个队列，
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode thiss=new TreeNode(-1);
        while(!queue.isEmpty()){
            thiss=queue.poll();
            res.add(thiss.val);
            if (thiss.right!=null){
                queue.add(thiss.right);

            }
            if (thiss.left!=null){
                queue.add(thiss.left);
            }
        }
        return res;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {


        return  false;
    }
    public int MoreThanHalfNum_Solution(int [] array) {//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
        // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
        if(array.length==0) return 0;
        //
        int res=array[0];
        //得记录下每一个数字出现的次数。
        //可以用空间换时间。
        //直接记录当前这个数字出现过的次数就可以了
        for(int i=0;i<array.length;i++){
           // if()
        }
        return 0;

    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        ListNode p2=pHead2;
        while(pHead1!=null){
            while (pHead2!=null){
                if (pHead1==pHead2) return pHead1;
                pHead2=pHead2.next;
            }
            pHead1=pHead1.next;
            pHead2=p2;
        }
        return null;

    }
    public int GetNumberOfK(int [] array , int k) {//统计一个数字在排序数组中出现的次数。
        int res=0;
        boolean flag=false;
        for(int i=0;i<array.length;i++){
            if(array[i]==k){
                flag=true;
                res++;
            }
            if(array[i]!=k&&flag){
                break;
            }
        }
        return res;

    }
    public int TreeDepth(TreeNode root) {//二叉树深度
        if(root ==null) return 0;
        int lenL=TreeDepth(root.left);
        int lenR=TreeDepth(root.right);
        return  lenL>lenR?lenL+1:lenR+1;


    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    }
    public int Sum_Solution(int n) {//求1+2+3+...+n，要求不能使用乘除法、
        // for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
    public RandomListNode Clone(RandomListNode pHead)
    {//复杂链表的复制
        if(pHead==null) return null;
        RandomListNode res =new RandomListNode(pHead.label);
        RandomListNode q=pHead;
        RandomListNode p=res;
        pHead=pHead.next;
        while(pHead!=null){
            RandomListNode tem =new RandomListNode(pHead.label);
            p.next=tem;
            p=p.next;
            pHead=pHead.next;
        }
        //先创建，在设置random,得去查找这个lable 值的node
        p=res;
        pHead=q;
        while(p!=null){
            //先找到这个lable去
            if(pHead.random!=null){
                int label=pHead.random.label;
                RandomListNode pp=res;
                while(pp!=null){
                    if (pp.label==label){
                        p.random=pp;
                        pp=res;
                        break;
                    }
                    pp=pp.next;
                }
            }else {
                p.random=null;
            }
            p=p.next;
            pHead=pHead.next;
        }
        return res;

    }
    public ArrayList<String> Permutation(String str) {
        boolean flag[]= new boolean[str.length()];
        return null;

    }
    public String getString(String str,boolean[] flag,int n,String half){//n为层数
        String tempHalf=half;

        if(n==str.length()){
            return half;
        }
        for(int i=0;i<str.length();i++){
            if(flag[i]){
                flag[i]=true;
                half=half+str.charAt(i);
                getString(str,flag,n+1,half);
                flag[i]=false;
                half=tempHalf;
            }
            //回溯

        }
        new Thread(() -> System.out.println("Hello")).start();

        return "";

    }
    public String PrintMinNumber(int [] numbers) {//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
        // 打印能拼接出的所有数字中最小的一个。
        // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
        StringBuffer res=new StringBuffer();
        //res.append(numbers[0]);
        return  res.toString();

    }
    public String PrintMinNumber2(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str,new Comparator<String>(){//重写构造器这个类。
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
    public String Print(int[] numbers){
        if(numbers==null||numbers.length==0) return "";
        int len= numbers.length;
        StringBuffer res=new StringBuffer();
        String[]  ss=new String[len];
        for(int i=0;i<len;i++){
            ss[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1=o1+o2;
                String c2=o2+o1;
                return c1.compareTo(c2);//该方法实现字典顺序比较，比较的结果是一位的差别，如果第一位相同，那就比较第二位。
            }
        });
        for(int i=0;i<len;i++){
            res.append(ss[i]);
        }
        return  res.toString();



    }
    public String ReverseSentence(String str) {//反转单词顺序列
        if(str.equals(" ")) return " ";
        String[] list = str.split(" ");
        StringBuffer res=new StringBuffer();
        for(int i=list.length-1;i>=0;i--){
            res.append(list[i]);
            res.append(" ");
        }
        res.delete(res.length()-1,res.length());
        return res.toString();
    }


}
