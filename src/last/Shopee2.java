package last;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-28 19:56
 **/
public class Shopee2 {


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line1 =scanner.nextLine();
        String line2 =scanner.nextLine();
        boolean res=isMatch(line2,line1);
        if(res){
            System.out.println(1);
        }else {
            System.out.println(0);
        }



    }

    private static boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp =new boolean[m+1][n+1];
        dp[0][0] =true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] =true;
            }else {
                break;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;++j){
                if(p.charAt(j-1)=='*'){
                    dp[i][j] =dp[i][j-1]||dp[i-1][j];

                }else if(p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];

                }else if(p.charAt(j-1)=='#'){
                    boolean thisres=false;
                    int ii=i;
                    while (ii>=0){
                        if(dp[ii][j-1]==true) thisres=true;
                        ii--;
                    }
                    dp[i][j]=thisres;

                }
            }
        }
        return dp[m][n];

    }
}
