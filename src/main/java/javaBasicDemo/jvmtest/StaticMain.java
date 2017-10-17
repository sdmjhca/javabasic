package javaBasicDemo.jvmtest;


import java.util.concurrent.ExecutorService;

import static javaBasicDemo.jvmtest.StaticTest.display;
import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * @author JHMI on 2017/8/17.
 */
public class StaticMain {
    public static void main(String args[]) throws ClassNotFoundException {

        /**
         * 1、static final 静态常量在启动服务时已经加载
         * 2、static 静态变量 和 静态方法块 在加载类时会进行加载
         * 3、调用构造方法和静态变量时 都会先加载类 然后调用方法
         */

        //StaticTest test = new StaticTest();

        /*Class.forName("com.sdmjhca.javaBasicDemo.jvmtest.StaticTest");

        StaticTest.StaticInner inner = new StaticTest.StaticInner();

        System.out.println(StaticTest.Innerasd.A);*/
        //System.out.println(StaticTest.Y);

        //StaticTest test = new StaticTest();
        //StaticTest son = new SonStatic("sss");
        display();
        ExecutorService service = newCachedThreadPool();
        service.execute(new Runnable() {
            public void run() {
                new StaticTest();
            }
        });

        //FinalMain.FinalInner finalInner = new FinalMain().new FinalInner();
        //FinalMain main = new FinalMain();
    }
}
