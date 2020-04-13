package solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findKthToTail() {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e =new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        Solution s =new Solution();
        ListNode y=new ListNode(4);
        y.next=null;
        s.FindKthToTail(y,100);

    }
    @Test
    void p(){
         int test[][]={{1,2},{3,4}};
        Solution s =new Solution();
        s.printMatrix(test);

    }
    @Test
    void tClone(){
        Solution3 s =new Solution3();
        RandomListNode a=new RandomListNode(1);
        RandomListNode b=new RandomListNode(2);
        RandomListNode c=new RandomListNode(3);
        RandomListNode d=new RandomListNode(4);
        RandomListNode e=new RandomListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        a.random=c;
        b.random=e;
        d.random=b;
        RandomListNode res=s.Clone(a);
        while(res!=null){
            System.out.println(res.label);
            if(res.random!=null) {System.out.println(res.random.label);}
            else {
                System.out.println("#");
            }
            res=res.next;
        }

    }
    @Test
    void testSum_Solution(){
        Solution3 s =new Solution3();
        int res=s.Sum_Solution(5);
        System.out.println(res);

    }
    @Test
    void pp(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e =new ListNode(5);
        ListNode f=new ListNode(4);
        ListNode g =new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=f;
        f.next=g;

        d.next=e;
        e.next=f;
        Solution3 s =new Solution3();
        ListNode res=s.FindFirstCommonNode(a,d);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
    @Test
    void reverse(){
        Solution4 s=new Solution4();
      //  System.out.println( s.NumberOf1Between1AndN_Solution(13));
        System.out.println(s.LastRemaining_Solution(8,5));
        int[] num={2,3,1,0,2,5,3};
        int length=7;
        int[] d=new int[2];
        System.out.println(s.duplicate(num,length,d));
        System.out.println(d[0]);
      }
    @Test
    void de(){
        Solution4 s=new Solution4();
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(3);
        ListNode e=new ListNode(4);
        ListNode f=new ListNode(4);
        ListNode g=new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=null;
        ListNode res=s.deleteDuplication(a);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }


    }
    @Test
    void pop() {
        Solution5 s=new Solution5();
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println();
        System.out.println("SolutionTest.pop");

        System.out.println( s.IsPopOrder(a,b));


    }
    @Test
    void testThreePoint(){
        Solution5 s =new Solution5();
        int[] a = {1,2,3,4,5};
        s.testthreepoin(a);
    }
    @Test
    void testmaxHeap(){
       Solution8 s =new Solution8();
       s.Insert(1);
       s.Insert(2);
       s.Insert(3);
       s.Insert(4);
       Double res=s.GetMedian();
        System.out.println(res);
        System.out.printf(res+"");
       // System.out.printf(s.GetMedian());
       assert s.GetMedian()==2.5;
    }


}