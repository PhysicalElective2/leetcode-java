package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-19 15:49
 **/
public class C3 {
    public static void main(String[] args) {
//        System.out.println("hhh");
//        List<Integer> list =new ArrayList<>();
//        list.add(10);
//        list.add(10);
//        list.add(10);
        Integer a =1000;
        Integer b =1000;


        if(a==b){
            System.out.println("==");
        }else {
            System.out.println("!=");
        }
        //System.out.println(addUp(list.stream()));
    }
    public static int addUp(Stream<Integer> number){
//        int res= number.mapToInt(e -> e).sum();
        int res =number.mapToInt(e->e).sum();
        return res;
    }
}
