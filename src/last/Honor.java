package last;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-16 19:05
 **/
public class Honor {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line =scanner.nextLine();
        if(line.length()==0||line.equals("@")){
            System.out.println();
            return;
        }
        String s1 =line.split("@")[0];

        Map<Character,Integer> map =new HashMap<>();
        String[] s11=s1.split(",");

        for(int i=0;i<s11.length;i++){
            Character c=s11[i].split(":")[0].charAt(0);
            int n = Integer.parseInt(s11[i].split(":")[1]);
//            int n =s11[i].split(":")[1].charAt(0)-'0';
            map.put(c,n);
        }
        if(line.split("@").length>1){
            String s2 =line.split("@")[1];
            String[] s22=s2.split(",");

            for(int i=0;i<s22.length;i++){
                Character c=s22[i].split(":")[0].charAt(0);
//                int n =s22[i].split(":")[1].charAt(0)-'0';
                int n = Integer.parseInt(s22[i].split(":")[1]);
                int num =map.get(c);
//            System.out.println("c: "+c+" m: "+n);
                num-=n;
                map.put(c,num);
            }


        }

//        for(Map.Entry<Character,Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//
//        }

        StringBuilder res=new StringBuilder();

        for(int i=0;i<s1.length();i++){
            char c =s1.charAt(i);
            if(map.get(c)!=null&&map.get(c)!=0){
                res.append(c);
                res.append(":");
                res.append(map.get(c));
                res.append(",");
            }
        }
        if(res.length()>0){
            res.deleteCharAt(res.length()-1);
        }
        System.out.println(res.toString());

    }
}
