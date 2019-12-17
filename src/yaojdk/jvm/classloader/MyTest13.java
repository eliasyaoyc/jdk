package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/16:下午9:38
 */

public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null){
            classLoader  = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
