package javaBasicDemo.synchronizedtest;

/**
 * @author JHMI on 2018/12/29.
 */
public class ObjectSynchronized {
    private String s1 = new String();
    private String s2 = new String();
    public void test1() throws InterruptedException {
        synchronized (s1){
            System.out.println(Thread.currentThread().getName()+"---进入test1");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"---test1 end");
        }
    }

    public void test2() throws InterruptedException {
        synchronized (s1){
            System.out.println(Thread.currentThread().getName()+"-====进入test2");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"---test2 end");
        }
    }
}
