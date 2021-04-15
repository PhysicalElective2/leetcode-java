package month4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 第一题
public class Pdd3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pdd3 main3 = new Pdd3();
        String s = bufferedReader.readLine();
        int num = Integer.parseInt(s);
        String s2 = bufferedReader.readLine();
        String[] s1 = s2.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        int res = main3.test3(nums);
        System.out.println(res);
    }

    private int test3(int[] nums) {
        int[] add = new int[nums.length];
        int[] del = new int[nums.length];
        int res = -1;
        add[0] = 1;
        del[del.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                add[i] = add[i - 1] + 1;
            }
            if (nums[i] <= nums[i - 1]) {
                add[i] = 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                del[i] = del[i + 1] + 1;
            }
            if (nums[i] <= nums[i + 1]) {
                del[i] = 1;
            }
        }
        for (int i = 0; i < del.length; i++) {
            if (del[i] != 1 && add[i] != 1) {
                res = Math.max(res, del[i] + add[i] - 1);
            }
        }
        return res;
    }
}
