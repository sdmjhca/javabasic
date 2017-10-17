package javaBasicDemo.deadlock;

/**
 * @author JHMI on 2017/8/20 0020.
 * 此种生成死锁的方式注意下列问题：
 * 1、测试类内部定义的对象不能是静态的
 * 2、synchronized必须是嵌套锁
 */
public class DeadLoakTest2 extends Thread {
    boolean flag;
    //局部变量是线程私有的
     Object o1;
     Object o2;
    /**
     * 此处注意不能使用static修饰符，
     */
    //static静态变量和常量是线程公有的
    static Object o3;
    static Object o4;


    public DeadLoakTest2(boolean temp){
        flag = temp;
    }
    public DeadLoakTest2(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        lock(o1,o2);
    }
    public void lock(Object o1,Object o2){
        synchronized (o1){
            System.out.println("已经获得对象1的锁，"+o1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("已经获得对象2的锁,"+o2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
