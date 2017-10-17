package javaBasicDemo.multyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JHMI on 2017/9/26.
 */
public class ThreadMain {
    static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        //Thread t1 = new Thread(new ThreadTest());
        for(int i = 0 ;i<3;i++){
            Thread t1 = new Thread(new ThreadTest());
            executorService.execute(t1);
        }
        executorService.shutdown();
    }
}
