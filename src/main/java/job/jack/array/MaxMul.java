package job.jack.array;


import java.util.Arrays;

/**
 * 三个数的最大乘积
 */
public class MaxMul {
    /**
     * 最大乘积
     * @param A int整型一维数组
     * @return long长整型
     */
    public static long solve (int[] A) {
        // 有两种情况：1.两个负数，一个整数；2.三个正数
        Arrays.sort(A);
        // 1.两个负数，一个正数；
        long num1 = (long)A[0] * A[1] * A[A.length - 1];
        // 2.三个正数
        long num2 = (long)A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        return Math.max(num1, num2);
    }

    public static void main(String[] args) {
        int[] arr = {3472, 7789, 7955, -7098, -9281, 6101, 5051, 7778, 3090, 7423, -7151, 5652, 1595, -8094, 677, -8324, 8347, -2482, 9313, -9338, -3157, 8559, 6945, 3618, 3087, 121, -8468, 3225, 1356, 6939, 2799, -7231, -6309, -5453, 633, -8689, -4776, 2714, -2743, -1409, 5918, -3333, 1803, 8330, -2206, -6117, -4486, -7903, -4375, -3739, 2897, 8056, -5864, -522, 7451, -4541, -2813, 5790, -532, -6517, 925};
        System.out.println(solve(arr));
    }
}
