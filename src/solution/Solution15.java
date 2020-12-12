package solution;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Solution15 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Size.L.toString());
        Size[] values=Size.values();
        Size.L.ordinal();
        Class s=Class.forName("S");
        s.newInstance();
        s.getConstructors();
        s.getModifiers();
//        Integer
//        Array.
        Array.newInstance(s,10);
        Constructor[]constructors=Class.forName("java.lang.String").getConstructors();
//        constructors[0].newInstance()
        int.class.newInstance();
        System.out.println(Arrays.toString(values));

    }
    enum Size{
        S,M,L;
    }
    public ListNode sortList(ListNode head) {
        return sortList(head, null);


    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        //may have just two node
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow =head,fast=head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;



    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<2) return n;
        int[] up =new int[n];
        int[] down =new int[n];
        up[0] =down[0] =1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                down[i]=down[i-1];
                up[i]=Math.max(up[i-1],down[i-1]+1);

            }else if(nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=Math.max(down[i-1],up[i-1]+1);
            }else {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);


    }
}
