package job.jack.algo;

import java.util.Arrays;

public class Nqueen2 {
    static int res = 0;
    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public static int Nqueen (int n) {
        // write code here
        int[] chess = new int[n];
        for (int i = 0; i < n; i++) {
            chess[i] = -1;
        }
        dfs(chess, 0);
        return res;
    }

    // 逐层摆放皇后，保证不冲突(横竖斜都不冲突)
    public static void dfs(int[] chess, int cur){
        // 找到一个摆放方式
        int len = chess.length;
        if(cur == len){
            res++;
            return;
        }

        // 确定下一个皇后的位置
        for(int i = 0; i < len; i++){
            // 下一次想要将皇后摆放在第cur行第i列
            if (!conflect(chess, cur, i)){
                int[] fcopy = Arrays.copyOf(chess, len);
                fcopy[cur] = i;
                dfs(fcopy, cur + 1);
            }
        }
    }

    // 判断是否冲突
    // m代表想要摆放皇后的行，n代表想要摆放的皇后的列
    // map中的key代表行，value代表列
    public static boolean conflect(int[] chess, int m, int n){
        // 检查斜线方向是否冲突
        for(int i = 0; i <= m; i++){
            // 检查纵向是否冲突
            if(chess[i] == n){
                return true;
            }
            // 检查上升斜线方向是否冲突
            if(i - chess[i] == m - n){
                return true;
            }
            // 检查下降斜线方向是否冲突
            if(i + chess[i] == m + n){
                return true;
            }
        }
        // 默认不冲突
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Nqueen(9));
    }
}
