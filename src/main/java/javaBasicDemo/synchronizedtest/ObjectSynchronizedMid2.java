package javaBasicDemo.synchronizedtest;

/**
 * @author JHMI on 2018/12/29.
 */
public class ObjectSynchronizedMid2 implements Runnable {
    private ObjectSynchronized o;

    public ObjectSynchronizedMid2(ObjectSynchronized o) {
        this.o = o;
    }
    @Override
    public void run() {
        try {
            o.test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
