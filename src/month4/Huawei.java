package month4;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-21 18:53
 **/
public class Huawei {
    static  class  Union{
        private int father[];
//        private int count;
        public boolean[] alone;
        public Union(int n){
            father=new int[n];
            alone=new boolean[n];
            for(int i=0;i<n;i++){
                father[i]=i;
            }

        }
        public void union(int a,int b){
            int fa=findFather(a);
            int fb=findFather(b);
            alone[a]=alone[b] =true;
            if(fa!=fb){
                father[fa]=fb;
            }
        }

        private int findFather(int a) {
            return a==father[a]? a:(father[a]=findFather(father[a]));

        }
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Set<Integer> set =new HashSet<Integer>();
        Union union =new Union(n);
        int lines  =Integer.parseInt(scanner.nextLine());
        int count1=0;
        for(int i=0;i<lines;i++){
            String[] s= scanner.nextLine().split(" ");
            int a =Integer.parseInt(s[0]);
            int b =Integer.parseInt(s[1]);
            int num=a*1000+b;
            if(!set.contains(num)){
                if(union.findFather(a)==union.findFather(b)){
                    count1++;
                }
                union.union(a,b);
                set.add(num);
            }

        }
        int count2 =0;
        for(int i=0;i<union.alone.length;i++){
            if(!union.alone[i]){
                count2++;
            }
        }
        if(count1>0){
            System.out.println(Math.max(8-count2,0));
        }else {
            System.out.println(Math.max(10-count2,0));
        }

    }
    public static void main2(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String[] line =scanner.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        int[] res=new int[24];
        while (n-->0){
            line=scanner.nextLine().split(" ");
            int start =Integer.parseInt(line[0]);
            int end =Integer.parseInt(line[1]);
            int num =Integer.parseInt(line[2]);
            boolean canacc=true;
            for(int i=start;i<end;i++){
                if(res[i]+num>m) canacc=false;

            }
            if(canacc){
                for(int i=start;i<end;i++){
                    res[i]+=num;

                }
            }
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]);
            if(i!=res.length-1){
                System.out.print(" ");
            }
        }
        System.out.println();


    }
}
