package yaojdk.juc.executor;

import java.util.concurrent.*;

/**
 * @Author: lancer.yao
 * @time: 2019/12/10:上午10:36
 */
public class ThreadPoolTest01 {
    public static void main(String[] args) {
        //创建一个线程
        //核心数量为5，最大数量为10，空闲时间为1秒，队列长度为5，拒绝策略打印一句话
        ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(currentThreadName() +",discard task");
            }
        });
        //提交20个任务，注意观察num
        for (int i = 0; i < 20; i++) {
            int num = i;
            threadPool.execute(() -> {
                System.out.println(currentThreadName() + "," + num + "running," + System.currentTimeMillis());
            });
        }
    }

    private static String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
