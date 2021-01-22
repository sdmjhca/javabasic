package javaBasicDemo.countdownlatch;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JHMI on 2019/12/6.
 */
public class Thread2 extends Thread{
    private Thread1 t1;

    private ReentrantLock lock;

    private boolean flag;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Thread1 getT1() {
        return t1;
    }

    public void setT1(Thread1 t1) {
        this.t1 = t1;
    }

    @Override
    public synchronized void run() {
        Condition condition = lock.newCondition();
        String[] s = {"a","b","c","d"};
        int i = 0;
        while (true){
            if(i >= s.length) break;
            lock.lock();
            System.out.println(s[i++]);
            try {
                condition.notify();
                condition.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        /*for(String o : s){
            System.out.println(o);
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
