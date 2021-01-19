package solution2021;

import java.util.*;

public class Com0117 {
    public int largestSubmatrixHeyue(int[][] matrix) {
        int maxCount = 0;
        Integer[] count = new Integer[matrix[0].length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count[j] = matrix[i][j] == 0 ? 0 : count[j] + 1;
            }
            Integer[] copy = Arrays.copyOf(count, count.length);
            Arrays.sort(copy, Collections.reverseOrder());
            for (int j = 0; j < copy.length; j++) {
                maxCount = Math.max(maxCount, copy[j] * (j + 1));
            }
        }
        return maxCount;
    }
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int res=0;

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=matrix[i-1][j]>0?matrix[i-1][j]+1:matrix[i][j];

                }
            }


        }
        for(int i=0;i<m;i++){
            Arrays.sort(matrix[i]);
            int h= Integer.MAX_VALUE;
            for(int j=n-1;j>=0;j--){
                h=Math.min(h,matrix[i][j]);
                res=Math.max(res,h*(n-j));




            }

        }
        return res;

    }
    public int countGoodRectangles(int[][] rectangles) {
        int res=0;
        int resLen=0;
        for(int[] i:rectangles){
            int len =Math.min(i[0],i[1]);
            if(len==resLen){
                res++;
            }else {
                if(len>resLen){
                    resLen=len;
                    res=1;
                }
            }


        }
        return res;

    }

    public static void main(String[] args) {
        Com0117 c=new Com0117();
        System.out.println(c.tupleSameProduct2(new int[]{2,3,4,6,8,12}));
    }
    private List<List<Integer>> res;//结果集
    private int target;//目标
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);  //  排序便于剪枝操作
        this.target = target;
        helper(nums, 0, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, int target, List<Integer> list) {
        if (list.size() == 4 && target == this.target) {
            //  如果数量相等，且和等于target，直接放入结果中
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            //  后续数量如果已经凑不齐4个，直接剪掉
            if (nums.length - i < 4 - list.size()) return;
            //  避免重复结果
            if (i > index && nums[i] == nums[i - 1]) continue;
            //  这里借鉴了官方题解评论中一位大哥的写法，这样可以精简代码，否则(3 - list.size()) * nums[i + 1]要写成好几个if条件，这样会粗略一些，不过应该还好
            if (i < nums.length - 1 && (target + nums[i] + (3 - list.size()) * nums[i + 1] ) > this.target) return;
            //  这里同上
            if (i < nums.length - 1 && (target + nums[i] + (3 - list.size()) * nums[nums.length - 1] ) < this.target)
                continue;
            //  下方的代码就是经典的回溯代码了，不再赘述
            list.add(nums[i]);
            helper(nums, i + 1, target + nums[i], list);
            list.remove(list.size() - 1);
        }
    }
    public int tupleSameProduct2(int[] nums) {
        int res=0;
        int n=nums.length;
        int[][] cheng=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cheng[i][j]=nums[i]*nums[j];
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                map.put(cheng[i][j],map.getOrDefault(cheng[i][j],0)+1);
            }
        }
        for(Integer i:map.values()){
                res+=i*(i-1)*4;


        }
        return res;



    }

        public int tupleSameProduct(int[] nums) {
//        List<List<Integer>> res =new ArrayList<>();
            int res=0;

            Arrays.sort(nums);
            for(int i=0;i<=nums.length-2;i++){

                for(int j=i+1;j<=nums.length-1;j++){



                    int cheng=nums[i]*nums[j];
                    int m=0;
                    int n=nums.length-1;
                    while (m<n){
                        if(m==i||m==j) {
                            m++;
                            continue;
                        }
                        if(n==i||n==j) {
                            n--;
                            continue;
                        }
                        if(nums[m]*nums[n]==cheng){
                            res++;

                            m++;

                            n--;

                            continue;
                        }
                        if(nums[m]*nums[n]>cheng){
                            n--;
                            continue;
                        }
                        if(nums[m]*nums[n]<cheng){
                            m++;
                            continue;
                        }

                    }



                }

            }
            return res*4;

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res =new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-4;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<=nums.length-3;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int lastTwoTar=target-nums[i]-nums[j];
                int m=j+1;
                int n=nums.length-1;
                while (m<n){
                    if(nums[m]+nums[n]==lastTwoTar){
                        List<Integer> oneres=new ArrayList<>();
                        oneres.add(nums[i]);
                        oneres.add(nums[j]);
                        oneres.add(nums[m]);
                        oneres.add(nums[n]);
                        res.add(oneres);

                        m++;
                        while(m+1<nums.length&&nums[m]==nums[m-1]){
                            m++;
                        }
                        n--;
                        while(n-1>=0&&nums[n]==nums[n+1]){
                            n--;
                        }
                        continue;
                    }
                    if(nums[m]+nums[n]>lastTwoTar){
                        n--;
                        continue;
                    }
                    if(nums[m]+nums[n]<lastTwoTar){
                        m++;
                        continue;
                    }

                }

            }

        }
        return res;

    }
}
