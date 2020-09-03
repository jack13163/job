package jack;

import com.sun.deploy.util.ArrayUtil;

import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int bits = Integer.parseInt(in.nextLine());
//
//        String a = in.nextLi  ne();
//        String b = in.nextLine();
//
//        // 1.a串和b串中1的个数首先需要一致
//        int s1 = 0;
//        int s2 = 0;
//        int diff1 = 0;
//        int diff2 = 0;
//        int same = 0;
//        for(int i = 0; i < bits; i++){
//            if(a.charAt(i) == '1'){
//                s1++;
//            }
//            if(b.charAt(i) == '1'){
//                s2++;
//            }
//            if(a.charAt(i) == '1' && b.charAt(i) == '1'){
//                same++;
//            }
//            if(a.charAt(i) == '1' && b.charAt(i) == '0'){
//                diff1++;
//            }
//            if(a.charAt(i) == '0' && b.charAt(i) == '1'){
//                diff2++;
//            }
//        }
//        int n1 = Math.abs(s1 - s2);
//        int nmax = Math.max(s1, s2);
//
//        // 2.位置变动
//        int result = nmax - same - n1;
//        System.out.println(result);
//    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] input = in.nextLine().split(" ");
//
//        String num = input[0];// 待排列组合的数字
//        String div = input[1];// 除数

        // 1.字符串的全排列
        List<Integer[]> strList = new ArrayList<>();

        int[] testArray = new int[]{3, 2 ,5, 8};
        perm(testArray, 0, 4, strList);
        strList.stream().forEach(integers -> {
            for (int i = 0; i < integers.length; i++) {
                System.out.print(integers[i] + " ");
            }
            System.out.println();
        });

        // 2.位置变动
        int result = 0;
        System.out.println(result);
    }

    /**
     * 分治法排列
     * @param args
     * @param m
     * @param n
     * @return
     */
    public static void perm (int[] args, int m, int n, List<Integer[]> strList) {
        if (m == n){
            Integer[] res = new Integer[args.length];
            for (int i = 0; i < args.length; i++) {
                res[i] = args[i];
            }
            strList.add(res);
        } else {
            for (int i = m; i < n; i++) {
                int temp = args[m];
                args[m] = args[i];
                args[i] = temp;

                perm(args, m + 1, n, strList);

                temp = args[m];
                args[m] = args[i];
                args[i] = temp;
            }
        }
    }
}