package job.jack.num;

/**
 * 最大解码方式总次数
 */
public class DecodeCount {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve(String nums) {
        // 动态规划
        int len = nums.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        // 初始化
        if (nums.charAt(0) - '0' >= 1 && nums.charAt(0) - '0' <= 9) {
            dp[1] = 1;
        }

        for (int i = 2; i <= len; i++) {
            if(nums.charAt(i - 1) == '0' && nums.charAt(i - 2) == '0'){
                break;
            }
            if(nums.charAt(i - 2) == '0'){
                dp[i] = i > 2 ? dp[i - 2] : 1;
            }else if(nums.charAt(i - 1) == '0') {
                dp[i] = dp[i - 1];
            }else{
                dp[i] = dp[i - 1];
                int tmp = Integer.parseInt(nums.substring(i - 2, i));
                if (tmp >= 10 && tmp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        // 31717126241541717,192
        // 72416145196211821232022471311148103136128331523141061051992231223,11520000
        System.out.println(solve("72416145196211821232022471311148103136128331523141061051992231223"));
    }
}
