package job.jack.str;

public class ReverserStr {
    // 反转字符串大小写
    public static String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                stringBuilder.append(Character.toLowerCase(str.charAt(i)));
            } else {
                stringBuilder.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        return stringBuilder.toString();
    }


    public static String trans(String s, int n) {
        // write code here
        String[] tmp = s.replace(" ", ",").split(",", -1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            stringBuilder.append(reverse(tmp[i]));
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(trans("h i ", 4));
    }
}
