package job.jack.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现公平锁：谁先到，谁先获得锁
 */
public class ReentrantLockTest2 {
    private static Lock lock = new ReentrantLock(true);// 公平锁

    public static void main(String[] args) {
        new Thread(()->test(), "线程D").start();
        new Thread(()->test(), "线程A").start();
        new Thread(()->test(), "线程B").start();
        new Thread(()->test(), "线程C").start();
        new Thread(()->test(), "线程E").start();
        new Thread(()->test(), "线程F").start();
    }

    public static void test(){
        for (int i = 0; i < 5; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            try {
                // 模拟耗时操作
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        }
    }
}
