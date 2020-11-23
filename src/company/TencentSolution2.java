package company;


import java.util.*;


public class TencentSolution2 {
    public static void main(String[] args) {
        int[][] test ={{1,2,3},{4,5,6},{7,8,9}};
        new TencentSolution2().spiralOrder(test);
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);

    }
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int total =n*n;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited =new boolean[n][n];
        int directionIndex =0;
        int row =0;
        int column =0;
        for(int i=0;i<total;i++){
            res[row][column]=i+1;
            visited[row][column]=true;
            int nextRow =row+directions[directionIndex][0];
            int nextColumn=column+directions[directionIndex][1];
            if(nextRow<0||nextColumn<0||nextRow>=n||nextColumn>=n||visited[nextRow][nextColumn]){
                directionIndex=(directionIndex+1)%4;

            }
            row=row+directions[directionIndex][0];
            column=column+directions[directionIndex][1];
        }
        return res;

    }
    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0||points[0].length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;

                }else if(o1[1] < o2[1]){
                    return -1;

                }
                return 0;
            }
        });
        int pos =points[0][1];
        int ans = 1;
        for(int[] ballon:points){
            if(ballon[0]>pos){
                pos=ballon[1];
                ++ans;
            }
        }
        return ans;

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return res;
        }

        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] visited =new boolean[m][n];
        int total =m*n;
        int[][] directions ={{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex =0;
        int row =0,column=0;
        for(int i=0;i<total;i++){
            res.add(matrix[row][column]);
            visited[row][column]=true;
            int nextRow =row+directions[directionIndex][0];
            int nextColumn =column+directions[directionIndex][1];

                if(nextRow<0||nextColumn<0||nextRow>=m||nextColumn>=n||visited[nextRow][nextColumn]){
                    directionIndex=(directionIndex+1)%4;

                }

//            if(nextRow<0||nextColumn<0||nextRow>=m||nextColumn>=n||visited[nextRow][nextColumn]){
//                directionIndex=(directionIndex+1)%4;
//
//            }
            row+=directions[directionIndex][0];
            column+=directions[directionIndex][1];
        }
        return res;

    }
    public ListNode reverseD(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p =reverseD(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
    public ListNode reverseList(ListNode head) {
        ListNode resPre=new ListNode(-1);
        resPre.next=null;
        ListNode temp=new ListNode(-1);
        while (head!=null){
            temp=head.next;
            head.next=resPre.next;
            resPre.next=head;
            head=temp;
        }
        return resPre.next;


    }


    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) return true;
        }
        return false;

    }
    //there way is better
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

    public int[] productExceptSelf(int[] nums) {
        int start[] =new int[nums.length];
        int end[] =new int[nums.length];
        start[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            start[i]=start[i-1]*nums[i];
        }
        end[nums.length-1]=nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--){
            end[i]=end[i+1]*nums[i];
        }
        int[] res=new int[nums.length];
        res[0]=end[1];
        res[nums.length-1]=start[nums.length-2];
        for(int i=1;i<nums.length-2;i++){
            System.out.println("start[i-1]"+start[i-1]);
            System.out.println("end[i+1]"+end[i+1]);
            res[i]=start[i-1]*end[i+1];
        }
        return res;


    }

    public void reverseString(char[] s) {
        int j = 0;
        int k = s.length - 1;
        char temp;
        while (j < k) {
            temp = s[j];
            s[j] = s[k];
            s[k] = temp;
            j++;
            k--;
        }


    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        if (ss.length == 0) return s;
        StringBuilder res = new StringBuilder();
        for (String oneS : ss) {
            char[] cs = new char[oneS.length()];
            for (int i = 0; i < cs.length; i++) {
                cs[i] = oneS.charAt(i);
            }
            reverseString(cs);
            res.append(cs);
            res.append(" ");
        }
        return res.substring(0, s.length());
    }


}
