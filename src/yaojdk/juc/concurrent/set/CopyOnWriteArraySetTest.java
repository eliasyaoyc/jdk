package yaojdk.juc.concurrent.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:25
 * 底层使用copyOnWriteArrayList(底层是数组 允许元素重复的)存储元素
 * CopyOnWriteArraySet 添加元素的时候使用了addIfAbsent()方法来确保元素不重复
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet set1 = new CopyOnWriteArraySet();
        set1.add(1);
        set1.add(5);
        set1.add(2);
        set1.add(7);
        set1.add(4);

        CopyOnWriteArraySet set2 = new CopyOnWriteArraySet();
        set2.add(1);
        set2.add(5);
        set2.add(2);
        set2.add(7);
        set2.add(4);
        System.out.println(eq(set1,set2));
        System.out.println(eq(set2,set1));
    }
    private static <T> boolean eq(Set<T> set1,Set<T> set2){
        if(set1.size() != set2.size()){
            return false;
        }
        for (T t : set1) {
            if(!set2.contains(t)){
                return false;
            }
        }
        return true;
    }
}
