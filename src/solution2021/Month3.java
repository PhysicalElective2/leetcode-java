package solution2021;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

public class Month3 {
    public static void main(String[] args) {
        Month3 m=new Month3();
        System.out.println(m.calculate("3+5 / 2"));

    }



    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign ='+';
        int num =0;
        int n= s.length();
        for(int i=0;i<n;++i){
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }


        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;




    }
    public int calculate2(String s) {
        int res=0;
        Stack<Integer> stack =new Stack<>();
        stack.push(1);
        int i=0;
        int n= s.length();
        while (i<n){
            if(s.charAt(i)=='+'){
                continue;
            }else if(s.charAt(i)=='-'){

            }
        }
        return 0;

    }

    public String removeDuplicates(String S) {
        int deleteStart = findDeleteStart(S);
        while (deleteStart!=-1){
            int needDelete =findDeleteStart(S);
            S=S.substring(0,needDelete)+S.substring(needDelete+2,S.length());
            deleteStart=findDeleteStart(S);
        }
        return S;


    }

    private int findDeleteStart(String s) {
        int res=-1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                return i-1;
            }

        }
        return res;

    }

    public int minCut(String s) {
        int res=0;
        return res;

    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new LinkedList<>();
        List<String> oneres=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            oneres.add((String.valueOf( s.charAt(i))));
        }
        res.add(oneres);
        return res;
    }


}
