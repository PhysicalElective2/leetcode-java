package solution2021.month3;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class Solution{
    public static void main(String[] args) {
        LRUCache l =new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        System.out.println(l.get(2));
//        Solution s =new Solution();
//        int res=s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
//        System.out.println(res);

    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack =new LinkedList<>();
        int index=0;
        while (index<tokens.length){
            if(tokens[index].equals("+")){
                Integer oneNum =stack.pop()+stack.pop();
                stack.push(oneNum);
                index++;
                continue;

            }
            if(tokens[index].equals("-")){
                Integer num1 =stack.pop();
                Integer num2 =stack.pop();
                stack.push(num2-num1);
                index++;
                continue;
            }
            if(tokens[index].equals("*")){
                Integer num1 =stack.pop();
                Integer num2 =stack.pop();
                stack.push(num2*num1);
                index++;
                continue;
            }
            if(tokens[index].equals("/")){
                Integer num1 =stack.pop();
                Integer num2 =stack.pop();
                stack.push(num2/num1);
                index++;
                continue;
            }
            stack.push(Integer.valueOf(tokens[index]));
            index++;

        }
        return stack.peek();
    }
    public int evalRPNWrong(String[] tokens) {
        int res =Integer.valueOf(tokens[0]);
        int index =1;
        int num =0;
        while (index<tokens.length){
            if(tokens[index].equals("+")){
                res+=num;
                index++;
                continue;

            }
            if(tokens[index].equals("-")){
                res-=num;
                index++;
                continue;

            }
            if(tokens[index].equals("*")){
                res=res*num;
                index++;
                continue;

            }
            if(tokens[index].equals("/")){
                res=res/num;
                index++;
                continue;
            }
            num=Integer.valueOf(tokens[index]);
            index++;

        }
        return res;

    }
    public int maxEnvelopes(int[][] envelopes) {
        int size =envelopes.length;
//        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(envelopes, (o1, o2) ->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

        int[] res= new int[size];
        int re=Integer.MIN_VALUE;
        Arrays.fill(res,1);
        for(int i=1;i<size;i++){
            int oneres=1;
//            oneres=Math.max()

            for(int j=0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    oneres=Math.max(oneres,res[j]+1);
                }
            }
            res[i]=oneres;
            re =Math.max(re,res[i]);
        }
        return re;


    }
    public static  <T> void test(T input){
        System.out.println(input.getClass().getName());


    }



    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
