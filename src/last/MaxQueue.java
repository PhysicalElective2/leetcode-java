package last;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-02 11:58
 **/
public class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;
    public MaxQueue(){
        q=new LinkedList<>();
        d=new LinkedList<>();
    }
    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }
    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }



}
