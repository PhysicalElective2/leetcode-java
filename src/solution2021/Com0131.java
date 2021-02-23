package solution2021;

import java.util.*;

public class Com0131 {

    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = lowLimit; i <= highLimit; i++) {
            int boxNum = getBoxNum(i);
            map.put(boxNum, map.getOrDefault(boxNum, 0) + 1);
            res = Math.max(res, map.get(boxNum));

        }
        return res;

    }
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA= Arrays.stream(A).sum();
        int sumB= Arrays.stream(B).sum();
        int delta =(sumA-sumB)/2;
        Set<Integer> nums=new HashSet<>();
        for(int num:A){
            nums.add(num);
        }
        int[] res=new int[2];
        for(int y:B){
            if(nums.contains(delta-y)){
                res[0]=delta-y;
                res[0] =y;
                break;
            }

        }
        return res;
    }

    public int getBoxNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;

    }

    public int[] restoreArray(int[][] adjacentPairs) {
        return null;


    }

    public static void main(String[] args) {
        Com0131 c = new Com0131();
        c.canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{
                {0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}

        });

    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n=candiesCount.length;
        long[] minCnts=new long[n+1];
        for (int i = 0; i < n; i++) {
            minCnts[i + 1] = minCnts[i] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for(int i=0;i<n;i++){
            int type = queries[i][0];
            long day = queries[i][1];
            long cap = queries[i][2];
            long min = day + 1;
            long max = min * cap;
            if (max > minCnts[type] && min <= minCnts[type + 1]) {
                ans[i] = true;
            }



        }
        return ans;

    }
    //need long
    public boolean[] canEat2(int[] candiesCount, int[][] queries) {
        boolean[] res=new boolean[queries.length];
        int days =queries.length;
        if(days==0) return res;
        for(int i=0;i<days;i++){
            res[i]=oneDayRes(candiesCount,queries[i]);

        }

        return res;

    }

    private boolean oneDayRes(int[] candiesCount, int[] query) {
        int favoriteType =query[0];
        int favoriteDay =query[1];
        int dailyCap =query[2];
        int min = favoriteDay+1;
        int max = (favoriteDay+1)*dailyCap;
        int beforeFavorite=0;
        for(int i=0;i<favoriteType;i++){
            beforeFavorite+=candiesCount[i];
        }
        int minneed =beforeFavorite;
        int maxneed =beforeFavorite+candiesCount[favoriteType];
        return max > minneed && min <= maxneed;
//        if(min>maxneed) return false;
//        if(max<minneed)return false;
//
//        return true;

    }


}
