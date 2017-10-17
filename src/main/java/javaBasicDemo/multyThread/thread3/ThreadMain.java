package javaBasicDemo.multyThread.thread3;


/**
 * @author JHMI on 2017/9/25.
 */
public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        Thread1Test t1 = new Thread1Test();
        Thread2Test t2 = new Thread2Test(t1);
        Thread4Test t4 = new Thread4Test();
        Thread3Test t3 = new Thread3Test(t2,t4);
        System.out.println("main 线程开始执行");
        t1.start();
        t2.start();
        t3.start();
        t3.join();//main 线程会等待线程3执行结束后 才结束
        System.out.println("main 线程执行结束");
    }

}
