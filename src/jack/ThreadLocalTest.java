package jack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 本地线程测试
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        char s = '\u0639';
        System.out.println(s);

        //ThreadPoolExecutor executor = new ThreadPoolExecutor();
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("b", "B");
        treeMap.put("a", "A");


        List<String> str = new ArrayList<>();
        List<String> strw = new LinkedList<>();
        Integer a = 112;
        a.intValue();


        for (String key : treeMap.keySet()) {
            System.out.println(treeMap.get(key));
        }

        // 100只能被装箱为Integer，不能装箱为Double
        //Double d = 100;
        double t = 100;

        final byte b = 10, c = 11;
        byte res = b + c;

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("jack");
                System.out.println(local.get());
            }
        }).start();

        try {
            Thread.sleep(2000);
            System.out.println("睡眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        }).start();
    }
}
