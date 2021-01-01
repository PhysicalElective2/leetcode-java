package solution2021;

public class S1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        if(flowerbed.length==1)

        if(flowerbed[0]==0&&(flowerbed.length==1||flowerbed[1]==0)){
            flowerbed[0]=1;
            n--;
        }
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
            flowerbed[flowerbed[flowerbed.length-1]]=1;
            n--;
        }
        return n<=0;

    }

    public static void main(String[] args) {
        S1 s=new S1();
        System.out.println(s.maxProfit(new int[]{2, 1, 4}));
    }
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for(int i=1;i<res.length;i++){
            res[i]=res[i>>1]+(i&1);


        }
        return res;


    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)return 0;
        int[] have =new int[n];
        int[] haveNot =new int[n];
        have[0] =-prices[0];
        haveNot[0]=0;
        for(int i=1;i<n;i++){
            if(i-2>=0){
                have[i]=Math.max(have[i-1],haveNot[i-2]-prices[i]);

            }else {
                have[i]=Math.max(have[i-1],-prices[i]);
            }
            haveNot[i]=Math.max(haveNot[i-1],have[i-1]+prices[i]);
        }
        for(int i:have){
            System.out.printf(i+"\t");
        }
        System.out.println();
        for(int i:haveNot){
            System.out.printf(i+"\t");
        }
        return haveNot[n-1];

    }
}
