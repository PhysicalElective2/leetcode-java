package solution2021.month3;

import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.*;

public class Huawei {
    public static void main(String[] args) {
        int[] ints=new int[]{1,1,2};
        System.out.println(qu2Wrong(ints));
//        Scanner sc =new Scanner(System.in);
//        String line =sc.nextLine();
//        line=line.substring(1,line.length()-1);
//        System.out.println(line);
//        String[] numsInline =line.split(",");
//        int[] info =new int[numsInline.length];
//        for(int i=0;i<numsInline.length;i++){
//            numsInline[i]=numsInline[i].trim();
//            info[i] = Integer.parseInt(numsInline[i]);
//        };
//        System.out.println(qu2(info));
    }
    public static int qu2(int[] info){
        if(info.length==0) return 0;
        int n=info.length;
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for( int i=0;i<n;i++){{
            if(map.keySet().contains(info[i])){
                if(map.get(info[i])<info[i]+1){
                    map.put(info[i],map.get(info[i])+1);
                }
            }else {
                map.put(info[i],1);
            }}
            if(map.get(info[i])==info[i]+1){
                res+=info[i]+1;
                map.put(info[i],0);
            }
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()>0){
                res+=entry.getKey()+1;
            }
        }
        return res;
    }
    public static int qu2Wrong(int[] info){
        if(info.length==0)return 0;
        int n=info.length;
        int res=0;
        Map<Integer ,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.keySet().contains(info[i])){
                if(map.get(info[i])<info[i]+1){
                    map.put(info[i],map.get(info[i]+1));
                }
            }
            else {
                map.put(info[i],1);
            }

            if(map.get(info[i])==info[i]+1){
                res+=info[i]+1;
                map.put(info[i],0);

            }

        }
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(e.getValue()>0){
                res+=e.getKey()+1;

            }
        }
        return res;
    }

}
