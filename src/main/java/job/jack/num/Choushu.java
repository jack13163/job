package job.jack.num;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 丑数
 */
public class Choushu {
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        // 动态规划求解
        int[] dp = new int[index];
        dp[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            final int last = dp[i - 1];
            int[] nums = new int[3];
            nums[0] = dp[t2] * 2;
            nums[1] = dp[t3] * 3;
            nums[2] = dp[t5] * 5;

            for (int j = 0; j < 3; j++) {
                while(nums[j] <= last){
                    if (j == 0) {
                        t2++;
                        nums[0] = dp[t2] * 2;
                    } else if (j == 1) {
                        t3++;
                        nums[1] = dp[t3] * 3;
                    } else {
                        t5++;
                        nums[2] = dp[t5] * 5;
                    }
                }
            }
            dp[i] = IntStream.of(nums).filter(e -> e > last).min().getAsInt();
        }

        return dp[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1500));
    }
}
