package yaojdk.juc.concurrent.set;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:25
 * Set	有序性	线程安全	底层实现	关键接口	特点
 * HashSet	无	否	HashMap	无	简单
 * LinkedHashSet	有	否	LinkedHashMap	无	插入顺序
 * TreeSet	有	否	NavigableMap	NavigableSet	自然顺序
 * CopyOnWriteArraySet	有	是	CopyOnWriteArrayList	无	插入顺序，读写分离
 * ConcurrentSkipListSet	有	是	ConcurrentNavigableMap	NavigableSet	自然顺序
 */
public class ConcurrentSkipListSetTest {
}
