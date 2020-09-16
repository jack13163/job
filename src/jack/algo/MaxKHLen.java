package jack.algo;

import java.util.Arrays;

/**
 * 最大括号长度
 */
public class MaxKHLen {
    public static void main(String[] args) {
        int res = longestValidParentheses("(()");
        System.out.println(res);
    }

    public static int longestValidParentheses (String s) {
        if(s.length() <= 0){
            return 0;
        }
        // write code here
        int[] d = new int[s.length()];
        for(int i = s.length() - 2; i >= 0; i--){
            int end = i + 1 + d[i + 1];
            if(s.charAt(i) == '(' && end < d.length && s.charAt(end) == ')'){
                d[i] = d[i + 1] + 2;
                if(end + 1 < d.length) {
                    d[i] += d[end + 1];
                }
            }
            System.out.println(Arrays.toString(d));
        }
        return Arrays.stream(d).max().getAsInt();
    }
}
