package last;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-20 19:01
 **/
public class HuaweiY {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        String line =scanner.nextLine();
        //[[1,2],[1,3],[2,4],[3,5],[4,7],[3,6],[6,7]]
        Map<Integer,Integer> map =new HashMap<>();
//        line=line.substring(1,line.length()-1);
        int index =0;
        int oneNum =0;

        List<Integer> list =new ArrayList<>();
        boolean havenum=false;
        while (index<line.length()){
            char c=line.charAt(index);
            if('0'<=c&&c<='9'){
                oneNum=oneNum*10+(c-'0');
                havenum=true;
            }else {
                if(havenum){
                    list.add(oneNum);
                    oneNum=0;
                    havenum=false;
                }
            }
            index++;

        }
        for(int i=0;i+1<list.size();i+=2){
            map.put(list.get(i),list.get(i+1));
            map.put(list.get(i+1),list.get(i));
        }
        res=n;
        max =0;
        List<Integer> vi =new ArrayList<>();
        vi.add(n);

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()==n){
                vi.add(entry.getValue());
                dfs(map,entry.getValue(),1,vi);
                vi.remove(vi.size()-1);

            }
        }
        System.out.println(res+" "+max);

    }
    public  static  int max;
    public  static  int res;

    private static void dfs(Map<Integer, Integer> map,int end,int len,List<Integer> vi) {
        if(len>max||len==max&&end<res){
            max=len;
            res=end;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()==end&&!vi.contains(entry.getValue())){
                vi.add(entry.getValue());
                dfs(map,entry.getValue(),len+1,vi);
                vi.remove(vi.size()-1);
            }
        }

    }
}
