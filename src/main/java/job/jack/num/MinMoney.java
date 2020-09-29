package job.jack.num;

public class MinMoney {
    /**
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public static int minMoney (int[] arr, int aim) {
        int len = arr.length;
        //dp[i][j]的含义为:在可以任意使用arr[0...i]货币的情况下，组成j所需的最小张数。
        int dp[][] = new int[len][aim + 1];

        // 初始化
        for(int i = 0; i < len; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j <= aim; j++){
            dp[0][j] = Integer.MAX_VALUE;
            if(j-arr[0] >= 0 && dp[0][j-arr[0]] != Integer.MAX_VALUE){
                dp[0][j] = dp[0][j-arr[0]] + 1;// 仅使用一种类型的货币
            }
        }

        // 更新
        for(int i = 1; i < len; i++){
            for(int j = 1; j <= aim; j++){
                if(j - arr[i] >= 0 && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][aim] == Integer.MAX_VALUE ? -1 : dp[len - 1][aim];
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3};
        int target = 20;
        System.out.println(minMoney(arr, target));
    }
}
