package last;

import tools.ListNode;
import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-25 16:24
 **/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Solution {

    public int findNthDigit(int n) {
        //0123456789101112131415
        int digit =1;
        long start =1;


        return 0;

    }

    private  int randIndex(Random rand,int min,int max){
        return rand.nextInt(max-min)+min;
    }
    private int countOccurences(int[] nums,int num){
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        List<List<Integer>> res =new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> tmp =new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node =queue.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
    public int majorityElement(int[] nums) {
        Random random =new Random();
        int majorityCount =nums.length/2;
        while (true){
            int candidate =nums[randIndex(random,0,nums.length)];
            if(countOccurences(nums,candidate)>majorityCount){
                return candidate;
            }
        }
    }
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];

        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans =new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            ans.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack =new Stack<>();
        int i =0;
        for(int num:pushed){
            stack.push(num);
            while (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }

        }
        return stack.isEmpty();

    }
    Node pre,head;

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;

    }

    private void dfs(Node cur) {
        if(cur==null){
            return;
        }
        dfs(cur.left);
        if(pre!=null){
            pre.right=cur;

        }else {
            head=cur;
        }
        cur.left=pre;
        pre=cur;
        dfs(cur.right);

    }

    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int pre=0;
        for(int x:nums){
            pre=Math.max(pre+x,x);
            res=Math.max(res,pre);
        }
        return res;

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if(k==0){
            return vec;
        }
        PriorityQueue<Integer> queue =new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            queue.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for(int i=0;i<k;i++){
            vec[i]=queue.poll();
        }
        return vec;

    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val) return head.next;
        ListNode pre =head,cur =head.next;
        while (cur!=null&& cur.val!=val){
            pre=cur;
            cur =cur.next;
        }
        if(cur!=null) pre.next=cur.next;
        return head;


    }
    public int[] exchange(int[] nums) {
        int i =0;
        int j=nums.length-1;
        while (i<j){
            while (i<j&&nums[i]%2==1){
                i++;
            }
            while (i<j&&nums[j]%2==0){
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;

    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int rows =matrix.length;
        int columns=matrix[0].length;
        boolean[][] visited =new boolean[rows][columns];
        int total =rows*columns;
        int[] order =new int[total];
        int row =0;
        int column =0;
        int[][] directions ={
                {0,1},
                {1,0},
                {0,-1},
                {-1,0},
        };
        int directionIndex =0;
        for(int i=0;i<total;i++){
            order[i]=matrix[row][column];
            visited[row][column]=true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];

        }
        return order;


    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null )&& (recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return recur2(root.left,root.right);

    }
    public boolean recur2(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1==null&&treeNode2==null) return true;
        if(treeNode1==null||treeNode2==null) return false;

        return (treeNode1.val==treeNode2.val)&&recur2(treeNode1.left,treeNode2.right)&&recur2(
                treeNode1.right,treeNode2.left
        );

    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return root;
        TreeNode left =mirrorTree(root.left);
        TreeNode right =mirrorTree(root.right);
        root.left=right;
        root.right=left;
        return root;

    }

    private boolean recur(TreeNode a, TreeNode b) {
        if(b==null) return true;
        if(a==null) return false;
        if(a.val!=b.val) return false;
        return recur(a.left,b.left)&& recur(a.right,b.right);
    }

    public int cuttingRope(int n) {
        return 0;



    }
    public TreeNode buildTree(int[] preorder,int[] inorder){
        TreeNode root =build(preorder,inorder,0,preorder.length,0,inorder.length);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if(preStart>=preEnd||inStart>=inEnd){
            return null;
        }
        int mid =inStart;
        for(;mid<inEnd;mid++){
            if(inorder[mid]==preorder[preStart]){
                break;
            }

        }
        int leftLen=mid-inStart;
        TreeNode node=new TreeNode(preorder[preStart]);
        node.left=build(preorder,inorder,inStart,mid,preStart+1,preStart+leftLen+1);
        node.right=build(preorder,inorder,mid+1,inEnd,preStart+leftLen+1,preEnd);
        return node;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;

    }


    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;

        }
        Queue<int[]> queue =new LinkedList<>();
        int[] dx={0,1};
        int[] dy={1,0};
        boolean[][] vis =new boolean[m][n];
        queue.offer(new int[]{0,0});
        vis[0][0] =true;
        int ans =1;
        while (!queue.isEmpty()){
            int[] cell =queue.poll();
            int x=cell[0],y=cell[1];
            for(int i=0;i<2;i++){
                int tx= dx[i]+x;
                int ty=dy[i]+y;
                if (tx < 0 || tx >= m || ty >= n || vis[tx][ty] || get(tx) + get(ty)>k) {
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty]=true;
                ans++;

            }

        }
        return ans;

    }
    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word[k]){
            return false;
        }
        if(k==word.length-1){
            return true;
        }
        board[i][j]='\0';
        boolean res= dfs(board,word,i+1,j,k+1)||
                dfs(board,word,i-1,j,k+1)||
                dfs(board,word,i,j+1,k+1)||
                dfs(board,word,i,j-1,k+1);
        board[i][j]=word[k];
        return res;
    }

    public int minArray(int[] numbers) {
        int low =0;
        int high =numbers.length-1;
        while (low<high){
            int pivot =low+(high-low)/2;
            if(numbers[pivot]<numbers[high]){
                high=pivot;
            }else if(numbers[pivot]>numbers[high]){
                low=pivot+1;
            }else {
                high--;
            }
        }
        return numbers[low];
    }

    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
