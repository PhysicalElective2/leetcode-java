package last;

import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-29 16:47
 **/
public class Solution0929 {
    public static void main(String[] args) {


    }
    public int[][] findContinuousSequence(int target) {

        return null;

    }

    public String minNumber(int[] nums) {
        String[] strings= new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i] =String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(x,y)->(x+y).compareTo(y+x));
        StringBuilder stringBuilder=new StringBuilder();
        for(String s:strings){
            stringBuilder.append(s);

        }
        return stringBuilder.toString();

    }
    public int[] singleNumbers(int[] nums) {
        int ret=0;
        for(int n:nums){
            ret^=n;
        }
        int div =1;
        while ((div & ret)==0){
            div <<=1;
        }
        int a=0;
        int b =0;
        for(int n:nums){
            if((div&n)!=0){
                a^=n;
            }else {
                b^=n;
            }
        }
        return new int[]{a,b};


    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    List<List<Integer>> res=new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if(root==null) return;
        path.offerLast(root.val);
        target-= root.val;
        if(root.left==null&&root.right==null&&target==0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.pollLast();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            LinkedList<Integer> tmp =new LinkedList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node= queue.poll();
                if(res.size()%2==0){
                    tmp.addLast(node.val);
                }else {
                    tmp.addFirst(node.val);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }

        return res;
    }
}
