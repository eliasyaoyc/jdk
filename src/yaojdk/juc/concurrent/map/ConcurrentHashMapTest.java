package yaojdk.juc.concurrent.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:22
 * 是hashMap线程安全版本，内部也是使用散列表(数组+链表+红黑树)的结构来存储元素
 */
public class ConcurrentHashMapTest {
    private static final Map<Integer,Integer> map = new ConcurrentHashMap<>();

    //这是不安全的 因为get操作之后if之前可能已经有线程在put这个元素了，这个时候在put就会把那个线程put的元素给覆盖
    public void unsafeUpdate(Integer key, Integer value){
        Integer oldValue = map.get(key);
        if(oldValue == null){
            map.put(key,value);
        }
    }
}
