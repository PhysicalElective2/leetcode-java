package last;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-16 20:10
 **/
public class Honor3 {
    public static int max;
    public static void main(String[] args) {
        max=Integer.MIN_VALUE;
        Scanner scanner =new Scanner(System.in);
        int m =Integer.parseInt(scanner.nextLine());
//        Map<Integer,Integer> map =new HashMap<>();
        Map<Integer, List<Integer>> map =new HashMap<>();
        String line;
        while (m-->0){
            line =scanner.nextLine();
            int start =Integer.parseInt(line.split(" ")[0]);
            int end =Integer.parseInt(line.split(" ")[1]);
             List<Integer> list=map.getOrDefault(start,new ArrayList<>());
             list.add(end);
            map.put(start,list);
        }
        int n =Integer.parseInt(scanner.nextLine());
        int  num=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                dfs(map,n,i,j,num);
            }
        }
        System.out.println(max);
    }

    private static void dfs(Map<Integer, List<Integer>> map, int n, int x, int y,int sum) {

        sum=sum*10+x*3+y+1;

        int num =x*3+y+1;
        if(n==0){
            max=Math.max(max,sum);
            return;
        }
        if(n<0)return;

        int[] nextX=new int[]{0,1,0,-1};
        int[] nextY=new int[]{1,0,-1,0};
        boolean haveNext=false;
        for(int i=0;i<4;i++){
            int x2=x+nextX[i];
            int y2=y+nextY[i];
            int nextNum = x2*3+y2+1;
            if(x2<3&&0<=x2&&y2>=0&&y2<3&&(map.get(num)==null||!map.get(num).contains(nextNum))){
                dfs(map, n-1, x2,y2,sum);
                haveNext=true;
            }
        }
        if(map.get(num)==null||!map.get(num).contains(num)){

            dfs(map,n-1,x,y,sum);
            haveNext=true;
        }
        if(!haveNext){
            return;
        }

    }
}
