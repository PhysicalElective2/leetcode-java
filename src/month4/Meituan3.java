package month4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-18 10:48
 **/
public class Meituan3 {


    public static void main(String[] args) throws IOException {
        BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while ((s=buf.readLine())!=null){
            Map<String,Integer> map =new HashMap<>(64);
            Map<String,List<Integer>> list=new HashMap<>(64);

            int n=Integer.parseInt(s),count =0;
            for(int i=0;i<n;i++){
                String[] temp=buf.readLine().split(" ");
                int type =Integer.parseInt(temp[0]);
                if(type==1){
                    if(!map.containsKey(temp[2])){
                        map.put(temp[2],count++);
                        list.put(temp[2],new ArrayList<>());
                    }
                    List<Integer> tempList =list.get(temp[2]);
                    tempList.add(Integer.parseInt(temp[1]));
                }else {
                    int swap =map.get(temp[1]);
                    map.put(temp[1],map.get(temp[2]));
                    map.put(temp[2],swap);
                }
            }
            Map<String,Integer> finalOut =new LinkedHashMap<>();
            map.entrySet().stream().sorted((o1, o2) -> o1.getValue()-o2.getValue())
                    .collect(Collectors.toList()).
                    forEach(e->finalOut.put(e.getKey(),e.getValue()));
            int x =0;
            for(String key:finalOut.keySet()){
                List<Integer> list1=list.get(key);
                for(Integer integer:list1){
                    if(x!=0){
                        System.out.print(" ");
                    }
                    System.out.print(integer);
                    x++;
                }

            }


        }

    }

}
