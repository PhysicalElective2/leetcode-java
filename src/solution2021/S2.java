package solution2021;

import solution2021.design.Node;
import tools.TreeNode;

import javax.xml.bind.annotation.XmlInlineBinaryData;
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
    public List<List<Integer>> threeSum(int[] nums) {
        List res=new ArrayList();

        int n= nums.length;
        if(n==0)return res;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0&&nums[i]==nums[i-1]) i++;
            int sum=-nums[i];
            int j=i+1;
            int k=n-1;
            while (j<k){
                if(nums[j]+nums[k]==sum){
                    List<Integer> oneRes=new ArrayList<>();
                    oneRes.add(nums[i]);
                    oneRes.add(nums[j]);
                    oneRes.add(nums[k]);
                    res.add(oneRes);
                    j++;
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    k--;
                    while (j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }else if(nums[j]+nums[k]<sum){
                    j++;

                }else {
                    k--;

                }

            }


        }
        return res;

    }
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        dp[0] =0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max_square_index =(int) Math.sqrt(n)+1;
        int square_num[] =new int[max_square_index];
        for(int i=1;i<max_square_index;i++){
            square_num[i]=i*i;
        }
        for(int i=1;i<=n;++i){
            for(int s=1;s<max_square_index;++s){
                if(i<square_num[s]){
                    break;
                }
                dp[i]=Math.min(dp[i],dp[i-square_num[s]]+1);
            }
        }
        return dp[n];
    }

    public int maxCoins(int[] nums) {
        int res=0;
        int n =nums.length;
        return 0;



    }
    public int[] hitBricks(int[][] grid, int[][] hits) {
        return new int[0];


    }
    public int removeStones(int[][] stones) {
        Union u =new Union();
        for(int[] stone:stones){
            u.union(stone[0]+10001,stone[1]);
        }
        return stones.length-u.getCount();

    }
    private class Union{
        private Map<Integer,Integer> p;
        private int count;
        public Union(){
            p=new HashMap<>();
            this.count=0;

        }
        public int getCount(){
            return count;

        }
        public int find(int x){
            if(!p.containsKey(x)){
                p.put(x,x);
                count++;
            }
            if(x!=p.get(x)){
                p.put(x,find(p.get(x)));
            }
            return p.get(x);

        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            p.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }





    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder,inorder,0,preorder.length,0,inorder.length);

        return root;

    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd,int preStart,int preEnd) {

        if(preStart>=preEnd||inStart>=inEnd)
            return null;
        int mid =inStart;
        for(;mid<inEnd;mid++){
            if(inorder[mid]==preorder[preStart]){
                break;
            }

        }
        int leftLen =mid-inStart;
        TreeNode node =new TreeNode(preorder[preStart]);
        node.left=build(preorder,inorder,inStart,mid,preStart+1,preStart+leftLen+1);
        node.right=build(preorder,inorder,mid+1,inEnd,preStart+leftLen+1,preEnd);
        return node;


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