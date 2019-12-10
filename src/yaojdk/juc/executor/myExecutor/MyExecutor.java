package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午4:38
 */
public interface MyExecutor {
    void execute(Runnable command);
}
