package solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution13 {
    //since 11.5
    public static void main(String[] args){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//注意月份是MM
            Date date = simpleDateFormat.parse("2020-11-01 23:37:30");
            System.out.println(date);

        }catch (Exception e){
            System.out.println("parse Fail");
        }
        Date simpdate = new Date();

        SimpleDateFormat simpleDateFormattime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间："+simpleDateFormattime.format(simpdate));

    }

    public int[] sortByBits(int[] arr) {
        int[] bit=new int[10001];
        List<Integer> list =new ArrayList<>();
        for(int i:arr){
            list.add(i);
            bit[i]=get(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(bit[o1]!=bit[o2]){
                    return bit[o1]-bit[o2];

                }else {
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;


    }

    private int get(int x) {
        int res=0;
        while (x!=0){
            res+=x%2;
            x/=2;
        }
        return res;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String s:wordList){
            
        }
        return 0;


    }

}
