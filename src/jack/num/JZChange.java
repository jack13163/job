package jack.num;


public class JZChange {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public static String solve (int M, int N) {
        // write code here
        int tmp = Math.abs(M);
        StringBuilder res = new StringBuilder();
        while(tmp != 0){
            int y = tmp % N;
            tmp = tmp / N;
            res.append(getChar(y));
        }

        String result = "";
        if(M < 0){
            result += "-";
        }
        result += res.reverse().toString();

        return result;
    }

    public static char getChar(int num) {
        if(num >= 0 && num <= 9){
            return (char)('0' + num);
        } else {
            return (char)('A' + num - 9 - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(7, 2));
    }
}
