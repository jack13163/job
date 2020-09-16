package jack.map;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        /**
         * HashMap
         * LinkedHashMap
         * TreeMap
         */
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>(10, 0.75f, true);
        Map<Integer, String> map3 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 10; i >= 0; i--) {
            map1.put("key: " + i, "value: " + i);
            map2.put("key: " + i, "value: " + i);
            map3.put(i, "value: " + i);
        }

        System.out.println("--------------------------");
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("--------------------------");
//        map2.remove("key: " + 8);
//        map2.put("key: " + 8, "value: " + 8);
        map2.get("key: " + 8);
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("--------------------------");
        for (Map.Entry<Integer, String> entry : map3.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
