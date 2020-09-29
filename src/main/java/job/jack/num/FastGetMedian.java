package job.jack.num;

import java.util.*;

/**
 * 在O(1)时间内获取数据的中位数
 */
public class FastGetMedian {
    // 定义最大堆和最小堆
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 父节点的值小于或等于子节点的值；

    // 插入元素到两个堆中【关键：保证最大堆中元素始终小于最小堆中的元素】
    public static void addToHeap(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        // 待插入的值比大根堆中最大的值小，因此需要插入到大根堆中
        if (maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            // 待插入的值比小根堆中最小的值小，因此需要插入到大根堆中
            if (minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    // 维持两个堆的高度差不超过1
    private static void modifyTwoHeapsSize() {
        while (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    // 从两个堆中获取中位数
    public static double getMedianFromHeap() {
        // 堆中元素为空时，返回-1
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return -1;
        }
        // 计算中位数
        Integer maxHeapHead = maxHeap.peek();
        Integer minHeapHead = minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2.0;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
    }

    /**
     * the medians
     *
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public static double[] flowmedian(int[][] operations) {
        // write code here
        int rows = operations.length;
        List<Double> result = new ArrayList<>();

        // 执行操作
        for (int i = 0; i < rows; i++) {
            if (operations[i][0] == 1) {
                int num = operations[i][1];
                addToHeap(num);
            } else {
                double res = getMedianFromHeap();
                result.add(res);
            }
        }

        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        // [[1,5],[2],[1,3],[2],[1,6],[2],[1,7],[2]]
        // [5,4,5,5.5]
        int[][] operations = new int[][]{
                {1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}
                //{2},{1,1},{2}
        };
        System.out.println(Arrays.toString(flowmedian(operations)));
    }
}
