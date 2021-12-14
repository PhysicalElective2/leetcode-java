package last;

import java.util.List;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-08 20:06
 **/
public class ALi {
    public  static  int mint;
    public static  int maxt;
    public static  int len;
    public  static int t;
    public static char[][] grid;

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line =scanner.nextLine();
        int h = Integer.parseInt(line.split(" ")[0]);
        int w = Integer.parseInt(line.split(" ")[1]);
        t = Integer.parseInt(line.split(" ")[2]);
        grid =new char[h][w];
        for(int i=0;i<h;i++){
            line=scanner.nextLine();
            for(int j=0;j<w;j++){
                grid[i][j]=line.charAt(j);
            }

        }

        boolean[][] visit =new boolean[h][w];

        mint=Integer.MAX_VALUE;
        maxt=Integer.MIN_VALUE;
        len=0;
        int i=0;
        int j=0;
        visit[i][j]=true;
        int oneSupNum=0;
        dfs(i,j,visit,oneSupNum,len);
        System.out.println(maxt);

    }


    private static void dfs(int i, int j,boolean[][] visit,int oneSupNum,int len) {

        if(i==grid.length-1&&j==grid[0].length-1){
            int onet=(t-len)/oneSupNum;
            System.out.println("len:"+len);
            System.out.println("oneSupNum:"+len);
            System.out.println("onet:"+onet);
            maxt=Math.max(maxt,onet);
            return;
        }
        if(i>grid.length||j>grid[0].length||i<0||j<0){
            return;
        }
        if(i+1<grid.length&&!visit[i+1][j]){
            i+=1;
            visit[i][j]=true;
            if(grid[i][j]=='#'){
                dfs(i,j,visit,oneSupNum+1,len);
            }else {
                dfs(i,j,visit,oneSupNum,len+1);
            }
            visit[i][j]=false;
            i-=1;

        }
        if(i-1>0&&!visit[i-1][j]){
            j+=1;
            visit[i][j]=true;
            if(grid[i][j]=='#'){
                dfs(i,j,visit,oneSupNum+1,len);
            }else {
                dfs(i,j,visit,oneSupNum,len+1);
            }
            visit[i][j]=false;
            j-=1;

        }
        if(j-1>0&&!visit[i][j-1]){
            j-=1;
            visit[i][j]=true;
            if(grid[i][j]=='#'){
                dfs(i,j,visit,oneSupNum+1,len);
            }else {
                dfs(i,j,visit,oneSupNum,len+1);
            }
            visit[i][j]=false;
            j+=1;

        }
        if(j+1<grid[0].length&&!visit[i][j+1]){
            j+=1;
            visit[i][j]=true;
            if(grid[i][j]=='#'){
                dfs(i,j,visit,oneSupNum+1,len);
            }else {
                dfs(i,j,visit,oneSupNum,len+1);
            }
            visit[i][j]=false;
            j-=1;
        }

    }


}
