package month8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-09-05 18:57
 **/
public class Zijie {
    public static void main(String[] args) {
        String[] s=new String[]{"B","Y","Y","Y","B"};
        System.out.println(qu1(s));
//        Scanner scanner = new Scanner(System.in);
//        String line =scanner.nextLine();
//        int n=Integer.parseInt(line.split(" ")[0]);
//        int k=Integer.parseInt(line.split(" ")[1]);
//        line=scanner.nextLine();
//        int[] nums =new int[n];
//        int index =0;
//
//        for(String s:line.split(" ")){
//            nums[index++]=Integer.parseInt(s);
//        }
//        System.out.println(getmax(nums,n-k));
    }
    public static int qu1(String[] s){
        int res=0;
        for(int i=0;i<s.length;i++){
            if(s[i].equals("B")){
                continue;
            }
            if(i-1>=0&&s[i-1].equals("B")){
                continue;
            }
            if(i+1<s.length&&s[i+1].equals("B")){
               continue;
            }
            s[i]="B";
            res++;
        }
        return res;
    }
    //  要改变量名
    private static int getmax(int[] num, int k) {
        int len = num.length;
        int[] temp = Arrays.copyOf(num, len);

        if(len <  k)
            return 0;

        while(k > 0){
            for(int i=1;i<=len;i++){

                //如果遍历到最后一个数的位置，仍然比左边数小，那就把最后位置的数删掉，只需将len--
                if(i == len){
                    len--;
                    break;
                }
                //发小左边数比右边数小，那就把左边数删掉
                if(temp[i-1] < temp[i]){

                    int index = i;
                    while(index < len)
                        temp[index-1] = temp[index++];

                    len--;
                    break;
                }
            }
            k--;
        }
        int res = 0;
        //把删除的数字还原
        for(int i=0;i<len;i++)
            res = 10*res + temp[i];

        return res;
    }

}
