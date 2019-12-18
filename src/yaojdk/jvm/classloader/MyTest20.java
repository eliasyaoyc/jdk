package yaojdk.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午10:27
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> aClass = loader1.loadClass("yaojdk.jvm.classloader.MyPerson");
        Class<?> aClass1 = loader2.loadClass("yaojdk.jvm.classloader.MyPerson");
        System.out.println(aClass == aClass1);
        Object o = aClass.newInstance();
        Object o1 = aClass1.newInstance();
        Method method = aClass.getMethod("setMyPerson", Object.class);
        method.invoke(o, o1);
    }
}
