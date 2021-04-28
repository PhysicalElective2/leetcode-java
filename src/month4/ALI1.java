package month4;

import solution2021.design.Node;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-28 09:12
 **/
public class ALI1 {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int  value)
        {
            this.value = value;
        }
        public void add(Node node)
        {
            if(node == null)
            {
                return;
            }
            //判断传入的节点的值比当前子树的根节点的值大还是小
            if(node.value < this.value)
            {
                //如果左节点为空
                if(this.left == null)
                {
                    this.left = node;
                }
                else
                {
                    this.left.add(node);
                }
            }
            else
            {
                if(this.right == null)
                {
                    this.right =node;
                }
                else
                {
                    this.right.add(node);
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.valueOf(sc.nextLine());

        List<Integer> data =new ArrayList<>();
        while (n-->0){
            data.add(sc.nextInt());
        }
        int[] res=res2(data);
        System.out.println(res[0]+" "+res[1]);
    }


    private static int[] res2(List<Integer> data) {
        Map<Integer,Node> map=new HashMap<>();
        Node root =new Node(data.get(0));
        map.put(0,root);
        for(int i=1;i<data.size();i++){
            Node node =new Node(data.get(i));
            map.put(i,node);
            root.add(node);
        }
        int maxLen=Integer.MIN_VALUE;
        int maxSize =0;
        for(Map.Entry entry:map.entrySet()){
            int leftLen =len((Node)entry.getValue(),true);
            if(leftLen==maxLen){
                maxSize++;
            }else if(leftLen>maxLen){
                maxLen=leftLen;
                maxSize=1;
            }
            int rightLen =len((Node)entry.getValue(),false);

            if(rightLen==maxLen){
                maxSize++;
            }else if(rightLen>maxLen){
                maxLen=rightLen;
                maxSize=1;
            }
        }
        return new int[]{maxLen,maxSize};

    }
    public static int len(Node node,boolean left){
        int res=0;
        while (node!=null){
            if(left){
                node=node.left;
            }else {
                node=node.right;
            }
            res++;
        }
        return res-1;
    }
}
