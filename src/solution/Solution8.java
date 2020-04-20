package solution;

import java.util.*;

/**
 * create at 20200413
 */
public class Solution8 {


    public ArrayList<Integer> maxInWindows3(int[] num, int size) {
        //这个代码才叫有水平，其实和我一样，他化简了 ,关键是java linklist 这个数据结构太灵活


        ArrayList<Integer> res = new ArrayList<>();
        if(size<1||num.length==0)return res;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length ; i++) {

            while(!list.isEmpty()&&num[list.peekLast()]<num[i]){
                list.pollLast();
            }
            //双端队列add ,默认add 到后面
            list.add(i);
            //判断左边是否失效
            if(list.peekFirst()<=i-size){
                list.pollFirst();
            }
            if(i>=size-1)
                res.add(num[list.peekFirst()]);

        }
        return  res;
    }
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        // 排除特殊情况，窗口的长度为0
        if (size==0) return result;

        // 滑动窗口最左边数的index
        int begin;
        // 建立一个双端队列
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            // begin是窗口起始位置
            begin = i-size+1;
            // 队列空，直接加入
            if(q.isEmpty())
                q.add(i);
                // 若队列最左边值已经不在窗口内，直接删除
            else if(begin > q.peekFirst())
                q.pollFirst();

            // 从队尾开始比较，把所有比他小的值丢掉
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            // 随后再把它放进去
            q.add(i);

            // 若窗口起始位置在数组的0位置上或者之后（窗口是完整大小的），才计算窗口的有效最大值
            if(begin>=0){
                // 永远是队列最左边最大，加入结果集
                result.add(num[q.peekFirst()]);
            }
        }
        return result;
    }
    //滑动窗口最大值

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        // 所要的窗口中的最大值
        //又是只通过百分之五十，哎

        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<>();
        //那么deque 还是存位置吧
        if (num.length < size || size==0) {
            return res;
        }
        for (int i = 0; i < num.length; i++) {
            //num[i]小,也得有合适的位置,把比他小的全部删掉,不区分大小了，为什么
            //总是加到最后，消除所有比他大的。
            while ((!deque.isEmpty()) && num[deque.peekLast()] <= num[i])
                deque.pollLast();
            deque.addLast(i);

            if (i - deque.getFirst() >= size) {
                deque.removeFirst();
            }


            if (i >= size - 1) {
                res.add(num[deque.getFirst()]);
            }
        }
        return res;

    }
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //先去matrix 中找str[0],matric给的还是一维数组
        //还要有标记数组，只能访问一次
        //还要记得回溯
        boolean visited[][] = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //如果这个数字等于str[0]
                if(matrix[i*cols+j]==str[0]&& dg(matrix,rows,cols,i,j,str,1,visited)){
                    return true;

                }
                visited[i][j]=false;

            }
        }
        return false;

    }


    private boolean dg(char[] matrix,int rows, int cols,int x,int y,char[] str,int index,boolean[][] visited) {
        //判断能不能达到下一个位置,index 为下一个要判断的位置
        if(index>=str.length){
            return true;
        }
        //先标记这个为true
        visited[x][y]=true;
        int nextX;
        int nextY;
        boolean res=false;
        for (int i=0;i<4;i++){
            nextX=x+dx[i];
            nextY=y+dy[i];
            if(nextX>=0 && nextX<rows && nextY>=0 &&nextY<cols && !visited[nextX][nextY]&&matrix[nextX*cols+nextY]==str[index]){//可能会有两条路线,这里会有越界
                res=res||dg(matrix,rows,cols,nextX,nextY,str,index+1,visited);
                visited[nextX][nextY]=false;
            }
        }
        return res;


    }

    public ArrayList<Integer> printMatrix2(int [][] matrix){
        //顺时针打印
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix.length==0) return res;
        int direction=0;
        boolean isVisit[][]=new boolean[matrix.length][matrix[0].length];//初始化，全都没有被访问过
        while(res.size()<matrix.length*matrix[0].length){
//            swich(direction){
//                //case 0:
//
//            }

        }
        return res;

    }
    //序列化二叉树
    //LinkedList类实现了Queue接口

    public ArrayList<Integer> printMatrix(int [][] matrix) {//顺时针打印
        //怎么还是时间复杂度过大啊
        //因为写错了一个符号，哎
        ArrayList<Integer> res=new ArrayList<>();
        if(matrix.length==0) return res;
        boolean isVisit[][]=new boolean[matrix.length][matrix[0].length];//初始化，全都没有被访问过
        //第一个方向为0
        int x=0;
        int y=0;
        int direction=0;
        isVisit[x][y]=true;
        res.add(matrix[x][y]);
        int size=matrix.length*matrix[0].length;
        while(res.size()<size) {//没有问题啊
            switch (direction) {
                case 0:
                    if (y +1< matrix[0].length&&!isVisit[x][y + 1] && x >= 0 && y >= 0 && x < matrix.length) {
                        y++;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = (direction+1)%4;

                    }
                    break;
                case 1:
                    if (x+1 < matrix.length &&!isVisit[x+1][y] && x >= 0 && y >= 0 &&  y < matrix[0].length) {
                        x++;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = (direction+1)%4;

                    }
                    break;
                case 2:
                    if ( x >= 0 && y-1 >= 0 &&!isVisit[x][y-1] && x < matrix.length && y < matrix[0].length) {
                        y--;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = (direction+1)%4;
                    }
                    break;
                case 3:
                    if ( x-1 >= 0 && y >= 0 &&!isVisit[x-1][y] && x < matrix.length && y < matrix[0].length) {
                        x--;
                        isVisit[x][y] = true;
                        res.add(matrix[x][y]);
                    } else {
                        direction = (direction+1)%4;
                    }
                    break;

            }
            // if(res.size()==matrix.length*matrix.length) break;
        }
        return res;

    }
    private int indexx=-1;
    String Serialize(TreeNode root) {
        if (root==null){
            return "#";
        }
        //这里可以改成‘！’
        return root.val+","+Serialize(root.left) +","+ Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        String[] s=str.split(",");
        indexx++;
        int len = s.length;
        if(indexx >=len){
            return null;
        }
        TreeNode t=null;
        // s 中的元素还是字符串
        if(!s[indexx].equals("#")){
            //t=TreeNode(Integer.parseInt(s[indexx]));
            t= new TreeNode(Integer.parseInt(s[indexx]));
            t.left=Deserialize(str);
            t.right=Deserialize(str);


        }
        return t;


    }
    private  int index=0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {//中序遍历
        if (pRoot!=null){
            TreeNode node = KthNode(pRoot.left,k);
            if(node!=null){
                return node;
            }
            index++;

            if(index==k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;

    }


    private PriorityQueue<Integer> minHeap =new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap =new PriorityQueue<>(15,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int count=0;


    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count%2==0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;

    }

    public Double GetMedian() {
        //Double 和Integer没有任何继承关系,不可以直接强制类型转化
        if(count%2==0){
            //注意除以二得在外面
            return new Double(maxHeap.peek() + minHeap.peek() )/2;

        }
        else {
            return new Double(minHeap.peek());
        }



    }

}
