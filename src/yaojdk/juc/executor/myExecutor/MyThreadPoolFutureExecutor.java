package yaojdk.juc.executor.myExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午5:04
 */
public class MyThreadPoolFutureExecutor extends MyThreadPoolExecutor implements MyFutureExecutor, Executor {

    public MyThreadPoolFutureExecutor(String name, int coreSize, int maxSize, BlockingQueue<Runnable> taskQueue, MyRejectPolicy rejectPolicy) {
        super(name, coreSize, maxSize, taskQueue, rejectPolicy);
    }

    @Override
    public <T> Future<T> submit(Callable<T> command) {
        return null;
    }
}
