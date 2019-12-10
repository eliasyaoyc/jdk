package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午5:01
 */
public interface Future<T> {
    T get();
}
