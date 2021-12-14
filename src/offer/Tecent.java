package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-22 20:51
 **/
public class Tecent {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String line =scanner.nextLine();
        int n =Integer.parseInt(line.split(" ")[0]);
        int k =Integer.parseInt(line.split(" ")[1]);
        String s=scanner.nextLine();


        String res=mostCompetitive(s,k);
        System.out.println(res);


    }
    public static String mostCompetitive(String s, int k) {
        int len = s.length();
        if (k == len) {
            return s;
        }

        // 需要移除的元素的个数
        int removeCount = len - k;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while (removeCount > 0 && !stack.isEmpty() && c > stack.peekLast()) {
                stack.removeLast();
                removeCount--;
            }
            stack.addLast(c);
        }

        // 如果还有可以删除的元素，从末尾删除
        for (int i = 0; i < removeCount; i++) {
            stack.removeLast();
        }

        StringBuilder res=new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(stack.removeFirst());
        }
        return res.toString();
    }


}
