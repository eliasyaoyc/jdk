package yaojdk.juc.AQS;

/**
 * @Author: lancer.yao
 * @time: 2019/12/6:下午5:08
 */
public class Test implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 100; i++){

            }
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "执行完毕");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();
        thread.start();
    }
}
