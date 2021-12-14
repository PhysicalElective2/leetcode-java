package company;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-11 19:51
 **/
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    static int length = Integer.MAX_VALUE;
    static String result = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
//        String str = "";
//        for(int i = 0; i < 5000;i ++) {
//            str += "ab";
//        }
        length = str.length();
        result = str;
        dfs(str, 0);
        System.out.println(result);
    }

    public static void dfs(String str, int i) {
        if(i == 0) {
            dfs(str, i + 1);
            return;
        }
        if(i >= str.length()) {
            if(str.length() < length) {
                length = str.length();
                result = str;
            }else if(str.length() == length) {
                if(str.compareTo(result) > 0) {
                    result = str;
                }
            }
            return;
        }
        if(str.charAt(i - 1) == 'a' && str.charAt(i) == 'b') {
            //remove a
            String str1 = str.substring(0,i - 1) + str.substring(i,str.length());
            dfs(str1, i - 1);
            //remove b
            String str2 = str.substring(0,i) + str.substring(i + 1, str.length());
            dfs(str2,i);
        }else {
            while(i < str.length() && !(str.charAt(i - 1) == 'a' && str.charAt(i) == 'b')) {
                i++;
            }
            if(i == str.length()) {
                if(str.length() < length) {
                    length = str.length();
                    result = str;
                }else if(str.length() == length) {
                    if(str.compareTo(result) > 0) {
                        result = str;
                    }
                }
            }else{
                dfs(str, i);
            }
//            dfs(str, i + 1);
        }
    }
}