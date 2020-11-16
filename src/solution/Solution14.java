package solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution14 {
    //since 11.16
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o1[2];
                }else {
                    return o2[1]-o1[1];
                }
            }
        });
        int n=people.length;
        int[][] answer =new int[n][];
        for(int[] p:people){
            int spaces=p[1];
            for(int i=0;i<n;i++){
                if(answer[i]==null){
                    if(spaces==0){
                        answer[i]=p;
                        break;
                    }
                    spaces--;
                }
            }

        }
        return answer;

    }

}
