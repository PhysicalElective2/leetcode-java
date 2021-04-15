package month4;

import java.util.Scanner;

public class ByteDance {
    public static void main(String[] args) {
        String path ="/keycloak-master_duplicate_fdse-3_42dec08f3c1c25013f79fa192dd42a17863e6a89/model/infinispan/src/main/java/org/keycloak/models/cache/infinispan/RoleAdapter.java";
        String duplicateDirectoryName=path.split("\\/")[1];
        System.out.println("duplicateDirectoryName:"+duplicateDirectoryName);
        String filePathInRepo=path.substring(path.indexOf(duplicateDirectoryName)+duplicateDirectoryName.length());
        System.out.println("filePathInRepo:"+filePathInRepo);
    }
    public static String res1(String string){
        int addNum=1;
        if(string.length()==0){
            return string;
        }
        char first =string.charAt(0);
        if('0'<=first&&first<='9'){
            addNum=first-'0';
        }else if('A'<=first&&first<='Z'){
            addNum=first-'A'+1;
        }else {
            addNum=1;
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<string.length();i++){
            char thisChar=string.charAt(i);
            if('0'<=thisChar&&thisChar<='9'){
                char need =(char) ((thisChar+addNum-'0')%10+'0');
                res.append(need);
            }else if('A'<=thisChar&&thisChar<='Z'){
                char need =(char) ((thisChar+addNum-'A')%26+'A');
                res.append(need);
            }else {
                res.append(thisChar);
            }


        }
        return res.toString();

    }

}
