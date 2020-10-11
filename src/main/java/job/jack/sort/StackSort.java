package job.jack.sort;

import java.util.*;

public class StackSort {
    /**
     * 栈排序
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public static int[] solve(int[] a) {
        // 要让字典序最大就要让大的数尽量先出栈。
        // 用一个数组rmax[i]表示第 i 项到第 n 项的数的最大值。
        // 如果栈顶元索大于第i项到第n项的最大值，那么直接让这个元索出栈，让大的先出栈总能保证字典序最大。
        // 如果栈顶元素小于第 i 项到第 n 项的最大值，那就让该元素入栈，等着后面更大的元素。
        // 如果最后所有元素都已经入栈了，记得还要输出栈内剩余的元素。
        int len = a.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2)-> i2 - i1);
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            queue.add(a[i]);
        }

        int loc = 0;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // 每次入站前查找下后面的有没有比它更大的，有点的话就入栈，没有就话就不要入栈了，这样字典序才时最大的。
            if (queue.peek() == a[i]) {
                result[loc++] = a[i];
                queue.poll();
            } else {
                stack.push(a[i]);
            }
        }

        while (!stack.isEmpty()) {
            result[loc] = stack.pop();
            loc++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,8,9,6,7,1,3,2,4};
        int[] b = solve(a);
        System.out.println(Arrays.toString(b));
    }
}
