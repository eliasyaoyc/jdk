package yaojdk.jvm.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lancer.yao
 * @time: 2019/12/15:上午11:30
 * 对于数组实例来说，其类型是由jvm在运行期动态生成的
 * 这种形式，动态生成的类型，其父类就是object
 * 助记符：
 * anewarray：表示创建一个引用类型的(如类，接口，数组)数组，并将其引用值压入栈顶
 * newarray：表示创建一个指定原始类型的(如int，float，char等)数组，并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 parent4 = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println("===");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}
class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}