package yaojdk.jvm.classloader;

import java.util.Random;

/**
 * @Author: lancer.yao
 * @time: 2019/12/15:上午11:47
 * 当一个接口在初始化的时，并不要求其父接口都完成了初始化
 * 只有再真正使用到父接口的时候(如引用接口中所定义的常量)，才会初始化
 * class只有加上final才是常量，interface不加也是常量
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
        //当一个类初始化的时候它所实现的接口是不会被初始化的
        System.out.println(MyChildClass5.b);
        //初始化一个接口的时候并不会初始化它的父接口
        System.out.println(MyParent5.thread);
    }
}

interface MyGrandpa{
    public static int a = new Random().nextInt(4);
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}
interface MyParent5 extends MyGrandpa{
    public static int a = new Random().nextInt(4);
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}
interface MyChild5 extends MyParent5 {
    public static final int b = 5;
}
class MyChildClass5 implements MyParent5 {
    public static int b = 5;
}