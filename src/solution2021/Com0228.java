package solution2021;

import java.util.Arrays;

public class Com0228 {
    public static void main(String[] args) {
        Com0228 c=new Com0228();
       int res= c.closestCost(new int[]{3,10},new int[]{2,5},9);
        System.out.println(res);
    }
    int closestNum=Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//        Arrays.sort(toppingCosts);
        int[] toppingCosts2=new int[toppingCosts.length*2];
        for(int i=0;i<toppingCosts.length;i++){
            toppingCosts2[i*2]=toppingCosts[i];
            toppingCosts2[i*2+1]=toppingCosts[i];
        }
        for(int i=0;i<baseCosts.length;i++){
//            int rest = target-baseCosts[i];
             dfs(toppingCosts2,0,baseCosts[i],target);
//            res=Math.max(res,target-res);


        }
        return closestNum;

    }

    private void dfs(int[] toppingCosts2,int index,int sum,int target) {
        if(index>=toppingCosts2.length){
            if(Math.abs(closestNum-target)>Math.abs(sum-target)){
                closestNum=sum;
            }
            if(Math.abs(closestNum-target)==Math.abs(sum-target)&&sum<closestNum){
                closestNum=sum;
            }

            return;
        }
        dfs(toppingCosts2,index+1,sum+toppingCosts2[index],target);
        dfs(toppingCosts2,index+1,sum,target);


    }
}
