package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午10:13
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
