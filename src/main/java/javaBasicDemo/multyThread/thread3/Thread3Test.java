package javaBasicDemo.multyThread.thread3;

/**
 * @author JHMI on 2017/9/25.
 */
public class Thread3Test extends Thread{

    private Thread2Test t2;
    private Thread4Test t4;
    public Thread3Test(Thread2Test thread2Test,Thread4Test thread4Test){
        this.t2 = thread2Test;
        this.t4 = thread4Test;
    }

    public void run(){
        System.out.println("thread3 开始执行");
        // t3 ...do otherthing;
        try {
            t4.start();
            System.out.println("thread3 开始等待 t2执行");
            t2.join();
            t4.join();

            System.out.println("t2 执行结束 thread3 继续执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread3 执行结束");
    }
}
