package company;


import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import tools.TreeNode;

import java.util.*;

public class TencentSolution3 {
    public static void main(String[] args) {
        Queue<String> q =new LinkedList<>();
        TencentSolution3 t = new TencentSolution3();
//        char[] nu1 = {'9', '8', '7', '6', '5', '4', '3', '2', '1'};
//        char nu2 = '9';
//        t.mul(nu1, nu2);
//        t.multiply("123","456");
//        System.out.println(t.addBinary("11", "1"));
//        System.out.println(t.permute(new int[]{1, 2, 3}));
        List<Integer> res=t.grayCode(4);
        for(Integer s:res){
            System.out.println(s);
        }
    }
    public boolean canWinNim(int n) {
        if(n<=3) return true;
        if(n==4) return false;
        return n%4>0;
//        if(n==5) return true;
//        if(n==6) return true;
//        if(n==7) return true;
//        if(n==8) return false;
//        if(n==9) return true;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> wayP=new ArrayList<>();
        ArrayList<TreeNode> wayQ =new ArrayList<>();

        find2(root,wayP,p);
        find2(root,wayQ,q);
        System.out.println("wayp.size:"+wayP.size());
        System.out.println("wayq.size:"+wayQ.size());
        TreeNode res=root;
        int i=wayP.size()-1;
        int j=wayQ.size()-1;
        while (i>=0&&j>=0){
            if(wayP.get(i).val==wayQ.get(j).val){
                res=wayP.get(i);
                i--;
                j--;
            }else {
                break;
            }
        }
        return res;

    }

    private boolean find2(TreeNode root, ArrayList<TreeNode> wayP,TreeNode p) {
        if(root.val==p.val){
            wayP.add(root);
            return true;
        }
        if(root.left!=null&&find2(root.left,wayP,p)){
            wayP.add(root);
            return true;

        }
        if(root.right!=null&&find2(root.right,wayP,p)){
            wayP.add(root);
            return true;
        }
        return false;

    }
    List<String> resGe;
    public List<String> generateParenthesis(int n) {
        resGe=new ArrayList<>();
        StringBuilder oneRes=new StringBuilder();
        oneRes.append('(');
        re(1,oneRes,n);
        return resGe;

    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> wayP=new ArrayList<>();
        ArrayList<TreeNode> wayQ =new ArrayList<>();
        find(root,wayP,p);
        find(root,wayQ,q);
        System.out.println("wayp.size:"+wayP.size());
        System.out.println("wayq.size:"+wayQ.size());
        TreeNode res=root;
        int i=0;
        int j=0;
        while (i<wayP.size()&&j<wayQ.size()){
            if(wayP.get(i).val==wayQ.get(j).val){
                res=wayP.get(i);
                i++;
                j++;
            }else {
                break;
            }
        }
        return res;


    }

