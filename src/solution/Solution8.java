package solution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * create at 20200413
 */
public class Solution8 {
    //序列化二叉树
    //LinkedList类实现了Queue接口
    private int indexx=-1;

    String Serialize(TreeNode root) {
        if (root==null){
            return "#";
        }
        //这里可以改成‘！’
        return root.val+","+Serialize(root.left) +","+ Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        String[] s=str.split(",");
        indexx++;
        int len = s.length;
        if(indexx >=len){
            return null;
        }
        TreeNode t=null;
        // s 中的元素还是字符串
        if(!s[indexx].equals("#")){
            //t=TreeNode(Integer.parseInt(s[indexx]));
            t= new TreeNode(Integer.parseInt(s[indexx]));
            t.left=Deserialize(str);
            t.right=Deserialize(str);


        }
        return t;


    }
    private  int index=0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {//中序遍历
        if (pRoot!=null){
            TreeNode node = KthNode(pRoot.left,k);
            if(node!=null){
                return node;
            }
            index++;

            if(index==k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;

    }


    private PriorityQueue<Integer> minHeap =new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap =new PriorityQueue<>(15,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int count=0;


    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count%2==0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;

    }

    public Double GetMedian() {
        //Double 和Integer没有任何继承关系,不可以直接强制类型转化
        if(count%2==0){
            //注意除以二得在外面
            return new Double(maxHeap.peek() + minHeap.peek() )/2;

        }
        else {
            return new Double(minHeap.peek());
        }



    }

}
