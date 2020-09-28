package job.jack.array;

import java.util.Arrays;

/**
 * 将数组中的奇数调整到偶数的前面，并保证奇数子序列和偶数子序列的原序列不变
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {

        int len = array.length;

        // 已经排好序的元素
        int k = 0;

        // 调整奇数到前半部分，偶数到后半部分
        while(k < len){
            // 找奇数
            for(int i = k; i < len; i++){
                if(array[i] % 2 != 0){
                    int target = array[i];
                    // 移动元素
                    for(int j = i; j > k; j--){
                        array[j] = array[j - 1];
                    }
                    array[k] = target;
                    break;
                }
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
