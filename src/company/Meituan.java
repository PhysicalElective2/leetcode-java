package company;

import java.util.Arrays;

public class Meituan {
    public static void main(String[] args) {
        Meituan m=new Meituan();
        System.out.println(m.getDis(new int[]{2676,4662,8383,357,6595},5));
    }
    public int getDis(int[] A, int n) {
        // write code here
//        Arrays.sort(A);
//        return A[n-1]-A[0];
         int res=Integer.MIN_VALUE;
         for(int i=0;i<n-1;i++){
             for(int j=i+1;j<n;j++){
                 res=Math.max(res,A[j]-A[i]);

             }
         }
         return res;
    }

}
