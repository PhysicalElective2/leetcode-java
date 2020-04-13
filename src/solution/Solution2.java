package solution;
import java.util.Stack;

public class Solution2 {
    private Stack<Integer> res=new Stack<Integer>();
    public void push(int node) {
        res.add(node);
    }
    public void pop() {
        res.remove(res.size()-1);
    }

    public int top() {
        return res.get(res.size()-1);
    }

    public int min() {
        int min = res.get(0);
        for(int i=1;i<res.size();i++){
            if(res.get(i)<min){
                min =res.get(i);
            }

        }
        return min;
    }

}
