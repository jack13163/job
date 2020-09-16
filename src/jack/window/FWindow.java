package jack.window;

import java.util.HashSet;
import java.util.Set;

public class FWindow {
    /**
     * 滑动窗口
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength(int[] arr) {
        // 滑动窗口法，求最大的窗口宽度
        int i = 0, j = 0;
        int width = 0;

        // 定义一个Set，用于减少查询，当set中存在当前数字，则说明当前数字与之前窗口中的某一位数字重复
        Set<Integer> set = new HashSet<>();
        while (i < arr.length && j < arr.length) {
            if (!set.contains(arr[j])) {
                // 窗口向右扩张
                set.add(arr[j]);
                width = Math.max(width, set.size());
                j++;
            } else {
                // 重复
                while (arr[i] != arr[j]) {
                    // 移除
                    set.remove(arr[i]);
                    i++;
                }
                set.remove(arr[i]);
                i++;
            }
        }
        return width;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,4,3};
        System.out.println(maxLength(arr));
    }
}
