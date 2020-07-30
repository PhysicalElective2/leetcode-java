package solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionMedium {
    //Meditation, one question a day
    List<String> res=new ArrayList<>();
    String numbersToLetters[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        //Depth first traversal
        if(digits.length()==0){
            return res;
        }
        List<Integer> road=new ArrayList<>();
        dfs(digits,road);
        return res;

    }
    public void dfs(String digits,List<Integer> road){
        if(road.size()==digits.length()){
            StringBuilder oneres=new StringBuilder();
            //Still need to follow the sequence digits
            for(int i=0;i<road.size();i++){
                oneres.append(numbersToLetters[digits.charAt(i)-'0'-2].charAt(road.get(i)));
            }
            res.add(oneres.toString());
            return;
        }
        if(road.size()<digits.length()){
            for(int i=0;i<numbersToLetters[digits.charAt(road.size())-'0'-2].length();i++){
                road.add(i);
                dfs(digits,road);
                road.remove(road.size()-1);
            }


        }


    }

    public static void main(String[] args) {
        SolutionMedium sm=new SolutionMedium();
//        System.out.println(sm.letterCombinations(new String("4545")));
        List<String> ress =sm.letterCombinations(new String("7"));
        for(int i=0;i<ress.size();i++){
            System.out.println(ress.get(i));
        }

    }


}
