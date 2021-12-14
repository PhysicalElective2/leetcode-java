package offer;

import tools.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-17 10:19
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public String reverseLeftWords(String s, int n) {

        return null;
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur =head;
        Map<Node,Node> map =new HashMap<>();
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);

    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next =reverseList(head.next);
        next.next=head;
        head.next=null;
        return next;
    }
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack= new Stack<ListNode>();
        ListNode temp = head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size =stack.size();
        int[] print =new int[size];
        for(int i=0;i<size;i++){
            print[i] = stack.pop().val;
        }
        return print;

    }

}
