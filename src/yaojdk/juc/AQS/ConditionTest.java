package yaojdk.juc.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lancer.yao
 * @time: 2019/12/4:上午11:08
 */
public class ConditionTest {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            //数组满了  则调用notFull.await()来等待同时释放了当前线程的锁；
            while (count == items.length) {
                notFull.await();
            }
            //当线程被唤醒时，将x添加到putptr索引的位置；
            items[putptr] = x;
            //如果当前putptr的位置是最后一个，则下一个索引的位置从0开始；
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            //调用notEmpty.signal();通知其他线程可以从数组中取出数据了。
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            //当count为0时，表示数组是空的，则调用notEmpty.await()来等待同时释放了当前线程的锁；
            while (count == 0) {
                notEmpty.await();
            }
            //当线程被唤醒时，将x添加到takeptr索引的位置；
            Object x = items[takeptr];
            //如果当前takeptr的位置是最后一个，则下一个索引的位置从0开始；
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            //调用notFull.signal();通知其他线程可以向数组中添加数据了。
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new ConditionTest().put(1212);
    }
}
