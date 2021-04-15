package month4;

import java.util.Scanner;

public class Pdd4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        int n=10;
        int m=10;
        System.out.println(zeroNum(n, m));

    }

    public static int zeroNum(int n, int m) {
        //step 1 get bigest Prime num
        int bigPrime = 1;
        for (int i = 2; i <=m; i++) {
            while (m % i == 0) {
                m= m/ i;
                bigPrime = i;
            }
        }
        System.out.println("bigPrime :"+bigPrime);
        int res=0;
        for(int i =2;i<=n;i++){
            int theNum =i;
            while (theNum>0){
                if(theNum%bigPrime==0){
                    theNum=theNum/bigPrime;
                    res+=1;
                }else {
                    break;
                }
            }

        }
        return res;


    }
}
