package month4;

import tools.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(2);
        a.next=b;
        b.next=c;
        ListNode d=new ListNode(-2);
        ListNode e=new ListNode(2);
        ListNode f=new ListNode(2);
        d.next=e;
        e.next=f;
        System.out.println(new Test().minusList(a,d));
        HashMap<Integer,Integer> hash =new HashMap<>();
        hash.put(1,0);
    }

    public ListNode minusList(ListNode minuendList, ListNode subtrahenList){
        ListNode a = reverse(minuendList);
        ListNode b = reverse(subtrahenList);
        int carry = 0;
        while(a.next != null){
            int temp = a.val - b.val + carry * 10;
            if (temp < 0){
                carry = 1;
                b.val = temp + 10;
            }else{
                carry = 0;
                b.val = temp;
            }
            a = a.next;
        }

        return new ListNode(0);
    }

    public ListNode reverse(ListNode list2){
        //头节点
        // 0 - 3 - 2 - 1
        ListNode pre = new ListNode(0);
        pre.next = list2;
        ListNode temp = list2.next;
        while(temp != null){
            ListNode temp2 = temp.next;
            pre.next = temp;
            temp.next = list2;
            list2.next = temp2;
            list2 = list2.next;
            temp = list2.next;
        }
        return pre.next;
    }
}
