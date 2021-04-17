package month4;

import java.util.Arrays;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-17 22:16
 **/
public class Yecun {
    public static void main(String[] args) {
        Yecun y=new Yecun();
        int[] A=new int[]{1,2,3,4};
        int[] res=y.solution(A, 4, 6);

        System.out.println(Arrays.toString(res));
    }
    public int[] solution(int[] A, int F, int M) {
        // find F num 'sum = M(A+F) -Sum(A)
        int sumA=0;
        for(int i:A){
            sumA+=i;
        }
        int toSum = (F+A.length)*M -sumA;
        if(toSum>F*6) return new int[]{0};
        if(toSum<0) return new int[]{0};
        int[] res=new int[F];
        int toAdd=0;
        while (toSum>0){
            res[toAdd]++;
            toAdd=(toAdd+1)%F;
            toSum--;
        }
        return res;
    }
    public int solution(int A, int B) {
        // write your code in Java SE 8
        int res=0;
        int a=(int)Math.floor(Math.sqrt(A));
        int b=(int)Math.ceil(Math.sqrt(B));
        while (a<b){
            if(A<=a*(a+1)&&a*(a+1)<=B){
                res++;
            }
            a=a+1;
        }
        return res;

    }
}
