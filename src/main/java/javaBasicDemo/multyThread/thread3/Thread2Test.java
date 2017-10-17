package javaBasicDemo.multyThread.thread3;

/**
 * @author JHMI on 2017/9/25.
 */
public class Thread2Test extends Thread {
    private Thread1Test t1;
    public Thread2Test(Thread1Test thread1Test){
        this.t1 = thread1Test;
    }
    public void run(){
        System.out.println("thread2 开始执行");
        // t2 ...do something;
        try {
            System.out.println("thread2 开始等待 t1执行");
            t1.join(2000);
            System.out.println("t1执行结束 thread2 开始继续执行");
            //Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2 执行结束");
    }
}
