package jack.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LListToArray {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(0).add(3);
        lists.get(1).add(4);
        lists.get(1).add(5);
        lists.get(1).add(6);

        System.out.println(Arrays.toString(listToArray(lists)));
    }

    // 将列表转化为二维数组
    public static int[][] listToArray (List<List<Integer>> list){
        if(list == null || list.size() == 0){
            return null;
        }
        int[][] res = new int[list.size()][list.get(0).size()];
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
}
