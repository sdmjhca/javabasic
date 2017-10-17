package javaBasicDemo.multyThread.thread3;

/**
 * @author JHMI on 2017/9/25.
 */
public class Thread4Test extends Thread{

    public void run(){
        System.out.println("thread4 开始执行");
        try {
            Thread.sleep(4000);//do something
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread4 执行结束");
    }

}
