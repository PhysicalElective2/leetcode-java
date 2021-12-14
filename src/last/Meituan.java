package last;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-24 10:04
 **/
public class Meituan {
    public  static int max;
    public static int maxCost;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line =scanner.nextLine();
        int n= Integer.parseInt(line.split(" ")[0]);
        int m= Integer.parseInt(line.split(" ")[1]);
        maxCost=m;
        List<List<Integer>> lists = new ArrayList<>();
        while (n-->0){
            line=scanner.nextLine();
            List<Integer> onelist =new ArrayList<>();
            String[] strings=line.split(" ");
            for(int i=1;i<strings.length;i++){
                onelist.add(Integer.parseInt(strings[i]));
            }
            lists.add(onelist);
        }
        max=-1;
        int sum=0;
        int lay=0;
        int cost=0;
        dfs(lists,lay,sum,cost);
        System.out.println(max);

    }

    private static void dfs(List<List<Integer>> lists, int lay, int sum, int cost) {
//        System.out.println(lay+" "+sum+ " " +cost);
//        if(lay>lists.size()) return;
        if(cost>maxCost) return;
        if(lay==lists.size()){
            max=Math.max(max,sum);
            return;
        }
        List<Integer> onelist=lists.get(lay);
        for(int i=0;i<=onelist.size()-2;i+=2){
            dfs(lists,lay+1,sum+onelist.get(i+1),cost+onelist.get(i));
        }
    }

}
