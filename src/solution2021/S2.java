package solution2021;

import solution2021.design.Node;
import tools.TreeNode;

import java.util.*;

/**
 * since at20210112
 **/

public class S2 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Stack s=new Stack();
//        s.add();
        return new int[0];


    }
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res =new ArrayList<>();
        int num=0;
        for (int i = 0; i < A.length; i++) {
            num=num*2+A[i];
            res.add(num%5==0);


        }
        return res;

    }

    int resDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        resDiameter=1;
        dfs(root);
        // nodeNum -1 is res ;
        return resDiameter-1;




    }

    private int  dfs(TreeNode root) {
        if(root==null) return 0;
        int L =dfs(root.left);
        int R =dfs(root.right);
        resDiameter=Math.max(resDiameter,L+R+1);
        return Math.max(L,R)+1;

    }

    public int leastInterval(char[] tasks, int n) {
        return 0;

    }
    public int[] findRedundantConnection(int[][] edges) {
         int n = edges.length;
         int[] p=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            p[i]=i;

        }
        for(int i=0;i<n;i++){
            int[] edge =edges[i];
            int node1=edge[0];
            int node2=edge[1];
            int f1=find(p,node1);
            int f2=find(p,node2);
            if(f1!=f2){
                p[f1]=f2;
            }else{
                return edge;
            }
        }
        return new int[0];


    }

    private int find(int[] p, int node) {
        while (p[node]!=node){
            p[node]=find(p,p[node]);
            node=p[node];

        }
        return node;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLine = new ArrayList<>();


            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                oneLine.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);

                }
                if(node.right!=null){
                    queue.add(node.right);

                }
            }
            res.add(oneLine);
        }
        return res;

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
