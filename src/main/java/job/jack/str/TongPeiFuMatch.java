package job.jack.str;

/**
 * 字符串通配符匹配
 */
public class TongPeiFuMatch {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "*";
        isMatch(s1, s2);
    }

    public static boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean dp[][] = new boolean[m + 1][n + 1];

        try {
            // 初始化
            dp[0][0] = true;
            for (int i = 1; i < m; i++) {
                if (p.charAt(i - 1) == '*' && dp[i - 1][0]) {
                    dp[i][0] = true;
                } else {
                    dp[i][0] = false;
                }
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = false;
            }

            // 逐行计算是否匹配
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                    }
                }
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return dp[m][n];
    }
}
