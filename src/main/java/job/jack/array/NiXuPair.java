package job.jack.array;

import java.util.Arrays;

/**
 * 数组中逆序对的个数
 */
public class NiXuPair {

    private static int count = 0;

    public static int InversePairs(int[] array) {
        // 借助于归并排序实现
        int len = array.length;
        split(array, 0, len - 1);
        return count;
    }

    /**
     * 归并排序之分解
     *
     * @param array
     * @param start
     * @param end
     */
    public static void split(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        split(array, start, mid);
        split(array, mid + 1, end);
        merge(array, start, end, mid);
    }

    /**
     * 归并排序之合并
     *
     * @param array
     * @param start
     * @param end
     * @param mid
     */
    public static void merge(int[] array, int start, int end, int mid) {

        // 辅助数组
        int[] tmp = new int[end - start + 1];
        // 将左右两边的元素复制到新建立的辅助数组中
        int k = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                tmp[k] = array[left];
                left++;
            } else {
                tmp[k] = array[right];
                right++;
                count += mid - left + 1;
            }
            k++;
        }
        // 将剩余的元素复制到临时数组中
        while (left <= mid) {
            tmp[k] = array[left];
            left++;
            k++;
        }
        while (right <= end) {
            tmp[k] = array[right];
            right++;
            k++;
        }

        // 将临时数组中的元素复制到原数组
        for (int i = start; i <= end; i++) {
            array[i] = tmp[i - start];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(array));
        System.out.println(Arrays.toString(array));
    }
}
