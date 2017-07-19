package wait;

/**
 * Created by lanouhn on 17/7/19.
 */
public class DeadLock {
    private String s1 = "s1";
    private String s2 = "s2";

    public void p1(){
        synchronized (s1){
            System.out.println("s1锁住了p1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (s2){
                System.out.println("s2锁住了p1");
            }
        }
    }

    public void p2(){
        synchronized (s2){
            System.out.println("s2锁住了p2");
            synchronized (s1){
                System.out.println("s1锁住了p2");
            }
        }

    }
}
