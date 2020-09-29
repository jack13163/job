package job.jack.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串拼接，字典序最大
 */
public class JoinStr {
    /**
     * @param strs string字符串一维数组 the strings
     * @return string字符串
     */
    public static String minString(String[] strs) {
        // write code here
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            strList.add(strs[i]);
        }

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        return strList.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "de"};
        System.out.println(minString(strs));
    }
}
