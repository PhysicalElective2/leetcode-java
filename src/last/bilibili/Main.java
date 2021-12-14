package last.bilibili;

import tools.ListNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-13 19:14
 **/

class Solution {
    /* Write Code Here */
    public int strstr(String a, String b) {
        int res = -1;
        for (int i = 0; i + b.length() < a.length(); i++) {
            if (b.equals(a.substring(i, i + b.length()))) {
                res = i;
                break;

            }

        }
        return res;


    }

    public String reorder(String a, String b) {

        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] acommon = new boolean[a.length()];
        boolean[] bcommon = new boolean[b.length()];

        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), i);
        }
        for (int i = 0; i < a.length(); i++) {
            if (map.keySet().contains(a.charAt(i))) {
                acommon[i] = true;
                bcommon[map.get(a.charAt(i))] = true;
            }
        }
        int indexa = 0;
        int indexb = 0;
        StringBuilder res = new StringBuilder();
        while (indexa < a.length()) {
            while (indexa < a.length() && !acommon[indexa]) {
                res.append(a.charAt(indexa));
                indexa++;
            }

            while (indexb < b.length() && !acommon[indexb]) {
                indexb++;
            }
            if (indexa < a.length() && indexb < b.length()) {
                res.append(b.charAt(indexb));
                indexa++;
                indexb++;
            }
        }
        return res.toString();


    }

    public int check(String input, int rule_cnt, String rules) {
        List<Integer> list = new ArrayList<>();
        input = input.substring(1, input.length() - 1);
        for (String s : input.split(",")) {
            list.add(Integer.parseInt(s));
        }
        rules = rules.substring(1, rules.length() - 1);
        int t = Integer.parseInt(rules.split(",")[0]);
        int n = Integer.parseInt(rules.split(",")[1]);
        int nt = Integer.parseInt(rules.split(",")[2]);
        int queues = 0;
        int ntt=0;
        int res=0;
        for (int i = 0; i < list.size(); i++) {
            if (i - t >= 0 && list.get(i - t) == 1) {
                queues--;
            }
            if(queues>=n&&ntt==0){
                ntt=nt-1;
                if(list.get(i)==1){
                    res++;
                }
            }
            if(ntt>0){
                if(list.get(i)==1){
                    res++;
                }
                ntt--;
            }

            if (list.get(i) == 1) {
                queues++;
                continue;
            }


        }
        return res;


    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        int _rule_cnt;
        _rule_cnt = Integer.parseInt(in.nextLine().trim());

        String _rules;
        try {
            _rules = in.nextLine();
        } catch (Exception e) {
            _rules = null;
        }

        res = new Solution().check(_input, _rule_cnt, _rules);
        System.out.println(String.valueOf(res));

    }
}