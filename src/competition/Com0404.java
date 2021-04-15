package competition;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.sql.ClientInfoStatus;
import java.util.*;

public class Com0404 {
    public static void main(String[] args) {
        Com0404 c=new Com0404();
        int[] num1={1,10,4,4,2,7};
        int[] num2={9,3,5,1,7,4};
        System.out.println(c.minAbsoluteSumDiff(num1,num2));
//        int[][] logs ={
//                {1,1},
//                {2,2},
//                {2,3},
//
//        };
//        int[] res=c.findingUsersActiveMinutes(logs,4);
//        for(int i:res){
//            System.out.println(i);
//        }
//        System.out.println();
    }
    public int minAbsoluteSumDiffOther(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums1){
            set.add(num);
        }
        int base = (int)1e9+7;
        long sum = 0;
        int len = nums1.length;
        int cur = 0;
        for(int i = 0; i < len; i++){
            sum += Math.abs(nums1[i] - nums2[i]);
            sum %= base;

            if(set.ceiling(nums2[i]) != null){
                int temp = set.ceiling(nums2[i]);
                cur = Math.max(cur, Math.abs(nums1[i] - nums2[i]) - Math.abs(temp - nums2[i]));
            }
            if(set.floor(nums2[i]) != null) {
                int temp = set.floor(nums2[i]);
                cur = Math.max(cur, Math.abs(nums1[i] - nums2[i]) - Math.abs(temp - nums2[i]));
            }
        }
        return (int)((sum - cur + base) % base);
    }
    public int minAbsoluteSumDiffHe(int[] nums1, int[] nums2) {
        int res = 0, tempMax = 0, tempI = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = Math.abs(nums1[i] - nums2[i]);
            if (temp > tempMax){
                tempI = i;
                tempMax = temp;
            }
            res = (int) ((res + Math.abs(nums1[i] - nums2[i])) % ( Math.pow(10, 9) + 7));
        }
        int res2 = res - tempMax;
        for (int j : nums1) {
            res = Math.min(res, (res2 + Math.abs(j - nums2[tempI])));
        }
        return res;
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res=0;
        int n=nums1.length;
        int[] mindiff=new int[n];
        int[] mindiff1=new int[n];
        int[] save =new int[n];
        for(int i=0;i<n;i++){
            mindiff[i]=Math.abs(nums1[i]-nums2[i]);
            mindiff1[i]=mindiff[i];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int abs = Math.abs(nums1[j]-nums2[i]);
                if(i!=j&&abs<mindiff[i]){
                    save[i]=mindiff1[i]-abs;
                    mindiff[i]=abs;
//                    target[i]=j;
                }

            }
        }
        int maxSave =Integer.MIN_VALUE;
        int maxSaveIndex =-1;
        for(int i=0;i<n;i++){
            if(save[i]>maxSave){
                maxSave=save[i];
                maxSaveIndex=i;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=maxSaveIndex){
                res+=mindiff1[i];
            }else {
                res+=mindiff[i];
            }

        }
        return res%1000000007;

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res=new int[k];
        Map<Integer, List> map= new HashMap<>();
        for(int[] ii:logs){
            if(map.containsKey(ii[0])){
                List<Integer> oneList=map.get(ii[0]);
                if(!oneList.contains(ii[1])){
                    oneList.add(ii[1]);
                }
                map.put(ii[0],oneList);

            }else {
                List<Integer> oneList=new ArrayList<>();
                oneList.add(ii[1]);
                map.put(ii[0],oneList);
            }
        }
        for(List list:map.values()){
            res[list.size()-1]++;
        }
        return res;
    }
    public String truncateSentence(String s, int k) {
        StringBuilder res=new StringBuilder();
        String[] ress=s.split(" ");
        for(int i=0;i<k;i++){
            res.append(ress[i]);
            if(i!=k-1){
                res.append(" ");
            }
        }
        return  res.toString();
    }

}
