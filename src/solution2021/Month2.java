package solution2021;

import java.util.*;

public class Month2 {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        int h=board.length;
        int w=board[0].length;
        boolean[][] visited =new boolean[h][w];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(find(board,visited,word,i,j,0)){
                        return true;

                    };

                }

            }
        }
        return false;




    }

    private boolean find(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==word.length()-1) return true;
        visited[i][j] =true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi=i+dir[0],newj= j+dir[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length&&!visited[newi][newj]){
                boolean flag = find(board, visited,word, newi, newj, k + 1);
                if (flag) {
                    result = true;
                    break;
                }






            }

        }
        visited[i][j] =false;
        return  result;



    }


    private boolean find() {
        return false;


    }

    public int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return matrix;
        int n=matrix[0].length;
        if(n==0) return matrix;
        int[][] res=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i]=matrix[i][j];
            }
        }
        return res;

    }

    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] line:A){
            int temp;
            for(int i=0;i<line.length/2;i++){
                temp=line[line.length-i-1];
                line[line.length-i-1]=line[i];
                line[i]=temp;

            }
            if(line.length%2==1){
                line[line.length/2]=1-line[line.length/2];
            }



        }
        return A;

    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total =0;
        int n=customers.length;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                total+=customers[i];

            }
        }
        int increase =0;
        for(int i=0;i<X;i++){
            increase+=customers[i]*grumpy[i];

        }
        int maxIncrease =increase;
        for(int i=X;i<n;i++){
            increase=increase-customers[i-X]*grumpy[i-X]+customers[i]*grumpy[i];
            maxIncrease =Math.max(maxIncrease,increase);
        }

        return total+maxIncrease;

    }

    public boolean checkPossibility(int[] nums) {
        int reverseNum=0;
        int pre =0;
        if(nums.length<=2) return true;
        if(nums[0]>nums[1]) {

            reverseNum++;
            pre=1;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) {

                reverseNum++;
            }else {
                pre=i;
            }
        }

        return reverseNum<=1;

    }
    public static void main(String[] args) {
        Month2 m=new Month2();
      //  System.out.println(m.check(new int[]{3,4,5,1,2}));
        //[9210,-5402,8022,-4660,-1719,-9686,3899,8543,-8813,2070,3791,3177,-775,-9400,-7036,-7050,-9843,2563,-1190,5216,-1089,2210,5775,1027,2729,4947,-6183,5850,1616,-5259,3605,-5142]
        //-10259
        System.out.println(m.minAbsDifference(new int[]{9210, -5402, 8022, -4660, -1719, -9686, 3899, 8543, -8813, 2070, 3791, 3177, -775, -9400, -7036, -7050, -9843, 2563, -1190, 5216, -1089, 2210, 5775, 1027, 2729, 4947, -6183, 5850, 1616, -5259, 3605, -5142}, -10259));
    }
    int resMinAbsDifference;

    public int minAbsDifference(int[] nums, int goal) {
        resMinAbsDifference=Integer.MAX_VALUE;
        int n=nums.length;
        back(nums,goal,0,0);
        return resMinAbsDifference;

    }
    public void back(int[] nums, int goal,int index,int sum){
        if(sum==goal){
            resMinAbsDifference=0;
            return;
        }
        if(index==nums.length){
            resMinAbsDifference=Math.min(resMinAbsDifference,Math.abs(sum-goal));
            return;

        }
        back(nums,goal,index+1,sum);
        back(nums,goal,index+1,sum+nums[index]);

    }
    public String largestMerge(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        while (word1.length() != 0 || word2.length() != 0){
            if(word1.compareTo(word2) > 0){
                res.append(word1.charAt(0));
                word1 = word1.substring(1);
            }else{
                res.append(word2.charAt(0));
                word2 = word2.substring(1);
            }
        }
        return res.toString();



    }
    public boolean check(int[] nums) {
        boolean res= false;
        int index =0;
        int n=nums.length;
        while (index< nums.length){
            boolean thisCan =true;
            int onestart =index;
            for(int step =1;step<n;step++){
                if(nums[(onestart+step-1)%n]>nums[(onestart+step)%n]){
                    thisCan=false;
                    break;

                }

            }
            if(thisCan){
                res=true;
                break;
            }
            index++;

        }
        return res;

    }
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int winsize=n-k;

        int sum = 0;
        for (int i = 0; i < winsize; ++i) {
            sum += cardPoints[i];
        }
        int minSum=sum;
        for(int i=winsize;i<n;i++){
            sum += cardPoints[i] - cardPoints[i - winsize];
            minSum = Math.min(minSum, sum);



        }
        return Arrays.stream(cardPoints).sum()-minSum;



    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int[] distance =new int[n];
        for(int i=0;i<n;i++){
            distance[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int index =0;
        int start=0;
        int sum=0;
        int maxL=0;
        while (index<n){
            sum+=distance[index];
            if(sum<=maxCost){
                maxL=Math.max(maxL,index-start+1);
            }
            while (sum>maxCost){
                sum-=distance[start];
                start++;
            }

            index++;

        }
       return maxL;



    }

    public double findMaxAverage(int[] nums, int k) {

        int sum=0;
        int index=0;
        while (index<k){
            sum+=nums[index++];
        }
        int res=sum;

        for(;index<nums.length;index++){
            sum-=nums[index-k];
            sum+=nums[index];
            res=Math.max(res,sum);
        }
        return ((double) res)/k;

    }

    public int characterReplacement(String s, int k) {
        int[] num =new int[26];
        int n=s.length();
        int maxn=0;
        int left =0;
        int right =0;
        while (right<n){
            num[s.charAt(right)-'A']++;
            maxn=Math.max(maxn,num[s.charAt(right)-'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;

        }
        return right-left;

    }
}
