package month4;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-23 20:18
 **/
public class MS {

    static class Tree{
        public int x;
        public Tree l;
        public Tree r;
    }
    int res;
    public int solution(Tree tree){
        res=Integer.MIN_VALUE;
        Set<Integer> set=new HashSet<>();
        dfs(tree,set);
        return res;
    }

    public int solution(int[] A, int[] B) {
        int len =A.length;
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<len;i++){
            if(set.contains(A[i])){
                continue;
            }
            if(set.contains(B[i])){
                continue;
            }
            set.add(Math.max(A[i],B[i]));
        }
        int res=1;
        while (set.contains(res)){
            res++;
        }
        return res;

    }

    private void dfs(Tree tree,Set<Integer> set) {
        if(tree==null) return;
        if(set.contains(tree.x)){
            return;
        }
        int val=tree.x;
        set.add(val);
        res=Math.max(set.size(),res);
        dfs(tree.l,new HashSet<>(set));
        dfs(tree.r,new HashSet<>(set));
    }
    public static void main(String[] args) {
        int[] data =new int[]{2,2,3,4,3,3,2,2,1,1,2,5};

        MS ms= new MS();
        int[] A=new int[]{2,2,1,6,5};
        int[] B=new int[]{4,2,1,3,3};
        System.out.println(ms.solution(A, B));
//        System.out.println(ms.solution(data));

    }

    public int solution(int[] A){
        List<Integer> l =new ArrayList<>();
        l.add(A[0]);
        for(int i=1;i<A.length;i++){
            if(A[i]!=l.get(l.size()-1)){
                l.add(A[i]);
            }
        }
        if(l.size()==1){
            return 1;
        }
        int[] add =new int[l.size()];
        int[] addR=new int[l.size()];
        int[] de =new int[l.size()];
        int[] deR=new int[l.size()];
        add[0] =1;
        de[0] =1;
        for(int i=1;i<l.size();i++){
            if(l.get(i)>l.get(i-1)){
                 add[i] = add[i-1]+1;
            }else {
                add[i]=1;
            }
            if(l.get(i)<l.get(i-1)){
                de[i] =de[i-1]+1;
            }else {
                de[i]=1;
            }
        }
        addR[addR.length-1] =1;
        deR[deR.length-1] =1;
        for(int i=l.size()-2;i>=0;i--){
            if(l.get(i)>l.get(i+1)){
                addR[i] =addR[i+1]+1;
            }else {
                addR[i]=1;
            }
            if(l.get(i)<l.get(i+1)){
                deR[i] =deR[i+1]+1;
            }else {
                deR[i]=1;
            }
        }
        int res=2;
        for(int i=1;i<add.length-1;i++){
            if(add[i]>1&&addR[i]>1) res++;
            if(de[i]>1&&deR[i]>1) res++;
        }
        return  res;


    }


}
