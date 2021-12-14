package month9;

import java.net.InetAddress;
import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-18 16:11
 **/
public class MeiTuan {
    public  static Set<Integer> set =new HashSet<>();
    public  static Integer res;

    public static void main(String[] args) {
        res=0;
        Scanner scanner =new Scanner(System.in);
        String line=scanner.nextLine();
        int n=Integer.parseInt(line.split(" ")[0]);
        int m=Integer.parseInt(line.split(" ")[1]);
        Set<Integer> set =new HashSet<>();
        Map<Integer,List<Integer>> map =new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        
         while (m-->0){
//             System.out.println("m ="+m);
            line=scanner.nextLine();
            int x =Integer.parseInt(line.split(" ")[0]);
            int y =Integer.parseInt(line.split(" ")[1]);
            List<Integer> xl=map.get(x);
            xl.add(y);
             List<Integer> yl=map.get(y);
             yl.add(x);
        }
         for(int i=1;i<=n;i++){
             List<Integer> now =new ArrayList<>();
             now.add(i);
             dfs(map,i,now);
         }
        System.out.println(res);

    }

    private static void dfs(Map<Integer, List<Integer>> map, int i, List<Integer> now) {
        if(now.size()==5){
            int num=getNum(now);
            if(!set.contains(num)){
                for(Integer iii:now){
                    System.out.print(" "+iii);
                }
                System.out.println();
                res++;
                set.add(num);

            }
        }
        if(now.size()>5){
            return;
        }
        List<Integer> list =map.get(i);
        if(list.size()>0){
            for(Integer ii:list){
                now.add(ii);
                dfs(map,ii,now);
                now.remove(now.size()-1);
            }

        }


    }
    public static int getNum(List<Integer> list){
        int res=0;
        list.sort((o1, o2) -> o1-o2);
        for(Integer i:list){
            res=res*10+i;
        }
        return res;
    }


}
