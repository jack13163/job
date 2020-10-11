package job.jack.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断就是一个线程获取不到锁，不会傻傻的一直等下去，ReentrantLock会给予一个中断回应。
 */
public class ReentrantLockTest4 {
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
                lock1.lockInterruptibly();
                // 模拟线程对象持有lock1，但是还需要持有lock2的死锁情况
                TimeUnit.MICROSECONDS.sleep(1);
                lock2.lockInterruptibly();
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
        try {
            // 3秒后中断线程A，线程B将获取资源并正常结束
            Thread.sleep(3000);
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
