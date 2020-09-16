package jack.algo;

import java.util.*;

public class LRU_LinkedHashMap {


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>(k, 0.75f, true);
        List<Integer> list = new ArrayList<>();
        // 思路就是每次判断访问的
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                int key = operators[i][1];
                int value = operators[i][2];
                // 放入缓存
                if(map.size() < k){
                    map.put(key, value);
                }else{
                    // 移除最后使用的
                    Iterator<Integer> iterator = map.keySet().iterator();
                    map.remove(iterator.next());
                    map.put(key,value);
                }
            } else if (operators[i][0] == 2) {
                // 获取结果
                int key = operators[i][1];
                Integer value = map.get(key);
                // 判断结果是否存在
                if (value != null) {
//                    // 移除后重新添加
//                    map.remove(key);
//                    map.put(key, value);
                    list.add(value);
                } else {
                    list.add(-1);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;

        int[] res = LRU(operators, k);
        System.out.println(Arrays.toString(res));
    }
}
