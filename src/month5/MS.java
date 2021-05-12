package month5;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-08 19:13
 **/
public class MS {
    public static class point2D{
        int x;
        int y;
    }
    public static class AB  {
        double a;
        double b;
        @Override
        public boolean equals(Object o){
            if(o==this) return true;
            return true;

        }
    }
    public static int solution(point2D[] point2DS){
        int res=0;
        int num = point2DS.length;
        AB[][] abs =new AB[num][num];
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(i!=j){
                    AB ab =new AB();
                    double a;
                    double b;
                    if(point2DS[i].x==point2DS[j].x){
                        a = Integer.MAX_VALUE;
                        b=point2DS[i].x;
                    }else {
                        a= (point2DS[j].y-point2DS[i].y)/(point2DS[j].x-point2DS[i].x);
                        b= point2DS[i].y-a*point2DS[i].x;
                    }
                    ab.a=a;
                    ab.b=b;
                }
            }
        }
        List<AB> list =new ArrayList<>();
        for(int i= 0;i<num;i++){
            for(int j=0;j<num;j++){
                if(abs[i][j]!=null){
                    list.add(abs[i][j]);
                }
            }
        }
        Map<AB,Integer> map=new HashMap<>();
        for(AB ab:list){
            map.put(ab,map.getOrDefault(ab,0));
        }
        for(Map.Entry entry:map.entrySet()){
            if((Integer)entry.getValue()>=3){
                res+=(Integer) entry.getValue();
            }
        }



        return -1;

    }
    public static void main(String[] args) {
        String s1=new String("-H-HH--");
        String s2=new String("H");
        String s3=new String("HH-HH");
        String s4=new String("-H-H-H-H-H");
        point2D p =new point2D();
        System.out.println(new MS().solution(new String(s4)));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int res=0;
        for(int i=1;i<=A.length;i++){
            res+=Math.abs(i-A[i-1]);
        }
        return res;

    }

    public int solution(String S) {
        // write your code in Java SE 8
        int res=0;
        boolean can =true;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='-') continue;
            if(i-1>=0&&S.charAt(i-1)=='-'||i+1<S.length()&&S.charAt(i+1)=='-'){
                continue;
            }else {
                can=false;
                break;
            }
        }
        if(!can){
            return -1;

        }
        StringBuilder stringBuilder =new StringBuilder(S);
        boolean[] vi = new boolean[S.length()];
        for(int i=0;i<S.length();i++){
            if(stringBuilder.charAt(i)=='-'&&i-1>=0&&stringBuilder.charAt(i-1)=='H'&&i+1<S.length()&&
            stringBuilder.charAt(i+1)=='H'&&!vi[i-1]&&!vi[i+1]){
                stringBuilder.setCharAt(i,'T');
                res++;
                vi[i-1]=true;
                vi[i+1]=true;
            }
        }
        for(int i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)=='H'){
                if(i-1>=0&&stringBuilder.charAt(i-1)=='T'||
                i+1<stringBuilder.length()&&stringBuilder.charAt(i+1)=='T'){
                    continue;
                }else {
                    res++;
                }
            }
        }
        return res;


    }
}
