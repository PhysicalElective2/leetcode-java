package solution2021;

import solution2021.design.Node;
import tools.TreeNode;

import java.util.*;

/**
 * since at20210112
 **/

public class S2 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        return null;


    }
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        Deque<Integer> deque =new LinkedList<>();
        int[] res=new int[n];
        res[n-1] =0;
        deque.addLast(n-1);
        for(int i=n-2;i>=0;i--){
            if(T[deque.peekFirst()]>T[i]){
                res[i]=1;
                deque.addFirst(i);
            }else {
                while (!deque.isEmpty()&&T[deque.peekFirst()]<=T[i]){
                    deque.pollFirst();
                }
                if(deque.isEmpty()){
                    res[i]=0;
                    deque.addFirst(i);
                }else {
                    res[i]=deque.peekFirst()-i;
                    deque.addFirst(i);
                }
            }

        }
        return res;


    }
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root !=null){
            bstToGst(root.right);
            sum+=root.val;
            root.val=sum;
            bstToGst(root.left);

        }
        return root;


    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        Queue<Node> queue = new LinkedList();
        if(root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLine = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                oneLine.add(node.val);
                for (int j = 0; j <node.children.size() ; j++) {
                    queue.add(node.children.get(i));

                }
            }
            res.add(oneLine);
        }
        return res;

    }


}
