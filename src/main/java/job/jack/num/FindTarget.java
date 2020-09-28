package job.jack.num;

import java.util.Arrays;

/**
 * 从数组中寻找指定的元素
 */
public class FindTarget {
    public static int[] findElement(int[][] mat, int n, int m, int x) {
        if(mat == null || mat.length == 0 || mat.length != n || mat[0].length != m){
            return null;
        }
        // n为行，m为列
        int total = n * m;
        int left = 0;
        int right = total - 1;
        int mid = -1;
        // 二分查找
        while(get(mat, m, left) < get(mat, m, right)){
            mid = (left + right) / 2;
            if(get(mat, m, mid) == x){
                return new int[]{mid / m, mid % m};
            }else if(get(mat, m, mid) < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return null;
    }

    // 获取第ind个数
    public static int get(int[][] mat, int m, int ind){
        // 确定该数字所在的行
        int row = ind / m;
        // 确定该数字所在的列
        int col = ind % m;
        return mat[row][col];
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
        };
        int n = 6;
        int m = 3;
        int target = 14;
        int[] res = findElement(mat, n, m, target);
        System.out.println(Arrays.toString(res));
    }
}
