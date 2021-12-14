package month8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-31 19:01
 **/
public class PDD2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line=scanner.nextLine();
        int t =Integer.parseInt(line);
        while (t-->0){
            line=scanner.nextLine();
            int n=Integer.parseInt(line.split(" ")[0]);
            int m=Integer.parseInt(line.split(" ")[1]);
            int k=Integer.parseInt(line.split(" ")[2]);
            line=scanner.nextLine();
            int[] num1 =new int[n];
            String[] numsInline=line.split(" ");
            for(int i=0;i<n;i++){
                num1[i]=Integer.parseInt(numsInline[i]);
            }
            line=scanner.nextLine();
            int[] num2 =new int[m];
            numsInline=line.split(" ");
            for(int i=0;i<m;i++){
                num2[i]=Integer.parseInt(numsInline[i]);
            }
            int res=qu1( num1,num2,k);
            System.out.println(res);
        }

    }

    private static int qu1(int[] nums1,int[] nums2,int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res=0;
        int i=0;
        int j=0;
        while (i<nums1.length&&j<nums2.length){
            if(Math.abs(nums1[i]-nums2[j])<=k){
                i++;
                j++;
                res++;
                continue;

            }
            if(nums1[i]<nums2[j]){
                i++;
                continue;
            }
            if(nums2[j]<nums1[i]){
                j++;
            }
        }

        return res;
    }
}
