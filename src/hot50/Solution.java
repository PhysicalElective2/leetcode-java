package hot50;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-06 22:04
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] num) {
        int major = num[0];
        int count = 1;
        for(int i=0;i<num.length;i++){
            if(count==0){
                major=num[i];
                count=1;
            }else if(major==num[i]){
                count++;
            }else {
                count--;
            }
        }
        return major;
    }

}
