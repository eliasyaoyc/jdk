package yaojdk.jvm.classloader;

import javax.sound.midi.Soundbank;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午10:16
 */
public class MyTest18_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/koso/yyichen/");
        Class<?> aClass = loader1.loadClass("yaojdk.jvm.classloader.MyTest1");
        System.out.println("class: " + aClass.hashCode());
        System.out.println("class loader: " + aClass.getClassLoader());
    }
}
