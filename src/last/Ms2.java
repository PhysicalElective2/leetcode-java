package last;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-18 11:43
 **/
public class Ms2 {
    public static void main(String[] args) {
        int N =5;
        int[] A =new int[]{2,2,1,2};
        int[] B =new int[]{1,3,4,4};
        new Ms2().solution(N,A,B);
        int res= new Ms2().solution(new int[]{3,5,1});
        System.out.println(res);
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int num =0;
        for(int i=A.length-1;i>=0;i--){
            num=num*10+A[i];
        }
        int cheng17 =num*17;
        int res=0;
        while (cheng17>0){
            res+=cheng17%10;
            cheng17/=10;
        }
        return res;

    }
    public int solution(int N, int[] A, int[] B) {
        Map<Integer,Integer> map =new HashMap<>();
        for(Integer i:A){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Integer i:B){
            map.put(i,map.getOrDefault(i,0)+1);
        }
//        int[] nodes =new int[N+1];
        List<Integer> list =new ArrayList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        list.sort(Comparator.comparingInt(o -> map.getOrDefault(o, 0))
                );

        Map<Integer,Integer> score =new HashMap<>();
        int val =1;
        for(Integer i: list){
            score.put(i,val++);
        }
        int res=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            res+=entry.getValue()*score.get(entry.getKey());
        }
        return res;
//        Arrays.sort(nodes);





        // write your code in Java SE 8

    }
}
