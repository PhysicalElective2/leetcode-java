package offer;

import java.io.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-26 19:23
 **/
public class Hulu2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int v=Integer.parseInt(bufferedReader.readLine());
        String s=bufferedReader.readLine();
        print(s,v);
    }
    private static void print(String s,int v) throws IOException{
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder finish = new StringBuilder();
        for(int i=0;i<s.length();i++){
            finish.append('.');

        }
        StringBuilder stringBuilder= new StringBuilder(s);
        bufferedWriter.write( stringBuilder.toString().replaceAll("L|R","X")+'\n');


        while (!finish.toString().equals(stringBuilder.toString())){
            StringBuilder next =new StringBuilder(finish.toString());
            for(int i=0;i<stringBuilder.length();i++){
                if(stringBuilder.charAt(i)=='L'&&i-v>=0){
                    next.setCharAt(i-v,next.charAt(i-v)=='R'?'M':'L');
                   // next.setCharAt(i-v,'M');
                }else if(stringBuilder.charAt(i)=='R'&&i+v<s.length()){
                    next.setCharAt(i+v,next.charAt(i+v)=='L'?'M':'R');
                }else if(stringBuilder.charAt(i)=='M'){
                    if(i+v< s.length()){
                        next.setCharAt(i+v,next.charAt(i+v)=='L'?'M':'R');
                    }
                    if(i-v>=0){
                        next.setCharAt(i-v,next.charAt(i-v)=='R'?'M':'L');

                    }
                }
            }
            stringBuilder=next;
            String print =next.toString().replaceAll("L|R|M","X");
            if(!finish.toString().equals(stringBuilder.toString())){
                bufferedWriter.write(print+'\n');


            }else {
                bufferedWriter.write(print);

            }
        }
        bufferedWriter.flush();
    }
}
