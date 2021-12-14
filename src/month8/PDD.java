package month8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-14 11:44
 **/
public class PDD {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> output =new ArrayList<>();
        for (int num:nums) {
            output.add(num);
        }
        int n= nums.length;
        backtrack(n,output,res,0);
        return res;

    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if(first==n){
            res.add(new ArrayList<>(output));
        }
        for(int i=first;i<n;i++){
            Collections.swap(output,first,i);
            backtrack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }

    public int singleNonDuplicate(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^=nums[i];
        }
        return res;

    }
    public int singleNonDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

}
