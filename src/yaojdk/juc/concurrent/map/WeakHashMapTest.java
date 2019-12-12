package yaojdk.juc.concurrent.map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:22
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new WeakHashMap<>(3);
        //放入3个new String()声明的字符串
        map.put(new String("1"),1);
        map.put(new String("2"),1);
        map.put(new String("3"),1);
        //放入不用new String()声明的字符串
        map.put("6",1);
        //使用key强引用"3"这个字符串
        String key = null;
        for (String s : map.keySet()) {
            if(s.equals("3")){
                key = s;
            }
        }
        //输出{6=6, 1=1, 2=2, 3=3}，未gc所有key都可以打印出来
        System.out.println(map);
        //gc一下
        System.gc();
        //放一个new String()声明的字符串
        map.put(new String("4"),4);
        //输出{4=4, 6=6, 3=3}，gc后放入的值和强引用的key可以打印出来
        System.out.println(map);
        //key与"3"的引用断裂
        key = null;
        //gc
        System.gc();
        //输出{6=6}，gc后强引用的key可以打印出来
        System.out.println(map);
    }
}
