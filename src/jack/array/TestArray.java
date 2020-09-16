package jack.array;

import java.util.Arrays;

public class TestArray {
    public static void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;

        // 逐个进行比较
        while (j < n) {
            if (m > 0 && i < m + j && A[i] <= B[j]) {
                // 不需要移动，直接将指针向后移动
                i++;
                continue;
            } else {
                // 移动数组A，将B中元素复制到A中
                move(A, i, m + j - i);
                A[i] = B[j];
                i++;
                j++;
            }
        }
    }

    // 将数组中指定下标后面的若干个元素一起向后移动
    public static void move(int A[], int ind, int num) {
        for (int i = ind + num - 1; i >= ind; i--) {
            A[i + 1] = A[i];
        }
    }

    public static void main(String[] args) {
        int A[] = new int[10];
        A[0] = 4;
        A[1] = 5;
        A[2] = 6;
        int m = 3;
        int B[] = {1, 2, 3};
        int n = 3;
        merge(A, m, B, n);

        System.out.println(Arrays.toString(A));
    }
}
