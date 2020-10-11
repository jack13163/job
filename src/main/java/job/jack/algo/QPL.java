package job.jack.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class QPL {

    private static List<List<Character>> res = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";
        perm(str.toCharArray(), 0, str.length() - 1);
        System.out.println(res);
    }

    /**
     * 组合
     * @param chars
     * @param s
     * @param e
     */
    private static void perm(char[] chars, int s, int e) {
        if(s == e){
            List<Character> chs = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                chs.add(chars[i]);
            }
            res.add(chs);
        }
        for (int i = s; i <= e; i++) {
            swap(chars, s, i);
            perm(chars, s + 1, e);
            swap(chars, s, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
    }
}
