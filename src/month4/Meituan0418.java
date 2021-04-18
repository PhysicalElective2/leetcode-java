package month4;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-18 10:02
 **/
public class Meituan0418 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<Node> list =new ArrayList<>();
        int n=Integer.valueOf(sc.nextLine());
        while (n>0){
            n--;
            String line =sc.nextLine();
            if(line.equals("query")){
                List<Node> res=sortandReturn(list);
                if(res.size()==0){
                    System.out.println("null");
                    continue;
                }
                for(Node node:res){
                    System.out.print(node.id+" ");
                }
                System.out.println();

            }else {
                int id = Integer.valueOf(line.split(" ")[1]);
                int add = Integer.valueOf(line.split(" ")[2]);
                addHot(id,add,list);
            }

        }

    }
    public static void addHot(int id,int val,List<Node> list){
        boolean have =false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).id==id){
                list.get(i).val+=val;
                have=true;
            }
        }
        if(!have){
            Node node =new Node(id,val);
            list.add(node);
        }

    }
    public static List<Node> sortandReturn(List<Node> list){
        if(list.size()<=1) return list;
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val!=o2.val){
                    return o2.val-o1.val;
                }else {
                    return o1.id-o2.id;
                }

            }
        });
        if(list.size()<=10){
            return list;
        }else {
            return list.subList(0,10);
        }



    }
    static class Node{
        public Node(int id,int val){
            this.id=id;
            this.val=val;

        }
        int id;
        int val;
    }
}
