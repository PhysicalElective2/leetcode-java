package month5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-09 10:18
 **/
public class MeiTuan {
    public static void main(String[] args) {
        int n;
        int m;
        int k;
        Scanner sc =new Scanner(System.in);
        String[] line =sc.nextLine().split(" ");
        n=Integer.valueOf(line[0]);
        m=Integer.valueOf(line[1]);
        k=Integer.valueOf(line[2]);
        int[][] road =new int[k][5];
        int index=0;
        while (k-->0){
            int[] oneroad =new int[5];
            line =sc.nextLine().split(" ");
            oneroad[0] = Integer.parseInt(line[0]);
            oneroad[1] = Integer.parseInt(line[1]);
            oneroad[2] = Integer.parseInt(line[2]);
            oneroad[3] = Integer.parseInt(line[3]);
            oneroad[4] = Integer.parseInt(line[4]);
            road[index++]=oneroad;
        }
        int res=qu1(n,m,road);
        System.out.println(res);
    }
    public static  int cost;
    private static int qu1(int n, int m, int[][] road) {
       cost=Integer.MAX_VALUE;
       for(int i=0;i<road.length;i++){
           if(road[i][0]==1&&road[i][1]==1){
               dfs(road[i][2],road[i][3],n,m,road,road[i][4]);
           }
       }
       return cost==Integer.MAX_VALUE?-1: cost;
    }

    private static void dfs(int u,int v,int n, int m, int[][] road,int costNow) {
        if(u==n&&v==m){
            cost=Math.min(costNow,cost);
        }
        for(int i=0;i<road.length;i++){
            if(road[i][0]==u&&road[i][1]==v){
                dfs(road[i][2],road[i][3],n,m,road,costNow+road[i][4]);
            }
        }

    }
}
