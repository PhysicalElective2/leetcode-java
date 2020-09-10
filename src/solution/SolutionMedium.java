package solution;

import java.util.*;

public class SolutionMedium {
    //can just be used once

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        ArrayList<Integer> path=new ArrayList<>();
        combinationDfs2(candidates,res,path,target,0);
        return res;


    }

    private void combinationDfs2(int[] candidates, List<List<Integer>> res, ArrayList<Integer> path, int target, int i) {
        if(target==0&&res.indexOf(path)<0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=candidates.length){
            return;
        }

        //jump
        combinationDfs2(candidates,res,path,target,i+1);
        //add
        if(target>=candidates[i]){
            path.add(candidates[i]);
            combinationDfs2(candidates,res,path,target-candidates[i],i+1);
            path.remove(path.size()-1);
        }

    }

    //Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //here arringlist is better,they are all the Implementation class of List.
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        //it is hard to wirte this
        //Implement ArrrayList class  Directly
        ArrayList<Integer> path=new ArrayList<Integer>();
        combinationDfs(candidates,path,0,target,res);
        return res;



    }

    private void combinationDfs(int[] candidates, List<Integer> path, int i, int target,List<List<Integer>> res) {
        if(i>=candidates.length){
            return;
        }
        if(target==0){
            if(path.get(0)==7){
                System.out.println("i="+i);
            }
            //shoud use this way to add ArrayList
            res.add(new ArrayList<Integer>(path));
           // res.add(path); wrong way
            return;
        }
        //jump over
        combinationDfs(candidates,path,i+1,target,res);
        //add
        if(target>=candidates[i]){
            target-=candidates[i];
            path.add(candidates[i]);
            //number can be  selectedRepeatedly
            combinationDfs(candidates,path,i,target,res);
            path.remove(path.size()-1);
            target+=candidates[i];


        }
    }

    //k most frequent elements.
    public int[] topKFrequent(int[] nums, int k) {
        //count the sum of each element
        HashMap<Integer,Integer> hash =new HashMap<>();

        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        //use heap to contain the k most frequent nums;
        PriorityQueue<Integer> pq =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//
                return hash.get(o1)-hash.get(o2);
            }
        });
        for(Integer key:hash.keySet()){
            if(pq.size()<k){
                pq.offer(key);
            }else {
                if(hash.get(key)>hash.get(pq.peek())){
                    pq.remove();
                    pq.offer(key);
                }

            }

        }
        //heap->int[] and return
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = pq.remove();
        }
        return ret;



    }

    //Given a linked list, remove the n-th node from the end of list and return its head.

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //may the head need to be removed
        ListNode resPre=new ListNode(-1);
        resPre.next=head;
        ListNode fast=resPre;
        //slow point the preDelete
        ListNode slow=resPre;
        while(n>=0){
            fast=fast.next;
            n--;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return resPre.next;


    }
    //Meditation, one question a day
    List<String> res=new ArrayList<>();
    String numbersToLetters[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;

    }

    public List<String> letterCombinations(String digits) {
        //Depth first traversal
        if(digits.length()==0){
            return res;
        }
        List<Integer> road=new ArrayList<>();
        dfs(digits,road);
        return res;

    }
    public void dfs(String digits,List<Integer> road){
        if(road.size()==digits.length()){
            StringBuilder oneres=new StringBuilder();
            //Still need to follow the sequence digits
            for(int i=0;i<road.size();i++){
                oneres.append(numbersToLetters[digits.charAt(i)-'0'-2].charAt(road.get(i)));
            }
            res.add(oneres.toString());
            return;
        }
        if(road.size()<digits.length()){
            for(int i=0;i<numbersToLetters[digits.charAt(road.size())-'0'-2].length();i++){
                road.add(i);
                dfs(digits,road);
                road.remove(road.size()-1);
            }


        }


    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res =new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-4;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<=nums.length-3;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int lastTwoTar=target-nums[i]-nums[j];
                int m=j+1;
                int n=nums.length-1;
                while (m<n){
                    if(nums[m]+nums[n]==lastTwoTar){
                        List<Integer> oneres=new ArrayList<>();
                        oneres.add(nums[i]);
                        oneres.add(nums[j]);
                        oneres.add(nums[m]);
                        oneres.add(nums[n]);
                        res.add(oneres);

                        m++;
                        while(m+1>=nums.length&&nums[m]==nums[m-1]){
                            m++;
                        }
                        n--;
                        while(n-1>=0&&nums[n]==nums[n+1]){
                            n--;
                        }
                        continue;
                    }
                    if(nums[m]+nums[n]>lastTwoTar){
                        n--;
                        continue;
                    }
                    if(nums[m]+nums[n]<lastTwoTar){
                        m++;
                        continue;
                    }

                }

            }

        }
        return res;

    }

    public static void main(String[] args) {
        SolutionMedium sm=new SolutionMedium();
//        System.out.println(sm.letterCombinations(new String("4545")));

        List<List<Integer>> py= sm.combinationSum2(new int[]{2,5,2,1,2},5);
        System.out.println(py.size());
        for(int h=0;h<py.size();h++){
//            for(int j=0;j<py.get(h).size();j++){
//                System.out.print(py.get(h).get(j));
//            }
            System.out.println(py.get(h));

        }
        List<List<Integer>> py22= sm.combinationSum(new int[]{2,3,6,7},7);
        System.out.println(py22.size());
        for(int h=0;h<py22.size();h++){
//            for(int j=0;j<py.get(h).size();j++){
//                System.out.print(py.get(h).get(j));
//            }
            System.out.println(py22.get(h));

        }



    }


}
