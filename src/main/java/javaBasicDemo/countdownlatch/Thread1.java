package javaBasicDemo.countdownlatch;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JHMI on 2019/12/6.
 */
public class Thread1 extends Thread{
    private Thread2 t2;

    private ReentrantLock lock;

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Thread2 getT2() {
        return t2;
    }

    public void setT2(Thread2 t2) {
        this.t2 = t2;
    }

    @Override
    public void run() {
        Condition condition = lock.newCondition();
        String[] s = {"1","2","3","4"};
        int i = 0;
        while (true){
            lock.lock();
            if(i >= s.length) break;
            System.out.println(s[i++]);
            try {
                condition.notifyAll();
                condition.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
