package month5;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-17 09:13
 **/
public class TestMs {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j =0;j<n;j++){
                int temp =matrix[i][j];
                matrix[i][j] =matrix [n-i-1][j];
                matrix[n-i-1][j]=temp;


            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp =matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }

}
