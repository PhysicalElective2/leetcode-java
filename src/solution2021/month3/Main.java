package solution2021.month3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Object o=new Object();
        o.hashCode();
        o.equals(new Object());
//        new String().equals();
        StringBuilder s=new StringBuilder();
        s.equals(new Object());
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {



        }
    }

    public int test2(List<Integer> nums){
        int res=0;
        while (nums.size()!=1){
            int sum =0,i=0,j=nums.size()-1;
            int x=0,y=0;
            for (;i==j;){
                x=0;
                y=0;
                for(int k=0;k<=1;k++){
                    x+=nums.get(k);
                }
                for(int k=j;k<nums.size();k++){
                    y+=nums.get(k);
                }
                if(x<y){
                    i++;
                }else {
                    j--;
                }

            }
            res+=x<y?x:y;
            if(x<y){
                nums=nums.subList(0,i);
            }else {
                nums=nums.subList(j+1,nums.size()-1);
            }
        }
        return res;

    }
}
