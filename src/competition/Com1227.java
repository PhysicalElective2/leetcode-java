package competition;

import java.util.*;

public class Com1227 {
    public static void main(String[] args) {
        Com1227 c=new Com1227();
        int[] apple =new int[]{20000};
        int[] days  =new int[]{20000};
       // System.out.println(c.eatenApples(apple,days));
        int[][] g=new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(c.findBall(g)));

//        System.out.println(c.halvesAreAlike("AbCdEfGh"));
    }
    public int[] findBall(int[][] grid) {
        int[] res=new int[grid[0].length];
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<n;i++){
            int oneres=i;

            for(int j=0;j<m;j++){
                oneres=getNextIndex(oneres,j,grid);
                if(oneres==-1){
                    break;
                }

            }
            res[i]=oneres;
            System.out.println("one res:"+oneres);

        }
        return res;



    }
    public int getNextIndex(int j,int i,int[][] grid){
        System.out.println("i=="+i+"j=="+j);
        int n=grid[0].length;
        if(grid[i][j]==1&&j<n-1&&grid[i][j+1]!=-1){
            j+=1;
            System.out.println("j:"+j);
            return j;

        }
        if(grid[i][j]==-1&&j>0&&grid[i][j-1]!=1){
            j-=1;
            System.out.println("j: "+j);
            return j;

        }
        return -1;
    }
    public boolean halvesAreAlike(String s) {
        int len=s.length();
        if(len%2==1) return false;
     //   char[] keys=new char[]{'a','e','i','o','u','A','E','I','O','U'};
        List<Character> keylist = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        String s1 =s.substring(0,len/2);
        String s2 =s.substring(len/2,len);
        int count1=0;
        int count2=0;

        for(int i=0;i<s1.length();i++){
            if(keylist.contains(s1.charAt(i))){
                count1++;
               // map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0));

            }
        }
        for(int i=0;i<s2.length();i++){
            if(keylist.contains(s2.charAt(i))){
                count2++;
               // map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0));

            }
        }
        //next judge map
        return  count1==count2;



    }
    public int eatenApples(int[] apples, int[] days) {
        List<Integer> badDay =new ArrayList<>();
        int n=apples.length;
        int res=0;
        for(int i=0;i<n;i++){
            int thisbadday =i+days[i];
            while (badDay.size()-1<thisbadday){
                badDay.add(0);
            }
            badDay.set(thisbadday,badDay.get(thisbadday)+apples[i]);
            //
            int getDay =getApple(i,badDay);
            if(getDay>-1){
                System.out.println("getDay:"+getDay);
                badDay.set(getDay,badDay.get(getDay)-1);
                res++;
            }

        }
        System.out.println(res);
        int next =n;
        while (next<badDay.size()){
            int getDay =getApple(next,badDay);
            if(getDay!=-1){
                badDay.set(getDay,badDay.get(getDay)-1);
                res++;
            }
            next++;
        }

        return res;

    }

    private int getApple(int i, List<Integer> badDay) {
//        for(Integer ii:badDay){
//            System.out.print(" "+ii);
//
//        }
//        System.out.println(" end of one baddaylist");
        i++;
        for(;i<badDay.size();i++){
            if(badDay.get(i)>0){
                return i;


            }
        }
        return -1;
    }



}
