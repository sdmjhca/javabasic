package javaBasicDemo.queuetest;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author JHMI on 2017/9/1.
 * 缓存队列，实现生产者/消费者模型
 * 从缓存中获取方法对比：
 * 1、linkedBlockingDeque.element()，如果获取不到则返回NoSuchElementException
 * 2、peek()，如果获取不到则返回null
 * 3、take()，如果获取不到，则一直等待
 * 往缓存中插入数据对比：
 * 1、add()，如果超过队列容量，则抛出异常IllegalStateException("Deque full")
 * 2、offer()，如果超过队列容量，则返回false
 * 3、put()，如果超过队列容量，则一直等待
 */
public class QueueTest {
    static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(3);//队列深度，默认无限大

    static int i = 0;

    public static void main(String[] args) {
        //定义一个生产者，往往生产往队列里放的速度较快
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始生产");
                i++;
                try {
                    //do something
                    Thread.sleep(1000);//生产过程
                    System.out.println("生产结束"+i);
                    linkedBlockingDeque.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //定义一个消费者，往往消费者的速度要比生产者慢，由于需要执行更多的业务逻辑
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始消费");
                try {
                    Thread.sleep(5000);
                    int a = (int) linkedBlockingDeque.take();
                    //linkedBlockingDeque.remove();
                    System.out.println(" 消费结束，消费到="+a);
                    System.out.println("队列深度为"+linkedBlockingDeque.size());
                    *//*linkedBlockingDeque.peek();
                    linkedBlockingDeque.take()*//*
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();*/
        System.out.println("开始消费");
        try {
            Thread.sleep(2000);
            int a = Integer.parseInt(linkedBlockingDeque.take().toString());
            //linkedBlockingDeque.remove();
            System.out.println(" 消费结束，消费到="+a);
            System.out.println("队列深度为"+linkedBlockingDeque.size());
                    /*linkedBlockingDeque.peek();
                    linkedBlockingDeque.take()*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
