package yaojdk.jvm.classloader;

/**
 * @Author: lancer.yao
 * @time: 2019/12/18:上午9:31
 */
public class MyCat {
    public MyCat(){
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
    }
}
