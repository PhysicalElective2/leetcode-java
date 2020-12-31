package company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MinStack {

    /**
     * initialize your data structure here.
     */
    private final int INIT_SIZE = 100;
    private int[] elements;
    private int size;
    Deque<Integer> minStack;
    public MinStack() {
        elements = new int[INIT_SIZE];
        minStack =new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
//        min = Integer.MAX_VALUE;
    }
    public void push(int x) {
        ensureCapacity();       /* 扩容检测 */
        elements[size++] = x;
        /* 维护最小值 */
        minStack.push(Math.min(minStack.peek(),x));
    }
    public void pop() {
        int popNum = elements[--size]; /* 被删除的数 */
        /* 维护最小值 */
        minStack.poll();
    }

    public int top() {
        return elements[size - 1];
    }
    public int getMin() {
        return  minStack.peek();
       // return min;  /* 直接返回最小值 */
    }
    private void ensureCapacity() {
        if(size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }



}
