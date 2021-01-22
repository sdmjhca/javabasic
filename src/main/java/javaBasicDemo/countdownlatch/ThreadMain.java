package javaBasicDemo.countdownlatch;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JHMI on 2019/12/13.
 */
public class ThreadMain {
    public static void main(String[] args) {
//        AtomicBoolean flag = new AtomicBoolean(true);
        boolean flag = true;
        ReentrantLock lock = new ReentrantLock();
        Thread1 t1 = new Thread1();
        t1.setFlag(flag);
        t1.setLock(lock);
        Thread2 t2 = new Thread2();
        t2.setFlag(flag);
        t2.setLock(lock);

        t1.start();
        t2.start();
    }
}
