package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午4:54
 */
public class DiscardRejectPolicy implements MyRejectPolicy{
    @Override
    public void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor) {
        System.out.println("discard one task");
    }
}
