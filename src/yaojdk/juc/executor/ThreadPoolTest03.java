package yaojdk.juc.executor;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: lancer.yao
 * @time: 2019/12/10:下午1:21
 */
public class ThreadPoolTest03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //定时线程池
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        System.out.println("start: " + System.currentTimeMillis());

        //执行一个无返回值任务，5秒后执行，只执行一次
        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("spring: " + System.currentTimeMillis());
            }
        }, 5, TimeUnit.SECONDS);

        //执行一个有返回值任务，5秒后执行，只执行一次
        ScheduledFuture<String> future = scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("inner summer: " + System.currentTimeMillis());
            return "outer summer: ";
        }, 5, TimeUnit.SECONDS);
        //获取返回值
        System.out.println(future.get() + System.currentTimeMillis());

        //固定频率执行一个任务，每2秒执行一次，1秒后执行
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("autumn: " + System.currentTimeMillis());
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
        },1,2,TimeUnit.SECONDS);

        //按固定延迟执行一个任务，每延迟2秒执行一次，1秒执行
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("winter: " + System.currentTimeMillis());
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
        },1,2,TimeUnit.SECONDS);
    }
}
