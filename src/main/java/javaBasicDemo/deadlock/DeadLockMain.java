package javaBasicDemo.deadlock;

/**
 * @author JHMI on 2017/8/20 0020.
 * 此种生成死锁的方式注意下列问题：
 * 1、测试类内部定义的对象不能是静态的
 * 2、synchronized必须是嵌套锁
 */
public class DeadLockMain {
    public static void main(String args[]) throws InterruptedException {
        /*DeadLoakTest t1 = new DeadLoakTest(true);

        DeadLoakTest t2 = new DeadLoakTest(false);
        t1.start();
        t2.start();*/
        /*ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(t1);
        executor.execute(t2);*/
        Object o1 = new String("11111111111111111");
        Object o2 = new String("22222222222222");
        DeadLoakTest2 test2 = new DeadLoakTest2(o1,o2);
        //Thread.sleep(1000);
        DeadLoakTest2 test21 = new DeadLoakTest2(o2,o1);
        test2.start();
        test21.start();

        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()

    }
}
