package month7;

import company.ListNode;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-28 15:30
 **/
public class SenseTime {
    public ListNode detectCycle(ListNode head){
        if(head==null){
            return null;
        }
        ListNode slow  =head;
        ListNode fast  =head;
        while (fast !=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else {
                return null;
            }
            if(fast==slow){
                ListNode ptr =head;
                while (ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
