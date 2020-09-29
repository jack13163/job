package job.jack.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有子数组中累加和为k的最长子数组长度
 */
public class LongestArray {
    /**
     * max length of the subarray sum = k
     *
     * @param arr int整型一维数组 the array
     * @param k   int整型 target
     * @return int整型
     */
    public static int maxlenEqualK(int[] arr, int k) {
        // write code here
        int len = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // arr[i + 1, ..., j] = k
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 只记录第一次的位置，因为要求最长数组
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            // 判断是否需要更新len
            if(map.containsKey(sum - k) && i - map.get(sum - k) > len){
                len = i - map.get(sum - k);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 1, 1, 1};
        int target = 0;
        System.out.println(maxlenEqualK(array, target));
    }
}
