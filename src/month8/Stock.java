package month8;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 22:15
 **/
public class Stock {
    public int maxProfit2(int[] prices){
        int[] haveIn=new int[prices.length];
        int[] haveNot =new int[prices.length];
        haveIn[0] = -prices[0];
        haveNot[0] = 0;
        for(int i=1;i<prices.length;i++){
            haveIn[i] =Math.max(haveIn[i-1],haveNot[i-1]-prices[i]);
            haveNot[i] =Math.max(haveNot[i-1],haveIn[i-1]+prices[i]);
        }
        return haveNot[prices.length-1];
    }
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice=prices[i];
            }else if(prices[i]-minprice>maxprofit){
                maxprofit=prices[i]-minprice;
            }
        }
        return maxprofit;
    }

}
