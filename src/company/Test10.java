package company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-10 10:19
 **/


public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> list = new LinkedList<>();
        for(int i = 0;i < T;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] ch = new char[n][m];
            String res = "NO";
            for(int j = 0;j < n;j++){
                for(int k = 0;k < m;k++){
                    String str = sc.next();
                    ch[j][k] = str.charAt(0);
                }
            }
            for(int a = 1;a < n - 1;a++){
                for(int b = 1;b < m - 1;b++){
                    if(ch[a][b] == '*'){
                        for(int q = 0;q < Math.max(n,m);q++){
                            if(a + q < n && a - q >= 0 && b + q < m && b - q >= 0){
                                if(ch[a + q][b] == '*' && ch[a - q][b] == '*' &&
                                        ch[a][b + q] == '*' && ch[a][b - q] == '*' ){

                                }
                                else{
                                    if(a + q + 1 >= n || ch[a + q + 1][b] == '.'){
                                        if(a - q - 1< 0 || ch[a - q - 1][b] == '.'){
                                            if(a + q + 1 >= n || ch[a][b + q + 1] == '.'){
                                                if(a - q - 1< 0 || ch[a][b - 1 - 1] == '.'){
                                                    res = "YES";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            list.add(res);
        }
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
