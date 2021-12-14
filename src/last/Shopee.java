package last;

import tools.ListNode;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-28 19:56
 **/
public class Shopee {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line =scanner.nextLine();
        int num =Integer.parseInt(line);
        StringBuilder stringBuilder =new StringBuilder();
        int count=0;
        while (num>0){
            int onenum =num%10;
            num/=10;
            stringBuilder.append(onenum);
            count++;
            if(count==3){
                stringBuilder.append(",");
                count=0;
            }

        }

        if(stringBuilder.charAt(stringBuilder.length()-1)==','){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        stringBuilder.reverse();

        System.out.println(stringBuilder.toString());




    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy =new ListNode(0,head);
        ListNode cur =dummy;
        while (cur.next!=null && cur.next.next!=null){
            if(cur.next.val ==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }

            }else {
                cur=cur.next;
            }
        }

        return dummy.next;

    }

}
