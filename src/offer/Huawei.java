package offer;

import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-18 19:14
 **/
class MultiKnapsack {
    private static int[] P={0,2,3,4};
    private static int[] V={0,3,4,5};
    private static int[] M={0,4,3,2};
    private static int T = 15;

    private Integer[][] results = new Integer[P.length + 1][T + 1];

    public void solve2() {
        int result = ks2(P.length - 1,T);
        System.out.println("最大价值为：" + result);
    }

    private int ks2(int i, int t){
        // 如果该结果已经被计算，那么直接返回
        if (results[i][t] != null) return results[i][t];
        int result = 0;
        if (i == 0 || t == 0){
            // 初始条件
            result = 0;
        } else if(V[i] > t){
            // 装不下该珠宝
            result = ks2(i-1, t);
        } else {
            // 可以装下
            // 取k个物品，取其中使得价值最大的
            for (int k = 0; k <= M[i] && k * V[i] <= t; k++){
                int tmp2 = ks2(i-1, t - V[i] * k) + P[i] * k;
                if (tmp2 > result){
                    result = tmp2;
                }
            }
        }
        results[i][t] = result;
        return result;
    }
}
public class Huawei {
    private static int[] P;
    private static int[] V;
    private static int[] M;
    private static int T;
    private static Integer[][] results;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String line =sc.nextLine();
        T=Integer.parseInt(line.split(" ")[0]);
        int count=Integer.parseInt(line.split(" ")[1]);
        P=new int[count];
        V=new int[count];
        M=new int[count];
        int index =0;
        while (index<count){
            line=sc.nextLine();
            P[index]=Integer.parseInt(line.split(" ")[2]);
            V[index]=Integer.parseInt(line.split(" ")[0]);
            M[index]=Integer.parseInt(line.split(" ")[1]);
            index++;
        }
        results=new Integer[P.length + 1][T + 1];
        int result = ks2(P.length - 1,T);
        //int result1 = ks(P.length - 1,T);
        System.out.println("最大价值为：" + result);
//        System.out.println("最大价值为：" + result1);

    }
    private static int ks(int i, int t){
        int result = 0;
        if (i == 0 || t == 0){
            // 初始条件
            result = 0;
        } else if(V[i] > t){
            // 装不下该珠宝
            result = ks(i-1, t);
        } else {
            // 可以装下
            // 取k个物品i，取其中使得总价值最大的k
            for (int k = 0; k <= M[i] && k * V[i] <= t; k++){
                int tmp2 = ks(i-1, t - V[i] * k) + P[i] * k;
                if (tmp2 > result){
                    result = tmp2;
                }
            }
        }
        return result;
    }
    private static int ks2(int i, int t){
        // 如果该结果已经被计算，那么直接返回
        if (results[i][t] != null) return results[i][t];
        int result = 0;
        if (i == 0 || t == 0){
            // 初始条件
            result = 0;
        } else if(V[i] > t){
            // 装不下该珠宝
            result = ks2(i-1, t);
        } else {
            // 可以装下
            // 取k个物品，取其中使得价值最大的
            for (int k = 0; k <= M[i] && k * V[i] <= t; k++){
                int tmp2 = ks2(i-1, t - V[i] * k) + P[i] * k;
                if (tmp2 > result){
                    result = tmp2;
                }
            }
        }
        results[i][t] = result;
        return result;
    }
}
