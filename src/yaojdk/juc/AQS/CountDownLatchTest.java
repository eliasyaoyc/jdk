package yaojdk.juc.AQS;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: lancer.yao
 * @time: 2019/12/5:下午10:23
 * 计数器
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        System.out.println("in " + Thread.currentThread().getName() + "...");
        System.out.println("before latch.await()...");
        for (int i = 1; i <= 3; i++) {
            new Thread("T" + i) {
                @Override
                public void run() {
                    System.out.println("enter Thread " + getName() + "...");
                    System.out.println("execute countdown...");
                    latch.countDown();
                    System.out.println("exit Thread" + getName() + ".");
                }
            }.start();
        }
        latch.await();
        System.out.println("in " + Thread.currentThread().getName() + "...");
        System.out.println("after latch.await()...");
    }
}
