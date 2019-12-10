package yaojdk.juc.executor.myExecutor;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午5:03
 */
public class FutureTask<T> implements Runnable,Future<T>{
    //真正的任务
    private Callable<T> task;

    public FutureTask(Callable<T> task) {
        this.task = task;
    }

    @Override
    public void run() {

    }

    @Override
    public T get() {
        return null;
    }
}
