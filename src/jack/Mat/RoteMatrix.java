package jack.Mat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 矩阵旋转
 */
public class RoteMatrix {
    public static int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        //
        return mat;
    }


    public static void swap(int[][] mat, int i, int j, int m, int n){
        int temp = mat[m][n];
        mat[m][n] = mat[i][j];
        mat[i][j] = temp;
    }

    public static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                if(j == a[i].length - 1){
                    System.out.println();
                }else{
                    System.out.print(",");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * a.length + j;
            }
        }

        print(a);

        int[][] b = new int[3][3];
        // 行列互换
        int l = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][l] = a[i][j];
            }
            l--;
        }

        print(b);
    }
}
