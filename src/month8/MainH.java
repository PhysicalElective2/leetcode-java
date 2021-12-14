package month8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-08 20:30
 **/
public class MainH {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String num =bf.readLine();
        int n=Integer.parseInt(num);
        String s=bf.readLine();
        int index = 0;
        int[] res= new int[n];
        StringBuilder stringBuilder= new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stringBuilder.insert(index,'(');
                index++;
            }else if(s.charAt(i)==')'){
                stringBuilder.insert(index,')');
                index++;
            }else if(s.charAt(i)=='L'){
                if(index!=0){
                    index--;
                }
            }else if(s.charAt(i)=='R'){
                if(index!= stringBuilder.length()){
                    index++;
                }

            }else if(s.charAt(i)=='D'){
                if(index!=0){
                    stringBuilder.deleteCharAt(index-1);
                    index--;
                }
            }
            res[i]=judgeIsMatch(stringBuilder);
            res[i]=getV(stringBuilder);

        }
        for(int i=0;i<n;i++){
            if(i!=0){
                System.out.print(" ");
            }
            System.out.print(res[i]);
        }
    }
    public static  int fun(String s){
        int left =0;
        int right =0;
        int maxLen =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){

            }
        }
        return 0;
    }
    public  static int getV(StringBuilder s){
        int maxStackNum =Integer.MIN_VALUE;
        int stackNum=0;
        int left=0;
        int right =0;
        int need=0;
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
        return need==0?maxStackNum:-need;
    }

    private static int judgeIsMatch(StringBuilder sb) {
        int left =0;
        int right =0;
        int res=0;
        int count=0;
        int max=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                left++;
                count++;
                max=Math.max(count,max);
            }else {
                if(left>0){
                    left--;
                }else {
                    res++;
                }
            }
        }
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)==')'){
                right++;
            }else {
                if(right>0){
                    right--;
                }else {
                    res++;
                }
            }
        }
        if(res!=0){
            return -res;
        }else {
            return count;
        }
    }

}
