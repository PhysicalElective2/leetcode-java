package last;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-18 10:31
 **/
public class Ms {
    public static void main(String[] args) {
        String[] A=new String[]{
                "eva",
                "jqw",
                "tyn",
                "jan"
        };
        System.out.println(new Ms().solution(A));

    }
    public static int res=0;
    public int solution(String[] A) {
        // write your code in Java SE 8
        List<String> A2 =new ArrayList<>();
        for(String s:A){
            if(norepeat(s)){
                A2.add(s);
            }
        }
        Set<Character> set =new HashSet<>();
        List<String> list =new ArrayList<>();
        int num=0;
        int index=0;
        dfs(A2,list,index);
        return res;

    }

    private void dfs(List<String> a2, List<String> list, int index) {
//        if(set.size()!=num){
//            System.out.println("size:"+set.size());
//            System.out.println("num:"+num);
//            for(Character s:set){
//                System.out.print(s);
//            }
//            System.out.println();
//            return;
//        }


        if(index>=a2.size()){
            StringBuilder stringBuilder=new StringBuilder();
            for(String s:list){
                stringBuilder.append(s);
            }
            if(norepeat(stringBuilder.toString())){{
                res=Math.max(res,stringBuilder.length());
            }}
            return;
        }
        String thiss=a2.get(index);
        dfs(a2,list,index+1);
        list.add(thiss);

        dfs(a2,list,index+1);
        list.remove(list.size()-1);


    }

    private boolean norepeat(String s) {
        Set<Character> set =new HashSet<>();
        boolean res=true;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                res=false;
                break;
            }else {
                set.add(s.charAt(i));
            }

        }
        return res;
    }
}
