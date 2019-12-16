package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/16:下午1:09
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
class CL{
    static {
        System.out.println("Class CL");
    }
}
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = loader.loadClass("yaojdk.jvm.classloader.CL");
        System.out.println(aClass);
        System.out.println("-------------");
        aClass = Class.forName("yaojdk.jvm.classloader.CL");
        System.out.println(aClass);
    }
}
