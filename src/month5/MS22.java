package month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-17 16:04
 **/
public class MS22 {
    public static List<List> res = new ArrayList();
    public static int m;
    public static boolean vi[];

    public static void main(String[] args) {
        int n = 5;
        m = 2;
        int[] nums = new int[n];
        vi =new boolean[n];
        dfs(0, 0, nums);
        for(List<Integer> l:res){
            for(Integer i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    public static void dfs(int i, int sum, int[] nums) {
        if (sum > m) {
            return;
        }
        if (i == nums.length) {
            if (sum <= m) {
                List<Integer> oneRes =new ArrayList<>();
                for(int ii=0;ii<i;++ii){
                    oneRes.add(nums[ii]);
                }
                res.add(oneRes);
            }
            return;
        }

        for (int j = 0; j < vi.length; j++) {
            int[] tempNums = nums;
            if (!vi[j]) {
                vi[j] = true;
                nums[i] = j;
                sum += getRevertNum(nums,i);
                dfs(i + 1, sum, nums);
                vi[j]=false;
                nums = tempNums;

            }
        }

    }

    private static int getRevertNum(int[] nums, int i) {

        return nums[i]-i-1>0?nums[i]-i-1:0;
    }

}
