package javaBasicDemo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JHMI on 2017/8/28.
 */
public class CountDownLatchTest2 extends Thread{
    private String test = "a,b,c,d";
    CountDownLatch countDownLatch;
    CountDownLatch countDownLatch2;
    public CountDownLatchTest2(CountDownLatch countDownLatch,CountDownLatch countDownLatch2){
        this.countDownLatch = countDownLatch;
        this.countDownLatch2 = countDownLatch2;
    }
    ReentrantLock lock;

    boolean flag;

    public CountDownLatchTest2(ReentrantLock reentrantLock,boolean flag){
        this.lock = reentrantLock;
        this.flag = flag;
    }
    public void run(){

        String tests[] = test.split(",");
        for(int i=0;i<tests.length;i++){
            if(flag){
                lock.notify();
            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(tests[i]);
            flag =false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
