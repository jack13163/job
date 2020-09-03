package jack.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{42, 20, 17, 13, 28, 14, 23, 15};

        for (int i = 0; i < arr.length -1; i++) {
            // 如果一轮下来没有发生一次交换，则说明已经排好序，直接退出[冒泡算法改进]
            boolean flag = false;

            // i为未排序的部分的第一个元素
            for (int j = arr.length -1; j > i; j--) {
                // 从后往前逐个比较，将较小的数向上冒泡
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    flag = true;
                }
            }

            System.out.println(Arrays.toString(arr));

            if(!flag){
                break;
            }
        }
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
