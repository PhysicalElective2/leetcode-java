package month4;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-21 21:29
 **/
public class TopN {
    public static void main(String[] args) {
        TopN t =new TopN();
        int[] data =new int[]{1,23,2,4,5,5,6,7,8,9,10,11,12,13,16,56,89};

        t.findTopN(5,data);
        t.print(data);

    }
    private int parent(int n){
        return (n-1)/2;
    }
    private int left(int n){
        return 2*n+1;
    }
    private int right(int n){
        return 2*n+2;
    }
//    private void buildHeap(int n,int[] data){
//        for(int i=1;i<n;i++){
//            int t=i;
//            while (t!=0&&data[parent(t)]>data[t]){
//
//            }
//        }
//
//
//    }
    private void buildHeap(int n, int[] data) {
        for(int i = 1; i < n; i++) {
            int t = i;
            // 调整堆, 从子节点开始调整，父节点会被调整，以到了0 号位置为结束。//
            //小顶堆
            while(t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }
    private void adjust(int i, int n, int[] data) {
        if(data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶 ，小顶堆，顶最小
        int t = 0;
        //左边还在范围内，且比堆顶小或者右边还在范围内，且比堆顶小
        while( (left(t) < n && data[t] > data[left(t)])
                || (right(t) < n && data[t] > data[right(t)]) ) {
            if(right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子，调整到右孩子，并且继续调整右孩子。
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public void findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for(int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
    }

    // 打印数组
    public void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}
