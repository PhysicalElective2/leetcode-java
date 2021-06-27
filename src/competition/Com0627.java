package competition;


import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-27 10:30
 **/
public class Com0627 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] res=new Com0627().rotateGrid(grid,2);
        for(int[] line:res){
            for(int i:line){
                System.out.print("\t"+i);
            }
            System.out.println();
        }

    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int levelNum = Math.min(m, n) / 2;
        for (int i = 0; i < levelNum; i++) {
            List<Integer> nums = new ArrayList<>();
            int x = i;
            int y = i;
            while (x < m-i&& grid[x][y] != 0) {
                nums.add(grid[x][y]);
                grid[x][y] = 0;
                x++;
            }
            x--;
            y++;
            while (y < n-i && grid[x][y] != 0) {
                nums.add(grid[x][y]);
                grid[x][y] = 0;
                y++;
            }
            y--;
            x--;
            while (x >= 0+i && grid[x][y] != 0) {
                nums.add(grid[x][y]);
                grid[x][y] = 0;
                x--;
            }
            x++;
            y--;
            while (y >= 0+i && grid[x][y] != 0) {
                nums.add(grid[x][y]);
                grid[x][y] = 0;
                y--;
            }
            int index =0;
            x = i;
            y = i;
            while (x < m && grid[x][y]==0) {
                grid[x][y]=nums.get(((index++)+nums.size()-(k%nums.size()))%nums.size());
                x++;
            }
            x--;
            y++;
            while (y < n && grid[x][y]==0){
                grid[x][y]=nums.get(((index++)+nums.size()-(k%nums.size()))%nums.size());

                y++;
            }
            y--;
            x--;
            while (x >= 0 && grid[x][y] == 0) {
                grid[x][y]=nums.get(((index++)+nums.size()-(k%nums.size()))%nums.size());

                x--;
            }
            x++;
            y--;
            while (y >= 0 && grid[x][y] == 0) {
                grid[x][y]=nums.get(((index++)+nums.size()-(k%nums.size()))%nums.size());

                y--;
            }
        }
        return grid;


    }

    public List<Integer> getNumList(int[][] grid, int k, int l) {
        List<Integer> list = new ArrayList<>();
        int statX = l;
        int statY = l;
        list.add(grid[statX][statY]);
        statX += 1;
        while (statX != l && statY != l) {

        }
        return list;


    }

    public int[][] rotateGridHeyue(int[][] grid, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int count = 0, num = grid.length * grid[0].length;
        int i = 0, j = 0;
        while (count < num) {
            List<Integer> list = new ArrayList<>();
            while (j < grid[0].length && grid[i][j] != -1) {
                list.add(grid[i][j]);
                grid[i][j] = -1;
                j++;
                count++;
            }
            j--;
            i++;
            while (i < grid.length && grid[i][j] != -1) {
                list.add(grid[i][j]);
                grid[i][j] = -1;
                i++;
                count++;
            }
            i--;
            j--;
            while (j >= 0 && grid[i][j] != -1) {
                list.add(grid[i][j]);
                grid[i][j] = -1;
                j--;
                count++;
            }
            j++;
            i--;
            while (i >= 0 && grid[i][j] != -1) {
                list.add(grid[i][j]);
                grid[i][j] = -1;
                i--;
                count++;
            }
            i++;
            j++;
            lists.add(list);
        }
        i = j = count = 0;
        while (count < lists.size()) {
            int x = k;
            List<Integer> temp = lists.get(count);
            while (j < grid[0].length && grid[i][j] == -1) {
                grid[i][j] = temp.get(x % temp.size());
                x++;
                j++;
            }
            j--;
            i++;
            while (i < grid.length && grid[i][j] == -1) {
                grid[i][j] = temp.get(x % temp.size());
                x++;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && grid[i][j] == -1) {
                grid[i][j] = temp.get(x % temp.size());
                x++;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && grid[i][j] == -1) {
                grid[i][j] = temp.get(x % temp.size());
                x++;
                i--;
            }
            i++;
            j++;
            count++;
        }
        return grid;
    }

    public int maxProductDifference(int[] nums) {
        int min1 = Math.min(nums[0], nums[1]);
        int min2 = Math.max(nums[0], nums[1]);
        int max1 = Math.max(nums[0], nums[1]);
        int max2 = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max2 * max1 - min1 * min2;

    }
}
