package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午9:40
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> aClass = loader1.loadClass("yaojdk.jvm.classloader.MySample");
        System.out.println("class: " + aClass.hashCode());
        //如果注释掉该行，并不会实例化MySample对象，即MySample构造方法不会被调用 因此不会实例化MyCat对象，
        //即没有对MyCat进行主动使用，这里就不会加载MyCat class(类加载器并不需要等到某个类首次主动使用时在加载它 jvm会预先加载一些类。)
//        Object o = aClass.newInstance();
    }
}
