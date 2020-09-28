package job.jack.num;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 组成最大数字
 */
public class MaxNum {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public static String solve(int[] nums) {
        // write code here
        List<String> strList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            strList.add(nums[i] + "");
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (max == 0) {
            return "0";
        }

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 长度越短的越靠前，长度也相同的情况下，应当满足值越大的越靠前。
                if (s1.charAt(0) != s2.charAt(0)) {
                    return s2.charAt(0) - s1.charAt(0);
                } else if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s2.compareTo(s1);
                }
            }
        });

        return strList.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int[] array = new int[]{31, 32, 30, 0, 33, 3, 4, 3};
        System.out.println(solve(array));// 433333231300
    }
}
