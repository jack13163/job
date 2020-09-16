package jack.reverse;

public class IntegerReverse {
    /**
     * @param x int整型
     * @return int整型
     */
    public static int reverse(int x) {
        // write code here
        long num = x;
        num = Math.abs(x);
        int bits = 0;
        // 计算位数
        while (num > 0) {
            num = num / 10;
            bits++;
        }
        // 生成新数字
        long sum = 0;
        num = Math.abs(x);
        for (int i = 0; i < bits; i++) {
            sum += getNum(num, i + 1) * Math.pow(10, bits - i - 1);
        }
        if (x < 0) {
            return -(int) sum;
        }
        return (int) sum;
    }

    // 获取数字的某一位
    public static int getNum(long num, int bit) {
        return (int) (num / Math.pow(10, bit - 1) % 10);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
}
