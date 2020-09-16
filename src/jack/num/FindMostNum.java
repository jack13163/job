package jack.num;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找数组中出现频率超过一半的数字
 */
public class FindMostNum {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else{
                int tmp = map.get(array[i]) + 1;
                map.put(array[i], tmp);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > len / 2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
