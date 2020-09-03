package solution;

import java.util.*;

public class Solution10 {
    //Bracket generation
    //three way to add bracket
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dp(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void dp(List<String> ans, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ans.add(curr.toString());
            return;
        }
        //it is too hard to find the Backtracking path
        if (open < max) {
            curr.append('(');
            dp(ans, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(')');
            dp(ans, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    //same tree
    //how can I judege two tree is same
    public int removeElement(int[] nums, int val) {
        int resNum = 0; // the sum
        int testNum = 0; //the item need to be test
        while (testNum < nums.length) {
            if (nums[testNum] == val) {
                testNum++;
            } else {
                nums[resNum + 1] = nums[testNum + 1];
            }

        }

        return resNum;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null | q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    public int maxDepth(TreeNode root) {
        //Maximum depth of binary tree
        if (root == null) {
            return 0;
        }
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        return Math.max(leftLen, rightLen) + 1;
    }


    public boolean divisorGame(int N) {
        //try to choice the bigger
        //la ji
        return N % 2 == 0;

    }

    public int[] twoSum(int[] numbers, int target) {
        //I haven't get the Connotation ,it's two pointer
        //before to solve a  problem ,try some Algorithm idea
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{-1, -1};

    }

    //
    public int searchInsert(int[] nums, int target) {
        int res;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;

            }
        }

        return i;

    }

    //两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //use  recursion
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            //if there is value in map use its value ,else use default value -0
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            // the getOrDefault funtion is good
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //good funtion to copy Array
        return Arrays.copyOfRange(res, 0, index);

    }

    //恢复空格 把文章断开，要求未识别的字符最少，返回未识别的字符数
    //这都得动态规划
    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int dp[] = new int[n + 1];
        // 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    //不能减一，因为，可能过了好几个才匹配的
                    dp[i] = Math.min(dp[i], dp[idx]);


                }
            }
        }
        return dp[n];

    }

    //整数转化为罗马数字
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int j = 0;
        while (num > 0) {
            if (num >= nums[j]) {
                num = num - nums[j];
                res.append(strs[j]);
            } else {
                j++;
            }
        }
        return res.toString();

    }

    /**
     * 12.15开始
     * 三数之和为0
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>(); // 也可以用于初始化
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    res.add(curr);
                    j++;
                    k--;
                    while (j < k & nums[j] == nums[j - 1]) j++;
                    while (k > j & nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;

                } else {
                    j++;
                }
            }


        }
        return res;


    }

    public int threeSumClosest(int[] nums, int target) {
        //最接近的三数之和,排序后遍历
        //可以打表
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int thisRes = res;
            while (j < k) {
                thisRes = nums[i] + nums[j] + nums[k];
                if (thisRes == target) {
                    return target;
                } else if (thisRes < target) {
                    j++;
                } else {
                    k--;
                }
                res = Math.abs(res - target) < Math.abs(thisRes - target) ? res : thisRes;

            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution10 s = new Solution10();
//        System.out.println(s.threeSum(new int[]{0,0,0}));
//        System.out.println(s.intToRoman(1994));
//        System.out.println(s.respace(new String[]{"looked","just","like","her","brother"},"jesslookedjustliketimherbrother"));
//        int[] ress=s.intersect(new int[]{1,2,3},new int[]{5,1,2});
//        for(int i=0;i<ress.length;i++){
//            System.out.println(ress[i]);
//        }
//        int[] resss=s.twoSum(new int[]{1,2,3,4,4,9,56,90}
//        ,8);
//        System.out.println(resss[0]+" "+resss[1]);
        System.out.println(s.divisorGame(4));
    }


}
