package solution2021.month3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alibaba0322 {
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextLine()){
            String nextline=sc.nextLine();
            if(nextline.length()==0) continue;
            String[] line1 =nextline.split(" ");

            int n=Integer.parseInt(line1[0]);
            int m=Integer.parseInt(line1[1]);
//            int m=sc.nextInt();

            flag =false;
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(sc.nextInt());
            }
            list.sort((o1, o2) -> o1-o2);
            if(test(list,m)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }


            /*
            String[] line1 =sc.nextLine().split(" ");
            int n=Integer.parseInt(line1[0]);
            int m=Integer.parseInt(line1[1]);
            String line =sc.nextLine();

            String[] lines=line.split(" ");
            int[] nums =new int[n];
            for(int i=0;i<n;i++){
                nums[i] =Integer.parseInt(lines[i]);

            }
            boolean res=qu1(n,m,nums);
            if(res){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            /*
             */


        }
    }

    private static boolean test(List<Integer> list, int m) {
        dfs2(list,0,m);
        return flag;

    }

    private static void dfs2(List<Integer> list, int k, int target) {
        if(target==0) {
            flag=true;
            return;
        }else if(target<0)
            return;
        for(int i=k;i<list.size();i++){
            dfs2(list,i,target-list.get(i));
        }
    }


    public  static boolean res1;
    private static boolean qu1(int n, int m, int[] nums) {
        res1=false;
        dfs(nums,m,0);
        return res1;

    }

    private static void dfs(int[] nums, int m,int index) {
        if(index>=nums.length) return;

        if(m==0){
            res1=true;
            }
        if(m<=0) return;
            dfs(nums,m-nums[index],index++);
        dfs(nums,m,index++);


    }
}
