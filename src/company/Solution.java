package company;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-27 12:09
 **/
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set =new HashSet<>();
        int n = s.length();
        int rk =-1;
        int ans =0;
        for(int i=0;i<n;++i){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (rk+1<n&&!set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                ++rk;
            }
            ans=Math.max(ans,rk-i+1);
        }
        return ans;

    }

    public Solution(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);
        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }


}
