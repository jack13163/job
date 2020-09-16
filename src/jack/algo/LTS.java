package jack.algo;

import java.util.*;

/**
 * // 动态规划方法，超时
 * 设f(i)表示L中以ai为末元素的最长递增子序列的长度。
 * <p>
 * 在求以ai为末元素的最长递增子序列时，找到所有序号在L前面且小于ai的元素aj，即j<i且aj<ai。
 * <p>
 * 1.如果这样的元素存在，那么对所有aj,都有一个以aj为末元素的最长递增子序列的长度f(j)，
 * 把其中最大的f(j)选出来，那么f(i)就等于最大的f(j)加上1，即以ai为末元素的最长递增子序列，
 * 等于以使f(j)最大的那个aj为末元素的递增子序列最末再加上ai；
 * <p>
 * 2.如果这样的元素不存在，那么ai自身构成一个长度为1的以ai为末元素的递增子序列。
 * <p>
 * <p>
 * // 下面说说贪心+二分的解法
 * <p>
 * 举例说明基本思路，假设数组arr为[2, 3, 1, 2, 3]，vec数组里面存放递增子序列，maxLen数组里存放以元素i结尾的最大递增子序列长度，那么遍历数组arr并执行如下更新规则:
 * <p>
 * 初始情况下，vec为[2]，maxLen[1]
 * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[2,3]，maxLen[1,2]
 * 接下来遇到1，由于vec最后的元素大于1, 我们在vec中查找大于等于1的第一个元素的下标，并用1替换之，此时vec为[1,3], maxLen[1,2,1]
 * 接下来遇到2，由于vec最后的元素大于2，我们在vec中查找大于等于2的第一个元素的下标，并用2替换之，此时vec为[1,2], maxLen[1,2,1,2]
 * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[1,2,3]，maxLen为[1,2,1,2,3]
 * 此时vec的大小就是整个序列中最长递增子序列的长度（但是vec不一定是本题的最终解）
 * <p>
 * 对于第二步，假设我们原始数组是arr1，得到的maxLen为[1,2,3,1,3]，最终输出结果为res（字典序最小的最长递增子序列），
 * res的最后一个元素在arr1中位置无庸置疑是maxLen[i]==3对应的下标，那么到底是arr1[2]还是arr1[4]呢？
 * 如果是arr1[2]，那么arr1[2]<arr1[4]，则maxLen[4]==4，与已知条件相悖。因此我们应该取arr1[4]放在res的最后一个位置。
 */
public class LTS {

    /**
     * 最长递增子序列
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // temp存放结果为递增子序列，由于贪心算法求的是一个解，不保证最后的结果符合字典序要求
        int[] temp = new int[arr.length];
        int[] maxLen = new int[arr.length];
        maxLen[0] = 1;
        temp[0] = arr[0];
        int k = 1;// k为递增子序列的长度
        for (int i = 1; i < arr.length; i++) {
            // arr[i]与temp中的最后一个元素对比
            if (arr[i] > temp[k - 1]) {
                // 若arr[i]大于temp中的最后一个元素，则将其加入递增序列
                temp[k] = arr[i];
                k++;// 递增子序列的长度增加1
                maxLen[i] = k;
            } else {
                // 否则，使用二分法找到temp中第一个大于当前值的元素，并进行替换
                int left = 0;
                int right = k - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (temp[mid] >= arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                temp[left] = arr[i];
                maxLen[i] = left + 1;// 记录当前元素结尾的最大递增子序列的长度
            }
        }

        // 获取结果
        int[] result = new int[k];
        for (int i = maxLen.length - 1; i >= 0 && k >= 0; i--) {
            if (maxLen[i] == k) {
                result[k - 1] = arr[i];
                k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 3};
        System.out.println(Arrays.toString(LIS(arr)));
    }
}
