package competition;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-30 10:28
 **/
public class Com0530 {
    class Server{
        int id;
        int weight;
        int time;
        public Server(int id,int weight){
            this.id =id;
            this.weight =weight;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];
        int count =0;
        int timer =0;
        // a.weight - b.weight);
        //        // 正在执行服务器
        PriorityQueue<Server> usable =new PriorityQueue<>((a,b)->
                a.weight==b.weight?a.id-b.id:a.weight-b.weight);
        //why  no use ,it is The default sort ?
        PriorityQueue<Server> run =new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        for(int i=0;i<servers.length;i++){
            usable.add(new Server(i,servers[i]));
        }
        while (true){
            if(count ==tasks.length){
                break;
            }
            while (!run.isEmpty()&&run.peek().time<=timer){
                usable.add(run.poll());
            }
            while (count<=timer&& count <tasks.length){
                if(!usable.isEmpty()){
                    Server server =usable.poll();
                    server.time=timer+tasks[count];
                    res[count++] = server.id;
                    run.add(server);

                }else{
                    break;
                }
            }
            if(usable.isEmpty()){
                timer=run.peek().time;
            }else {
                timer++;
            }

        }
        return res;



    }

    public String maxValue(String n, int x) {
        if (!(n.charAt(0) == '-')) {
            return maxValue1(n, x);
        } else {
            n = n.substring(1);
            return "-" + maxValue2(n, x);

        }
    }
    //"469975787943862651173569913153377"
    //3
    //输出：
    //"4699757879433862651173569913153377"
    //预期：
    //"4699757879438632651173569913153377"

    private String maxValue2(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num <= x) {
                stringBuilder.append(num);
            } else {
                stringBuilder.append(x);
                break;
            }
        }
        if (i == n.length()) {
            stringBuilder.append(x);
        } else {
            stringBuilder.append(n.substring(i, n.length()));

        }
        return stringBuilder.toString();

    }

    public String maxValue1(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num >= x) {
                stringBuilder.append(num);
            } else {
                stringBuilder.append(x);
                break;
            }
        }
        if (i == n.length()) {
            stringBuilder.append(x);
        } else {
            stringBuilder.append(n.substring(i, n.length()));

        }
        return stringBuilder.toString();
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);


    }

    public int getNum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - 'a';
        }
        return res;

    }

}
