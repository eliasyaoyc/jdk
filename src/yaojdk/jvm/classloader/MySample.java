package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午9:39
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is load by: " + this.getClass().getClassLoader());
        new MyCat();
    }
}
