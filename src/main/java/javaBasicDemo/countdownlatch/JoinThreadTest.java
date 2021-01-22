package javaBasicDemo.countdownlatch;

import javaBasicDemo.interviewQuestion.Test1;
import javaBasicDemo.multyThread.thread3.Thread1Test;
import javaBasicDemo.multyThread.thread3.Thread2Test;

/**
 * @author JHMI on 2019/12/6.
 */
public class JoinThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.setT2(t2);
        t2.setT1(t1);
        t1.start();
        t2.start();

    }
}
