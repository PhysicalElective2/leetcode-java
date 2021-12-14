package month8;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-31 20:06
 **/
public class PDD23 {
    public static List<Integer> lineNum;
    public static List<Integer> zhengNum;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=Integer.parseInt(scanner.nextLine());

        while (t-->0){
            String s=scanner.nextLine();
            int n=Integer.parseInt(s);

            System.out.println(qu32(n));

        }


    }
    public static int qu32(int n){
        int lay=0;
        int layLine=0;
        while (layLine<n){
            lay++;
            layLine=2*lay*lay+2*lay;
        }
        int res=lay*lay;
        while (layLine>n){
            if(res==((lay-1)*(lay-1)+1)||res==((lay-1)*(lay-1)+lay)){
                layLine-=3;
                res--;

            }else {
                layLine-=2;
                res--;
            }

        }
        return res;
    }
}
