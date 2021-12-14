package offer;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-21 19:55
 **/
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class JD {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int index =0;
        List<Point> list =new ArrayList<>();

        while (index<n){
            String line =scanner.nextLine();

            int x =Integer.parseInt(line.split(" ")[0]);
            int y =Integer.parseInt(line.split(" ")[1]);
            list.add(new Point(x,y));
            index++;
        }
        list.sort((e1,e2)->{
            if(e1.x==e2.x){
                return e1.y-e2.y;
            }else {
                return  e1.x-e2.x;
            }
        });
//        for(Point p:list){
//            System.out.println(p.x+" "+p.y);
////            System.out.println(p.x);
//        }

        int res=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((list.get(j).x-list.get(i).x)!=0){
                    if((list.get(j).y-list.get(i).y)/(list.get(j).x-list.get(i).x)==-1){
                        res++;
                        System.out.println();


                    }
                    if((list.get(j).y-list.get(i).y)/(list.get(j).x-list.get(i).x)==1){
                        res++;
                        break;
                    }

                }

            }
        }
        System.out.println(res);


    }
}
