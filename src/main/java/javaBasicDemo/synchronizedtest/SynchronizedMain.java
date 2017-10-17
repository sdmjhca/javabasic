package javaBasicDemo.synchronizedtest;

import java.util.concurrent.CountDownLatch;

/**
 * 例子：T1和T2线程执行计算，T3线程进行T1和T2结果的统计
 * 思路定义一个“锁计数器”为2的线程并发类，T3通过await方法进行锁等待，T1执行完成后计数器-1，T2完成后计数器-1；
 * 当计数器为0后，T3开始执行统计方法，得到最终计算结果
 * @author JHMI on 2017/8/18.
 */
public class SynchronizedMain {
    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch end = new CountDownLatch(2);
    private static int i = 1;

    private static int j = 1;
    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start.await();
                    System.out.println("T1开始执行");

                    //SynchronizedTest.staticIn.method1();
                    i++;
                    //Thread.sleep(1000);
                    end.countDown();
                    System.out.println("T1计算结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start.await();
                    System.out.println("T2开始执行");

                   // SynchronizedTest.staticIn.method2();

                    j++;
                    //Thread.sleep(1000);
                    end.countDown();
                    System.out.println("T2执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        /*Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    start.await();
                    System.out.println("T3开始执行，进入等待状态");
                    end.await();
                    System.out.println("获得锁 开始执行T3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.sleep(1000);

                int c = i+j;
                System.out.println("统计结果="+c);
                System.out.println("T3执行结束");

            }
        });*/
        t1.start();
        t2.start();
        //t3.start();
        start.countDown();
        end.await();

        System.out.println("开始执行汇总流程="+(i+j)+Thread.currentThread().getName());
       /* i = i+j;
        System.out.println("i="+i);*/
    }
}
