package solution2021;

import tools.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Com0110 {
    public static void main(String[] args) {
        int[] jobs =new int[]{38,49,91,59,14,76,84};
        int k=3;
        Com0110 c=new Com0110();
        System.out.println(c.minimumTimeRequired(jobs, 3));

    }
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] res =new int[k];
        for(int i=jobs.length-1;i>=0;i--){
            int  shouldAdd =0;
            for(int j=1;j<k;j++){
                shouldAdd= res[j]<res[shouldAdd]? j:shouldAdd;
            }
            res[shouldAdd]+=jobs[i];

        }
        int result=res[0];
        for(int i=1;i<k;i++){
            result=Math.max(result,res[i]);
        }
        return result;

    }

    int[] p;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        p=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
        }
        for(int[] i:allowedSwaps){
            int px=find(i[0]);
            int py=find(i[1]);
            p[px] =p[py];
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            Map<Integer, Integer> mm = map.getOrDefault(find(i), new HashMap<>());
            mm.put(source[i], mm.getOrDefault(source[i], 0) + 1);
            map.put(find(i), mm);

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> mm = map.getOrDefault(find(i), new HashMap<>());
            if (!mm.containsKey(target[i]) || mm.get(target[i]) <= 0) {
                res++;
            }else {
                mm.put(target[i], mm.get(target[i]) - 1);
            }
        }
        return res;
    }

    private int find(int i) {
        while (p[i]!=i){
            p[i]=find(p[i]);
            i=p[i];
        }
        return i;
    }

    private void swap(int[] source, int i, int i1) {
        int temp =source[i];
        source[i]=source[i1];
        source[i1]=temp;
    }

    private int distance(int[] source, int[] target) {
        int res=0;
        for(int i=0;i<source.length;i++){
            if(source[i]!=target[i]) res++;
        }
        return res;
    }

    public ListNode swapNodes(ListNode head, int k) {
//        ListNode preHead=new ListNode(-1);
//        preHead.next=head;
//        ListNode preFirst=preHead;
//        ListNode preLast =preHead;
        ListNode first=head;
        ListNode last =head;
        ListNode tail =head;

        while (k-1>0){
            first=first.next;
            tail=tail.next;
        }
        while (tail.next!=null){
            tail=tail.next;
            last=last.next;
        }
        int temp=last.val;
        last.val=first.val;
        first.val=temp;
        return head;


    }



    public int[] decode(int[] encoded, int first) {
        int[] res=new int[encoded.length+1];
        res[0]=first;
        int index=0;
        for(int i=0;i<encoded.length;i++){
            first= i==0?first:res[index];
            res[++index]=getOne(first,encoded[i]);

        }
        return res;


    }

    private int getOne(int first, int i) {
        return i^first;
    }
}
