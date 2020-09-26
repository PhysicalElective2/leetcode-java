package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution11 {
    //today I
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //mergeTrees
        if(t1==null)return t2;
        if(t2==null)return t1;

        TreeNode res=new TreeNode(t1.val+t2.val);
        res.left=mergeTrees(t1.left,t2.left);
        res.right=mergeTrees(t1.right,t2.right);
        return  res;
    }

    //这和以前的一样，只是用map省去了每次遍历查找节点的步骤
    HashMap<Integer,Integer> inorderArrayMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //why I have no memory for the item
        for(int i=0;i<inorder.length;i++){
            inorderArrayMap.put(inorder[i],i);//将节点值和索引倒排，记录
        }
        post=postorder;
        TreeNode res=dpBuild(0,inorder.length-1,0,postorder.length-1);
        //find the minddle in inorder
        return res;


    }
    public TreeNode dpBuild(int inorderStart,int inorderEnd,int postOrderStart,int postOrderEnd){
        if(inorderStart>inorderEnd||postOrderStart>postOrderEnd){
            return null;
        }
        int root=post[postOrderEnd];
        int rootIndexInInorderArray = inorderArrayMap.get(root);//获取对应的索引
        TreeNode node=new TreeNode(root);
        node.left=dpBuild(inorderStart,rootIndexInInorderArray-1,postOrderStart,postOrderStart+rootIndexInInorderArray-inorderStart-1);
        node.right=dpBuild(rootIndexInInorderArray+1,inorderEnd,postOrderStart+rootIndexInInorderArray-inorderStart,postOrderEnd-1);
        return node;


    }
    List resPathSum =new ArrayList();
    LinkedList<Integer> onePath = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //find the all way that sum == a number
        dpPath(root,sum);
        return resPathSum;

    }
    private void dpPath(TreeNode root,int sum) {
        if(root==null){
            return;
        }
        onePath.add(root.val);
        sum-=root.val;
        if(root.right==null&&root.left==null&&sum==0){
            //不能直接加进去，为啥来着,第二次遇到了，就得add(new LinkList)
            resPathSum.add(new LinkedList<>(onePath));
        }
        dpPath(root.left,sum);
        dpPath(root.right,sum);
        onePath.pollLast();
    }
}
