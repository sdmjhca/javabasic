package javaBasicDemo.multyThread;

/**
 * @author JHMI on 2017/9/1.
 * ThreadGroup 线程组批量管理线程
 */
public class ThreadGroupTest extends Thread{
    static ThreadGroup threadGroup = new ThreadGroup("我的线程组");

    public ThreadGroupTest(ThreadGroup threadGroup,String name){
        super(threadGroup,name);
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("开始执行线程="+Thread.currentThread().getName());
            System.out.println("当前线程组="+Thread.currentThread().getThreadGroup());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroupTest t1 = new ThreadGroupTest(threadGroup, "线程1");
        ThreadGroupTest t2 = new ThreadGroupTest(threadGroup, "线程2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        threadGroup.interrupt();
    }
}
