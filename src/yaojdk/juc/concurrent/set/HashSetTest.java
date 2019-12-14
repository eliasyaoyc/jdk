package yaojdk.juc.concurrent.set;

import java.util.HashSet;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:23
 * 是set的一种实现， 底层主要使用HashMap来确保元素的不重复  无序
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
    }
}
