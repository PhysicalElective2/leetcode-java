package month9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-16 14:19
 **/
public class Huawei {
    public static void main(String[] args) {
        String s ="sdfsdsdgsgsdgs";
        String s1 ="987-123-4567";
        String s2 ="123 456 7890";
        String s3 ="(123) 456-7890";
        List l =new ArrayList();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        qu2(l);


    }
    private static  List<String> qu2(List<String> list){

        List<String> res=new ArrayList<>();
        for(String ss:list){
            if(ss.matches("^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$"));
            res.add(ss);

        }
        System.out.println(res.size());


        return res;

    }

    private List<String> qu(String s){
        List<String> preList =readMethod(s);
        List<String> res=new ArrayList<>();
        for(String ss:preList){
            if(ss.matches("^(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}$"));
            res.add(ss);

        }
        System.out.println(res.size());


        return res;

    }
    public static List<String> readMethod(String filePath) {
        System.out.println("filePath: "+filePath);
        List<String> res=new ArrayList<>();
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            line = in.readLine();
            while (line != null) {
//                System.out.println(line);
                res.add(line);
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static void print(String s) {
        Map<Character, List<Integer>> res=new HashMap<>();
        List<Character> list =new ArrayList<>();
        for(int i=0;i<s.length();i++){
            List<Integer> oneres =res.getOrDefault(s.charAt(i),new ArrayList<>());
            oneres.add(i);
            res.put(s.charAt(i),oneres);
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        list.sort((o1, o2) -> o1-o2);

//        for(Map.Entry<Character,List<Integer>> map:res.entrySet()){
//            System.out.print(map.getKey()+" ");
//            System.out.println(map.getValue().size());
//
//        }
    }

}
