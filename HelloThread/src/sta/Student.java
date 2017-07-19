package sta;

/**
 * Created by lanouhn on 17/7/19.
 */
public class Student {
    private static String name = "张三";

//    静态代码块
//    静态的东西，会随着类的加载进入内存，因为对象是依赖类的，有类后，才能创建对象
//    所以当类刚刚加载进内存时，是不可能有对象存在的，所以在静态代码块或静态方法中，不可以使用this
    static {
        System.out.println("我是静态代码块");
    }

    private static void showInfo() {
        System.out.println("显示信息的方法----");
    }
}
