package jack;

import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scanner = new Scanner(System.in);
        String MN = br.readLine();//scanner.nextLine();
        String[] mn = MN.split(" ");
        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);

        // 槽的个数
        long[] res = new long[n];

        // 编码
        for(int i = 0; i < m; i++){
            String temp = br.readLine();//scanner.nextLine();
            if(temp == null || temp.equals("")){
                break;
            }
            String[] tmp = temp.split(" ");
            int Li = Integer.parseInt(tmp[0]);
            int Ri = Integer.parseInt(tmp[1]);
            // 结果
            for(int j = Li; j <= Ri; j++){
                res[j] = i + 1;
            }
        }

        // 求和
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += res[i] * i;//(0*0 + 3*1 + 2*2 + 1*3 + 0*4)
        }

        long result = sum % 100000009;
        System.out.println(result);
    }
}