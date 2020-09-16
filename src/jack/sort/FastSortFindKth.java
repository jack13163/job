package jack.sort;

/**
 * 利用快排的思想寻找第K大的数
 */
public class FastSortFindKth {
    /**
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * [1,3,5,2,2],5,3
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        return oneSort(a, 0, n - 1, K);
    }

    /**
     * 快速排序
     *
     * @param a
     * @param s
     * @param e
     * @return
     */
    public static int oneSort(int[] a, int s, int e, int K) {

        // write code here
        int dummy = a[s];
        int i = s;
        int j = e;

        while (i < j) {
            // 从后向前搜索，直到找到一个比当前dummy值小的数
            while (i < j && a[j] >= dummy) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
            }
            // 从前向后搜索，直到找到一个比当前dummy值大的数
            while (i < j && a[j] <= dummy) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
            }
        }
        a[i] = dummy;

        // 判断i和K的大小
        if(i == K - 1){
            return a[i];
        }else if(i < K - 1){
            return oneSort(a, i + 1, e, K);
        }else{
            return oneSort(a, s, i - 1, K);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 2, 2};
        System.out.println(findKth(a, 5, 3));
    }
}
