package job.jack.str;

import java.io.*;
import java.util.Scanner;

/**
 * 输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
 */
public class ReadFileAndFindStr {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件名：");
        String filepath = scanner.nextLine();
        System.out.println("请输入需要寻找的字符串：");
        String target = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        int count = 0;
        String line;
        while((line = reader.readLine()) != null){
            int oldLen = line.length();
            line = line.replaceAll(target, "");
            int newLen = line.length();
            count += (oldLen - newLen) / target.length();
        }
        System.out.println(target + "出现的次数为：" + count);
    }
}
