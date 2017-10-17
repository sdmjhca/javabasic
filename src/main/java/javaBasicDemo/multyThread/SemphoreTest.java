package javaBasicDemo.multyThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author JHMI on 2017/9/1.
 * Semaphore 控制线程的并发数，控制信号量
 */
public class SemphoreTest extends  Thread{
    static Semaphore semaphore = new Semaphore(5,true);
static CountDownLatch countDownLatch = new CountDownLatch(1);
    public void run(){
        try {
            countDownLatch.await();
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"获取到资源所");
            Thread.sleep(2000);
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+"释放资源所");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            SemphoreTest test = new SemphoreTest();
            test.start();
        }
        countDownLatch.countDown();
    }
}
