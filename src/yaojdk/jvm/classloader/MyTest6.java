package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/15:下午5:05
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1 " + Singleton.counter1);
        System.out.println("counter2 " + Singleton.counter2);
    }
}
class Singleton{
    public static int counter1;
    private static Singleton singleton = new Singleton();
    public Singleton() {
        counter1++;
        counter2++;
    }
    public static int counter2 = 0;
    public static Singleton getInstance(){
        return singleton;
    }
}
