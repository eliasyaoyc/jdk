package yaojdk.juc.concurrent.list;

import java.util.LinkedList;

/**
 * @Author: lancer.yao
 * @time: 2019/12/11:下午2:47
 * 双向链表实现的list，可以做为队列或者栈来使用。 集成Deque和Queue 无界队列
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1,1);
    }
}
