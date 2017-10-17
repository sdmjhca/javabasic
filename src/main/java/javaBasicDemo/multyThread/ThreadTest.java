package javaBasicDemo.multyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JHMI on 2017/9/6.
 */
public class ThreadTest extends Thread{
    private static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    System.out.println("----------");
                }
            });

            service.execute(thread);
        }

        service.shutdown();
    }

    public void run(){
        System.out.println("start");
    }
}
