package month7;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-19 11:36
 **/
// import java.util.List;
import java.util.*;
public class Solution{
    public static void main(String[] args){
        int[] A= new int[]{1,2,3,5,8};
        int[] B =new int[]{2,3,4,5,6};
        Solution s=new Solution();
        List<Integer> res=s.findNum(A,B);
        for(Integer i:res){
            System.out.println(i);
        }



    }
    public static int start =0;
    public List<Integer> findNum(int[] A,int[] B){
        List<Integer> res=new ArrayList<>();
        for(int i:B){
            if(find(A,i)>=0){
                res.add(i);
            }
        }
        return res;
    }
    public int find(int[] A,int num){
        int left =start;
        int right =A.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(num==A[mid]){
                return mid;
            }
            if(A[mid]<num){
                left =mid+1;
                start =left;
            }else{
                right =mid-1;
            }
        }
        return -1;
    }

}