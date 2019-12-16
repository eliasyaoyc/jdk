package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/16:上午10:08
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());

        Class<?> aClass1 = Class.forName("yaojdk.jvm.classloader.C");
        System.out.println(aClass1.getClassLoader());
    }
}
class C{

}
