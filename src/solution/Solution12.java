package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution12 {
    public int videoStitching(int[][] clips, int T) {
        //Backpack problem ,no it is dp
        //dp is hard
        int t[] =new int[T+1];
        Arrays.fill(t,Integer.MAX_VALUE-1);
        t[0]=0;
        for(int i=0;i<=T;i++){
            for(int[] ii:clips){
                if(ii[0]<i && i<=ii[1]){
                    t[i]=Math.min(t[i],t[ii[0]]+1);
                }
            }
        }
        return t[T]==Integer.MAX_VALUE-1?-1:t[T];

    }
    public static void main(String[] args) {
        Solution12 s12=new Solution12();
        ListNode a=new ListNode(-129);
        ListNode b=new ListNode(-129);
        a.next=b;
        b.next=null;
        System.out.println(s12.isPalindrome(a));
    }



    public boolean isPalindrome(ListNode head) {
        boolean res=true;
        List<Integer> array=new ArrayList<Integer>();
        while (head!=null){
            array.add(head.val);
            head=head.next;


        }
        //judge if is palindrom
        Integer i=0;
        Integer j=array.size()-1;
        System.out.println(array.size());
        while (i<=j){

            if(!(array.get(i).equals(array.get(j)))){
                System.out.println("is mot equal");
                System.out.println(array.get(i)+" "+array.get(j));
                res=false;
                break;
            }
            i++;
            j--;
        }
        return res;
    }

    public List<Integer> partitionLabels(String S) {
        int[] last =new int[26];
        int length=S.length();
        for(int i=0;i<length;i++){
            last[S.charAt(i)-'a']=i;
        }

        ArrayList<Integer> partition =new ArrayList<>();
        int start =0,end=0;
        for(int i=0;i<length;i++){
            end =Math.max(end,last[S.charAt(i)-'a']);
            //if the character's index is the end index of all character before the character,can  cut off
            if(i==end){
                partition.add(end-start+1);
                start=end+1;
            }
        }
        return partition;

    }
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while (j<typed.length()){
            if(i<name.length()&&name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j-1)==typed.charAt(j)){
                j++;
            }else {
               return  false;

            }
        }

        return i==name.length();
    }
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
