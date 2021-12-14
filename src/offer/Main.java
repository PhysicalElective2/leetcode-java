package offer;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-20 19:01
 **/
public class Main {
    public static void main(String[] args) {

        Map<Integer, List<Integer>> mapLine =new HashMap<>();
        Map<Integer,Integer> map =new HashMap<>();
        int max=0;
        Scanner scanner= new Scanner(System.in);
        String line =scanner.nextLine();
        int n= Integer.valueOf(line.split(" ")[0]);
        int m= Integer.valueOf(line.split(" ")[1]);
        for(int i=1;i<=n;i++){
            map.put(i,i);
        }
        for(int i=1;i<=n;i++){
            List<Integer> list =new ArrayList<>();
            list.add(i);
            mapLine.put(i,list);
        }
        while (m-->0){
            line =scanner.nextLine();
            int a= Integer.valueOf(line.split(" ")[0]);
            int b= Integer.valueOf(line.split(" ")[1]);
            int line1 =map.get(a);
            int line2 =map.get(b);
            if(line1!=line2){
                int resLineNum =Math.max(line1,line2);
                mapLine.get(line1).addAll(mapLine.get(line2));
                List<Integer> resLine= mapLine.get(line1);
                mapLine.get(line2).clear();
                mapLine.put(line1,null);
                mapLine.put(resLineNum,resLine);
                for(Integer i:resLine){
                    map.put(i,resLineNum);
                }
                max=Math. max(max,resLine.size());
//                System.out.println(max);
            }else {
                int num=mapLine.get(line1).size();
                System.out.println(max-num);
            }
        }
        int index =0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.print(entry.getValue());
            index++;
            if(index<n){
                System.out.print(" ");
            }

        }
        System.out.println();
    }

}
