package month4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-16 22:04
 **/
class StreamRank {
    List<Integer> list;
    public static void main(String[] args) {
        StreamRank s=new StreamRank();
        s.track(10);
        s.track(12);
        s.track(8);
        s.track(5);
        s.getRankOfNumber(10);
    }

    public StreamRank() {
        list=new ArrayList<>();

    }

    public void track(int x) {
        list.add(x);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public int getRankOfNumber(int x) {
        int res=0;
        for(int i =0;i<list.size();i++){
            if(list.get(i)<=x){
                res++;
                continue;
            }else {
                break;
            }
        }
        return res;

    }
}
