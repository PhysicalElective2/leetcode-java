package month7;


import java.util.HashMap;
import java.util.Map;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-03 21:25
 **/
public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){

        }
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Map<Integer,DLinkedNode> cache =new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;
    public  LRUCache(int capacity){
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;

    }
    public int get(int key){
        DLinkedNode node =cache.get(key);
        if(node==null){
            return -1;

        }
        moveToHead(node);
        return node.value;

    }
    public void put(int key,int value){
        DLinkedNode node=cache.get(key);
        if(node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                --size;

            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }
    private DLinkedNode removeTail() {
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;

    }
    private void addToHead(DLinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }



}
