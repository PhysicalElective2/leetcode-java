package competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-06-13 10:30
 **/
public class Com0613 {
    public static void main(String[] args) {
        String s ="abcacb";
        String p="ab";
        int[] removable =new int[]{3,1,0};
        System.out.println(new Com0613().maximumRemovals(s,p,removable));
    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] tempTar=new int[3];
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]<=target[0]&&triplets[i][1]<=target[1]&&triplets[i][2]<=target[1]){

                tempTar[0] = Math.max(tempTar[0], triplets[i][0]);
                tempTar[1] = Math.max(tempTar[1], triplets[i][0]);
                tempTar[2] = Math.max(tempTar[2], triplets[i][0]);
            }
        }
        return target[0]==tempTar[0]&&target[1]==tempTar[1]&&target[2]==tempTar[2];
    }
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        for(int i=0;i<removable.length;i++){
            String oneS =newS(s,removable,i);
//            System.out.println("oneS:"+oneS);
//            String oneS = s.substring(0,removable[i])+s.substring(removable[i]+1);
            if(isSubsequence(p,oneS)){
                continue;
            }else {
                return i;
            }
        }
        return removable.length;
    }
    public String newS(String s,int[] removable,int k){
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<=k;i++){
            set.add(removable[i]);
        }
        StringBuilder res =new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    public boolean makeEqual(String[] words) {
        boolean res=true;
        Map<Character,Integer> map = new HashMap<>();
        for(String w:words){
            for(int i=0;i<w.length();i++){
                map.put(w.charAt(i),map.getOrDefault(w.charAt(i),0)+1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%words.length!=0){
                res=false;
                break;
            }
        }
        return res;


    }

}
