package life;

/**
 * Created by lanouhn on 17/7/18.
 */
public class SecondThread extends Thread {
    private FirstThread ft;

    public SecondThread(FirstThread ft) {
        this.ft = ft;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Second:--"+getState()+"---First:--"+ft.getState());
        }
    }
}
