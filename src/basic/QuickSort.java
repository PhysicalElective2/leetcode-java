package basic;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-04-26 09:36
 **/
public class QuickSort {

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;

        //temp就是基准位
        temp = arr[low];
        while (i<j){
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j){
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j){

                i++;

            }

            //如果满足条件则交换

            if (i<j){

                t=arr[j];

                arr[j]=arr[i];

                arr[i]=t;

            }

        }
        //最后将基准为与i和j相等位置的数字交换
        // arr[i] 就是小于等于temp 的
        arr[low] = arr[i];
        System.out.println("low:"+arr[low]);
        System.out.println("temp:"+temp);
        System.out.println();
        arr[i] = temp;

        //递归调用左半数组

        quickSort(arr, low, j-1);

        //递归调用右半数组

        quickSort(arr, j+1, high);

    }
    public static void main(String[] args){

        int[] arr = {6,1,2,7,9,11,4,5,10,8};

        quickSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {

            System.out.print("\t"+arr[i]);
        }
        System.out.println();

    }}
