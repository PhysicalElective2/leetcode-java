package month5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-16 11:04
 **/
public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer,Integer> map=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }

    }

    public void add(int index, int val) {
        map.put(nums2[index],map.get(nums2[index])-1);
        map.put(nums2[index]+val,map.getOrDefault(nums2[index]+val,0)+1);
        nums2[index]+=val;

    }

    public int count(int tot) {
        int res=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] >tot) break;
            res+=map.getOrDefault(tot-nums1[i],0);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1=new int[]{1, 1, 2, 2, 2, 3};
        int[] num2=new int[]{1, 4, 5, 2, 5, 4};
        FindSumPairs f =new FindSumPairs(num1,num2);
        System.out.println(f.count(7));
        f.add(3,2);
        System.out.println(f.count(8));

    }
}
