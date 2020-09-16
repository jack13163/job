package jack.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 求两数和
 */
public class TwoNumberSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3){
            return new ArrayList<ArrayList<Integer>>();
        }

        // 数组排序
        Arrays.sort(num);

        // 找出所有的组合
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int l = 0; l < num.length; l++){
            int target = num[l];
            // 排除不可能的结果
            if(target > 0){
                break;
            }

            // 去重
            if(l > 0 && num[l] == num[l - 1]){
                continue;
            }

            // 利用双指针法，在剩余数组中寻找和为target的两个数
            int i = l + 1;
            int j = num.length - 1;
            Set<Integer> set = new HashSet<>();
            while(i < j){
                // 找到组合
                if(num[i] + num[j] > -target){
                    j--;
                }else if(num[i] + num[j] < -target){
                    i++;
                }else {
                    // 排重
                    if(set.contains(num[i])) {
                        i++;
                        continue;
                    }
                    set.add(num[i]);

                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(target);
                    list.add(num[i]);
                    list.add(num[j]);
                    res.add(list);
                    i++;
                    j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 1, 1, 2};
        ArrayList<ArrayList<Integer>> res = threeSum(arr);
        res.stream().forEach(list->{
            System.out.println((list.get(0) + ":" + list.get(1) + ":" + list.get(2)));
        });
    }
}
