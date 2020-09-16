package jack.vl;

/**
 * 判断是否为回文数
 */
public class IsHuiWen {
    /**
     *
     * @param x int整型
     * @return bool布尔型
     */
    public static boolean isPalindrome (int x) {
        // write code here
        long num = x;
        // 计算位数
        int ws = 0;
        long tmp = Math.abs(num);
        while(tmp > 0){
            tmp = tmp / 10;
            ws++;
        }
        // 求两边
        int step = 1;
        tmp = Math.abs(num);
        while(step <= ws / 2){
            int left = getNum(tmp,step);
            int right = getNum(tmp,ws - step + 1);
            if(left != right){
                return false;
            }
            step++;
        }
        return true;
    }

    // 获取一个数字的某一位
    public static int getNum(long num, int bit){
        if(bit < 1){
            return -1;
        }
        if(bit == 1){
            return (int)(num % 10);
        }else{
            num = (long)(num / Math.pow(10, bit - 1));
            int res = (int)(num % 10);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
    }
}
