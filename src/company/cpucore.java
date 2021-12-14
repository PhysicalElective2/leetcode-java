package company;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-10 10:32
 **/
import java.util.Arrays;
import java.util.Scanner;

public class cpucore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        scanner.next()
        char[] chars = str.toCharArray();
        char[] charTemp = new char[chars.length];
        int charCount=0;
        char[] numTemp = new char[chars.length];
        int numCount =0 ;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '?') continue;
            else if(chars[i]>='0' && chars[i]<='9'){
                numTemp[numCount++] = chars[i];
            }else if((chars[i]>='a'&& chars[i]<='z') || (chars[i] >= 'A' || chars[i] <= 'Z')){
                charTemp[charCount++] = chars[i];
            }
        }
        //   System.out.println(str);
        Arrays.sort(charTemp,0,charCount);
        Arrays.sort(numTemp,0,numCount);
        charCount = 0;
        numCount--;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='?') continue;
            else if(chars[i]>='0' && chars[i]<='9') {
                chars[i] = numTemp[numCount--];
            }else if((chars[i]>='a'&& chars[i]<='z') || (chars[i] >= 'A' || chars[i] <= 'Z')){
                chars[i] = charTemp[charCount++];
            }
        }
        String res = new String(chars);
        System.out.println(res);
    }
}