package job.jack.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 限时等待
 */
public class ReentrantLockTest5 {
    static class LockJZDemo implements Runnable {
        private Lock lock1;
        private Lock lock2;

        public LockJZDemo(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                // 一个线程在10秒内没有获取锁，那就会返回false
                while(!lock1.tryLock()){
                    // 模拟线程对象持有lock1，但是还需要持有lock2的死锁情况
                    TimeUnit.MICROSECONDS.sleep(1000);
                }
                while (!lock2.tryLock()){
                    TimeUnit.MICROSECONDS.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + "同时获取两个锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Thread thread1 = new Thread(new LockJZDemo(lock1, lock2), "线程A");
        Thread thread2 = new Thread(new LockJZDemo(lock2, lock1), "线程B");
        thread1.start();
        thread2.start();
    }
}
