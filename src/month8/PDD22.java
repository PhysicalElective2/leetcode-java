package month8;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-31 19:23
 **/
class MyString implements Comparable{
    String s;
    String best;
    String worst;
    public MyString(String s){
        this.s=s;
    }


    @Override
    public int compareTo( Object o) {
        MyString anothers =(MyString)o;
        return this.worst.compareTo(anothers.worst);
//        if(this.worst.compareTo(anothers.worst)<0){
//            return -1;
//
//        }
//        return this.worst.compareTo(anothers.worst);
    }
//    public void setBest(){
//        int len =s.length();
//        StringBuilder bestA=new StringBuilder();
//        StringBuilder bestB=new StringBuilder();
//        for (int i=0;i<(s.length()/2);i++){
//            if(s.charAt(i)>=s.charAt(len-i-1)){
//                bestA.append(s.charAt(i));
//                bestB.append(s.charAt(len-i-1));
//            }else {
//                bestA.append(s.charAt(len-i-1));
//                bestB.append(s.charAt(i));
//            }
//        }
//
//        if(len%2==1){
//            bestA.append(s.charAt(len/2));
//        }
//        bestA.append(bestB.reverse());
//         this.best=bestA.toString();
//    }
    public void setworst(){
        int len =s.length();
        StringBuilder bestA=new StringBuilder();
        StringBuilder bestB=new StringBuilder();
        for (int i=0;i<(s.length()/2);i++){
            if(s.charAt(i)>=s.charAt(len-i-1)){

                bestA.append(s.charAt(len-i-1));
                bestB.append(s.charAt(i));

            }else {
                bestA.append(s.charAt(i));
                bestB.append(s.charAt(len-i-1));

            }
        }
        if(len%2==1){
            bestA.append(s.charAt(len/2));
        }
        bestA.append(bestB.reverse());
        this.worst=bestA.toString();
    }
}
public class PDD22 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        MyString[] myStrings=new MyString[n];
        int index=0;
        while (index<n){
            String line =scanner.nextLine();
            MyString oneString =new MyString(line);
            oneString.setworst();
            myStrings[index++]=oneString;

        }
        Arrays.sort(myStrings);
        for(MyString m:myStrings){
            System.out.println(m.s);
        }


    }
}
