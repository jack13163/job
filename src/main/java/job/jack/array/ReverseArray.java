package job.jack.array;

import java.util.Arrays;

public class ReverseArray {
    /**
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public static int[] solve (int n, int m, int[] a) {
        int t = n - m % n;
        if(t > 0){
            // 第一步，反转数组的前m个元素和后n-m个元素
            reverse(a, 0, t - 1);
            reverse(a, t, n - 1);
            // 第二步，反转整个数组
            reverse(a, 0, n - 1);
        }
        return a;
    }

    // 旋转数组
    public static void reverse(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        while(left < right){
            swap(a, left++, right--);
        }
    }

    // 数组中指定下标位置的元素互换
    public static void swap(int[] a, int left, int right){
        a[left] ^= a[right];
        a[right] ^= a[left];
        a[left] ^= a[right];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solve(a.length, 7, a)));
    }
}
