package yaojdk.juc.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lancer.yao
 * @time: 2019/12/4:上午11:06
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        //测试公平锁
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
