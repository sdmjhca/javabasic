package javaBasicDemo.synchronizedtest;

/**
 * @author JHMI on 2018/12/29.
 * synchronized 对象互斥锁---指非静态同步方法和同步代码块----同一个实例下的同一个对象互斥，其它不互斥
 * synchronized 类互斥锁---指一个类的class加锁或静态同步方法----两个实例下的锁互斥，其它不互斥
 * 类锁和对象锁不互斥
 */
public class ObjectSynchronizedMain {

    public static void main(String[] args) throws InterruptedException {
        ObjectSynchronized o = new ObjectSynchronized();
        Thread t1 = new Thread(new ObjectSynchronizedMid(o));
        Thread t2 = new Thread(new ObjectSynchronizedMid2(o));
        t1.start();
        t2.start();
    }
}
