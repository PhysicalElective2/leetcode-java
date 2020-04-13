package solution;

import java.util.ArrayList;
import java.util.Stack;


public class Solution6 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //5最长回文子串，好像很难的。
    public String longestPalindrome(String s) {
        return "";
    }
    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
        //子结构可能不要求内存位置相同吧。
        //遍历的过程，如果出现就是子结构。
        //要比较的是数值
        if(root2==null) return false;
        if(root1==null) return false;
        if(root1==root2){
            return true;
        }else {
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        }
    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)  return false;
        return doesTree1HasTree2(root1, root2)|| HasSubtree(root1.left, root2)
                ||HasSubtree(root1.right, root2);
    }

    private boolean doesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2==null)  return true;
        if(root1==null)  return false;
        return root1.val==root2.val && doesTree1HasTree2(root1.left, root2.left)
                && doesTree1HasTree2(root1.right, root2.right);
    }



    public void push(int node) {
        //stack1用来入队
        //stack2 用来出队
        stack1.push(node);

    }

    public int pop() {
        if(stack2.isEmpty()){
            //如果空了，就去提取出栈一全部的。
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int Fibonacci(int n) {
        //F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)
        int[] res=new int[40];
        res[1]=1;
        res[2]=1;
        for(int i=3;i<40;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }
    public int JumpFloor(int target) {//青蛙跳台阶，动态规划
        if(target==1) return 1;
        if(target==2) return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    public int JumpFloorII(int target) {
        if(target==0) return 1;
        int sum=0;
        for(int i=1;i<=target;i++){
            sum+=JumpFloorII(target-i);
        }
        return sum;
    }
    public int RectCover(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        return RectCover(target-1)+RectCover(target-2);
    }
    public int NumberOf1(int n) {//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
       return 0;
    }
    public ListNode Merge(ListNode list1,ListNode list2) {//合并链表
        //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
        if(list1==null) return list2;
        if(list2==null) return list1;
        //ListNode res=new ListNode(list1.val<list2.val?list1.val:list2.val);//还得往前走一部呢。这样不行。
        //以小的为基准吧。,直接使用原来的节点吧，节省空间。
        ListNode res=new ListNode(-1);
        ListNode p=new ListNode(-1);
        ListNode q=new ListNode(-1);
        if(list1.val<=list2.val){
            p=list1.next;
            res=list1;
            res.next=null;
            list1=p;
        }else {
            q=list2.next;
            res=list2;
            res.next=null;
            list2=q;
        }
        ListNode temp=res;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1==null){
            temp.next=list2;
        }
        if(list2==null){
            temp.next=list1;
        }
        return  res;
    }
    public ListNode ReverseList(ListNode head) {//反转链表
        Stack<ListNode> s=new Stack<ListNode>();
        ListNode tem=new ListNode(-1);
        ListNode thiss=new ListNode(-1);
        while(head!=null){
            thiss=head;
            tem=head.next;
            s.push(thiss);
            head=tem;
        }
        ListNode res=s.pop();
        tem=res;
        while(!s.isEmpty()){
             tem.next=s.pop();
             tem=tem.next;
             //最后没有封上。
        }
        tem.next=null;
        return res;

    }
    public int minNumberInRotateArray(int [] array) {//旋转数组的最小元素
        if(array.length==0) return 0;
        for(int i=0;i<array.length;i++){
            if(i+1<=array.length-1){
                if(array[i+1]<array[i]){
                    return array[i+1];
                }
            }

        }
        return array[0];

    }
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if(target==array[i][j]){
                    return true;
                }
                if(target<array[i][j]){
                    break;
                }
            }
        }
        return false;

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //尾到头的顺序
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(listNode==null){
            return res;
        }
        while(listNode!=null){
            res.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> realres = new ArrayList<Integer>();
        for(int i=res.size()-1;i>0;i--){
            realres.add(res.get(i));
        }
        return realres;
    }
        public String replaceSpace(StringBuffer str) {
            char[] res=new char[100];
            int j=0;
            StringBuffer res2=new StringBuffer("");
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==' '){
                    res2.append('%');
                    res2.append('2');
                    res2.append('0');
                }else{
                    res2.append(str.charAt(i));
                }
            }
            return res2.toString();
        }


}
