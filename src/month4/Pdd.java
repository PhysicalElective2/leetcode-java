package month4;

import java.util.Scanner;


public class Pdd {
    //第二题
    public static void main(String[] args) {
        String s="sdfsd0";
        //比较的就是字典序
        Scanner sc=new Scanner(System.in);
//        int n =sc.nextInt();
        int n=23;
        System.out.println(getHappy(n));
    }

    private static int getHappy(int n) {
        if(n<=20) return n;
        int res=-1;
        int nn=n;
        while (nn>0){
            if(isHappy(nn)){
                res=nn;
                break;
            }else {
                nn=nn+n;
            }
        }
        return res;
    }
    private static  boolean isHappy(int i){
        int another =-1;
        while (i>0){
            int end =i%10;
            if(end==0||end==1){
                i=i/10;
            }else {
                if(another==-1){
                    another=end;
                    i=i/10;
                }else if(another==end){
                    i=i/10;
                }else {
                    return false;
                }
            }

        }
        return true;
    }



}
