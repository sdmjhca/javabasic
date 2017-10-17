package javaBasicDemo.synchronizedtest;

/**
 * @author JHMI on 2017/8/18.
 */
public class SynchronizedTest {
    /**
     * 懒汉单例模式，并不是线程安全的 需要加synchronized 锁
     */
    /*private SynchronizedTest(){}
    private static SynchronizedTest synchronizedTest;
    public static synchronized SynchronizedTest getSynchronizedTest(){
        if(synchronizedTest == null){
            synchronizedTest =  new SynchronizedTest();
        }
        return synchronizedTest;
    }*/
    /**
     * 饿汉单例模式,天生是线程安全的，对象在类加载的时候初始化，并且类只会加载一次
     */
    private SynchronizedTest(){}
    private static final SynchronizedTest synchronizedTest = new SynchronizedTest();
    public static SynchronizedTest getSynchronizedTest(){
        return synchronizedTest;
    }

    public static SynchronizedTest staticIn = new SynchronizedTest();   //静态对象

    public synchronized void method1(){                                      //非静态方法1
        for(int i = 0;i < 10;i++){
            System.out.println("method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public  void method2(){                                   //非静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public  static void staticMethod1(){                     //静态方法1
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod2(){                      //静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
