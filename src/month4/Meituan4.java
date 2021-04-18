package month4;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-18 10:45
 **/
public class Meituan4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] num =sc.nextLine().split(" ");

        int n=Integer.valueOf(num[0]);
        int m=Integer.valueOf(num[1]);
        int k=Integer.valueOf(num[2]);
        List<TreeNode> list =new ArrayList<>();
        Map<Integer,TreeNode> map =new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new TreeNode());
        }
        while (m>0){
            m--;
            String[] line=sc.nextLine().split(" ");
            int id =Integer.parseInt(line[0]);
            int left =Integer.parseInt(line[1]);
            int right=Integer.parseInt(line[2]);
            map.get(id).left=map.get(left);
            map.get(id).right=map.get(right);
        }
        String[] line =sc.nextLine().split(" ");
        for(int i=0;i<line.length;i++){
            map.get(i+1).val=Integer.parseInt(line[i]);
        }
        int pl=0;
        int pr=Integer.MAX_VALUE;
        visitTree(map.get(k),pl,pr);
        int res=0;
        for(TreeNode node:map.values()){
            if(!node.visit) res++;
        }
        System.out.println(res);
    }

    private static void visitTree(TreeNode treeNode, int pl, int pr) {
        if(treeNode==null) return;
        if(pl>pr){
            return;
        }
        treeNode.visit =true;
        visitTree(treeNode.left,pl,treeNode.val-1);
        visitTree(treeNode.right,treeNode.val,pr);
    }
    static class TreeNode{
        public TreeNode(){}


        private TreeNode left;
        private TreeNode right;
        int id;
        int val;
        public boolean visit;
        int a;
        int b;
    }
}
