package yaojdk.jvm.classloader;

import java.io.*;

/**
 * @Author: lancer.yao
 * @time: 2019/12/17:上午9:37
 * 在这个例子当中， 自定义了一个类加载器。比如我要加载某一个类(MyTest1) 那么它并不会调用自定义的这个MyTest16去加载MyTest1这是因为双亲委托机制
 * 会让父类加载器 也就是系统加载器来进行加载。在我们main方法中创建了两个MyTest16的实例加载相同的MyTest1。因为loader1已经被系统加载器加载过了
 * 所以loader2不会重复加载直接使用。系统加载器加载是classPath中的class类，如果我们把MyTest1的class文件移到桌面或者其他地方那么系统加载器
 * 及其所有父类都无法加载那么最终就会让自定义的MyTest16来进行加载，那么loader1 loader2 都会加载一次  因为这两个不是相同的加载器。
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super(); //将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path){
        this.path = path;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] bytes = this.loadClassData(className);
        return defineClass(className,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/koso/Desktop/project/yichen.yao/yaoJdk/out/production/yaoJdk/");
        Class<?> aClass = loader1.loadClass("yaojdk.jvm.classloader.MyTest1");
        System.out.println("class: " + aClass.hashCode());
        Object o = aClass.newInstance();
        System.out.println(o);

        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("/Users/koso/Desktop/project/yichen.yao/yaoJdk/out/production/yaoJdk/");
        Class<?> aClass2 = loader2.loadClass("yaojdk.jvm.classloader.MyTest1");
        System.out.println("class: " + aClass2.hashCode());
        Object o2 = aClass.newInstance();
        System.out.println(o2);

    }
}
