package last;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-29 18:57
 **/
public class Huawei {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String[] nums = line.split(":");
        if(!noerror(nums)){
            System.out.println("error");
        }else {
            String res=simple(nums);
            System.out.println(res);

        }

    }
    public static String simple(String[] nums){
        StringBuilder res =new StringBuilder();
        List<String> list=new ArrayList<>();
        for(String s:nums){
//            StringBuilder news=new StringBuilder();
            int index=0;
            while (index<s.length()&&s.charAt(index)=='0'){
                index++;
            }
            String news=s.substring(index,s.length());
            if(news.length()>0){
                list.add(news);
            }else {
                list.add("0");
            }
        }
        for(int i=0;i<list.size();i++){
            int starti=i;
            String s=list.get(i);
            if(!s.equals("0")){
                res.append(s);
            }
            if(s.equals("0")){
                int count=1;
                while (i+1<list.size()&&list.get(i+1).equals("0")){
                    i++;
                    count++;
                }
                if(count==1){
                    res.append(s);

                }else if(count>=2){
                    if(res.length()>0&&res.charAt(res.length()-1)==':'){

                    }else {
                        res.append(":");
                    }
                }
            }
            if(starti!=list.size()-1){
                res.append(":");
            }
        }
        return res.toString();


    }
    //2001:0000:3238:DFE1:0063:0000:0000:FEEB
    //0000:0000:0000:0000:0000:0000:0000:0000
    public static boolean noerror(String[] nums){
        boolean res =true;
//        System.out.println("num.length: "+nums.length);
        if(nums.length!=8){
            res=false;
            return res;
        }
        for(String s:nums){
            if(s.length()>4){
//                System.out.println("lenght>4: "+s);
                res=false;
                return res;
            }
        }
        return res;




    }
}
