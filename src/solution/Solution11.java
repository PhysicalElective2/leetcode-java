package solution;

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
}
