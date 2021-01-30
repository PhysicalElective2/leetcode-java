package solution2021;

import solution2021.design.Node;
import tools.TreeNode;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.*;

/**
 * since at20210112
 **/

public class S2 {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int left =0;
        int right=n*n-1;
        while (left<right){
            int mid =(left+right)/2;
            if(can2end(grid,mid)){
                right=mid;

            }else {
                left=mid+1;

            }



        }
        return left;



    }
    public boolean can2end(int[][] grid,int k){
        if (grid[0][0] > k) {
            return false;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()){
            int[] square = queue.poll();
            int i = square[0], j = square[1];
            for(int[] d:directions){
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n&&!visited[ni][nj] && grid[ni][nj] <= k) {
                        queue.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;

                }

            }

        }


        return visited[n - 1][n - 1];

    }
    public boolean isValidBST(TreeNode root) {
        return heper(root,null,null);

    }

    private boolean heper(TreeNode root, Integer  lower, Integer upper) {
        if(root==null) return true;
        int val=root.val;
        if(lower!=null&& val<=lower)return false;
        if(upper!=null&& val>=upper)return false;
        if(!heper(root.left,lower,val)) return false;
        if(!heper(root.right,val,upper)) return false;
        return true;

    }

    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        boolean[] can =new boolean[nums.length];
        can[0] =true;
        for(int i=0;i<nums.length;i++){
            int start=i+1;
            int len=nums[i];
            if(can[i]){
                while (start<nums.length&&len>0){
                    can[start]=true;
                    start++;
                    len--;
                }

            }
        }
        return can[nums.length-1];



    }

    public int maxProduct(int[] nums) {
        int min =nums[0];
        int max =nums[0];
        int ans =nums[0];
        for(int i=1;i<nums.length;i++){
            int tmin=min;
            int tmax =max;
            max=Math.max(tmax*nums[i],Math.max(tmin*nums[i],nums[i]));
            min=Math.min(tmax*nums[i],Math.min(tmin*nums[i],nums[i]));
            ans=Math.max(max,ans);
        }
        return ans;


    }
    public int minimumEffortPath(int[][] heights) {
        List<int[]> edges=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int id = i * n + j;
                if(i>0){
                    edges.add(new int[]{id-n,id,Math.abs(heights[i][j] - heights[i - 1][j])});

                }
                if(j>0){
                    edges.add(new int[]{id-1,id,Math.abs(heights[i][j] - heights[i][j-1])});


                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            if (uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;


    }
    public  class UnionFind{
        int[] parent;
        int[] size;
        int n;
        // 当前连通分量数目
        int setCount;
        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findset(x);
            y = findset(y);
            return x == y;
        }



    }

    int resFind;
    public int findTargetSumWays(int[] nums, int S) {
        resFind=0;
        int n=nums.length;
        dfs(nums,S,0,0);
        return resFind;


    }

    private void dfs(int[] nums, int s, int i,int sum) {
        if(i==nums.length){
            if(sum==s){
                resFind++;

            }
            return;

        }
        dfs(nums,s,i+1,sum+nums[i]);
        dfs(nums,s,i+1,sum-nums[i]);
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res, dp[i][j]);

                }

            }
        }
        return res * res;


    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int left = 0;
        int right = sum;
        if (nums.length == 0) return -1;
        if (left == right) return 0;
        right -= nums[0];
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if (left == right) return i;

        }
        return -1;


    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Stack s = new Stack();
