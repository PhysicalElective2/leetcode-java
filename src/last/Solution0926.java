package last;

import tools.ListNode;

import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-26 11:57
 **/
public class Solution0926 {
    public int cuttingRope2(int n) {
        if(n==2) return 1;


        return 0;

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum =new ListNode(0);
        ListNode cur =dum;
        while (l1!=null&& l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next= l1!=null ?l1:l2;
        return dum.next;
    }
    public int cuttingRope(int n){
        if(n<4) return n-1;
        int res=1;
        while (n>4){
            n=n-3;
            res*=3;
        }
        if(n<4) res*=n;
        if(n==4) res*=4;
        return res;

    }
}
