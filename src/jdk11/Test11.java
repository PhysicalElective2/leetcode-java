package jdk11;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-11-14 19:16
 **/
public class Test11 {
    public static void main(String[] args) {
        int[] nums =new int[]{1,2,3,3,3,4};
        int key =3;
        System.out.println(commonBinarySearch(nums,key));
    }
    public static int commonBinarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;			//定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }

}
