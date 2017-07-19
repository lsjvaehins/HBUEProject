package syn;

/**
 * Created by lanouhn on 17/7/18.
 */
public class SynDemo {
//    synchronized关键字
//    表示同步，可以用来修饰代码块，也可以用来修饰方法

    private static int count = 0;

//    SynDemo.class是synchronized关键字修饰方法时的默认锁对象
    public static synchronized void add(){
//        add方法被synchronized修饰
//        那么当线程A调用add方法时，线程A已经进入方法体中进行操作了
//        这时线程B如果要调用add方法，需要等线程A执行完add才可以
        for (int i = 0; i < 10000; i++) {
        count++;
        System.out.println(Thread.currentThread().getName()+"--------"+count);
        }
    }


    /**
     * del方法，也被synchronized修饰了
     * 这样del方法和add方法同步锁对象就是一个了，都是SynDemo.class这个类对象
     * 所以当线程A进入到add方法时，线程A持有这个锁对象，那么线程B要进入del方法时，无法持有这个锁对象，所以就进不来了。
     */
    public static synchronized void del(){
        for (int i = 0; i < 10000; i++) {
            count--;
        }
        System.out.println(Thread.currentThread().getName()+"--------"+count);
    }
}
