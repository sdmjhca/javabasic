package javaBasicDemo.synchronizedtest;

import java.util.concurrent.CountDownLatch;

/**
 * @author JHMI on 2017/8/22.
 * 注意两种变量的定义方式
 * private String lock = "123";
 * private String lock = new String("123");
 * 互斥对象锁的结果不一样，第一种方式，相当于定义了一个常量，放在常量池，在启动的时候初始化一次，是线程共有的
 * 第二种方式，new 了一个对象，每次加载类都会重新生成，是线程私有的
 */
public class SynMain extends Thread{
    //private String lock = "123";
    private String lock = new String("123");
    static CountDownLatch countDownLatch = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {

        new SynMain().start();
        new SynMain().start();
        new SynMain().start();
        new SynMain().start();
        new SynMain().start();
        countDownLatch.await();
    }
    public void run(){
        System.out.println("thread start 开始获取锁-----------");
        countDownLatch.countDown();
        synchronized (lock){
            System.out.println("-----------已经获取到锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------------已经结束释放锁");
        }
    }
}
