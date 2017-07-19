package syn;

import sta.Student;

/**
 * Created by lanouhn on 17/7/19.
 */
public class CodeDemo {
/**
 * 什么是同步，什么是异步？
 *
 * 什么叫同步？
 * 小红叫小明去吃饭，小明说你等我化完妆，小红就在门口等着，斗转星移，海枯石烂
 * 小明化完了，然后俩人牵着小手去吃饭了
 *
 * 什么叫异步？
 * 小红叫小明去吃饭，小明说你等会我马上就化完了，小红说mmp,qnmd，我自己去了
 * 小红就自己去吃饭了
 * 小明继续化妆，化完也自己去了。
*/



    private static Student stu = new Student();

    private static int count = 0;

    public void add(){
//        同步关键字，修饰代码块
//        同步只会影响到代码块中的内容
//        (stu)是锁
//        锁 只是一个抽象的概念，实际上就是一个对象
//        这个对象可以是任意的，非固定的
//        比如这里也可以不用stu，只要在当前类可以使用的对象都可以写在这个括号中充当锁对象，比如：this,CodeDemo.class等。
//        CodeDemo.class是类对象
        synchronized (stu){
            count++;
        }

    }
}
