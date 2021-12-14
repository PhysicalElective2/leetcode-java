package month8;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 20:14
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.valueOf(scanner.nextLine());
        String line = scanner.nextLine();
        StringBuilder s=new StringBuilder();
        int index =0;
        while (n>0){
            n--;
            char c =line.charAt(index++);
            if(c=='('||c==')'){

            }
            s.append(line.charAt(index++));



        }


    }
    public  int getV(StringBuilder s){
        int maxStackNum =0;
        int stackNum=0;
        int need=0;
        int left =0;
        int right =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
                stackNum++;
                maxStackNum=Math.max(maxStackNum,stackNum);
            }else {
                right++;
                if(stackNum>0){
                    stackNum--;
                }else {
                    need++;
                }
            }
        }
        if(stackNum!=0){
            need+=stackNum;
        }
//        if(need==0||)
        return need==0?maxStackNum:-need;
    }
}
