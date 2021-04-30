package month4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-29 19:02
 **/
public class TME {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String[] nums =sc.nextLine().split("");

        int index=0;
        while (n-->0){
            nums[index++]=sc.nextInt();
        }
        int res=getRes(nums);

    }

    private static int getRes(int[] nums) {
        Set<Integer> set=new HashSet<>();


    }


}
