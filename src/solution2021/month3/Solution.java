package solution2021.month3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int size =envelopes.length;
//        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(envelopes, (o1, o2) ->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

        int[] res= new int[size];
        int re=Integer.MIN_VALUE;
        Arrays.fill(res,1);
        for(int i=1;i<size;i++){
            int oneres=1;
//            oneres=Math.max()

            for(int j=0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    oneres=Math.max(oneres,res[j]+1);
                }
            }
            res[i]=oneres;
            re =Math.max(re,res[i]);
        }
        return re;


    }

}
