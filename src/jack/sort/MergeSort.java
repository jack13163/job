package jack.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 9, 3, 8, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int L, int R) {
        if(L >= R){
            return;
        }
        // 划分
        int mid = L + ((R - L) >> 1);// 注意必须加括号
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * 合并两个已经排好序的数组【关键在于合并，合并的思想就是通过一个临时数组存放排序结果】
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        // 两个数组逐个对比
        int[] tmp = new int[r - l + 1];
        int i = 0;

        // 从两个数组的起始位置开始查找
        int left = l;
        int right = mid + 1;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                tmp[i] = arr[left];
                left++;
                i++;
            } else {
                tmp[i] = arr[right];
                right++;
                i++;
            }
        }

        // 复制剩余的元素
        while (left <= mid) {
            tmp[i] = arr[left];
            left++;
            i++;
        }
        while (right <= r) {
            tmp[i] = arr[right];
            right++;
            i++;
        }

        // 将排序好的内容复制到原来数组中
        for (int j = 0; j < i; j++) {
            arr[l + j] = tmp[j];
        }
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
