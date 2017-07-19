package excep;

/**
 * Created by lanouhn on 17/7/18.
 */
public class DataThread extends Thread{
    /**
    *  原子性操作
     *  int n = 1;是原子性操作
     *  n = n + 1;不是，这条语句，实际上进行了三次操作
     *  1、在内存中取出n的值
     *  2、将取出的值（1）与1做减法操作
     *  3、将得到的结果赋值给n
     *
     *  多线程操作的时候，很可能当前线程进行到第二步后，就被抢走了执行权
     *  其他线程获取n的值得时候，取出的值还是第一步n的值
     *  这样实际进行了两次减法操作，但是n只减掉了1，这就是为什么会有减不到0的现象发生
     *
     *  关于数据顺序混乱：
     *  线程A执行输出语句时，可能从内存中获得了当前num的值，但是在输出前的那一刹那，被抢走了执行权
     *  等线程A再抢回执行权时，其他线程可能已经输出过num的值了，所以线程A输出的值会与顺序不符。
    */

//    static是静态的，修饰num后，num这个变量就是类变量了
//    只要是DataThread的对象，都会共享num
//    注意！！！是共享，不是每个对象都有一个num是10000
//    如果有一个DataThread对象，将num改成了1000，那么其他DataThread对象使用num时，就是1000了
    private static int num = 10000;

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 2500; i++) {
            num--;
            System.out.println(getName()+"-----"+num);
        }
    }
}
