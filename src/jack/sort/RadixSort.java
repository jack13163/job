package jack.sort;

import java.util.Arrays;

/**
 * 基数排序(radix sort)又称桶排序（bucket sort）
 * 一种分配式排序，即通过将所有数字分配到应在的位置最后再覆盖到原数组完成排序的过程。
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     * 将所有待比较数值（自然数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。
     * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     * @param arr
     */
    private static void radixSort(int[] arr) {

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
