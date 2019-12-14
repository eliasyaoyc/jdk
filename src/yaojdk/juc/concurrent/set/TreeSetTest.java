package yaojdk.juc.concurrent.set;

import java.util.TreeSet;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:24
 * 底层是采用TreeMap实现的一种set。所以是有序的(NavigableMap)
 * TreeMap和LinkedHashSet都是有序的但是
 * LinkedHashSet并没有实现SortedSet接口，它的有序性主要依赖于LinkedHashMap的有序性，所以它的有序性是指按照插入顺序保证的有序性；
 * 而TreeSet实现了SortedSet接口，它的有序性主要依赖于NavigableMap的有序性，而NavigableMap又继承自SortedMap，
 * 这个接口的有序性是指按照key的自然排序保证的有序性，而key的自然排序又有两种实现方式，一种是key实现Comparable接口，一种是构造方法传入Comparator比较器。
 *
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
    }
}
