package jack.num;

import java.util.Arrays;

/**
 * 求递增个数
 */
public class Increment {

    public static int MLS (int[] arr) {
        // 排序
        Arrays.sort(arr);

        // 利用动态规划计算最大长度
        int len = arr.length;
        int max = 1;
        int maxLen = 0;
        for(int i = 1; i < len; i++){

            // 判断是否是连续递增
            if(arr[i] == arr[i - 1] + 1){
                max += 1;
            }else{
                max = 1;
            }
            if(max > maxLen){
                maxLen = max;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,4,200,1,3,2};
        System.out.println(MLS(arr));
    }
}
