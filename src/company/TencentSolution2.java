package company;


import java.math.BigInteger;
import java.util.*;


public class TencentSolution2 {
    private static final Object M = "media";
    private static final Object L = "large";
    private static final Object S = "small";
    public boolean isPowerOfTwo(int n) {
        double nn=n;
        while (nn>1){
            nn/=2;
        }
        return nn==1;

    }
    // a better way
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
    public ListNode rotateRight(ListNode head, int k) {
        //first get the last two node
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;

    }
    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int n=1;
        ListNode oldHead =head;
        while (oldHead.next!=null){
            oldHead=oldHead.next;
            n++;
        }
        oldHead.next=head;
        ListNode new_tail = head;
        for(int i=0;i<n-k%n-1;i++){
            new_tail=new_tail.next;
        }
        ListNode new_head=new_tail.next;
        new_tail.next=null;
        return new_head;




    }




        public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == target && res[0] == -1) {
                res[0] = i;
            } else {

            }
            if (nums[j] == target && res[1] == -1) {
                res[1] = j;

            } else {

            }
            if (res[0] == -1) {
                i++;
            }
            if (res[1] == -1) {
                j--;
            }
            if (res[0] != -1 && res[1] != -1) {
                return res;
            }
        }
        return res;

    }

    public int[] searchRange2(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);

        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};

    }

    private int search(int[] nums, int target, boolean low) {
        int left = 0;
        int right = nums.length;
        int ans = nums.length;
        while (right <= left) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || low && nums[mid] >= target) {
                right = mid - 1;
                ans = mid;

            } else {
                left = mid + 1;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        // print[][]
//        Arrays.deepToString()
//        Arrays.equals()
//        Arrays.fill();
//        int[][] test ={{1,2,3},{4,5,6},{7,8,9}};
//        new TencentSolution2().spiralOrder(test);
        Throwable able = new Throwable("想吐。。。");
        System.out.println("max:" + Integer.MAX_VALUE);

        System.out.println(able.toString()); // 输出该异常的类名

        System.out.println(able.getMessage()); // 输出异常的信息

        able.printStackTrace(); // 打印栈信息
//        TencentSolution2 t=new TencentSolution2();
//        t.beautifulArray(6);
//        enum Size{ M,L,S};
//        enum Color { RED, GREEN, BLUE }

    }


    Map<Integer, int[]> memo;

    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : f((N + 1) / 2))  // odds
                ans[t++] = 2 * x - 1;
            for (int x : f(N / 2))  // evens
                ans[t++] = 2 * x;
        }
        memo.put(N, ans);
        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return null;

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum / 10;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // a better way
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resPre = new ListNode(-1);
        ListNode pointPre = resPre;
        ListNode temp = new ListNode(-1);
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1.next;
                pointPre.next = l1;
                l1.next = null;
                l1 = temp;

            } else {
                temp = l2.next;
                pointPre.next = l2;
                l2.next = null;
                l2 = temp;


            }
            pointPre = pointPre.next;

        }
        if (l1 != null) {
            pointPre.next = l1;
        }
        if (l2 != null) {
            pointPre.next = l2;
        }
        return resPre.next;

    }

    public int reverse2(int x) {

        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
//
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if ((res * 10) / 10 != res) {
                res = 0;
                break;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }


    private void swap(int[] nums1, int i, int k) {
        int temp = nums1[i];
        nums1[i] = nums1[k];
        nums1[k] = temp;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);

    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];
        int directionIndex = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < total; i++) {
            res[row][column] = i + 1;
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= n || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;

            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return res;

    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;

                } else if (o1[1] < o2[1]) {
                    return -1;

                }
                return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] ballon : points) {
            if (ballon[0] > pos) {
                pos = ballon[1];
                ++ans;
            }
        }
        return ans;

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int total = m * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0, column = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;

            }

//            if(nextRow<0||nextColumn<0||nextRow>=m||nextColumn>=n||visited[nextRow][nextColumn]){
//                directionIndex=(directionIndex+1)%4;
//
//            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return res;

    }

    public ListNode reverseD(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseD(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList(ListNode head) {
        ListNode resPre = new ListNode(-1);
        resPre.next = null;
        ListNode temp = new ListNode(-1);
        while (head != null) {
            temp = head.next;
            head.next = resPre.next;
            resPre.next = head;
            head = temp;
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
        int start[] = new int[nums.length];
        int end[] = new int[nums.length];
        start[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            start[i] = start[i - 1] * nums[i];
        }
        end[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            end[i] = end[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        res[0] = end[1];
        res[nums.length - 1] = start[nums.length - 2];
        for (int i = 1; i < nums.length - 2; i++) {
            System.out.println("start[i-1]" + start[i - 1]);
            System.out.println("end[i+1]" + end[i + 1]);
            res[i] = start[i - 1] * end[i + 1];
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
