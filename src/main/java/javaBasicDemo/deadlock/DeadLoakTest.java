package javaBasicDemo.deadlock;

/**
 * @author JHMI on 2017/8/20 0020.
 */
public class DeadLoakTest extends Thread {
    boolean flag;
    public DeadLoakTest(boolean temp){
        flag = temp;
    }
    public void run(){
        if(flag){
            lock(Resource.o1,Resource.o2);
        }else{
            lock(Resource.o2,Resource.o1);
        }
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
