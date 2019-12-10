package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午5:02
 */
public interface MyFutureExecutor extends MyExecutor{
    <T> Future<T> submit(Callable<T> command);
}