    private void find(TreeNode root, ArrayList<TreeNode> wayP, TreeNode p) {
        wayP.add(root);
        if(root.val==p.val){
            return;
        }
        if(root.val>p.val){
            find(root.left,wayP,p);
        }else {
            find(root.right,wayP,p);
        }

    }
    // bettter way
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }


    public int candy(int[] ratings) {
        int n =ratings.length;
        int res=0;
        int[] left =new int[n];
        int[] right =new int[n];
        for(int i=0;i<n;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i<n-1&&ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }else {
                right[i]=1;
            }
        }
        for(int i=0;i<n;i++){
            res+=Math.max(left[i],right[i]);
        }
        return res;


    }

    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        int size = 1<<n;
        boolean[] visited =new boolean[size];
        visited[0]=true;
        res.add(0);
        while (res.size()<size){
            for(int i=0;i<n;i++){
                //find changed index i to get next
                System.out.println(res.size()+" "+res.get(res.size()-1));
                int next = res.get(res.size()-1)^(1<<i);
                if(next>=0&&next<(size)&&!visited[next]){
//                    System.out.println(i);
                    res.add(next);
                    visited[next]=true;
                    break;
                }

            }

        }
        return res;


    }
    public boolean  isNext(int a, int b){
        int c=a^b;
        int res=0;
        while (c!=0){
            res+=c&1;
            c=c>>>1;
        }
        System.out.println(res==1);
        return res==1;
    }
    public List<List<Integer>> subsets5(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n =nums.length;
        for(int i=0;i<(2<<n);i++){
            ArrayList<Integer> oneRes =new ArrayList<>();
            for(int j=0;j<n;j++){
                if((1<<j&i)!=0) oneRes.add(nums[j]);
            }
            res.add(new ArrayList<>(oneRes));

        }
        return res;
    }

    private void re(int i, StringBuilder oneRes, int n) {
        if(sumChar(oneRes,')')>sumChar(oneRes,'(')){
            return;
        }
        if(i>n*2) return;
        if(i==n*2&&sumChar(oneRes,')')==sumChar(oneRes,'(')){
            resGe.add(oneRes.toString());
            return;
        }
        StringBuilder add1=new StringBuilder(oneRes);
        add1.append('(');
        StringBuilder add2=new StringBuilder(oneRes);
        add2.append(')');
        re(i+1,add1,n);
        re(i+1,add2,n);

    }

    private int sumChar(StringBuilder oneRes, char c) {
        int res=0;
        for(int i=0;i<oneRes.length();i++){
            if(oneRes.charAt(i)==c) res++;
        }
        return  res;
    }

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        boolean[] visit =new boolean[nums.length];
        List<Integer> oneRes =new ArrayList<>();
        recursive(nums,0,visit,oneRes);
        return res;


    }

    private void recursive(int[] nums, int i, boolean[] visit, List<Integer> oneRes) {
        if(i==nums.length){
            res.add(oneRes);
        }
        for(int h=0;h<visit.length;h++){
            System.out.println(Arrays.toString(visit));
            if(!visit[h]){
                visit[h]=true;
                List<Integer> nextRes =new ArrayList<>(oneRes);
                nextRes.add(nums[h]);
                System.out.println("oneRes:"+Arrays.toString(oneRes.toArray()));
                recursive(nums,i+1,visit,nextRes);
                visit[h]=false;
            }
        }
    }

    public String addBinary(String a, String b) {
        char[] sa=a.toCharArray();
        char[] sb=b.toCharArray();
        StringBuilder res=new StringBuilder();
        int add =0;
        int indexA =sa.length-1;
        int indexB =sb.length-1;
        while (indexA>=0&&indexB>=0){
            int thisSum=sa[indexA]-'0'+sb[indexB]-'0'+add;
            res.append(thisSum%2);
            add=thisSum/2;
            indexA--;
            indexB--;
        }
        while (indexA>=0){
            int thisSum=sa[indexA]-'0'+add;
            res.append(thisSum%2);

            add=thisSum/2;
            indexA--;

        }
        while (indexB>=0){
            int thisSum=sa[indexB]-'0'+add;
            res.append(thisSum%2);

            add=thisSum/2;
            indexB--;
        }
        if(add>0) res.append(add);
        return res.reverse().toString();


    }
    List<Integer> vals;

    public int kthSmallest(TreeNode root, int k) {
        vals =new ArrayList<>();
        midOreder(root);
        return vals.get(k-1);

    }

    private void midOreder(TreeNode root) {
        if(root.left!=null){
            midOreder(root.left);
        }
        vals.add(root.val);
        if(root.right!=null){
            midOreder(root.right);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resWhenZero = new ArrayList<>();
        resWhenZero.add(new ArrayList<Integer>());
        if(nums.length==0) {
            return resWhenZero;
        }
        List<List<Integer>> thisRes =resWhenZero;
//        List<List<Integer>> lastRes=resWhenZero;
        for(int i=0;i<nums.length;i++){
//            thisRes=lastRes;
            int size=thisRes.size();
            for(int j=0;j<size;j++){
                List<Integer> add =new ArrayList<>(thisRes.get(j));
                add.add(nums[i]);
                thisRes.add(add);
            }

        }
        return thisRes;

    }
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        maxGain(root);
        return maxSum;


    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        StringBuilder ress = new StringBuilder();
        for (int i = 0; i <n2.length; i++) {
//            res+=mul(n2,n1[i])*Math.pow(10,n1.length-1-i);
            StringBuilder oneRes = mul(n1, n2[i]);
            ress = add(ress.insert(0,'0'), oneRes);
            System.out.println("temp res:"+ress);

        }
        return String.valueOf(ress.reverse());


    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int add = 0;
        int index = 0;
        StringBuilder res=new StringBuilder();
        while (index<num1.length()&&index<num2.length()) {
            int oner = num1.charAt(index) - '0' + num2.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        while (index<num1.length()){
            int oner = num1.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        while (index<num2.length()){
            int oner = num2.charAt(index) - '0' + add;
            res.append(oner%10);
            add = oner / 10;
            index++;
        }
        if(add>0){
            res.append(add);
        }
        return res;
    }


    public StringBuilder mul(char[] num1, char num2) {
        int add = 0;
        StringBuilder ress = new StringBuilder();
        for (int i = num1.length - 1; i >= 0; i--) {
//            res+=(num1[i]-'0')*(num2-'0')*Math.pow(10,num1.length-1-i);
            int thisNum = (num1[i] - '0') * (num2 - '0') + add;
            System.out.println((num1[i] - '0') * (num2 - '0') + add);
            ress.append(thisNum % 10);
            add = thisNum / 10;
        }
        if (add > 0) {
            ress.append(add);
        }
        System.out.println(Arrays.toString(num1) + "*" + num2 + "=");

        System.out.println(ress);
        return ress;
    }




    private int maxGain(TreeNode root) {
        if (root == null) return 0;
//        if(root.left==null&&root.left==null) return root.val;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int thisGain = leftGain + rightGain + root.val;
        maxSum = Math.max(thisGain, maxSum);
        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        List<Integer> num = new ArrayList<>();
        dfs(root, num);
        int[] dp = new int[num.size()];
        dp[0] = num.get(0);
        int res = dp[0];

        for (int i = 1; i < dp.length; i++) {
            System.out.println(num.get(i));
            dp[i] = Math.max(dp[i - 1] + num.get(i), num.get(i));
            res = Math.max(res, dp[i]);
        }
        return dp[num.size() - 1];


    }

    public List<String> getList() {
        return null;
    }

    public void dfs(TreeNode node, List num) {
        num.add(node.val);
        if (node != null) {
            num.add(node.val);
            dfs(node.left, num);
            dfs(node.right, num);
        } else {
            num.add(Integer.MIN_VALUE);
        }

    }

    //    public int search(int[] nums, int target) {
//        int n= nums.length;
//        if(n==0){
//            return -1;
//        }
//        if(n==1) return nums[0]==target?0:-1;
//        int l=0,r=n-1;
//        while (l<=r){
//            int mid =(l+r)/2;
//            if(nums[mid]==target) return mid;
//            if(nums[0]<=nums[mid]){
//                // front is in order
//                if(nums[0]<=target&&target<nums[mid]){
//                    r=mid-1;
//                }else {
//                    l=mid+1;
//                }
//
//            }else {
//                if (nums[mid] < target && target <= nums[n - 1]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//
//
//            }
//
//        }
//        return -1;
//
//
//    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {//mid左侧为有序数组
                if (nums[left] <= target && nums[mid] >= target) {//如果target在mid左侧的话
                    right = mid - 1;
                } else {//在mid右侧
                    left = mid + 1;
                }
            } else {//mid右侧为有序数组
                if (nums[mid] <= target && nums[right] >= target) {//如果target在mid右侧的话
                    left = mid + 1;
                } else {//在mid左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
