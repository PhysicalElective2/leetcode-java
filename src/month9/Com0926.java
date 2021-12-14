package month9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-26 10:30
 **/
public class Com0926 {
    public static void main(String[] args) {
        int[][] grid =new int[][]{
                {20,3,20,17,2,12,15,17,4,15},
                {20,10,13,14,15,5,2,3,14,3}
        };
        long res=new Com0926().gridGame(grid);
        // want 63
        System.out.println(res);

    }
    public static int max;
    public static List<int[]> resList;
    public  long gridGame(int[][] grid) {
        long res=0;
        resList=new ArrayList<>();
        max=0;
        List<int[]> oneList=new ArrayList<>();
        oneList.add(new int[]{0,0});
        int sum =grid[0][0];

        dfs(grid,0,0,oneList,sum);
        System.out.println("max1: "+max);

        for (int[] i:resList){
            grid[i[0]][i[1]]=0;
            System.out.println(i[0]+" "+i[1]);
        }
        max=0;

        oneList=new ArrayList<>();
        oneList.add(new int[]{0,0});
        sum=0;
        dfs(grid,0,0,oneList,sum);

        return max;


    }


    private  void dfs(int[][] grid, int i, int j, List<int[]> oneList,int sum) {
        if(i==grid.length-1&&j==grid[0].length-1){
            System.out.println("oneList: ");
            for (int[] on:oneList){
                System.out.println(on[0]+" "+on[1]);
            }
            System.out.println("sum:" +sum);
            if(sum>max){
                max=sum;
                resList=new ArrayList<>(oneList);
            }
        }
        int nexti=i+1;
        if(nexti<grid.length){
            oneList.add(new int[]{nexti,j});
            sum+=grid[nexti][j];
            dfs(grid,nexti,j,oneList,sum);
            sum-=grid[nexti][j];
            oneList.remove(oneList.size()-1);

        }
        int nextj=j+1;
        if(nextj<grid[0].length){
            oneList.add(new int[]{i,nextj});
            sum+=grid[i][nextj];
            dfs(grid,i,nextj,oneList,sum);
            sum-=grid[i][nextj];
            oneList.remove(oneList.size()-1);
        }
    }

    private void dfs() {
    }

    public int maximumDifference(int[] nums) {
//        int i=0;
//        int j=1;
        int res=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    res=Math.max(res,nums[j]-nums[i]);
                }
            }
        }
        return res;


    }
}
