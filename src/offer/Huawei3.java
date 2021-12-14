package offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-18 20:40
 **/
public class Huawei3 {
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int target = Integer.parseInt(s[0]), len = Integer.parseInt(s[1]);
        String[] numStr = bufferedReader.readLine().split(" ");
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        Arrays.sort(nums);
        dfs(nums, target, 0, 0);
        System.out.println(res);
    }

    private static void dfs(int[] nums, int target, int index, int sum) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs(nums, target, i + 1, sum + nums[i]);
        }
    }
}
