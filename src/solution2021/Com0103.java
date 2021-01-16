package solution2021;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Com0103 {
    public static void main(String[] args) {
        System.out.println("哈哈");
        JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),"嘿嘿");
        Com0103 c = new Com0103();
        System.out.println(c.countPairs(new int[]{2, 14, 11, 5, 1744, 2352, 0, 1, 1300, 2796, 0, 4, 376, 1672, 73, 55, 2006, 42, 10, 6, 0, 2, 2, 0, 0, 1, 0, 1, 0, 2, 271, 241, 1, 63, 1117, 931, 3, 5, 378, 646, 2, 0, 2, 0, 15, 1}));
        //   System.out.println(c.countPairs(new int[]{2,14,11,5,1744,2352,0,1,1300,2796,0,4,376,1672,73,55,2006,42,10,6,0,2,2,0,0,1,0,1,0,2,271,241,1,63,1117,931,3,5,378,646,2,0,2,0,15,1}));
    }
    public int getSum(int a,int b){
        while (b!=0){

        }
        return 0;
    }


    public int countPairs(int[] deliciousness){
        Map<Integer, Long> map = new HashMap<>();
        int res = 0;
        for (int d : deliciousness) {
            for (int i = 0; i <= 21; i++) {
                res = (int) ((res + map.getOrDefault((1 << i) - d, 0L)) % 1000000007);
            }
            map.put(d, map.getOrDefault(d, 0L) + 1);
        }
        return  res%1000000007;


    }
    //wrong
    public int countPairs_W(int[] deliciousness) {
        int[] dp = new int[deliciousness.length];
        if (deliciousness.length <= 1) return 0;
        dp[0] = 0;
        dp[1] = isMiOfTwo((deliciousness[1] + deliciousness[0])) ? 1 : 0;
        for (int i = 2; i < deliciousness.length; i++) {
            dp[i] = dp[i - 1] + loop(deliciousness, i);
        }
        return dp[dp.length - 1];


    }

    private int loop(int[] deliciousness, int i) {
        int res = 0;
        int index = 0;
        while (index < i) {
            if (isMiOfTwo(deliciousness[index] + deliciousness[i])) {
                res++;
            }
            index++;
        }
        return res;
    }


    public boolean isMiOfTwo(int i) {
        // if(i==1) return false;
        i &= (i - 1);
        return i == 0;

    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int count = 0;
        int res = 0;
        int index = 0;
        while (count < truckSize && index < boxTypes.length) {
            int oneCount = boxTypes[index][0];
            int oneIndex = 0;
            while (oneIndex < oneCount && count < truckSize) {
                res += boxTypes[index][1];
                count++;
                oneIndex++;
            }
            index++;


        }
        return res;

    }
}
