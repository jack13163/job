package jack.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 3, 1, 2, 4, 6};
        int grap = arr.length / 2;// 初始间隔（组数）
        // 组数
        while (grap >= 1){
            // 对每一个元素进行按组插入排序，从每组的第二个元素开始
            for (int i = grap; i < arr.length; i++) {
                insertSort(arr, grap, i);
                printArray(arr);
            }
            grap = grap / 2;
        }
    }

    /**
     * 插入排序
     * 将arr中的第i个元素按照分组插入到正确的位置
     * @param arr
     * @param grap 步长
     * @param ind
     */
    public static void insertSort(int[] arr, int grap, int ind) {
        int i = ind - grap;// 分组中已经排序的最后一个元素
        int tmp = arr[ind];// 保存当前元素值

        // 类似于牌排序
        while (i >= 0 && arr[i] > arr[ind]){
            // 移动
            arr[i + grap] = arr[i];
            i = i - grap;
        }

        // 将要插入的数据插入到当前位置
        arr[i + grap] = tmp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
