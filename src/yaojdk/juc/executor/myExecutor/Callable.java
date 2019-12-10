package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午5:00
 */
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
