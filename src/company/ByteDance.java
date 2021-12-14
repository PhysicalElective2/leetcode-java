package company;

import java.math.BigInteger;
import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-10 10:00
 **/
public class ByteDance {
//    public static BigInteger max;
//    public static int max;
    public static int min;
    public static String max;
    public static List<Integer> list;
    public static Map<Integer,Integer>  map;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        min=Integer.MAX_VALUE;
        list=new ArrayList<>();
        qu2(n);
        max=getMax(n);
        System.out.println(max);
        System.out.println(min);

    }
    private static String getMax(int n){
        StringBuilder res=new StringBuilder();


        if(n%2==0){

        }else {
            res.append("7");

            n-=3;

        }
        int count=n/2;
        while (count>0){
            res.append("1");

            count--;

        }
        return res.toString();
    }

    private static int qu2(int n) {

        int[] nums =new int[]{2,3,4,5,6,7};
        map =new HashMap<>();
        map.put(2,1);
        map.put(3,7);
        map.put(4,4);
        map.put(5,2);
        map.put(6,0);
        map.put(7,8);

        for(Integer i:nums){
            int firstNum =map.get(i);
            if(firstNum==0){
                firstNum=6;
            }
            list.add(firstNum);
            dfs(firstNum,n-i);
            list.remove(list.size()-1);
        }

        return 0;


    }
    public static void  dfs(int sum,int rest){
        if(rest==0){
//            System.out.println("onemin:"+sum);
            if(sum>0){
//                System.out.println("one res:");
//                for(Integer i:list){
//                    System.out.print( i+" ");
//                }
//                System.out.println();
                min=Math.min(min,sum);

            }


        }
        if(rest<0){
            return;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(entry.getValue());

            int temp=sum;
            sum=sum*10+entry.getValue();
            rest-=entry.getKey();
            dfs(sum,rest);
            list.remove(list.size()-1);

            rest+=entry.getKey();
            sum=temp;
        }

    }
}
