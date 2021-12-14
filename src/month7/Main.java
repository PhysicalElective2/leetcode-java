package month7;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-05 15:02
 **/
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(4,4);
        ReentrantLock r=new ReentrantLock();

        Integer a=new Integer(10);
        synchronized (a){
            a.longValue();
        }
        Scanner sc=new Scanner(System.in);
        String line =sc.nextLine();
        String res=qu1(line);
        System.out.println(res);
    }
    

    private static String qu1(String line) {
        StringBuilder sb =new StringBuilder();
        int index =0;
        while (index<line.length()){
            sb.append(line.charAt(index));
            char c =line.charAt(index);
            int count =1;
            while (index+1<line.length()&&c==line.charAt(index+1)){
                count++;
                index++;
            }
            index++;
            if(count>1){
                sb.append(count);
            }
        }
        return sb.toString();
    }
}
