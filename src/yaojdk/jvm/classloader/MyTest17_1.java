package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午9:50
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/koso/yyichen/");
        Class<?> aClass = loader1.loadClass("yaojdk.jvm.classloader.MySample");
        System.out.println("class: " + aClass.hashCode());
        Object o = aClass.newInstance();
    }
}
