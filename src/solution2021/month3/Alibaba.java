package solution2021.month3;

import java.util.*;

public class Alibaba {
    public static void main(String[] args) {

        Alibaba a=new Alibaba();
//        List<List<Integer>> res=a.qu(3,9);
//        for(List l:res){
//            System.out.println(l.toString());
//        }
//        System.out.println(a.res(new int[]{0,0,0,1,1}).toString());
        int[][] roads=new int[][]{
                {0,1,3},
                {1,2,2},
                {2,3,1},
                {1,3,4},

        };

//        System.out.println(a.res(roads,4,4));
        a.te();

    }
    int[] p;
    void te(){
       Hashtable<Integer,Integer> ha=new Hashtable<>();
       ha.put(3,4);
       ha.put(2,2);
       ha.put(3,2);
        System.out.println(ha);

//        Collections.sort(s);

    }
    public int res(int[][] roads,int d,int n){
         p=new int[n];
        for(int i=0;i<n;i++){
            p[i] =i;
        }
        for(int[] road:roads){
            //距离小于等于d
            if(road[2]<=d){
                int i=find(road[0]);
                int j=find(road[1]);
                if(i!=j){
                    p[i]=p[j];

                }

            }

        }
//        int res=0;
//        int[] size=new int[n];
        Map<Integer,List<Integer>> set=new HashMap<>();

        for(int i=0;i<n;i++){
            int key =find(i);
//            set.put(key,set.getOrDefault(key,0));
            if(set.containsKey(i)){
                List nodes =set.get(key);
                nodes.add(i);
                set.put(key,nodes);
            }else {
                List<Integer> nodes =new ArrayList<>();
                nodes.add(i);
                set.put(key,nodes);
            }

        }
        int resSize=Integer.MAX_VALUE;
        int ress=-1;
        for(List<Integer> list:set.values()){
            if(list.size()<=resSize){
                ress=list.get(list.size()-1);

            }
        }
        return ress;
    }
    public int find(int x) {
        if (p[x] == x) {
            return x;
        } else {
            return find(p[x]);
        }
    }

    //评测题目: 无
//找一个数字组合，组合是1-9整数且不重复
// 入参
// 总和为X
// 数字数量为Y

// 出参
// 组合列表

    // 例如
// Y = 3, X = 9
// 输出: [[1,2,6], [1,3,5], [2,3,4]]
    List<List<Integer>> res;
    public List<List<Integer>> qu(int x,int y){
        res=new ArrayList<>();
        List<Integer> oneres =new ArrayList<>();
        int sum=0;
        int index=1;
        dfs(sum,index,oneres,x,y);
        return res;

    }
    public int zhongjiang(int[] nums,int k){
        int res=Integer.MIN_VALUE;
        int n=nums.length;
        int dp[][] =new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=i+k&&j<n;j++){
                dp[i][j]=dp[i][j-1]^nums[j];
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;

    }
    public int[]  res(int[] nums){
        //
        int i=0,j=nums.length-1;
        int n=nums.length;
        int wrongSum=0;
        int wrongIndex=-1;
        while (i<j&&wrongSum<=1){
            if(nums[i]==nums[j]){

            }else {
                wrongSum++;
                wrongIndex=i;
            }
            i++;
            j--;

        }
        if(wrongSum<=1){
            if(nums[wrongIndex]>nums[n-wrongIndex-1]){
                nums[wrongIndex]=nums[n-wrongIndex-1];
            }else {
                nums[n-wrongIndex-1]=nums[wrongIndex];
            }
            return nums;

        }
        for(int s=0;s<n;s++){
            if(nums[s]>0) {
                nums[s] =0;
                break;
            }
        }
        return nums;




    }

    private void dfs(int sum, int index, List<Integer> oneres,int x,int y) {
        if(index>=10) return;
        if(sum==y&&oneres.size()==x){
            res.add(new ArrayList<>(oneres));
        }
        if(oneres.size()>=x)return;
        oneres.add(index);
        dfs(sum+index,index+1,oneres,x,y);
        oneres.remove(oneres.size()-1);
        dfs(sum,index+1,oneres,x,y);

    }

    public double res2(int len){
//        int[] dp =new int[len];
        double[] dp = new double[len+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=2;
        for(int i=5;i<=len;i++){
            double oneRes= 0;
            if(i%2==0){
                //
                for(int j=1;j<i/2;j++){
                    oneRes+=(j+dp[i-j])*2;

                }
                oneRes+=dp[i/2];
                dp[i]=oneRes/(i-1);


            }else {
                for(int j=1;j<=i/2;j++){
                    oneRes+=j+dp[i-j]*2;
                }


            }
            dp[i] =oneRes/(i-1);


        }
        return dp[len];
    }



}
