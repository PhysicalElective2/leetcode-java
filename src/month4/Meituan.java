package month4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Meituan {
    public static void main(String[] args) {
        List<String> list = Stream.of("ffssf","ff","fff").filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>=10;
            }
        }).collect(Collectors.toList());
        System.out.println(list.toArray());
        List<List> ss=new ArrayList<>();
        //what in ss must be a list
        ss.stream().flatMap( nu->nu.stream()).collect(Collectors.toList());
        ConcurrentHashMap<Integer,String> map =new ConcurrentHashMap<>();

        map.size();
        new HashMap<Integer,String>().put(1,"f");
        Function f=new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };
        ExecutorService executorService= Executors.newSingleThreadExecutor();


//        list.stream().map(string->string.toUpperCase()).collect()

    }


}
