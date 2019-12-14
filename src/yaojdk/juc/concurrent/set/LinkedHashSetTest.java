package yaojdk.juc.concurrent.set;

import java.util.LinkedHashSet;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:23
 * 有序 继承hashSet  全部方法都用hashSet的 但是存储元素没有使用HashMap 使用的是LinkedHashMap
 * 但是linkedHashSet不支持按访问顺序对元素排序的，只能按插入顺序排序
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
    }
}
