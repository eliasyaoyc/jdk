package yaojdk.juc.executor.myExecutor;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lancer.yao
 * @time: 2019/12/9:下午4:32
 * 1.当线程池中线程数未达到核心线程数coreSize时，来一个任务加一个线程是可以的，也可以提高任务执行的效率。
 * 2.当线程池中线程数达到核心线程数后，得控制一下线程的数量，来任务了先进队列，如果任务执行足够快，这些核心线程很快就能把队列中的任务执行完毕，完全没有新增线程的必要。
 * 3.当队列中任务也满了，这时候光靠核心线程就无法及时处理任务了，所以这时候就需要增加新的线程了，但是线程也不能无限制地增加，所以需要控制其最大线程数量maxSize。
 * 4.其次，我们需要一个任务队列来存放任务，这个队列必须是线程安全的，我们一般使用BlockingQueue阻塞队列来充当，当然使用ConcurrentLinkedQueue也是可以的（注意ConcurrentLinkedQueue不是阻塞队列，不能运用在jdk的线程池中）。
 * 5.最后，当任务越来越多而线程处理却不及时，迟早会达到一种状态，队列满了，线程数也达到最大线程数了，这时候怎么办呢？这时候就需要走拒绝策略了，也就是这些无法及时处理的任务怎么办的一种策略，常用的策略有丢弃当前任务、丢弃最老的任务、调用者自己处理、抛出异常等。
 * 根据上面的描述，我们定义一个线程池一共需要这么四个变量：核心线程数coreSize、最大线程数maxSize、阻塞队列BlockingQueue、拒绝策略RejectPolicy。
 */
public class MyThreadPoolExecutor implements MyExecutor {
    //线程池名字
    private String name;
    //线程序列号
    private AtomicInteger sequence = new AtomicInteger(0);
    //核心线程数
    private int coreSize;
    //最大线程数
    private int maxSize;
    //任务队列
    private BlockingQueue<Runnable> taskQueue;
    //拒绝策略
    private MyRejectPolicy rejectPolicy;
    //当前正在运行的线程数 需要修改时线程立即感知
    private AtomicInteger runningCount = new AtomicInteger(0);

    public MyThreadPoolExecutor(String name, int coreSize, int maxSize, BlockingQueue<Runnable> taskQueue, MyRejectPolicy rejectPolicy) {
        this.name = name;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.rejectPolicy = rejectPolicy;
    }

    @Override
    public void execute(Runnable task) {
        //正在运行的线程数
        int count = runningCount.get();
        //如果正在运行的线程数小于核心线程数，直接加一个线程
        if (count < coreSize) {
            //这里不一定添加成功，addWorker方法里面还要判断依次是不是确实小
            if (addWorker(task, true)) {
                return;
            }
            //如果添加核心线程数失败，进入下面的逻辑
        }
        //如果达到了核心线程数， 先尝试让任务入队。
        //这里之所有使用offer()，是因为如果队列满了offer()会立即返回false
        if (taskQueue.offer(task)) {

        } else {
            //入队失败，队列满了，添加一个非核心线程
            if (!addWorker(task, false)) {
                rejectPolicy.reject(task, this);
            }
        }
    }

    private boolean addWorker(Runnable newTask, boolean core) {
        //自旋判断是不是真的可以创建一个线程
        for(;;){
            //正在运行的线程数
            int count = runningCount.get();
            //核心线程还是非核心线程
            int max = core ? coreSize : maxSize;
            //不满足创建线程的条件，直接返回false
            if(count >= max){
                return false;
            }
            //修改runningCount成功，可以创建线程
            if(runningCount.compareAndSet(count,count + 1)){
                //线程的名字
                String threadName = (core?"core_":"") + name + sequence.incrementAndGet();
                //创建线程并启动
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("thread name" + Thread.currentThread().getName());
                        //运行的任务
                        Runnable task = newTask;
                        while (task != null || (task = getTask()) != null){
                            try {
                                //执行任务
                                task.run();
                            } finally {
                                //任务执行完成，置为空
                                task = null;
                            }
                        }
                    }
                },threadName).start();
                break;
            }
        }
        return true;
    }

    private Runnable getTask() {
        try {
            // take()方法会一直阻塞直到取到任务为止
            return taskQueue.take();
        } catch (InterruptedException e) {
            // 线程中断了，返回null可以结束当前线程
            // 当前线程都要结束了，理应要把runningCount的数量减一
            runningCount.decrementAndGet();
            return null;
        }
    }
}
