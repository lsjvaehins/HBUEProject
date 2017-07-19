package my;

/**
 * Created by lanouhn on 17/7/18.
 */
public class MyRunnable implements Runnable {
    /**
     * 问题：MyRunnable是不是线程呢？
     *
     * 线程是什么？线程是Thread
     * MyRunnable是不是一个Thread呢？
     *  所以MyRunnable不是一个线程
     *  只是一个可执行类，因为实现了Runnable
     */


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是Runnable");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
