package solution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Solution7Test {
    public static Solution6 s=new Solution6();

    @BeforeEach
    void setUp() {
         Solution7 s =new Solution7();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rectCover() {

        System.out.println(s.RectCover(5));
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        ListNode res =s.ReverseList(a);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }

}