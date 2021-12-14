package month8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-15 20:04
 **/
public class Mihayou {
    public static void main(String[] args) {
        Mihayou m=new Mihayou();
        System.out.println(m.computeN(400000));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp =new int[len][len];
        for(int i=0;i<len;++i){
            dp[len-1][i]=triangle.get(len-1).get(i);
        }
        for(int i=len-2;i>=0;--i){
            for(int j=0;j<=i;++j){
                dp[i][j] =Math.min(dp[i+1][j],dp[i+1][i+1]);
                dp[i][j]+=triangle.get(i).get(j);
            }
        }
        return dp[0][0];

    }

    public int computeN (int maxValue) {
        if(maxValue==1){
            return maxValue;
        }
        int pre =1;
        int res=1;
        for(int i=2;i<=maxValue;i++){
            int post = pre+oneNum(i);
//            System.out.println("i:"+i);
//            System.out.println("post:"+post);
            if(post==i){
                res=post;

            }
            pre=post;
        }
        return res;
    }
    public int oneNum(int num){
        int res=0;
        while (num>0){
            if(num%10==1)res++;
            num/=10;
        }
        return res;
    }
    public static int Four=4;
    public int[] nums;
    ArrayList<String> res=new ArrayList<>();
    public ArrayList<String> restoreIpAddresses (String ipStr) {
        nums = new int[Four];
        dfs(ipStr,0,0);
        return res;
        // write code here
    }


    private void dfs(String s, int count,int index) {
        if(count==Four){
            if(index==s.length()){
                StringBuilder oneAdd =new StringBuilder();
                for (int i=0;i<Four;i++){
                    oneAdd.append(nums[i]);
                    if(i!=Four-1){
                        oneAdd.append(".");
                    }
                }
                res.add(oneAdd.toString());
            }
            return;

        }
        if(index==s.length()){
            return;
        }
        if(s.charAt(index)=='0'){
            nums[count]=0;
            dfs(s,count+1,index+1);
        }
        int addr = 0;
        for (int segEnd = index; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                nums[count] = addr;
                dfs(s,count + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }

}
