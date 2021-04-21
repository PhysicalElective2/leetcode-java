import solution2021.design.Node;

import java.net.InetAddress;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class functionalprogramming {
    public static void main(String[] args) {
        String name="shaoxi";
        //name can not change if it will be used in lambda
        Runnable noA=()-> System.out.println("hh");
        Runnable f=new Runnable() {
            @Override
            public void run() {
                System.out.println("hhh "+name);
            }
        };
        Thread t=new Thread(f);
        t.run();
        //可以通过lanbda 表达式 实现一个函数接口
         Predicate<Integer> s = x->x>5;
        System.out.println(s.test(5));
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        ThreadLocal<Map> threadLocal=ThreadLocal.withInitial(()->hashMap);
        new functionalprogramming().useMap(new HashMap<>());
        System.out.println(new ArrayList<Integer>().stream().filter(a -> a > 0).count());


    }
    public void maptoInt(){
        IntSummaryStatistics i=new ArrayList<Integer>().stream().mapToInt(e->e).summaryStatistics();
        i.getCount();
    }
    public void map(){
        // map can return different struct but can not no return
        List<Node> reslist=new ArrayList<>();
        List<Integer> list =reslist.stream().map(e->{
            return e.val;
        }).collect(Collectors.toList());
        int a=20;
        a=10;
        int finalA = a;
        a+=10;
        list.stream().map(e-> finalA).collect(Collectors.toList());
    }
    public  void useMap(HashMap<String,String> map){
        return;
    }


}
