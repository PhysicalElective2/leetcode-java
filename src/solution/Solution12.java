package solution;

public class Solution12 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder Sa=new StringBuilder();
        StringBuilder Sb=new StringBuilder();
//        StringBuffer Sb=new StringBuffer();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(Sa.length()>0){
                    Sa.deleteCharAt(Sa.length()-1);
                }
            }else{
                Sa.append(S.charAt(i));
            }
        }
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'){
                if(Sb.length()>0){
                    Sb.deleteCharAt(Sb.length()-1);
                }
            }else{
                Sb.append(T.charAt(i));
            }
        }
        return Sa.toString().equals(Sb.toString());

    }

}
