package month7;

import solution.ListNode;
import tools.TreeNode;

import java.util.*;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-07-03 15:09
 **/
public class ForShopee {


    public int[] sortArray(int[] nums) {
        return  new int[0];
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int index = m+n-1;
        while (i>=0||j>=0){
            int n1=i>=0?nums1[i]:Integer.MIN_VALUE;
            int n2=j>=0?nums2[j]:Integer.MIN_VALUE;
            if(n1>=n2){
                nums1[index--]=nums1[i--];
            }else {
                nums1[index--]=nums2[j--];
            }
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = null;
         ListNode tail = null;
         int carry =0;
         while (l1!=null||l2!=null){
             int n1 = l1!=null? l1.val:0;
             int n2 = l2!=null? l2.val:0;
             int sum = n1+n2+carry;
             if(head==null){
                 head=tail=new ListNode(sum%10);


             }else {
                 tail.next=new ListNode(sum%10);
                 tail=tail.next;

             }
             carry =sum/10;
             if(l1!=null){
                 l1=l1.next;
             }
             if(l2!=null){
                 l2=l2.next;
             }

         }
         if(carry>0){
             tail.next=new ListNode(carry);

         }
         return head;

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former =head;
        ListNode latter = head;
        for(int i=0;i<k;i++){
            former=former.next;

        }
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        return latter;

    }


    public static void main(String[] args) {
        new ForShopee().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return root;
        }
        TreeNode left =root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            res = Math.max(res, pre);

        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLine = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                oneLine.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(oneLine);
        }
        return res;

    }


    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            int target = -nums[first];
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                if (third < n - 1 && nums[third] == nums[third + 1]) {
                    third--;
                    continue;
                }
                System.out.println("sum:" + (nums[second] + nums[third]));
                System.out.println("target:" + target);
                if (nums[third] + nums[second] < target) {
                    second++;
                    continue;
                }
                if (nums[third] + nums[second] > target) {
                    third--;
                    continue;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                    second++;
                    third--;
                }
            }
        }
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
