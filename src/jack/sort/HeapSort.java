package jack.sort;


import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{42, 20, 17, 13, 28, 14, 23, 15};
        int len = arr.length;
        // 创建大顶堆
        buildHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            // 将大顶堆的根节点放在最后一个未排序的数组的后面
            swap(arr, 0, i);
            len--;// 前面0-len为未排序的数组
            heapy(arr, len, 0);// 从根节点开始，继续维护大顶堆
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 创建大顶堆
     * @param arr
     * @param length
     */
    private static void buildHeap(int[] arr, int length) {
        // 从倒数第二层的非叶子节点开始遍历产生大顶堆
        for (int i = (int)Math.floor(length / 2); i >= 0; i--) {
            heapy(arr, length, i);
        }
    }

    /**
     * 维护父亲节点始终大于两个孩子
     * 所有情况：
     * 1.没有孩子大于父亲节点，则不移动
     * 2.有一个孩子大于父亲节点，交换该孩子和父亲节点的位置
     * 3.两个孩子均大于父亲节点，交换最大的孩子与父亲节点的位置
     * @param arr
     * @param len 比较区域数组的长度
     * @param parent
     */
    private static void heapy(int[] arr, int len, int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;

        // 如果左孩子存在，且大于父亲，则交换
        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }

        // 如果右孩子存在，且大于父亲，则交换
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }

        // 如发生了交换，则对应的子分支都需要调整
        if(largest != parent){
            swap(arr, largest, parent);
            heapy(arr, len, largest);
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
