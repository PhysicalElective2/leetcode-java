package solution;

import java.text.CollationElementIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution13 {

    //since 11.5
    public static void main(String[] args){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        strings.removeIf(()-> return true);
        strings.removeIf(e->e.length()<=1);
        ArrayList<Integer> names=new ArrayList<>();
        names.add(1);
        names.add(2);
        names.add(3);
        names.stream().map(Node::new).distinct().collect((Collectors.toList()));
        strings.removeIf((e)-> {
            if(e==null)
                return true;
            return false;
        });
//        Arrays.sort(names, new Comparator<T>() {
//            @Override
//            public int compare(T o1, T o2) {
//                return 0;
//            }
//        });
//        Arrays.sort(names,Comparator.comparing(Integer.bitCount()).thenComparing());
// 获取空字符串的数量
        long count = strings.stream().filter(string -> string.length()>=1).count();
//        Object[] hh= strings.stream().filter(string -> string.length()>=1).;
//        System.out.println(hh);
//        int[] arr1 = new int[]{28,6,22,8,44,17};
//        int[] arr2 = new int[]{22,28,8,6};
//        System.out.println(new Solution13().relativeSortArray(arr1,arr2));




    }
    public int maxProfit(int[] prices, int fee) {
        int[] haveIN =new int[prices.length];
        int[] haveNot =new int[prices.length];
        haveIN[0]=-prices[0];
        haveNot[0]=0;
        for(int i=1;i<prices.length;i++){
            haveIN[i]=Math.max(haveIN[i-1],haveNot[i-1]-prices[i]);
            haveNot[i]=Math.max(haveNot[i-1],haveIN[i-1]+prices[i]-fee);
        }
        return haveNot[prices.length-1];

    }


    public String removeKdigits(String num, int k) {
        Deque<Character> deque =new LinkedList<>();
        int length =num.length();
        for(int i=0;i<length;i++){
            char digit = num.charAt(i);
            while (!deque.isEmpty()&&k>0&&deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for(int i=0;i<k;i++){
            deque.pollLast();
        }
        StringBuilder ret =new StringBuilder();
        boolean leadingZero =true;
        while (!deque.isEmpty()){
            char digit =deque.pollFirst();
            if(leadingZero&&digit=='0'){
                continue;
            }
            leadingZero=false;
            ret.append(digit);
        }
        return ret.length()==0?"0":ret.toString();


    }


    //there answer is pretty good too
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        //should use Collection.sort(),but why (x,y) as Comparator()
        //lambda 
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int[] res=new int[arr1.length];
        Integer[] res=new Integer[arr1.length];
        for(int i=0;i<arr1.length;i++){
            res[i]=arr1[i];
        }
        //notice the "Integer" place
        Map<Integer,Integer> indexInArr2 =new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            indexInArr2.put(arr2[i],i);
        }

        Arrays.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                make -1,keep order
                if(indexInArr2.containsKey(o1)&&indexInArr2.containsKey(o2)){
                    return indexInArr2.get(o1)- indexInArr2.get(o2);
//                    return indexInArr2.getOrDefault(o1,1001)-indexInArr2.getOrDefault(o2,1001)
                }else if(indexInArr2.containsKey(o1)){
                    return -1;
                }else if(indexInArr2.containsKey(o2)){
                    return +1;
                }else {
                    return o1-o2;
                }
            }
        });
        for(int i=0;i<res.length;i++){
            System.out.println("\t"+res[i]);
        }
        int[] realRes=new int[res.length];
        for(int i=0;i<realRes.length;i++){
            realRes[i]=res[i];
        }
        return realRes;


    }
    public ListNode oddEvenList2(ListNode head) {
        //this kind of question,loop deal with two node
        if(head==null){
            return head;
        }
        ListNode evenHead=head.next;
        ListNode odd=head,even=evenHead;
        while (even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return odd;
    }
    public ListNode oddEvenList(ListNode head) {
        //but I think my code is Rubbish
        ListNode evenPre=new ListNode(-1);
        ListNode evenPreFlag=evenPre;
        ListNode oddPre =new ListNode(-1);
        oddPre.next=head;
        int index=1;

        while (oddPre.next!=null){
            System.out.println(("val: "+oddPre.next.val));
            if(index%2==1){
                //save
                oddPre=oddPre.next;


            }else {
                evenPre.next=oddPre.next;
                oddPre.next=oddPre.next.next;
                System.out.println("removed val:"+evenPre.next.val);
                evenPre=evenPre.next;
                evenPre.next=null;
                //then evenPre is the last even
            }
            index++;

        }
        oddPre.next=evenPreFlag.next;

        return head;

    }

    //wrong ,because choice left and right may have different result
    public int findRotateSteps(String ring, String key) {
        int res = 0;
        int index =0;
        //point in 0, when start
        //need find the nearest point,and make to the point
        for(int i=0;i<key.length();i++){
            int nearest =findNearest(index,ring,key.charAt(i));
            //find and turn to
            int needMove=Math.min((nearest+(ring.length()-index))%ring.length(),(index+(ring.length()-nearest))%ring.length());
            index=nearest;
            res+=needMove;


            res++;

        }
        System.out.println(res);

        return res;

    }

    private int findNearest(int index, String ring, char charAt) {

        int[] leftLen =new int[ring.length()];
        int[] rightLen =new int[ring.length()];
        int minLen=ring.length()+1;
        int res=-1;
        for(int i =0;i<ring.length();i++){
            rightLen[i]=(i+(ring.length()-index))%ring.length();
            leftLen[i]=(index+(ring.length()-i))%ring.length();
            if(ring.charAt(i)==charAt){
                //is what I need
                int len =Math.min(rightLen[i],leftLen[i]);
                if(len<minLen){
                    minLen=len;
                    res=i;
                }

            }
        }
        return res;
    }

    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while (j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);


    }

    private void reverse(int[] nums, int i) {
        int left =i;
        int right =nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] res=new int[K][2];
        int[] lens =new int[points.length];
        //first get the maxL
        for(int i=0;i<points.length;i++){
            lens[i]=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
        }
        Arrays.sort(lens);
        int maxL=lens[K-1];
        int index=0;
        for(int i=0;i<points.length;i++){
            if((points[i][0]*points[i][0])+(points[i][1]*points[i][1])<=maxL&&index<K){
                res[index][0]=points[i][0];
                res[index][1]=points[i][1];
                index++;
            }
        }
        return res;

    }
    //answer
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return + ,reverse order;often Ascending
                //return -; often Ascending
                return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]+o2[1]*o2[1];
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }



    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        // if have stock in hand
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],prices[i]+dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }


        return dp[n-1][0];

    }


    public int[] sortByBits(int[] arr) {
        int[] bit=new int[10001];
        List<Integer> list =new ArrayList<>();
        for(int i:arr){
            list.add(i);
            bit[i]=get(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bit[o1]!=bit[o2]){
                    return bit[o1]-bit[o2];

                }else {
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;


    }

    private int get(int x) {
        int res=0;
        while (x!=0){
            res+=x%2;
            x/=2;
        }
        return res;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String s:wordList){
            
        }
        return 0;


    }

}
