package solution;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.*;

public class Solution15 {
    public List<String> getList(){
        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Size.L.toString());
        Size[] values=Size.values();
        Arrays.sort(values);
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
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] temp=matrix.clone();
        List<Integer> nums=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums.add(temp[i][j]);

            }
        }
        int count=0;
        for(int j=n-1;j>=0;j--){
            for(int i=0;i<n;i++){
                matrix[i][j]=nums.get(count++);
            }
        }



    }
    public boolean wordPattern(String pattern, String s) {
        boolean res=false;
        Boolean ress=false;
        ActionListener a =e-> System.out.println("ff");
        Object o;
//        o.clone();
//        s.substring();
        String[] ss=s.split(" ");
        if(ss.length!=pattern.length()) return false;
        for(int i=0;i<ss.length;i++){
//            if()
        }

        return  res;


    }
    public int monotoneIncreasingDigits(int N) {
        char[] strN =Integer.toString(N).toCharArray();
        int i=1;
        while (i<strN.length&&strN[i-1]<=strN[i]){
            i++;
        }
        if(i<strN.length){
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }

        }
        return Integer.valueOf(strN.toString());

    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =new HashMap<String,List<String>>();
        for(String s:strs){
            char[] array =s.toCharArray();
            Arrays.sort(array);
            String key =new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);

        }
        return new ArrayList<List<String>>(map.values());
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
