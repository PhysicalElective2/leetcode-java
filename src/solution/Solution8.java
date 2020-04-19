package solution;

import java.util.*;

/**
 * create at 20200413
 */
public class Solution8 {
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
