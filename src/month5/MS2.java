package month5;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-17 14:59
 **/
public class MS2 {
    public static class CA{
        int x1;
        int x2;
        int y1;
        int y2;
    }
    public static void main(String[] args) {
        CA a=new CA();
        a.x1=1;
        a.x2=2;
        a.y1=1;
        a.y2=2;
        CA b=new CA();
        b.x1=0;
        b.x2=2;
        b.y1=0;
        b.y2=2;
        System.out.println(area(a,b));

    }
    public static int area(CA a,CA b){
        int x1=Integer.MIN_VALUE;
        x1=Math.max(x1,a.x1);
        x1=Math.max(x1,b.x1);
        int x2=Integer.MAX_VALUE;
        x2=Math.min(x2,a.x2);
        x2=Math.min(x2,b.x2);
        int y1=Integer.MIN_VALUE;
        y1=Math.max(y1,a.y1);
        y1=Math.max(y1,b.y1);
        int y2=Integer.MAX_VALUE;
        y2=Math.min(y2,a.y2);
        y2=Math.min(y2,b.y2);

        if(x1>=x2||y1>=y2){
            return 0;
        }
        return (y2-y1)*(x2-x1) ;
    }




}
