package life;

/**
 * Created by lanouhn on 17/7/18.
 */
public class FirstThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("FFFFFF--"+getState());

        }
    }
}
