package last;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-20 20:30
 **/
public class Test {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        new ArrayList<>().contains(1);
        if(list.contains(new Integer(1))){
            System.out.println("contain");
        }else {
            System.out.println(" not contain");
        }
    }
}
