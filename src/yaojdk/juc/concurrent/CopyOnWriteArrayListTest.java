package yaojdk.juc.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: lancer.yao
 * @time: 2019/12/11:上午10:21
 * ArrayList线程安全版本，内部也是通过数组实现，每次对数组的修改都完全拷贝一份新的数组来修改，修改完了在替换掉老数组。
 * 这样保证了只阻塞写操作，不阻塞读操作，实现读写分离
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
    }
}
