package job.jack.array;

import java.util.ArrayList;

public class TravelArray {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int q = 0;
        int total = (int) Math.ceil(1.0 * Math.min(m, n) / 2.0);
        try {
            // 循环加入每一圈中的元素
            while (q < total) {
                // 每一圈都从[q,q]开始，每一圈元素总个数为num，
                int height = m - 2 * q;
                int width = n - 2 * q;

                // 仅含1行或者1列元素，单独考虑
                if (height == 1 || width == 1) {
                    for (int i = q; i < m - q; i++) {
                        for (int j = q; j < n - q; j++) {
                            result.add(matrix[i][j]);
                        }
                    }
                    return result;
                }

                int num = 2 * width + 2 * (height - 2);
                for (int i = 0; i < num; i++) {
                    int row = 0, col = 0;
                    if (i < width) {// 左上角→右上角
                        // 上
                        row = q;
                        col = q + i;
                    } else if (i < width + height - 1) {// 右上角→右下角
                        // 右
                        col = q + width - 1;
                        row = q + i - width + 1;
                    } else if (i < 2 * width + height - 2) {// 右下角→左下角
                        // 下
                        row = q + height - 1;
                        col = n - q - 2 - (i - (width + height - 1));
                    } else {// 左下角→左上角
                        // 左
                        col = q;
                        row = m - q - 2 - (i - (2 * width + height - 2));
                    }
                    result.add(matrix[row][col]);
                }
                q++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println(spiralOrder(matrix));
    }
}
