package job.jack.str;

/**
 * 字符串模式匹配算法
 */
public class KMP {
    public static void main(String[] args) {
        String target = "dlfkjaariewhjdcriewhjdabasriewhjdldabxbariewhjdfkjdsuababariewhjdf";
        String pattern = "ababa";

        int res = search(target, pattern);
        if(target.indexOf(pattern) == res){
            System.out.println(res);
        }
    }

    /**
     * KMP算法
     *
     * @param target
     * @param pattern
     * @return
     */
    public static int search(String target, String pattern) {
        int i = 0;
        int j = 0;
        int[] next = next(pattern);

        while (i < target.length()) {
            if (j == pattern.length()) {
                return i - j;
            } else if (target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                j = next[j] + 1;
            }
        }
        return -1;
    }

    /**
     * 计算next数组
     *
     * @param pattern
     * @return
     */
    public static int[] next(String pattern) {
        int len = pattern.length();
        int[] result = new int[len];
        result[0] = -1;

        int left = -1;
        int right = 0;
        while (right < len - 1) {
            if (left == -1 || pattern.charAt(left) == pattern.charAt(right)) {
                result[right + 1] = left + 1;
                right++;
                left++;
            } else {
                left = result[left];
            }
        }


        return result;
    }
}
