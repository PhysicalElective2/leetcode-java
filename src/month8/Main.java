package month8;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 19:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.valueOf(scanner.nextLine());
        while (n>0){
            n--;
            String line =scanner.nextLine();
            int x= Integer.valueOf(line.split(" ")[0]);
            int y= Integer.valueOf(line.split(" ")[1]);
            int r= Integer.valueOf(line.split(" ")[2]);
            int res=0;
            if(r==Math.abs(x)){
                res++;
            }else if(r>Math.abs(x)){
                res+=2;
            }
            if(r==Math.abs(y)){
                res++;
            }else if(r>Math.abs(y)) {
                res+=2;
            }
            int xy2=x*x+y*y;
            if(r*r==xy2){
                res--;
            }
//            if(r*r>xy2){
//                res+=2;
//            }
            System.out.println(res);
        }

    }
}
