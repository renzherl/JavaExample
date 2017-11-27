package MultiThread;

/**
 * Created by mi on 2017/11/9.
 */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException{
        Thread newThread = new Thread() {
            public void run() {
                System.out.println("Hello from new thread");
            }
        };

        newThread.start();
        Thread.yield();
        //Thread.sleep(1);
        System.out.println("Hello from main thread");
        newThread.join();

    }
}
