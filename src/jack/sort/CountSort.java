package jack.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 适合于最大值和最小值的差值不是不是很大的排序。
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 5, 0};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序
     * @param arr
     */
    private static void countSort(int[] arr) {

    }

    /**
     * 交换数组中两个元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}
