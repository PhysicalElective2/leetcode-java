package solution;

import java.util.*;


public class Solution11 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        //need know the end of a line
        while (!queue.isEmpty()) {
            int size=queue.size();
            //size will change
            for (int i=0;i<size;i++){
                Node node =queue.poll();
                if(i<size-1){
                    node.next=queue.peek();
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                   queue.offer(node.right);
                }

            }

        }

        return root;

    }

    public void bfs(Node root) {
    }

    // two node as a loop
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;

            temp = start;
        }
        return pre.next;

    }

    public int pre = -1;
    public int res = Integer.MAX_VALUE;
    public boolean first = true;

    public int getMinimumDifference(TreeNode root) {
        preOrder(root);
        return res;


    }

    public void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        preOrder(root.left);

        if (pre == -1) {
            //the first node
            pre = root.val;
        } else {
            res = Math.min(res, Math.abs(root.val - pre));
            pre = root.val;
        }
        preOrder(root.right);
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 == 1) return false;
        int taget = sum / 2;
        if (max > taget) return false;
        boolean[][] dp = new boolean[nums.length][taget + 1];
        if (nums[0] <= taget) {
            dp[0][nums[0]] = true;
        }
        //the first just num[0] is true ,i reprent firt-i numbers
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= taget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }
        }


        return dp[nums.length - 1][taget];

    }

    //my way out of time
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 == 1) return false;
        //find a set make its'sum= sum/2;
        boolean res = canFindSumSet(nums, sum / 2, 0);
        return res;
    }

    private boolean canFindSumSet(int[] nums, int sum, int index) {
        boolean res;
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index == nums.length) {
            return false;
        }
        res = canFindSumSet(nums, sum - nums[index], index + 1) || canFindSumSet(nums, sum, index + 1);
        return res;
    }

    private int sum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    //today I
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //mergeTrees
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);
        return res;
    }

    //这和以前的一样，只是用map省去了每次遍历查找节点的步骤
    HashMap<Integer, Integer> inorderArrayMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //why I have no memory for the item
        for (int i = 0; i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);//将节点值和索引倒排，记录
        }
        post = postorder;
        TreeNode res = dpBuild(0, inorder.length - 1, 0, postorder.length - 1);
        //find the minddle in inorder
        return res;


    }

    public TreeNode dpBuild(int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd) {
        if (inorderStart > inorderEnd || postOrderStart > postOrderEnd) {
            return null;
        }
        int root = post[postOrderEnd];
        int rootIndexInInorderArray = inorderArrayMap.get(root);//获取对应的索引
        TreeNode node = new TreeNode(root);
        node.left = dpBuild(inorderStart, rootIndexInInorderArray - 1, postOrderStart, postOrderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = dpBuild(rootIndexInInorderArray + 1, inorderEnd, postOrderStart + rootIndexInInorderArray - inorderStart, postOrderEnd - 1);
        return node;


    }

    List resPathSum = new ArrayList();
    LinkedList<Integer> onePath = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //find the all way that sum == a number
        dpPath(root, sum);
        return resPathSum;

    }

    private void dpPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        onePath.add(root.val);
        sum -= root.val;
        if (root.right == null && root.left == null && sum == 0) {
            //不能直接加进去，为啥来着,第二次遇到了，就得add(new LinkList)
            resPathSum.add(new LinkedList<>(onePath));
        }
        dpPath(root.left, sum);
        dpPath(root.right, sum);
        onePath.pollLast();
    }

    public static void main(String[] args) {
        Solution11 s11 = new Solution11();

        System.out.println(s11.canPartition2(new int[]{2, 2, 3, 5}));
    }
}
