package tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache {

    int capacity;
    List<Node> cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache =new ArrayList<>(capacity);

    }
    public int get(int key) {
        AtomicInteger res= new AtomicInteger(-1);
        cache.forEach((e)->{
            if(e.key==key){
                e.count=0;
                res.set(e.value);
            }else {
                e.count+=1;
            }
        });
        cache.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count-o1.count;
            }
        });
        return res.get();


    }

    public void put(int key, int value) {
        if(cache.size()>=capacity){

        }
        AtomicBoolean have= new AtomicBoolean(false);
        cache.forEach((e)->{
            if(e.key==key){
                e.value=value;
                e.count=0;
                have.set(true);
            }else {
                e.count+=1;
            }
        });

        if(!have.get()&&cache.size()==capacity){
            cache.remove(0);
            cache.add(new Node(key,value));
        }else if(!have.get()) {
            cache.add(new Node(key,value));
        }

        cache.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count-o1.count;
            }
        });

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
