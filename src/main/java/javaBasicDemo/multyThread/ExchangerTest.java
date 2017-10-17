package javaBasicDemo.multyThread;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author JHMI on 2017/9/1.
 * Exchanger 两个线程的数据交换
 */
public class ExchangerTest extends Thread{
    static Exchanger exchanger = new Exchanger();
    String str;
    public ExchangerTest(String attr){
        this.str = attr;
    }

    public void run(){
        try {
            Random ran = new Random();
            int i = ran.nextInt(5);
            Thread.sleep(i*1000);
            System.out.println(Thread.currentThread().getName()+"开始线程交换，交换前的数据="+ str);
            String str1 = (String) exchanger.exchange(str);
            System.out.println(Thread.currentThread().getName()+"交换后的数据="+str1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExchangerTest exchangerTest = new ExchangerTest("123");
        exchangerTest.start();
        ExchangerTest exchangerTest2 = new ExchangerTest("2222222222");
        exchangerTest2.start();
        ExchangerTest exchangerTest3 = new ExchangerTest("33333");
        exchangerTest3.start();
        ExchangerTest exchangerTest4 = new ExchangerTest("4444");
        exchangerTest4.start();
    }
}
