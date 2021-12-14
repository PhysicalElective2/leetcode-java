package last;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-20 20:53
 **/
public class Huawei1 {
    class O{
        int x;
        int y;
    }
    public static void test(){
        List<O> l =new ArrayList<>();
        l.sort(new Comparator<O>() {
            @Override
            public int compare(O o1, O o2) {
                return o2.x-o1.x;
            }
        });

    }
    public static void main(String[] args) {

    }

}
