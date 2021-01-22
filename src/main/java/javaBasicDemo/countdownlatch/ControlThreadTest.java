package javaBasicDemo.countdownlatch;

/**
 * @author JHMI on 2019/12/4.
 */
public class ControlThreadTest {

    Object o1 = new Object();
    public static void main(String[] args) {
        ControlThreadTest test = new ControlThreadTest();
        test.thread1().start();
        test.thread2().start();

    }

    private synchronized Thread thread1(){
        final String[] a = {"a","b"};
        return new Thread(()->{
            for(String s : a){
                synchronized (o1){
                    o1.notify();
                    System.out.println(s);
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        o1.notify();
                    }
                }
            }

        });
    }
    private synchronized Thread thread2(){
        final String[] a = {"1","2"};
        return new Thread(()->{
            for(String s : a){
                synchronized (o1){
                    o1.notify();
                    System.out.println(s);
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        o1.notify();
                    }
                }

            }
        });
    }
}
