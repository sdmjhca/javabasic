package javaBasicDemo.synchronizedtest;

/**
 * @author JHMI on 2018/12/29.
 */
public class ObjectSynchronizedMid implements Runnable {
    private ObjectSynchronized o;

    public ObjectSynchronizedMid(ObjectSynchronized o) {
        this.o = o;
    }
    @Override
    public void run() {
        try {
            o.test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
