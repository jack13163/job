package job.jack.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 */
public class SelectSort {
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
        for (int i = 0; i < ints.length; i++) {
            int ind = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[ind]) {
                    ind = j;
                }
            }
            // 加入到结果中
            swap(ints, i, ind);
        }
        // Collections.sort(data);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < ints.length; i++) {
            result.add(ints[i]);
        }
        return result;
    }

    /**
     * 交换
     *
     * @param array
     * @param s
     * @param e
     */
    public static void swap(int[] array, int s, int e) {
        if (s == e) {
            return;
        }
        array[s] ^= array[e];
        array[e] ^= array[s];
        array[s] ^= array[e];
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 45, 23, 6, 38, 98, 54);
        System.out.println(insertSort(list));

        // write code here
        String[] num = {"n:10", "m:94"};
        int m = 0;
        int n = 0;
        for (int i = 0; i < 2; i++) {
            if (num[i].split(":")[0].equals("m")) {
                m = Integer.parseInt(num[i].split(":")[1]);
            } else {
                n = Integer.parseInt(num[i].split(":")[1]);
            }
        }
        int y = (m - 4 * n) / 6;
        int x = n - y;

        System.out.println("taxi:" + x + ",bus:" + y);
    }
}
