package last;

import tools.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-30 09:56
 **/
public class Solution0930 {
    public int search(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    private int helper(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while (i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target) i=m+1;
            else {
                j=m-1;
            }
        }
        return i;
    }

    public String reverseWords(String s) {
        s = s.trim();
        int j=s.length()-1;
        int i=j;
        StringBuilder res= new StringBuilder();
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;
            res.append(s.substring(i+1,j+1)+" ");
            while (i>=0&& s.charAt(i)==' ')i--;
            j=i;

        }
        return res.toString().trim();

    }
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) continue;
                if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];
                else grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
            }

        }
        return grid[m-1][n-1];

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pa =headA;
        ListNode pb =headB;
        while (pa!=pb){
            pa = pa==null?headB:pa.next;
            pb = pb==null?headA:pb.next;
        }
        return pa;
    }
    public int translateNum(int num) {
        char[] ch=String.valueOf(num).toCharArray();
        int len=ch.length;
        int[] dp =new int[len+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=len;i++){
            int n =(ch[i-2]-'0')*10+(ch[i-1]-'0');
            if(n>=10&&n<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[len];

    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        for(int l=1,r=2;l<r;){
            int sum =(l+r)*(r-l+1)/2;
            if(sum==target){
                int[] res=new int[r-l+1];
                for(int i=l;i<=r;i++){
                    res[i-l]=i;
                }
                vec.add(res);
                l++;
            }else if(sum<target){
                r++;
            }else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

}
