package yaojdk.juc.concurrent.map;

import java.util.TreeMap;

/**
 * @Author: lancer.yao
 * @time: 2019/12/12:上午10:22
 * 使用红黑树进行存储元素， 可以保证元素按key值的大小进行遍历
 */
public class TreeMapTest {
    public static void main(String[] args) {
        //构建一个10个元素的树
        TreeNodeTest<Integer> node = new TreeNodeTest<>(1,null).insert(2)
                .insert(6).insert(3).insert(5).insert(9).insert(7).insert(8).insert(4).insert(10);
        //中序遍历 打印结果为1到10的顺序
        node.root().inOrderTraverse();
    }
}
//树节点，假设不存在重复元素
class TreeNodeTest<T extends Comparable<T>>{
    T value;
    TreeNodeTest<T> parent;
    TreeNodeTest<T> left,right;

    public TreeNodeTest(T value, TreeNodeTest<T> parent) {
        this.value = value;
        this.parent = parent;
    }
    //获取根节点
    TreeNodeTest<T> root(){
        TreeNodeTest<T> cur = this;
        while (cur.parent != null){
            cur = cur.parent;
        }
        return cur;
    }
    //中序遍历
    void inOrderTraverse(){
        if(this.left != null){
            this.left.inOrderTraverse();
        }
        System.out.println(this.value);
        if(this.right != null){
            this.right.inOrderTraverse();
        }
    }
    //经典二叉树插入元素的方法
    TreeNodeTest<T> insert(T value){
        //先找根元素
        TreeNodeTest<T> cur = root();
        TreeNodeTest<T> p;
        int dir;
        //寻找元素应该插入的位置
        do{
            p = cur;
            if((dir = value.compareTo(p.value)) < 0){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }while (cur != null);
        //把元素放到找到的位置
        if(dir < 0){
            p.left = new TreeNodeTest<>(value,p);
            return p.left;
        }else {
            p.right = new TreeNodeTest<>(value,p);
            return p.right;
        }
    }
}