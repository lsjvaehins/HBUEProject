import excep.DataThread;
import life.FirstThread;
import life.SecondThread;
import my.MyRunnable;
import my.MyThread1;
import syn.SynDemo;
import wait.DeadLock;
import wait.WaitDemo;

/**
 * Created by lanouhn on 17/7/18.
 */
public class Main {
    /*
     * 大驼峰和小驼峰
     * 大驼峰：PlayGame
     * 小驼峰：playGame
     * 类名要用大驼峰
     * 方法名和对象名要使用小驼峰
     * 不能以数字开头，不可以使用汉字
     * 0-9，a-Z都可以，也可以使用$
     * 是命名规范，程序员约定俗成的
     * 比如类名不使用大驼峰，也不会报错
     */


    public static void main(String[] args) {
//        summary();
//        showThread(myThread);
//        showRunnable();
//        showCreate();
//        showLife();
//        showException();
//        showSync();
//        showDifference();
//        showDeadLock();
    }

    private static void showDeadLock() {

//        什么叫死锁？
//        一个人去面试，面试结束后，面试官给他打电话：我们觉得你各方面都很符合我们的要求
//        你给我解释下死锁吧，我就给你发offer
//        他就说：你给我发offer 我就给你解释死锁

//        当一个锁对象a被线程A持有，线程B在运行过程中，又需要锁对象a
//        这时候尴尬的一幕就发生了，两个线程都在等待对方释放锁资源，这个状态就叫做死锁。
        DeadLock deadLock = new DeadLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.p1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.p2();
            }
        }).start();
    }

    private static void showDifference() {
        WaitDemo waitDemo = new WaitDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.showSleep();
            }
        }).start();

        try {
//            写这个代码 是为了保证上面定义的线程先执行
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.showWait();
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.showNotify();
            }
        }).start();
    }

    private static void showSync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynDemo.add();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynDemo.add();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynDemo.del();
            }
        }).start();
    }

    private static void showException() {
        DataThread dt1 = new DataThread();
        DataThread dt2 = new DataThread();
        DataThread dt3 = new DataThread();
        DataThread dt4 = new DataThread();

        dt1.start();
        dt2.start();
        dt3.start();
        dt4.start();

        System.out.println("-----main走完了-----");
    }

    private static void showLife() {
        /**
         * 多线程能够提高效率，比如做a事的同时
         * 也可以去做b事，即使a会耗时很长，也不会耽误做b事
         *
         * 但是如果多线程涉及到了同一资源，那么就有可能出现数据异常
         *
         * 下面我们就去看一下数据异常是怎么造成的。
         */


        FirstThread ft = new FirstThread();
        SecondThread st = new SecondThread(ft);

        ft.start();
        st.start();
        System.out.println("*****main方法执行完了*****");
    }

    private static void showCreate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                在这里，写我们要这个进程做的事情
                System.out.println("我是匿名内部类");
            }
        }).start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("我也是匿名内部类");
            }
        }.start();
    }

    private static void showRunnable() {
        //        自定义类，实现Runnable接口
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }

    private static void showThread() {
        //        执行start方法，才是开启了这个线程
//        那么这个线程才会与主线程抢占，这才是多线程
//        如果执行run方法，只是对象调用方法而已
//        与我们刚刚写的dog.catchMouse没有什么区别
//        也不会开启多线程操作，依然是在主线程中执行的。
        //        创建线程
//        自定义类，继承Thread类

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
//        myThread1.run();
        System.out.println(Thread.currentThread().getName());
    }

    private static void summary() {
        System.out.println("以下是概述");
//        进程是一个独立的单元
//        在java中使用线程，可以继承类Thread,实现接口Runnable
    }
}
