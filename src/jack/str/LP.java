package jack.str;


/**
 * 最长回文串
 * <p>
 * 动态规划的方法:
 * 对于字符串str，假设dp[i,j]=1表示str[i...j]是回文子串，那个必定存在dp[i+1,j-1]=1。
 * 这样最长回文子串就能分解成一系列子问题，可以利用动态规划求解了。
 * <p>
 * 状态转移方程:
 * 当str[i]=str[j]时，如果str[i+1...j-1]是回文串，则str[i...j]也是回文串；
 * 如果str[i+1...j-1]不是回文串，则str[i...j]不是回文串。
 * <p>
 * 初始状态：
 * dp[i][i]=1
 * dp[i][i+1]=1 if str[i]==str[i+1]
 * 上式的意义是单个字符，两个相同字符都是回文串。
 */
public class LP {
    public static int getLongestPalindrome(String A, int n) {
        // 利用动态规划计算最长回文子串
        boolean[][] dp = new boolean[n][n];
        int longest = 1;

        // 初始化，长度为1和2的字符串
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i < n - 1 && A.charAt(i) == A.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    longest = 2;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // 长度为3、4、5...的字符串
        for (int l = 3; l <= n; l++) {
            // s为字符串开始位置
            for (int s = 0; s < n - l + 1; s++) {
                // e为结束位置
                int e = s + l - 1;
                // 当str[i]=str[j]时，如果str[i+1...j-1]是回文串，则str[i...j]也是回文串；
                if (A.charAt(s) == A.charAt(e) && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                    longest = l;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        String str = "cbc";
        int n = str.length();
        System.out.println(getLongestPalindrome(str, n));
    }
}
