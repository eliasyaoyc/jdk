package yaojdk.juc.concurrent.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lancer.yao
 * @time: 2019/12/11:下午1:30
 * 以数组实现的list,与数组相比，它具有动态扩展的能力，因此也可称之为动态数组
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Father[] fathers = new Son[]{};
        System.out.println(fathers.getClass());
        List<String> strList = new MyList();
        System.out.println(strList.toArray().getClass());
    }
}

class Father{};
class Son extends Father{}
class MyList extends ArrayList<String>{
    /**
     * 子类重写父类的方法，返回值可以不一样
     * 但这里只能用数组类型，换成Object就不行
     * 应该算是java本身的bug
     */
    @Override
    public Object[] toArray() {
        return new String[]{"1","2","3"};
    }
}
