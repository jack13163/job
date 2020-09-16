package jack.algo;

import java.util.Arrays;

/**
 * 最大乘积
 */
public class MaxMult {
    public static void main(String[] args) {
        // arr=[-2.5，4，0，3，0.5，8，-1]，子数组[3，0.5，8]累乘可以获得最大的乘积12，所以返回12。
        //题解 讨论 通过的代码笔记 纠错 收藏
        double[] arr = new double[]{0.1,0.0,3.0,-2.0,0.9,-1.3,5.0,-4.4};
        double result = maxProduct(arr);
        System.out.println(result);
    }

    public static double maxProduct(double[] arr) {
        double[] max = Arrays.copyOf(arr, arr.length);
        double[] min = Arrays.copyOf(arr, arr.length);
        double[] r = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;

            max[i] = Math.max(r[i], Math.max(max[j] * r[i], min[j] * r[i]));//min[j] * min[i];
            min[i] = Math.min(r[i], Math.min(max[j] * r[i], min[j] * r[i]));//min[j] * min[i];
            r[i] = Math.max(r[i], Math.max(max[j] * r[i], min[j] * r[i]));
        }
        return Arrays.stream(r).max().getAsDouble();
    }
}
