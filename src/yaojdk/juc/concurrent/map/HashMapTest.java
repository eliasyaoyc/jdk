package yaojdk.juc.concurrent.map;

import java.util.HashMap;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:21
 * key/value存储格式；每个key对应唯一的value，查询和修改的速度都很快，能达到O1的平均时间复杂度，且不保证元素存储的顺序
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
        hashMap.remove(1);
    }
}
