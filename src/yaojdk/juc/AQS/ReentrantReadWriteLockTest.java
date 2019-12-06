package yaojdk.juc.AQS;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.*;

/**
 * @Author: lancer.yao
 * @time: 2019/12/4:上午11:08
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
            }
        });
        thread.start();
        readLock.unlock();
        //读锁的实现原理和reentrantLock 一样  基于独占锁
        WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        writeLock.unlock();
    }
}
