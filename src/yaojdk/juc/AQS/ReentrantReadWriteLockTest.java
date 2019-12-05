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
//        readLock.unlock();
//        WriteLock writeLock = reentrantReadWriteLock.writeLock();
//        writeLock.lock();
    }
}
