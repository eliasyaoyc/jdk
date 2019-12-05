package yaojdk.juc.JMM;

/**
 * @Author: lancer.yao
 * @time: 2019/12/5:上午9:49
 */
public class VolatileTest {
    int a = 1;
    volatile int b = 2;

    public static void main(String[] args) {
        while (true) {
            VolatileTest test = new VolatileTest();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                test.print();
            }).start();
        }
    }

    private void print() {
        System.out.println("b = " + b + ";a = " + a);
        if(a == 1 && b == 3){
            System.out.println("error");
            return;
        }
    }

    private void change() {
        a = 3;
        b = a;
    }
}
