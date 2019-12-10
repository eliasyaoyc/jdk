package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午4:40
 */
public interface MyRejectPolicy {
    void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}
