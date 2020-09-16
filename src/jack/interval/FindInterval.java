package jack.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 间隔覆盖
 */
public class FindInterval {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // 首先将区间按照开始时间的升序排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        // 合并重叠区间
        ArrayList<Interval> res = new ArrayList<Interval>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            // 获取前一个区间
            Interval pre = res.get(res.size() - 1);
            // 获取后一个区间
            Interval cur = intervals.get(i);
            // 判断是否需要合并区间
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // [1,3],[2,6],[8,10],[15,18]
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        ArrayList<Interval> res = merge(list);
        res.stream().forEach(interval -> {
            System.out.println(interval.toString());
        });
    }
}
