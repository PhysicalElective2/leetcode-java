package competition;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-26 09:41
 **/
public class Com0626 {
    public static void main(String[] args) {
        Com0626 c=new Com0626();
//        System.out.println(Integer.valueOf("7542351161"));
//        System.out.println(c.largestOddNumber("-7542351161"));
        System.out.println(c.numberOfRounds("12:01","12:44"));
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // find each island  the judge
        return 0;


    }
    public int numberOfRounds(String startTime, String finishTime) {
        int startH = Integer.valueOf(startTime.split(":")[0]);
        int startM = Integer.valueOf(startTime.split(":")[1]);
        int finishH = Integer.valueOf(finishTime.split(":")[0]);
        int finishM = Integer.valueOf(finishTime.split(":")[1]);
        if(finishH<startH||finishH==startH&&finishM<startM){
            finishH+=24;
        }
//        while ()
        int res=0;
        while (finishH-1>startH){
            startH++;
            res+=4;
        }
        if(0==startM){
            startM=0;
        }else if(startM<=15){
            startM=15;
        }else if(startM<=30){
            startM=30;
        }else if(startM<=45){
            startM=45;
        }else if(startM<=60){
            startM=0;
            startH++;
        }
        while (startH<finishH||(startH==finishH)&&startM<finishM){
            startM+=15;
            if(startM==60){
                startM=0;
                startH++;
            }
            res++;
        }
        if(!(startH==finishH&&startM==finishM)){
            res--;
        }

      return res>=0?res:0;
    }
    public String largestOddNumber(String num) {
        String resS="";
        for(int i=num.length()-1;i>=0;i--){
            if(Integer.valueOf(num.charAt(i))%2==1){

                resS=num.substring(0,i+1);
                if(resS.charAt(0)=='-'){
                   resS=resS.substring(1);
                }
                break;
            }

        }
        return resS;


    }



}
