package javaBasicDemo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JHMI on 2017/8/28.
 */
public class CountDownLatchTest extends Thread{
    CountDownLatch countDownLatch;
    public CountDownLatchTest(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    ReentrantLock lock;
    boolean flag;

    public  void run(){
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("进入线程-----------");
        System.out.println("开始执行线程方法----------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        CountDownLatchTest test = new CountDownLatchTest(countDownLatch);
        new Thread(test).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("休息完成");

            }
        }).start();

        System.out.println("执行main方法");
    }
}
