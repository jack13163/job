package job.jack.sort;

import java.util.Arrays;
import java.util.List;

public class StackSort2 {

    public static int[] solve (int[] a) {
        int n = a.length;
        int[] stack=new int[n];
        int[] result = new int[n];
        int loc = 0;
        int[] maxs=new int[n + 1];
        int top = -1;

        //找出i到n中最大的那个值
        int max = Integer.MIN_VALUE;
        for (int i = n-1; i>=0; i--) {
            max=Math.max(max,a[i]);
            maxs[i]=max;
        }

        for (int i = 0; i <n; i++) {
            //入栈
            stack[++top]=a[i];
            //如果当前入栈的值 大于i+1到n之间的最大值 那么出栈
            //maxs[i+1]最后一定为0,所有栈内元素可以全部出栈
            while (top>=0&&stack[top]>maxs[i+1]){
                result[loc++] = stack[top];
                //模拟弹出栈顶,指针下移
                top--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,8,9,6,7,1,3,2,4};
        int[] stack = solve(arr);
        System.out.println(Arrays.toString(stack));
    }
}
