package solution;

import java.util.ArrayList;

public class Solution12 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        ListNode anotherHead = head;

        while (anotherHead != null) {
            array.add(anotherHead);
            anotherHead = anotherHead.next;
        }

        ListNode p = head;
        p.next = array.get(array.size() - 1);
        p = p.next;
        for (int i = 1; i < array.size() / 2; i++) {
            p.next = array.get(i);
            p = p.next;
            p.next = array.get(array.size() - i - 1);
            p = p.next;
        }
        if (array.size() % 2 == 1) {
            p.next = array.get(array.size() / 2);
            p = p.next;
        }
        p.next = null;

    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder Sa = new StringBuilder();
        StringBuilder Sb = new StringBuilder();
//        StringBuffer Sb=new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (Sa.length() > 0) {
                    Sa.deleteCharAt(Sa.length() - 1);
                }
            } else {
                Sa.append(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (Sb.length() > 0) {
                    Sb.deleteCharAt(Sb.length() - 1);
                }
            } else {
                Sb.append(T.charAt(i));
            }
        }
        return Sa.toString().equals(Sb.toString());

    }

}
