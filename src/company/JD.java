package company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-10-09 18:51
 **/
public class JD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        line = scanner.nextLine();
        String[] sn = line.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sn[i]);
        }
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum.put(num, sum.getOrDefault(num, 0) + 1);
            if (start.containsKey(num)) {
                end.put(num, i);
            } else {
                start.put(num, i);
                end.put(num, i);
            }
        }
        int resSize = 0;
        int resLen = nums.length;
        int resS = 0;
        int resE = nums.length - 1;
        for (Map.Entry<Integer, Integer> map : sum.entrySet()) {
            int size = map.getValue();
            int key = map.getKey();
            int len = end.get(key) - start.get(key);
            if (resSize < size || (resSize == size && resLen > len)) {
                resSize = size;
                resLen = len;
                resS = start.get(key);
                resE = end.get(key);

            }
        }
        resS++;
        resE++;
        System.out.println(resS + " " + resE);


    }
}
