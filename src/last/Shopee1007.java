package last;

import tools.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-06 16:38
 **/
public class Shopee1007 {
    public static void main(String[] args) {
        Shopee1007 shopee1007 =new Shopee1007();

    }
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public int jump(int[] nums) {
        int length =nums.length;
        int end =0;
        int maxPosition =0;
        int steps =0;
        for(int i=0;i<length-1;i++){
            maxPosition=Math.max(maxPosition,i+nums[i]);
            if(i==end){
                end=maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p=parent.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q=parent.get(q.val);
        }
        return null;

    }

    private void dfs(TreeNode root) {
        if(root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }


}
