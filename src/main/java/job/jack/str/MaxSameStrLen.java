package job.jack.str;

/**
 * 最长公共前缀
 */
public class MaxSameStrLen {
    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int count = 0;
        try {
            for (int j = 0; j < strs[0].length(); j++) {
                boolean flag = false;
                for (int i = 1; i < strs.length; i++) {
                    if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    count++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return strs[0].substring(0, count);
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "abc", "abc"};
        System.out.println(longestCommonPrefix(strs));
    }
}
