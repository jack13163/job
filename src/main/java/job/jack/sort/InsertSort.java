package job.jack.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param data int整型ArrayList
     * @return int整型ArrayList
     */
    public static ArrayList<Integer> insertSort(List<Integer> data) {
        // 插入排序，已排序列表
        int[] ints = data.stream().mapToInt(Integer::intValue).toArray();
        // 遍历
        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];
            int k = 0;
            while (k <= i) {
                // 确定待插入的位置
                if (ints[k] > temp) {
                    // 移动元素
                    for (int j = i; j > k; j--) {
                        ints[j] = ints[j - 1];
                    }
                    // 填充元素
                    ints[k] = temp;
                    break;
                }
                k++;
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < ints.length; i++) {
            result.add(ints[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 45, 23, 6, 38, 98, 54);
        System.out.println(insertSort(list));
    }
}
