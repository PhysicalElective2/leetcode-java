package company;

import java.util.HashMap;
import java.util.Map;
// out of time , till 17 /18
public class LRUCache {
    public static void main(String[] args) {
        LRUCache l=new LRUCache(2);
        System.out.println(l.get(2));
        l.put(2,6);
//        l.put(2,2);
        System.out.println(l.get(1));
        l.put(1,5);
        l.put(1,2);
        System.out.println(l.get(1));
        System.out.println(l.get(2));


    }
    Map<Integer,Integer> cache;
    Map<Integer,Integer> visit;
    int capacity;
    public LRUCache(int capacity) {
        cache =new HashMap<> (capacity);
        visit=new HashMap<>(capacity);
        this.capacity=capacity;

    }

    public int get(int key) {
        fresh();
        if(cache.containsKey(key)){
            visit.put(key,0);
            return cache.get(key);
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
//        System.out.println("size:"+cache.size());
        if(!cache.containsKey(key)&&cache.size()==capacity){
            //get the biges
            int deleteKey =getDeleteKey();
            cache.remove(deleteKey);
            visit.remove(deleteKey);
        }
        fresh();
        cache.put(key,value);
        visit.put(key,0);

    }

    private int getDeleteKey() {
        int res=0;
        int max =Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : visit.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                res=entry.getKey();
            }
        }
        System.out.println("delete key ="+res);
        return res;

    }
// my callback
    public void fresh(){

        visit.forEach((k,v)->{
            visit.put(k,v+1);
        });
//        System.out.println("cache.size: "+cache.size());
//        cache.forEach((k,v)->{
//            System.out.print(k+" "+v+"\t");
//        });
//        System.out.println();


    }
}

