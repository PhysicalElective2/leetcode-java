package solution2021.month3;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache l =new LRUCache(2);
        l.put(1,1);
        printQueue(l);

        l.put(2,2);
        printQueue(l);

        l.get(1);
        printQueue(l);

        l.put(3,3);
        printQueue(l);

        System.out.println(l.get(2));

    }
    int capacity;

    public PriorityQueue<Node> keys =new PriorityQueue<>((o1, o2) -> o2.count-o1.count);
    public LRUCache(int capacity) {
        this.capacity=capacity;

    }
    public static void printQueue(LRUCache cache){
        System.out.print("queue.peek =");
        Node peek= cache.keys.peek();
//        System.out.println();
        System.out.println(peek.key+" "+peek.value+" "+peek.count);
        Iterator ite =cache.keys.iterator();
        while (ite.hasNext()){
            Node node= ((Node )ite.next());
            System.out.println(node.key+" "+node.value+" "+node.count);
        }
        System.out.println();


    }

    public int get(int key) {

       for(Node n:keys){
           if(n.key==key){
               afterGetAndPut(n);
               return n.value;
           }
       }
       return -1;

    }

    public void put(int key, int value) {
        if(keys.size()>=capacity){
            //remove the last
            keys.poll();
        }
//        keys.add(new Node(key,value));
        Node n =new Node(key,value);
        keys.add(n);
        afterGetAndPut(n);
    }
    public void afterGetAndPut(Node n){
        n.count=0;
        for(Node nn:keys){
            if(!nn.equals(n)) nn.count++;
        }
        fresh(keys);


    }
     public void  fresh(PriorityQueue<Node> keys){

    }
    class Node{
        int key;
        int value;
        int count;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.count=0;

        }
    }
}