//        s.add();
        return new int[0];


    }

    // wrong, because have negative number
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);

        }
        return res;


    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        if (n == 0) return res;
        int tempSum = 0;
        int startI = 0;
        tempSum += nums[startI];
        if (tempSum == k) res++;
        for (int i = 1; i < nums.length; i++) {
            // i as end
            tempSum += nums[i];
            if (tempSum < k) {
                continue;
            }

            while (tempSum > k) {
                tempSum -= nums[startI];
                startI++;

            }
            if (tempSum == k) {
                res++;
                tempSum -= nums[startI];
                startI++;
                continue;

            }

        }
        return res;

    }

    public static void main(String[] args) {
        S2 s = new S2();
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int len = heights[i];

            for (int j = i; j >= 0; j--) {

                len = Math.min(len, heights[j]);
                res = Math.max(res, len * (i - j + 1));

            }

        }
        return res;

    }

    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        int n = heights.length;
        if (n == 0) return 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= height) left--;
            int right = i;
            while (right < n - 1 && heights[right + 1] >= height) right++;
            res = Math.max(res, height * (right - left + 1));


        }
        return res;

    }

    public int largestRectangleArea3(int[] heights) {
        int res = 0;
        int n = heights.length;
        if (n == 0) return 0;
        int[] temp = new int[n + 2];
        System.arraycopy(heights, 0, temp, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int h = temp[stack.pop()];
                res = Math.max(res, (i - stack.peek() - 1) * h);
            }
            stack.push(i);


        }
        return res;

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int res = 0;
        for (int[] i : dominoes) {
            int val = i[0] > i[1] ? i[0] * 10 + i[1] : i[1] * 10 + i[0];
            res += num[val];
            num[val]++;
        }
        return res;


    }


    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);


    }

    public int minCostConnectPoints2(int[][] points) {
        int[][] graph = new int[points.length][points.length];
        int[] weights = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            weights[i] = Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1] - points[0][1]);
            for (int j = 0; j < points.length; j++) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }

        }
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int k = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < points.length; j++) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
            }
            result += weights[k];
            weights[k] = 0;
            for (int j = 0; j < points.length; j++) {
                if (weights[j] != 0 && graph[k][j] < weights[j]) {
                    weights[j] = graph[k][j];
                }
            }
        }
        return result;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        Dunion union = new Dunion(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        int res = 0;
        int num = 0;
        for (Edge edge : edges) {
            int len = edge.len;
            int x = edge.x;
            int y = edge.y;
            if (union.unionSet(x, y)) {
                res += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }


        return res;

    }

    private int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);


    }

    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }

    }

    class Dunion {
        int[] f;
        int[] rank;
        int n;


        public Dunion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
            return true;
        }


    }

    public List<List<Integer>> threeSum(int[] nums) {
        List res = new ArrayList();

        int n = nums.length;
        if (n == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) i++;
            int sum = -nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    List<Integer> oneRes = new ArrayList<>();
                    oneRes.add(nums[i]);
                    oneRes.add(nums[j]);
                    oneRes.add(nums[k]);
                    res.add(oneRes);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < sum) {
                    j++;

                } else {
                    k--;

                }

            }


        }
        return res;

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_num[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; i++) {
            square_num[i] = i * i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_num[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_num[s]] + 1);
            }
        }
        return dp[n];
    }

    public int maxCoins(int[] nums) {
        int res = 0;
        int n = nums.length;
        return 0;


    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        return new int[0];


    }

    public int removeStones(int[][] stones) {
        Union u = new Union();
        for (int[] stone : stones) {
            u.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - u.getCount();

    }

    private class Union {
        private Map<Integer, Integer> p;
        private int count;

        public Union() {
            p = new HashMap<>();
            this.count = 0;

        }

        public int getCount() {
            return count;

        }

        public int find(int x) {
            if (!p.containsKey(x)) {
                p.put(x, x);
                count++;
            }
            if (x != p.get(x)) {
                p.put(x, find(p.get(x)));
            }
            return p.get(x);

        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            p.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, inorder, 0, preorder.length, 0, inorder.length);

        return root;

    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {

        if (preStart >= preEnd || inStart >= inEnd)
            return null;
        int mid = inStart;
        for (; mid < inEnd; mid++) {
            if (inorder[mid] == preorder[preStart]) {
                break;
            }

        }
        int leftLen = mid - inStart;
        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = build(preorder, inorder, inStart, mid, preStart + 1, preStart + leftLen + 1);
        node.right = build(preorder, inorder, mid + 1, inEnd, preStart + leftLen + 1, preEnd);
        return node;


    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = num * 2 + A[i];
            res.add(num % 5 == 0);


        }
        return res;

    }

    int resDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        resDiameter = 1;
        dfs(root);
        // nodeNum -1 is res ;
        return resDiameter - 1;


    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        resDiameter = Math.max(resDiameter, L + R + 1);
        return Math.max(L, R) + 1;

    }

    public int leastInterval(char[] tasks, int n) {
        return 0;

    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = i;

        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            int f1 = find(p, node1);
            int f2 = find(p, node2);
            if (f1 != f2) {
                p[f1] = f2;
            } else {
                return edge;
            }
        }
        return new int[0];


    }

    private int find(int[] p, int node) {
        while (p[node] != node) {
            p[node] = find(p, p[node]);
            node = p[node];

        }
        return node;
    }

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[n];
        res[n - 1] = 0;
        deque.addLast(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (T[deque.peekFirst()] > T[i]) {
                res[i] = 1;
                deque.addFirst(i);
            } else {
                while (!deque.isEmpty() && T[deque.peekFirst()] <= T[i]) {
                    deque.pollFirst();
                }
                if (deque.isEmpty()) {
                    res[i] = 0;
                    deque.addFirst(i);
                } else {
                    res[i] = deque.peekFirst() - i;
                    deque.addFirst(i);
                }
            }

        }
        return res;


    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);

        }
        return root;


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        Queue<Node> queue = new LinkedList();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLine = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                oneLine.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(i));

                }
            }
            res.add(oneLine);
        }
        return res;

    }


}
