package jack.array;


import java.util.*;

public class FindTarget {
    static class Pair {
        Integer key;
        Integer value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {

        // 建立映射关系
        List<Pair> pairs = new ArrayList<>();
        for (int k = 0; k < numbers.length; k++) {
            // <value, ind>
            pairs.add(new Pair(numbers[k], k + 1));
        }
        // 排序
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.key.compareTo(o2.key);
            }
        });

        // 排序
        int i = 0;
        int j = numbers.length - 1;

        // 双指针查找
        while (pairs.get(i).key + pairs.get(j).key != target) {
            if (pairs.get(i).key + pairs.get(j).key < target) {
                i++;
            } else {
                j--;
            }
        }
        if(pairs.get(i).value > pairs.get(j).value) {
            return new int[]{pairs.get(j).value, pairs.get(i).value};
        }else{
            return new int[]{pairs.get(i).value, pairs.get(j).value};
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 75, 25};
        int target = 100;
        int[] res = twoSum(a, target);
        System.out.println(Arrays.toString(res));
    }
}
