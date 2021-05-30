package month5;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-27 19:01
 **/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n =sc.nextLine();
        String line = sc.nextLine();
        int res =get2(line);
        System.out.println(res);
//        String s =sc.nextLine();
//        String res =get1(s);
//        System.out.println(res);
        //I speak Chicken Latin
        //Ipdda peakspddaa hickenCpddaaa atinLpddaaaa
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
        while (threeNum>0&&oneNum>0){
            oneNum--;
            threeNum--;
            res++;
        }
        while (threeNum>=2&&twoNum>0){
            twoNum--;
            threeNum-=2;
            res+=2;
        }
        res+=oneNum;
        res+=twoNum;
        res+=threeNum-threeNum/4;
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