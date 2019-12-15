package yaojdk.juc.concurrent.deque;

import java.util.ArrayDeque;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:29
 * 双端队列是一种特殊的队列。它的两端都可以进出元素
 * ArrayDeque 是一种以数组方式实现的双端队列，它是非线程安全的
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(1);
    }
}
