package wait;

/**
 * Created by lanouhn on 17/7/19.
 */
public class WaitDemo {
    public void showWait(){
        synchronized (WaitDemo.class){
//            wait
//            wait方法是Object方法，也就是所有继承Object类的子类，都有这个方法
//            这也变相证明了，锁对象可以是任何一个对象
//            当锁对象WatiDemo.class调用了wait方法后，会释放锁资源，进入阻塞状态
//            只有当同一个锁对象（也就是这个WaitDemo.class）调用唤醒方法时，这个线程才会由阻塞状态进入就绪状态
//            就绪状态不是运行时，而是有能力去抢夺执行权了。
            try {
                System.out.println("我要wait了");
                WaitDemo.class.wait();
                System.out.println("我ok了，gogogogo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showSleep(){
//        sleep会使当前线程进入阻塞状态，一段时间后继续执行
//        需要注意的是，sleep并不会释放锁资源，而wait会释放锁资源，这是他俩最大的区别
//        还有就是wait是锁对象在调用，而sleep是Thread的静态方法


        synchronized (WaitDemo.class){
            try {
                System.out.println("我要睡觉了");
                Thread.sleep(3000);
                System.out.println("实在是睡不着啊");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showNotify(){
        synchronized (WaitDemo.class){
//            notifyAll会唤醒所有被WaitDemo.class这个锁对象wait了的线程
            WaitDemo.class.notifyAll();
        }
    }
}
