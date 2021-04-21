package month4;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-21 19:28
 **/
//2
//3
//5
//6 5
//0 1
//0 2
//1 3
//1 4
//1 5
    ///5


public class Huawei3 {
    public static int res;
    public static int K;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        K=Integer.parseInt(scanner.nextLine());
        int[] cost =new int[K];
        int index =0;
        while (K-->0){
            cost[index++]=Integer.parseInt(scanner.nextLine());
        }
        String[] line = scanner.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        boolean[] visied =new boolean[n];
        int e=Integer.parseInt(line[1]);
        Map<Integer, List<Integer>> map=new HashMap<>();
        while (e-->0){
             line = scanner.nextLine().split(" ");
            int p=Integer.parseInt(line[0]);
            int s=Integer.parseInt(line[1]);
            if(map.containsKey(p)){
                map.get(p).add(s);
            }else {
                List<Integer> list =new ArrayList<>();
                list.add(s);
                map.put(p,list);
            }
            if(map.containsKey(s)){
                map.get(s).add(p);
            }else {
                List<Integer> list =new ArrayList<>();
                list.add(p);
                map.put(s,list);
            }
        }
        res=Integer.MAX_VALUE;
        dfs(0,map,visied,cost,0);
        System.out.println(res);


    }

    private static void dfs(int i, Map<Integer, List<Integer>> map, boolean[] visied, int[] cost,int costall) {
        System.out.println(" in dfs");
        if(i>=visied.length){
            return;
        }
        if(costall>res){
            return;
        }
        boolean can =true;

        boolean[] tempV =new boolean[visied.length];
        for(int start=0;start<tempV.length;start++){
            if(!visied[start]) can=false;
            tempV[start]=visied[start];
        }
        if(can){
            System.out.println(" can ");
            res=Math.min(res,costall);
            return;
        }
        List<Integer> list =new ArrayList<>();
        for(int ii =0;ii<cost.length;ii++){
            Set<Integer> affect =getNodeThatCanReach(ii+1,map,i);
            affect.forEach(integer -> visied[integer]=true);
            dfs(i+1,map,visied,cost,costall+cost[ii]);
            for(int iii=0;iii<visied.length;iii++){
                visied[iii]=tempV[iii];
            }
            dfs(i+1,map,tempV,cost,costall);
        }
    }
    public static Set<Integer> getNodeThatCanReach( int n,Map<Integer, List<Integer>> map,int start){
        Set<Integer> res=new HashSet<>();
        res.add(start);
        while (n-->0){
            Object[] data=res.toArray();
            for(Object i:data){
                List<Integer> list =map.get(i);
                res.addAll(list);
            }
        }
        return res;
    }
}
