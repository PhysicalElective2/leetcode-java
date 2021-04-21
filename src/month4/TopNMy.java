package month4;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-21 21:57
 **/
public class TopNMy {
    public static void main(String[] args) {
        TopNMy t =new TopNMy();
        int[] data =new int[]{1,23,2,4,5,5,6,7,8,9,10,11,12,13,16,56,89};

        t.findN(5,data);
        t.print(data);

    }
    public int p(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    public void findN(int n,int[] data){
        buildHeap(n,data);
        for(int i=n;i<data.length;i++){
            adjust(i,n,data);
        }


    }

    private void adjust(int i, int n, int[] data) {
        if(data[i]<=data[0]){
            return;
        }
        int temp=data[i];
        data[i] =data[0];
        data[0] =temp;
        int t=0;
        while (left(t)<n&&data[t]<data[left(t)]||
                right(t)<n&&data[t]<data[right(t)]

        ){
            if(left(t)<n&&data[t]<data[left(t)]){
                temp=data[t];
                data[t]=data[left(t)];
                data[left(t)]=temp;
                t=left(t);
            }else {
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            }


        }

    }

    private void buildHeap(int n, int[] data) {
        for(int i=1;i<n;i++){
            int t=i;
            while (t!=0&&data[t]<data[p(t)]){
                int temp=p(t);
                data[p(t)]=data[t];
                data[t]=temp;
                t=p(t);

            }
        }

    }

    public void print(int[] data){
        for(int i:data){
            System.out.print("\t"+i);
        }


    }

}
