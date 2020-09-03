package jack.sort;

import java.util.Arrays;

/**
 * 选择排序算法具体实现
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 7, 8, 3, 1, 2, 4, 6};

        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 如果比较小
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            // 将最小的数放在已排序列表的最后
            swap(arr, i, smallest);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组中两个元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b){
        if(a == b){
            return;
        }
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
    
}
