package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    private int size;
    HashMap<Integer,Integer> lru =new HashMap<Integer, Integer>();
    public LRUCache(int capacity) {
        this.size=capacity;

    }

    public int get(int key) {
        if(lru.containsKey(key)){
        }
        return -1;

    }

    public void put(int key, int value) {

    }

}
