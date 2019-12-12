package yaojdk.juc.concurrent.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:22
 * 集成hashMap拥有hashMap的一切特性 并且额外增加了按一定顺序访问的特性。
 * 维护hashMap的单向列表 同时自身添加一种双向链表的结构存储所有元素的顺序
 * 添加删除元素的时候需要同时维护在HashMap中的存储，也要维护在LinkedList中的存储，所以性能上来说会比HashMap稍慢。
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        //使用LinkedHashMap来实现LRU(least recently used)算法
        LRU<Integer,Integer> lru = new LRU<>(5,0.75f);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(7,7);
        System.out.println(lru.get(4));
        lru.put(6,666);
        //输出: {3=3, 5=5, 7=7, 4=4, 6=666}
        //可以看到最旧的元素被删除了
        //且最近访问的4被移到了后面
        System.out.println(lru);
    }
}
class LRU<K,V> extends LinkedHashMap<K,V>{
    //保存缓存容量
    private int capacity;

    public LRU(int capacity,float loadFactor){
        super(capacity,loadFactor);
        this.capacity = capacity;
    }
    //重写removeEldestEntry方法设置何时移出旧元素

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //当元素个数大于了缓存的容量, 就移除元素
        return size() > this.capacity;
    }
}
