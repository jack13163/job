package job.jack.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->test(), "线程A").start();
        new Thread(()->test(), "线程B").start();
    }

    public static void test(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "获取了锁");
        try {
            // 模拟耗时操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }
}
