package codeTop;

import tools.ListNode;

import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-29 18:38
 **/
public class Shopee {
    public static void main(String[] args) {
        int[]  nms =new int[]{-1,0,3,5,9,12,2};
        System.out.println(new Shopee().search(nms,2));


    }
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){

            int mid =(l+r)/2;
            if(target==nums[mid]) return mid;
            if(target>nums[mid]){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode pa=headA;
        ListNode pb=headB;
        while (pa!=null){
            pa=pa.next;
            lenA++;
        }
        while (pb!=null){
            pb=pb.next;
            lenB++;
        }
        pa=headA;
        pb=headB;
        if(lenA>lenB){
            while (lenA>lenB){
                pa=pa.next;
                lenA--;
            }

        }else {
            while (lenB>lenA){
                pb=pb.next;
                lenB--;
            }
        }
        while (pa!=null&&pb!=null){
            if(pa==pb) return pa;
            pa=pa.next;
            pb=pb.next;
        }
        return null;



    }
}
