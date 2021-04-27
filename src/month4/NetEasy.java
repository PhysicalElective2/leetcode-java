package month4;

import tools.ListNode;

public class NetEasy {
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

        ListNode res=new NetEasy().minusList(a,d);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
    public ListNode minusList(ListNode minuendList,ListNode subtrahenList){
//        ListNode res=new ListNode();
        ListNode dummy = new ListNode(-1);
        if(minuendList==null||subtrahenList==null){
            return null;
        }
        boolean flag1=minuendList.val>=0;
        int num1=Math.abs(minuendList.val);
        minuendList=minuendList.next;
        while (minuendList!=null){
            num1=num1*10+minuendList.val;
            minuendList=minuendList.next;
        }
        if(!flag1){
            num1=-num1;
        }

        boolean flag2=subtrahenList.val>=0;
        int num2=Math.abs(subtrahenList.val);
        subtrahenList=subtrahenList.next;
        while (subtrahenList!=null){
            num2=num2*10+subtrahenList.val;
            subtrahenList=subtrahenList.next;
        }
        if(!flag2){
            num2=-num2;
        }
        int res=num1-num2;
        while (res>0){
            ListNode oneNum =new ListNode(res%10);
            res=res/10;
            oneNum.next=dummy.next;
            dummy.next=oneNum;
        }

        return dummy.next;

    }
    public ListNode minusList2(ListNode minuendList,ListNode subtrahenList){
//        ListNode res=new ListNode();
        ListNode dummy = new ListNode(-1);
        if(minuendList==null||subtrahenList==null){
            return null;
        }
        boolean flag1=minuendList.val>=0;
        boolean flag2=subtrahenList.val>=0;

        ListNode revernum1=reverse(minuendList);
        ListNode revernum2=reverse(subtrahenList);

        int num1=Math.abs(minuendList.val);
        minuendList=minuendList.next;
        while (minuendList!=null){
            num1=num1*10+minuendList.val;
            minuendList=minuendList.next;
        }
        if(!flag1){
            num1=-num1;
        }

        int num2=Math.abs(subtrahenList.val);
        subtrahenList=subtrahenList.next;
        while (subtrahenList!=null){
            num2=num2*10+subtrahenList.val;
            subtrahenList=subtrahenList.next;
        }
        if(!flag2){
            num2=-num2;
        }
        int res=num1-num2;
        while (res>0){
            ListNode oneNum =new ListNode(res%10);
            res=res/10;
            oneNum.next=dummy.next;
            dummy.next=oneNum;
        }

        return dummy.next;

    }
    public ListNode reverse(ListNode minuendList){
        ListNode pre =new ListNode(-1);

        while (minuendList!=null){
            minuendList.next=pre.next;
            pre.next=minuendList;
            minuendList=minuendList.next;
        }
        return pre.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 判空输
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        // 遍历两个输链表
        ListNode first = null;
        ListNode head = null;
        int tmp = 0;
        while(l1 != null || l2 != null){
            tmp = tmp + (l1 != null ? l1.val : 0)+(l2 != null ? l2.val : 0);
            if(first == null){
                first = new ListNode(tmp % 10);
                head = first;

            }else{
                first.next= new ListNode(tmp % 10);
                first = first.next;
            }
            l1 = l1 != null ? l1.next:null;
            l2 = l2 != null ? l2.next:null;
            tmp = tmp/10;
        }
        // 处理相加的进位
        if(tmp != 0){
            first.next = new ListNode(tmp);
        }
        return head;

    }

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        int flag = 0;
        while (p1 != null || p2 != null) {
            int temp = flag;
            if (p1 != null) {
                temp += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                temp += p2.val;
                p2 = p2.next;
            }
            if (temp > 9) {
                temp -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            p.next = new ListNode(temp);
            p = p.next;
        }
        if (flag == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }



}
