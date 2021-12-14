package month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-09 14:51
 **/
public class Huawei {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -2, 4, -1, 2, 1, -5, 4,0,3};
        String s=new String("");
//        System.out.println(new Huawei().maxSubArray(nums));
//        System.out.println(new Huawei().array(nums));
    }

    //别写的一模一样，改一些变量名！！！！
    public List<String> array(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        nums=Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);

        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder oneRes = new StringBuilder();
            oneRes.append(nums[low]);
            if (low < high) {
                oneRes.append("->");
                oneRes.append(nums[high]);
            }
            res.add(oneRes.toString());

        }
        return res;

    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int x : nums) {
            pre = Math.max(x, pre + x);
            res = Math.max(res, pre);
        }
        return res;
    }

}
