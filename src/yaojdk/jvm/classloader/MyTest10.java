package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/16:下午12:57
 */
class Parent2{
    static int a = 3;
    static {
        System.out.println("Parent static block");
    }
}
class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}
public class MyTest10 {
    static {
        System.out.println("MyTest static block");
    }

    public static void main(String[] args) {
        //只是声明parent2的引用 不是主动使用
        Parent2 parent2;
        System.out.println("----------");
        //new对象是对parent2的主动使用
        parent2 = new Parent2();
        System.out.println("----------");
        System.out.println(parent2.a);
        System.out.println("----------");
        System.out.println(Child2.b);
    }
}
