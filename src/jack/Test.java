package jack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scanner = new Scanner(System.in);
        String MN = br.readLine();//scanner.nextLine();
        String[] mn = MN.split(" ");
        int n = Integer.parseInt(mn[0]);// 规则条数
        int m = Integer.parseInt(mn[1]);// IP个数

        // 读取规则
        List<String> rules = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String temp = br.readLine();//scanner.nextLine();
            temp.replace("*", ".+?");// 准备正则表达式
            rules.add(temp);
        }

        // 读取IP
        for(int i = 0; i < m; i++){
            String temp = br.readLine();//scanner.nextLine();
            // 匹配
            boolean flag = false;
            for(int j = 0; j < n; j++){
                Pattern pattern = Pattern.compile(rules.get(j));
                Matcher match = pattern.matcher(temp);
                if(match.find()){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
        }
    }
}
