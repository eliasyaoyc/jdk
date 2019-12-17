package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/17:上午9:09
 * 数组类型的不是由类加载器加载的，是由jvm运行期间动态生成的
 * 数组的类加载器和里面元素的类加载器一样。如果元素是原生类型的，那么是没有类加载器的
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader()); //这个null代表的是bootstrap加载器
        System.out.println("-----------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("-----------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
