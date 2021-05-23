package month5;

import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-06 10:02
 **/
public class Solution {
    class Trie {
        static final int L =30;
        Trie[] children =new Trie[2];
        public void insert(int val){
            Trie node =this;
            for(int i=L-1;i>=0;--i){
                int bit =(val>>i) & 1;
                if(node.children[bit]==null){
                    node.children[bit]=new Trie();
                }
                node =node.children[bit];
            }
        }
        public int getMaxXor(int val){
            int ans =0;
            Trie node =this;
            for(int i=L-1;i>=0;--i){
                int bit =(val>>i)& 1;
                if(node.children[bit^1]!=null){
                    ans|=1<<i;
                    bit ^=1;
                }
                node =node.children[bit];
            }
            return ans;
        }

    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ=queries.length;
        int[][] newQ =new int[numQ][3];
        for(int i=0;i<numQ;i++){
            newQ[i][0] =queries[i][0];
            newQ[i][1] =queries[i][1];
            newQ[i][2] =i;
        }
        Arrays.sort(newQ, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] ans =new int[numQ];
        Trie trie =new Trie();
        int idx =0,n=nums.length;
        for(int[] query:newQ){
            int x =query[0], m=query[1],qid =query[2];
            while (idx<n&&nums[idx]<=m){
                trie.insert(nums[idx]);
                ++idx;
            }
            if(idx==0){
                ans[qid]=-1;
            }else {
                ans[qid]=trie.getMaxXor(x);
            }
        }
        return ans;



    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp =new int[m][n];
        for(int i=1;i<=m;i++){
            int num1=nums1[i-1];
            for(int j=1;j<=n;j++){
                int num2=nums2[j-1];
                if(num1==num2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int kthLargestValue(int[][] matrix, int k) {
        int m= matrix.length;
        int n= matrix[0].length;
        int[][] pre =new int[m+1][n+1];
        List<Integer> results =new ArrayList<>();
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                pre[i][j]=pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1] ^ matrix[i-1][j-1];
                results.add(pre[i][j]);
            }
        }
        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return results.get(k-1);

    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res=new ArrayList<>();
        Map<String,Integer> cnt =new HashMap<>();
        for(String word:words){
            cnt.put(word,cnt.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry:cnt.entrySet()){
            res.add(entry.getKey());
        }
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  cnt.get(o1)==cnt.get(o2)?  o1.compareTo(o2):cnt.get(o2)-cnt.get(o1);
            }
        });
        return  res.subList(0,k);



    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n= arr.length;
        int[] xors =new int[n+1];
        for(int i=0;i<n;i++){
            xors[i+1] =xors[i]^ arr[i];

        }
        int m =queries.length;
        int[] ans =new int[m];
        for(int i=0;i<m;i++){
            ans[i]=xors[queries[i][0]]^xors[queries[i][1]+1];
        }
        return ans;


    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
    List<Integer> list;
    List<Integer> list2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       list =new ArrayList<>();
       list2=new ArrayList<>();
       dfs(root1);
       dfs2(root2);
       return list.equals(list2);


    }

    private void dfs2(TreeNode root) {

        if(root==null) return;
        if(root.right==null&&root.left==null){
            list2.add(root.val);
            return;
        }
        dfs2(root.right);
        dfs2(root.left);
    }

    private void dfs(TreeNode root1) {
        if(root1==null) return;
        if(root1.right==null&&root1.left==null){
            list.add(root1.val);
            return;
        }
        dfs(root1.right);
        dfs(root1.left);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] anoNums =nums.clone();
        Arrays.sort(anoNums);
        int start = anoNums.length;
        int end = 0;
        for(int i=0;i<anoNums.length;i++){
            if(anoNums[i]!=nums[i]){
                start=Math.min(start,i);
                end =Math.max(end,i);
            }
        }
        return (end-start>=0? end-start+1: 0);


    }
    public int deleteAndEarn(int[] nums) {
        int res=0;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum=new int[max+1];
        for(int val:nums){
            sum[val]+=val;
        }
        return rob(sum);
    }

    private int rob(int[] sum) {
        int size =sum.length;
        int first =sum[0];
        int second =sum[1];
        for(int i=2;i<size;i++){
            int temp=second;
            second=Math.max(second,first+sum[i]);
            first=temp;
        }
        return second;
    }

    public int[] decode(int[] encoded, int first) {
        int[] res=new int[encoded.length+1];
        res[0] =first;
        for(int i=1;i<res.length;i++){
            res[i]=res[i-1] ^ encoded[i-1];
        }
        return res;


    }

}
