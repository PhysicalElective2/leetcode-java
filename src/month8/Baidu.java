package month8;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 22:34
 **/
public class Baidu {
    public int maximumProduct(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack =new LinkedList<>();
        TreeNode prev=null;
        while (root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.right==null||root.right==prev){
                res.add(root.val);
                prev=root;
                root=null;

            }else {
                stack.push(root);
                root=root.right;
            }

        }
        return res;
    }

}
