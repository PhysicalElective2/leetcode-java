package month5;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-27 19:01
 **/
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nk =sc.nextLine();
        int n =Integer.valueOf(nk.split(" ")[0]);
        int k =Integer.valueOf(nk.split(" ")[1]);
        String nums =sc.nextLine();
        String[] numsList =nums.split(" ");
        int res=get3(numsList,k);
        System.out.println(res);
    }
    private static int get3(String[] line,int k) {
        int n =line.length;
        int[] nums =new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.valueOf(line[i]);
        }
        int res=0;
        PriorityQueue<Integer> queue=new PriorityQueue();
        int index=0;
        while (queue.size()<k){
            queue.add(nums[index++]);
        }
        int oneMid =getMid(queue);
        res+=oneMid;
        for(;index<n;index++){

            queue.remove(nums[index-k]);
            oneMid =getMid(queue);
            res+=oneMid;
            queue.add(nums[index]);
        }
        return res;
    }
    public static int getMid(PriorityQueue<Integer> queue){
        int n=queue.size();
        List<Integer> list=queue.stream().collect(Collectors.toList());
        return list.get(n/2);
    }

    private static int get2(String line) {
        String[] ss = line.split(" ");
        Map<String,Integer> map =new HashMap<>();
        for(String ones:ss){
            map.put(ones,map.getOrDefault(ones,0)+1);
        }
        int oneNum=0;
        int twoNum=0;
        int threeNum=0;
        int fourNum=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                oneNum++;
            }else  if (entry.getValue()==2){
                twoNum++;
            }else if(entry.getValue()==3){
                threeNum++;
            }else {
                fourNum++;
            }

        }
        int res=0;
        res+=fourNum;
        if(threeNum>oneNum){
            res+=oneNum;
            res+=Math.ceil(twoNum-(threeNum-oneNum)/2)>0?Math.ceil(twoNum-(threeNum-oneNum)/2)+threeNum:threeNum;
        }else {
            res+=oneNum+twoNum;
        }
        return res;



    }


    private static String get1(String s) {
        String[] ss =s.split(" ");
        Set<Character> set =new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder res=new StringBuilder();
        for(int i=0;i<ss.length;i++){
            if(set.contains(ss[i].charAt(0))){
                res.append(ss[i]);
            }else {
                res.append(ss[i].substring(1,ss[i].length()));
                res.append(ss[i].charAt(0));
            }
            res.append("pdd");
            for(int j=0;j<=i;j++){
                res.append("a");

            }
            if(i!=ss.length-1){
                res.append(" ");
            }
        }
        return res.toString();

    }

}